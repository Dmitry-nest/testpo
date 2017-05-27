package System;

import Function.FirstStatement;
import Function.Main;
import Function.SecondStatement;
import Logarifm.*;
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
 * Created by di452 on 22.05.2017.
 */
@RunWith(Parameterized.class)
public class TestWithoutAll {


    private double input;
    private double expected;

    private FirstStatement firstStatement;
    private SecondStatement secondStatement;

    private Main main;

    public TestWithoutAll(double input, double expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> input_data() {
        return Arrays.asList(new Object[][]{
                {0,Double.NaN},
                {-3*Math.PI/4, -1.89},
                {-7*Math.PI/4, 5.88},
                {-4*Math.PI/3, -0.13},
                {-Math.PI/5, 0.50997}
        });
    }



    @Before
    public void initTest () {
        firstStatement =  mock(FirstStatement.class);
        secondStatement = new SecondStatement(new Ln(),new Log2(), new Log3(), new Log5(), new Log10());
        main = new Main(firstStatement, secondStatement);

        when(firstStatement.calculate(0.0 - d)).thenReturn(0.98);
        when(firstStatement.calculate(0.0)).thenReturn(Double.NaN);
        when(firstStatement.calculate(-3*Math.PI/4)).thenReturn(-1.89011);
        when(firstStatement.calculate(-7*Math.PI/4)).thenReturn(5.88829);
        when(firstStatement.calculate(-4*Math.PI/3)).thenReturn(-0.12772);
        when(firstStatement.calculate(-Math.PI/5)).thenReturn(0.50997);

    }

    @Test
    public void test () throws Exception {
        double result = main.calculate(input);

        if (Double.isNaN(expected) || Double.isInfinite(expected)) {
            Assert.assertTrue(Double.isInfinite(result) || Double.isNaN(result));
        }  else {
            Assert.assertEquals(expected, result, delta);
        }
    }

}
