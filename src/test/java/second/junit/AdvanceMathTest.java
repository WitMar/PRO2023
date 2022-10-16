package second.junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AdvanceMathTest {

    AdvanceMath math;

    @Before
    public void setUp() {
        System.out.println("Run setUp");
        math = new AdvanceMath();
    }

    @Test
    public void additionTest() {
        Integer a = math.addition(1, 4);
        Assert.assertTrue(a == 5);
    }

    @Test
    public void additionTestString() {
        long a = math.addition("1", 4);
        Assert.assertEquals(5L, a);
    }


    @Test(expected = Exception.class)
    public void additionTestString2() {
        int a = math.addition("a1", 4);
    }

}