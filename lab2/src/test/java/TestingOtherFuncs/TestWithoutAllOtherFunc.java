package TestingOtherFuncs;

import Function.FirstStatement;
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
public class TestWithoutAllOtherFunc {

        private double input;
        private double expected;

        private FirstStatement statement;

        public TestWithoutAllOtherFunc (double input, double expected) {
            this.input = input;
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Collection<Object[]> input_data() {
            return Arrays.asList(new Object[][]{
                    {0,1.0},
                    {-Math.PI/4, 0.08578},
                    {-Math.PI/3, 34.41},
                    {-3*Math.PI/4, 0.085},
                    {-5*Math.PI/6, 0.52},
                    {-6*Math.PI/5, 3.37},
                    {-5*Math.PI/4, 2.914},
                    {-8*Math.PI/5, 6130.6029},
                    {-7*Math.PI/4, 2.91}
            });
        }

        @Before
        public void initTest () throws Exception {
            Cos cos = mock(Cos.class);
            Sec sec = mock(Sec.class);
            Cot cot = mock(Cot.class);
            Tan tan = mock(Tan.class);
            Csc csc = mock(Csc.class);
            statement = new FirstStatement(csc, cos, sec, cot, tan);

            when(cos.calculate(0)).thenReturn(1.0);
            when(cos.calculate(-Math.PI/4)).thenReturn(0.70711);
            when(cos.calculate(-Math.PI/3)).thenReturn(0.5);
            when(cos.calculate(-3*Math.PI/4)).thenReturn(-0.70711);
            when(cos.calculate(-5*Math.PI/6)).thenReturn(-0.86603);
            when(cos.calculate(-6*Math.PI/5)).thenReturn(-0.80902);
            when(cos.calculate(-5*Math.PI/4)).thenReturn(-0.70711);
            when(cos.calculate(-8*Math.PI/5)).thenReturn(0.30902);
            when(cos.calculate(-7*Math.PI/4)).thenReturn(0.70711);

            when(sec.calculate(0)).thenReturn(1.0);
            when(sec.calculate(-Math.PI/4)).thenReturn(1.41421);
            when(sec.calculate(-Math.PI/3)).thenReturn(2.0);
            when(sec.calculate(-3*Math.PI/4)).thenReturn(-1.41421);
            when(sec.calculate(-5*Math.PI/6)).thenReturn(-1.1547);
            when(sec.calculate(-6*Math.PI/5)).thenReturn(-1.23607);
            when(sec.calculate(-5*Math.PI/4)).thenReturn(-1.41421);
            when(sec.calculate(-8*Math.PI/5)).thenReturn(3.23607);
            when(sec.calculate(-7*Math.PI/4)).thenReturn(1.41421);

            when(csc.calculate(0)).thenReturn(Double.POSITIVE_INFINITY);
            when(csc.calculate(-Math.PI/4)).thenReturn( -1.41421);
            when(csc.calculate(-Math.PI/3)).thenReturn( -1.15470);
            when(csc.calculate(-3*Math.PI/4)).thenReturn(-1.41421);
            when(csc.calculate(-5*Math.PI/6)).thenReturn(-2.0);
            when(csc.calculate(-6*Math.PI/5)).thenReturn(1.70130);
            when(csc.calculate(-5*Math.PI/4)).thenReturn(1.41421);
            when(csc.calculate(-8*Math.PI/5)).thenReturn(1.05146);
            when(csc.calculate(-7*Math.PI/4)).thenReturn(1.41421);

            when(cot.calculate(0)).thenReturn(Double.POSITIVE_INFINITY);
            when(cot.calculate(-Math.PI/4)).thenReturn(-1.0);
            when(cot.calculate(-Math.PI/3)).thenReturn(-0.57735);
            when(cot.calculate(-3*Math.PI/4)).thenReturn(1.0);
            when(cot.calculate(-5*Math.PI/6)).thenReturn(1.73205);
            when(cot.calculate(-6*Math.PI/5)).thenReturn(-1.37638);
            when(cot.calculate(-5*Math.PI/4)).thenReturn(-1.0);
            when(cot.calculate(-8*Math.PI/5)).thenReturn(0.32492);
            when(cot.calculate(-7*Math.PI/4)).thenReturn(1.0);

            when(tan.calculate(0)).thenReturn(0.0);
            when(tan.calculate(-Math.PI/4)).thenReturn(-1.0);
            when(tan.calculate(-Math.PI/3)).thenReturn(-1.73205);
            when(tan.calculate(-3*Math.PI/4)).thenReturn(1.0);
            when(tan.calculate(-5*Math.PI/6)).thenReturn(0.57735);
            when(tan.calculate(-6*Math.PI/5)).thenReturn(-0.72654);
            when(tan.calculate(-5*Math.PI/4)).thenReturn(-1.0);
            when(tan.calculate(-8*Math.PI/5)).thenReturn(3.07768);
            when(tan.calculate(-7*Math.PI/4)).thenReturn(1.0);
        }

        @Test
        public void test () throws Exception {
            double result = statement.calculate(input);

            if (Double.isInfinite(result) || Double.isNaN(result)) {
                Assert.fail();
            }
            Assert.assertEquals(expected, result, delta);
        }

    }
