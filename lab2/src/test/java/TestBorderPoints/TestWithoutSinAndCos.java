package TestBorderPoints;

import Function.FirstStatement;
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by di452 on 22.05.2017.
 */
@RunWith(Parameterized.class)
public class TestWithoutSinAndCos {


        private double input;
        private double expected;

        private Sin sin;
        private Cos cos;
        private Sec sec;
        private Cot cot;
        private Tan tan;
        private Csc csc;

        private FirstStatement statement;

        public TestWithoutSinAndCos(double input, double expected) {
            this.input = input;
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Collection<Object[]> input_data() {
            return Arrays.asList(new Object[][]{
                    {0.0 + d, Double.NaN},//0
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
        public void initTest () throws Exception {
            sin = mock(Sin.class);
            cos = mock(Cos.class);
            sec = new Sec(cos);
            csc = new Csc(sin);
            cot = new Cot(sin, cos);
            tan = new Tan(sin, cos);
            statement = new FirstStatement(csc, cos, sec, cot, tan);

            when(sin.calculate(0.0 + d)).thenReturn(0.00999);
            when(sin.calculate(0.0)).thenReturn(0.0);
            when(sin.calculate(0.0 - d)).thenReturn(-0.0099998);
            when(sin.calculate(-Math.PI / 2 + d)).thenReturn(-0.99995);
            when(sin.calculate(-Math.PI / 2)).thenReturn(-1.0);
            when(sin.calculate(-Math.PI / 2 - d)).thenReturn(-0.99995);
            when(sin.calculate(-Math.PI + d)).thenReturn(-0.0099998);
            when(sin.calculate(-Math.PI)).thenReturn(-1.22465);
            when(sin.calculate(-Math.PI - d)).thenReturn(0.0099998);
            when(sin.calculate(-2 * Math.PI + d)).thenReturn(0.0099998);
            when(sin.calculate(-2 * Math.PI)).thenReturn(0.0);
            when(sin.calculate(-2 * Math.PI - d)).thenReturn(-0.0099998);

            when(cos.calculate(0.0)).thenReturn(1.0);
            when(cos.calculate(0.0 - d)).thenReturn(0.99995);
            when(cos.calculate(-Math.PI/2 + d)).thenReturn(0.0099998);
            when(cos.calculate(-Math.PI/2)).thenReturn(0.0);
            when(cos.calculate(-Math.PI/2 - d)).thenReturn(-0.0099998);
            when(cos.calculate(-3*Math.PI/2 + d)).thenReturn(-0.0099998);
            when(cos.calculate(-3*Math.PI/2)).thenReturn(0.0);
            when(cos.calculate(-3*Math.PI/2 - d)).thenReturn(0.0099998);
            when(cos.calculate(-Math.PI + d)).thenReturn(-0.99995);
            when(cos.calculate(-Math.PI)).thenReturn(-1.0);
            when(cos.calculate(-Math.PI - d)).thenReturn(-0.99995);
            when(cos.calculate(-2*Math.PI + d)).thenReturn(0.99995);
            when(cos.calculate(-2*Math.PI)).thenReturn(1.0);
            when(cos.calculate(-2*Math.PI - d)).thenReturn(0.99995);
        }

        @Test
        public void test () throws Exception {
            double result = statement.calculate(input);

            if (Double.isNaN(expected) || Double.isInfinite(expected)) {
                Assert.assertTrue(Double.isInfinite(result) || Double.isNaN(result));
            }  else {
                Assert.assertEquals(expected, result, delta);
            }
        }

    }


