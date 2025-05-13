import java.util.List;

import org.junit.jupiter.api.Assertions;

import br.pucrs.edu.Main;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.arbitraries.ListArbitrary;
import net.jqwik.api.Combinators;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;

public class AreaPescaPropertyTest {
    @Provide
    ListArbitrary<Main.AreaPesca.Rede> redesValidas() {
        return Combinators.combine(
            Arbitraries.integers().between(1, 100),
            Arbitraries.integers().between(1, 100),
            Arbitraries.integers().between(1, 100),
            Arbitraries.integers().between(1, 100)
        ).as((xi, xf, yi, yf) ->
            new Main.AreaPesca.Rede(Math.min(xi, xf), Math.max(xi, xf), Math.min(yi, yf), Math.max(yi, yf))
        )
        .list()
        .ofMinSize(1)
        .ofMaxSize(100);
    }

    @Property
    void areaNuncaNegativa(@ForAll("redesValidas") List<Main.AreaPesca.Rede> redes) {
        int area = Main.AreaPesca.calcularAreaAproveitada(redes);
        Assertions.assertTrue(area >= 0);
    }
}
