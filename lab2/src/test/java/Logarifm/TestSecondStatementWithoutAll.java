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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * Created by di452 on 21.05.2017.
 */
@RunWith(Parameterized.class)
public class TestSecondStatementWithoutAll {

    private double input;
    private double expected;

    private SecondStatement statement;

    public TestSecondStatementWithoutAll(double input, double expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> input_data() {
        return Arrays.asList(new Object[][]{
                {0.0, Double.NaN},
                {0.0 + d, -129.23},
                {0.25, -0.008},
                {1.0 - d, 0.63},
                {1.0, Double.NaN},
                {1.0 + d, 0.62},
                {1.5, 1.13},
                {2, 1.6}
        });
    }

    @Before
    public void initTest() {
        Ln ln = mock(Ln.class);
        Log2 log2 = mock(Log2.class);
        Log3 log3 = mock(Log3.class);
        Log5 log5 = mock(Log5.class);
        Log10 log10 = mock(Log10.class);
        statement = new SecondStatement(ln,log2, log3, log5, log10);


        when(ln.calculate(0.0)).thenReturn(Double.NEGATIVE_INFINITY);
        when(ln.calculate(0.0 + d)).thenReturn(-4.60517);
        when(ln.calculate(0.25)).thenReturn(-1.38);
        when(ln.calculate(1.0 - d)).thenReturn(-0.01005);
        when(ln.calculate(1.0)).thenReturn(0.0);
        when(ln.calculate(1.0 + d)).thenReturn(0.00995);
        when(ln.calculate(1.5)).thenReturn(0.4);
        when(ln.calculate(2)).thenReturn(0.69315);

        when(log2.calculate(0.0)).thenReturn(Double.NEGATIVE_INFINITY);
        when(log2.calculate(0.0 + d)).thenReturn(-6.64386);
        when(log2.calculate(0.25)).thenReturn(-2.0);
        when(log2.calculate(1.0 - d)).thenReturn(-0.01450);
        when(log2.calculate(1.0)).thenReturn(0.0);
        when(log2.calculate(1.0 + d)).thenReturn(0.01436);
        when(log2.calculate(1.5)).thenReturn(0.58);
        when(log2.calculate(2)).thenReturn(1.0);


        when(log3.calculate(0.0)).thenReturn(Double.NEGATIVE_INFINITY);
        when(log3.calculate(0.0 + d)).thenReturn(-4.19181);
        when(log3.calculate(0.25)).thenReturn(-1.26);
        when(log3.calculate(1.0 - d)).thenReturn(-0.00915);
        when(log3.calculate(1.0)).thenReturn(0.0);
        when(log3.calculate(1.0 + d)).thenReturn(0.00906);
        when(log3.calculate(1.5)).thenReturn(0.36);
        when(log3.calculate(2)).thenReturn(0.63093);

        when(log5.calculate(0.0)).thenReturn(Double.NEGATIVE_INFINITY);
        when(log5.calculate(0.0 + d)).thenReturn(-2.86134);
        when(log5.calculate(0.25)).thenReturn(-0.86);
        when(log5.calculate(1.0 - d)).thenReturn(-0.00624);
        when(log5.calculate(1.0)).thenReturn(0.0);
        when(log5.calculate(1.0 + d)).thenReturn(0.00618);
        when(log5.calculate(1.5)).thenReturn(0.25);
        when(log5.calculate(2)).thenReturn(0.43068);

        when(log10.calculate(0.0)).thenReturn(Double.NEGATIVE_INFINITY);
        when(log10.calculate(0.0 + d)).thenReturn(-2.0);
        when(log10.calculate(0.25)).thenReturn(-0.6);
        when(log10.calculate(1.0 - d)).thenReturn(-0.00436);
        when(log10.calculate(1.0)).thenReturn(0.0);
        when(log10.calculate(1.0 + d)).thenReturn(0.00432);
        when(log10.calculate(1.5)).thenReturn(0.18);
        when(log10.calculate(2)).thenReturn(0.30103);
    }

    @Test
    public void test() {
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

