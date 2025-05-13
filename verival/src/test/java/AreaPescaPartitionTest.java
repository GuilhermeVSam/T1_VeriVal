import br.pucrs.edu.Main.AreaPesca;
import br.pucrs.edu.Main.AreaPesca.Rede;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AreaPescaPartitionTest {

    @Test
    public void testAreaComum() {
        List<Rede> redes = Collections.singletonList(new Rede(1, 2, 1, 2));
        int area = AreaPesca.calcularAreaAproveitada(redes);
        assertEquals(1, area);
    }

    @Test
    public void testRedesNaoSobrepostas() {
        List<Rede> redes = Arrays.asList(
                new Rede(1, 3, 1, 3),
                new Rede(3, 5, 3, 5)  
        );
        int area = AreaPesca.calcularAreaAproveitada(redes);
        assertEquals(8, area);
    }

    @Test
    public void testRedesSobrepostas() {
        List<Rede> redes = Arrays.asList(
                new Rede(1, 4, 1, 4), 
                new Rede(3, 6, 3, 6)  
        );
        int area = AreaPesca.calcularAreaAproveitada(redes);
        assertEquals(17, area); 
    }

    @Test
    public void testRedeInvalida() {
        Rede redeInvalida = new Rede(5, 3, 1, 2);
        Executable exec = () -> AreaPesca.calcularAreaAproveitada(Collections.singletonList(redeInvalida));
        AssertionError e = assertThrows(AssertionError.class, exec);
        assertTrue(e.getMessage().contains("Xi deve ser <="));
    }

    @Test
    public void testRedeInvalidaYiMaiorQueYf() {
        Rede redeInvalida = new Rede(1, 2, 5, 3);
        Executable exec = () -> AreaPesca.calcularAreaAproveitada(Collections.singletonList(redeInvalida));
        AssertionError e = assertThrows(AssertionError.class, exec);
        assertTrue(e.getMessage().contains("Yi deve ser <="));
    }

    @Test
    public void testRedeForaDosLimites() {
        Rede redeInvalida = new Rede(0, 2, 1, 2);
        Executable exec = () -> AreaPesca.calcularAreaAproveitada(Collections.singletonList(redeInvalida));
        AssertionError e = assertThrows(AssertionError.class, exec);
        assertTrue(e.getMessage().contains("Xi deve ser no mínimo"));
    }

    @Test
    public void testRedeNaBordaInferior() {
        Rede rede = new Rede(1, 2, 1, 2);
        int area = AreaPesca.calcularAreaAproveitada(Collections.singletonList(rede));
        assertEquals(1, area);
    }

    @Test
    public void testRedeNaBordaSuperior() {
        Rede rede = new Rede(99, 101, 99, 101);
        int area = AreaPesca.calcularAreaAproveitada(Collections.singletonList(rede));
        assertEquals(4, area); 
    }

    @Test
    public void testRedeComAreaZero() {
        Rede rede = new Rede(5, 5, 5, 5); 
        int area = AreaPesca.calcularAreaAproveitada(Collections.singletonList(rede));
        assertEquals(0, area);
    }

}
