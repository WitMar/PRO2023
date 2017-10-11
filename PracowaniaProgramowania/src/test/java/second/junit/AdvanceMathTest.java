package second.junit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdvanceMathTest {

    AdvanceMath math;
    final static Logger logger = Logger.getLogger(AdvanceMath.class);

    @Before
    public void setUp(){
        logger.info("Odpalam setUpa");
        math = new AdvanceMath();
    }

    @Test
    public void additionTest() {
        Integer a = math.addition(1,4);
        assertTrue(a==5);
    }

    @Test
    public void additionTestString() {
        long a = math.addition("1",4);
        Assert.assertEquals(5L, a);
    }

    @Test(expected = Exception.class)
    public void additionTestString2() {
        int a = math.addition("a1",4);
    }

}