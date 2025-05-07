import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.pucrs.edu.Main;

public class MainUnitTest {
    
    @Test
    void testHello(){
        assertEquals("Hello, World", Main.hello());
    }
}
