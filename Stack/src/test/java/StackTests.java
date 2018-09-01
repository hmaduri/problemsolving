import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * Testing class for all the algorithms which use Stack as their primary datastructure.
 */
public class StackTests {
    @Test public void TestremoveKDigits() {
        RemoveKDigits algorithm = new RemoveKDigits();
        assertEquals("1219", algorithm.removeKdigits("1432219",3));
        assertEquals("200", algorithm.removeKdigits("10200", 1));
        assertEquals("0", algorithm.removeKdigits("0", 2));
        assertEquals("0", algorithm.removeKdigits("10",1));
        assertEquals("0", algorithm.removeKdigits("100", 1));
    }


}
