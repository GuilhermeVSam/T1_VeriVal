import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

public class MainPropertyTest {
    @Property
	boolean absoluteValueOfAllNumbersIsPositive(@ForAll int anInteger) {
		return anInteger == anInteger;
	}
}
