import br.pucrs.edu.Main.AreaPesca;
import br.pucrs.edu.Main.AreaPesca.Rede;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AreaPescaPartitTest {

    // Rede com area maior 0
    @Test
    public void testRedeValidaAreaSimples() {
        Rede rede = new Rede(1, 3, 1, 3);
        int area = AreaPesca.calcularAreaAproveitada(List.of(rede));
        assertEquals(4, area);
    }

    // Rede com area igual 0
    @Test
    public void testRedeComAreaZero_XiIgualXf() {
        Rede rede = new Rede(5, 5, 1, 10);
        int area = AreaPesca.calcularAreaAproveitada(List.of(rede));
        assertEquals(0, area);
    }

    // Duas redes sem sobreposição
    @Test
    public void testDuasRedesSemSobreposicao() {
        Rede r1 = new Rede(1, 3, 1, 3); // 4
        Rede r2 = new Rede(4, 6, 4, 6); // 4
        int area = AreaPesca.calcularAreaAproveitada(List.of(r1, r2));
        assertEquals(8, area);
    }

    // Duas redes com sobreposição parcial
    @Test
    public void testDuasRedesComSobreposicao() {
        Rede r1 = new Rede(1, 4, 1, 4); 
        Rede r2 = new Rede(3, 6, 3, 6); 
        int area = AreaPesca.calcularAreaAproveitada(List.of(r1, r2));
        assertEquals(14, area); 
    }

    // Rede ocupando todo o mar
    @Test
    public void testRedePreencheMarCompleto() {
        Rede rede = new Rede(1, 101, 1, 101);
        int area = AreaPesca.calcularAreaAproveitada(List.of(rede));
        assertEquals(10000, area);
    }

    // Xi menor que 1
    @Test
    public void testRedeComXiInvalido() {
        Rede rede = new Rede(0, 10, 1, 10);
        assertThrows(AssertionError.class, () -> AreaPesca.calcularAreaAproveitada(List.of(rede)));
    }

    // Xf maior que 100
    @Test
    public void testRedeComXfMaiorQue100() {
        Rede rede = new Rede(90, 101, 1, 10);
        assertThrows(AssertionError.class, () -> AreaPesca.calcularAreaAproveitada(List.of(rede)));
    }

    // Xi maior que Xf
    @Test
    public void testRedeComXiMaiorQueXf() {
        Rede rede = new Rede(10, 5, 1, 10);
        assertThrows(AssertionError.class, () -> AreaPesca.calcularAreaAproveitada(List.of(rede)));
    }

    // Yi menor que 1
    @Test
    public void testRedeComYiInvalido() {
        Rede rede = new Rede(1, 10, 0, 10);
        assertThrows(AssertionError.class, () -> AreaPesca.calcularAreaAproveitada(List.of(rede)));
    }

    // Yf maior que 100
    @Test
    public void testRedeComYfMaiorQue100() {
        Rede rede = new Rede(1, 10, 90, 101);
        assertThrows(AssertionError.class, () -> AreaPesca.calcularAreaAproveitada(List.of(rede)));
    }
}
