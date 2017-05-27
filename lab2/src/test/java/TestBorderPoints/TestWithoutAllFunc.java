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
public class TestWithoutAllFunc {

        private double input;
        private double expected;

        private Sin sin;
        private Cos cos;
        private Sec sec;
        private Cot cot;
        private Tan tan;
        private Csc csc;

        private FirstStatement statement;

        public TestWithoutAllFunc(double input, double expected) {
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
        public void initTest() throws Exception {
            cos = mock(Cos.class);
            sec = mock(Sec.class);
            cot = mock(Cot.class);
            tan = mock(Tan.class);
            csc = mock(Csc.class);
            statement = new FirstStatement(csc, cos, sec, cot, tan);

            when(cos.calculate(0.0)).thenReturn(1.0);
            when(cos.calculate(0.0 - d)).thenReturn(0.99995);
            when(cos.calculate(-Math.PI / 2 + d)).thenReturn(0.0099998);
            when(cos.calculate(-Math.PI / 2)).thenReturn(0.0);
            when(cos.calculate(-Math.PI / 2 - d)).thenReturn(-0.0099998);
            when(cos.calculate(-Math.PI + d)).thenReturn(-0.99995);
            when(cos.calculate(-Math.PI)).thenReturn(-1.0);
            when(cos.calculate(-Math.PI - d)).thenReturn(-0.99995);
            when(cos.calculate(-2 * Math.PI + d)).thenReturn(0.99995);
            when(cos.calculate(-2 * Math.PI)).thenReturn(1.0);
            when(cos.calculate(-2 * Math.PI - d)).thenReturn(0.99995);

            when(sec.calculate(0.0)).thenReturn(1.0);
            when(sec.calculate(0.0 - d)).thenReturn(1.00005);
            when(sec.calculate(-Math.PI / 2 + d)).thenReturn(100.002);
            when(sec.calculate(-Math.PI / 2)).thenReturn(Double.NEGATIVE_INFINITY);
            when(sec.calculate(-Math.PI / 2 - d)).thenReturn(-100.002);
            when(sec.calculate(-Math.PI + d)).thenReturn(-1.00005);
            when(sec.calculate(-Math.PI)).thenReturn(-1.0);
            when(sec.calculate(-Math.PI - d)).thenReturn(-1.00005);
            when(sec.calculate(-2 * Math.PI + d)).thenReturn(1.00005);
            when(sec.calculate(-2 * Math.PI)).thenReturn(1.0);
            when(sec.calculate(-2 * Math.PI - d)).thenReturn(1.00005);

            when(csc.calculate(0.0)).thenReturn(Double.POSITIVE_INFINITY);
            when(csc.calculate(0.0 - d)).thenReturn(-100.002);
            when(csc.calculate(-Math.PI / 2 + d)).thenReturn(-1.00005);
            when(csc.calculate(-Math.PI / 2)).thenReturn(-1.0);
            when(csc.calculate(-Math.PI / 2 - d)).thenReturn(-1.00005);
            when(csc.calculate(-Math.PI + d)).thenReturn(-100.002);
            when(csc.calculate(-Math.PI)).thenReturn(Double.POSITIVE_INFINITY);
            when(csc.calculate(-Math.PI - d)).thenReturn(100.002);
            when(csc.calculate(-2 * Math.PI + d)).thenReturn(100.002);
            when(csc.calculate(-2 * Math.PI)).thenReturn(Double.POSITIVE_INFINITY);
            when(csc.calculate(-2 * Math.PI - d)).thenReturn(-100.002);


            when(cot.calculate(0.0)).thenReturn(Double.NEGATIVE_INFINITY);
            when(cot.calculate(0.0 - d)).thenReturn(-99.9967);
            when(cot.calculate(-Math.PI / 2 + d)).thenReturn(-0.01);
            when(cot.calculate(-Math.PI / 2)).thenReturn(0.0);
            when(cot.calculate(-Math.PI / 2 - d)).thenReturn(0.01);
            when(cot.calculate(-Math.PI + d)).thenReturn(99.9967);
            when(cot.calculate(-Math.PI)).thenReturn(Double.NEGATIVE_INFINITY);
            when(cot.calculate(-Math.PI - d)).thenReturn(-99.9967);
            when(cot.calculate(-2 * Math.PI + d)).thenReturn(99.9967);
            when(cot.calculate(-2 * Math.PI)).thenReturn(Double.NEGATIVE_INFINITY);
            when(cot.calculate(-2 * Math.PI - d)).thenReturn(-99.9967);

            when(tan.calculate(0.0)).thenReturn(0.0);
            when(tan.calculate(0.0 - d)).thenReturn(-0.01);
            when(tan.calculate(-Math.PI / 2 + d)).thenReturn(-99.9967);
            when(tan.calculate(-Math.PI / 2)).thenReturn(Double.NEGATIVE_INFINITY);
            when(tan.calculate(-Math.PI / 2 - d)).thenReturn(99.9967);
            when(tan.calculate(-Math.PI + d)).thenReturn(0.01);
            when(tan.calculate(-Math.PI)).thenReturn(0.0);
            when(tan.calculate(-Math.PI - d)).thenReturn(-0.01);
            when(tan.calculate(-2 * Math.PI + d)).thenReturn(0.01);
            when(tan.calculate(-2 * Math.PI)).thenReturn(0.0);
            when(tan.calculate(-2 * Math.PI - d)).thenReturn(-0.01);
        }

        @Test
        public void test() throws Exception {
            double result = statement.calculate(input);

            if (Double.isNaN(expected) || Double.isInfinite(expected)) {
                Assert.assertTrue(Double.isInfinite(result) || Double.isNaN(result));
            } else {
                Assert.assertEquals(expected, result, delta);
            }
        }

    }


