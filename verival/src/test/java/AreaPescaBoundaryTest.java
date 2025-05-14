import br.pucrs.edu.Main.AreaPesca;
import br.pucrs.edu.Main.AreaPesca.Rede;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class AreaPescaBoundaryTest {

    @Test
    public void testXiYiMinimoValido() {
        Rede rede = new Rede(1, 2, 1, 2);
        int area = AreaPesca.calcularAreaAproveitada(Collections.singletonList(rede));
        assertEquals(1, area);
    }

    @Test
    public void testXiAbaixoDoMinimo() {
        Rede rede = new Rede(0, 2, 1, 2);
        Executable exec = () -> AreaPesca.calcularAreaAproveitada(Collections.singletonList(rede));
        AssertionError e = assertThrows(AssertionError.class, exec);
        assertTrue(e.getMessage().contains("Xi deve ser no mínimo"));
    }

    @Test
    public void testYiAbaixoDoMinimo() {
        Rede rede = new Rede(1, 2, 0, 2);
        Executable exec = () -> AreaPesca.calcularAreaAproveitada(Collections.singletonList(rede));
        AssertionError e = assertThrows(AssertionError.class, exec);
        assertTrue(e.getMessage().contains("Yi deve ser no mínimo"));
    }

    @Test
    public void testXfYfMaximoValido() {
        Rede rede = new Rede(99, 100, 99, 100); 
        int area = AreaPesca.calcularAreaAproveitada(Collections.singletonList(rede));
        assertEquals(1, area);
    }

    @Test
    public void testXfAcimaDoMaximo() {
        Rede rede = new Rede(1, 101, 1, 2);
        Executable exec = () -> AreaPesca.calcularAreaAproveitada(Collections.singletonList(rede));
        AssertionError e = assertThrows(AssertionError.class, exec);
        assertTrue(e.getMessage().contains("Xf deve ser no máximo"));
    }

    @Test
    public void testYfAcimaDoMaximo() {
        Rede rede = new Rede(1, 2, 1, 101);
        Executable exec = () -> AreaPesca.calcularAreaAproveitada(Collections.singletonList(rede));
        AssertionError e = assertThrows(AssertionError.class, exec);
        assertTrue(e.getMessage().contains("Yf deve ser no máximo"));
    }

    @Test
    public void testXiIgualXfAreaZero() {
        Rede rede = new Rede(5, 5, 5, 6); 
        int area = AreaPesca.calcularAreaAproveitada(Collections.singletonList(rede));
        assertEquals(0, area);
    }

    @Test
    public void testYiIgualYfAreaZero() {
        Rede rede = new Rede(5, 6, 5, 5); 
        int area = AreaPesca.calcularAreaAproveitada(Collections.singletonList(rede));
        assertEquals(0, area);
    }

    @Test
    public void testNumeroMinimoDeRedes() {
        Rede rede = new Rede(1, 2, 1, 2);
        int area = AreaPesca.calcularAreaAproveitada(Collections.singletonList(rede));
        assertEquals(1, area);
    }

    @Test
    public void testNumeroMaximoDeRedes() {
        int expectedArea = 0;
        var redes = new java.util.ArrayList<Rede>();
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                redes.add(new Rede(i, i + 1, j, j + 1));
                expectedArea += 1;
            }
        }
        assertEquals(100, redes.size());
        int area = AreaPesca.calcularAreaAproveitada(redes);
        assertEquals(expectedArea, area);
    }
}
