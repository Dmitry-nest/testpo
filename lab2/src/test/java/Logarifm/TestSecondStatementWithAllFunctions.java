package Logarifm;

import Function.SecondStatement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static Function.MathUtil.d;
import static Function.MathUtil.delta;

/**
 * Created by di452 on 21.05.2017.
 */
@RunWith(Parameterized.class)
public class TestSecondStatementWithAllFunctions {

    private double input;
    private double expected;

    private SecondStatement statement;

    public TestSecondStatementWithAllFunctions(double input, double expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> input_data() {
        return Arrays.asList(new Object[][]{
                {0.0, Double.NaN},
                {0.0 + d, -129.23},
                {0.25, 0},
                {1.0 - d, 0.63},
                {1.0, Double.NaN},
                {1.0 + d, 0.62},
                {1.5, 1.13},
                {2, 1.6}

        });
    }


    @Before
    public void initTest() {
        Ln ln = new Ln();
        Log2 log2 = new Log2();
        Log3 log3 = new Log3();
        Log5 log5 = new Log5();
        Log10 log10 = new Log10();
        statement = new SecondStatement(ln,log2, log3, log5, log10);
    }

    @Test
    public void test () throws Exception {
        double result = statement.calculate(input);

        if (Double.isNaN(expected)) {
            Assert.assertTrue(Double.isNaN(result));
        } else if (Double.isNaN(result)) {
            Assert.fail();
        } else {
            Assert.assertEquals(expected, result, delta);
        }
    }
}