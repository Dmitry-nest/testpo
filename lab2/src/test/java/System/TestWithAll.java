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
import tgiron.*;

import java.util.Arrays;
import java.util.Collection;

import static Function.MathUtil.d;
import static Function.MathUtil.delta;

/**
 * Created by di452 on 22.05.2017.
 */
@RunWith(Parameterized.class)
public class TestWithAll {

    private double input;
    private double expected;

    private FirstStatement firstStatement;
    private SecondStatement secondStatement;

    private Main main;

    public TestWithAll(double input, double expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> input_data() {
        return Arrays.asList(new Object[][]{
                {0.0, 1.02},//1
                {0.0 - d, 0.98},//2
                {-Math.PI, 1.0 },//3
                {-Math.PI + d,0.98},//4
                {-Math.PI - d, 1.02},//5
                {-Math.PI / 2, Double.NaN},//6
                {-2 * Math.PI + d, 1.02},//7
                {-2 * Math.PI, 1.0},//8
                {-2 * Math.PI - d, 0.98},//9
        });
    }



    @Before
    public void initTest () {
        firstStatement = new FirstStatement(new Csc(), new Cos(), new Sec(), new Cot(), new Tan());
        secondStatement = new SecondStatement(new Ln(),new Log2(), new Log3(), new Log5(), new Log10());
        main = new Main(firstStatement, secondStatement);

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
