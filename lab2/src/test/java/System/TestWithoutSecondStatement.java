package System;

import Function.FirstStatement;
import Function.Main;
import Function.SecondStatement;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import tgiron.*;

import java.util.Arrays;
import java.util.Collection;

import static Function.MathUtil.delta;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by di452 on 22.05.2017.
 */
@RunWith(Parameterized.class)
public class TestWithoutSecondStatement {


    private double input;
    private double expected;

    private FirstStatement firstStatement;
    private SecondStatement secondStatement;

    private Main main;

    public TestWithoutSecondStatement(double input, double expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> input_data() {
        return Arrays.asList(new Object[][]{
                {0.0, 1.0},
                {0.5, 0.19},
                {1.0, Double.NaN},
                {1.25,0.88},
                {2,1.6}
        });
    }



    @Before
    public void initTest () {
        firstStatement =  new FirstStatement(new Csc(), new Cos(), new Sec(), new Cot(), new Tan());
        secondStatement = mock(SecondStatement.class);
        main = new Main(firstStatement, secondStatement);

        when(secondStatement.calculate(0.0)).thenReturn(1.0);
        when(secondStatement.calculate(0.5)).thenReturn(0.19);
        when(secondStatement.calculate(1.0)).thenReturn(Double.NaN);
        when(secondStatement.calculate(1.25)).thenReturn(0.88);
        when(secondStatement.calculate(2)).thenReturn(1.6);
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
