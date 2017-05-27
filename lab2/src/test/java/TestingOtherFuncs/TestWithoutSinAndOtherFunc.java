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
public class TestWithoutSinAndOtherFunc {


        private double input;
        private double expected;

        private FirstStatement statement;

        public TestWithoutSinAndOtherFunc(double input, double expected) {
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
                    {-8*Math.PI/5, 6130.30},
                    {-7*Math.PI/4, 2.91}
            });
        }

        @Before
        public void initTest() throws Exception {
            Sin sin = mock(Sin.class);
            Cos cos = new Cos(sin);
            Sec sec = new Sec(cos);
            Cot cot = new Cot(sin, cos);
            Tan tan = new Tan(sin, cos);
            Csc csc = new Csc(sin);
            statement = new FirstStatement(csc, cos, sec, cot, tan);


            when(sin.calculate(0 + Math.PI/2)).thenReturn(1.0);
            when(sin.calculate(0)).thenReturn(0.0);

            when(sin.calculate(-Math.PI / 4 + Math.PI / 2)).thenReturn(0.70711);
            when(sin.calculate(-Math.PI / 4)).thenReturn(-0.70711);

            when(sin.calculate(-Math.PI / 3 + Math.PI / 2)).thenReturn(0.5);
            when(sin.calculate(-Math.PI / 3)).thenReturn(-0.86602);

            when(sin.calculate(-3 * Math.PI / 4 + Math.PI / 2)).thenReturn(-0.70711);
            when(sin.calculate(-3 * Math.PI / 4)).thenReturn(-0.70711);

            when(sin.calculate(-5 * Math.PI / 6 + Math.PI / 2)).thenReturn(-0.86603);
            when(sin.calculate(-5 * Math.PI / 6)).thenReturn(-0.5);

            when(sin.calculate(-6 * Math.PI / 5 + Math.PI / 2)).thenReturn(-0.80902);
            when(sin.calculate(-6 * Math.PI / 5)).thenReturn(0.58779);

            when(sin.calculate(-5 * Math.PI / 4 + Math.PI / 2)).thenReturn(-0.70711);
            when(sin.calculate(-5 * Math.PI / 4)).thenReturn(0.70711);

            when(sin.calculate(-8 * Math.PI / 5 + Math.PI / 2)).thenReturn(0.30902);
            when(sin.calculate(-8 * Math.PI / 5)).thenReturn(0.95106);

            when(sin.calculate(-7 * Math.PI / 4 + Math.PI / 2)).thenReturn(0.70711);
            when(sin.calculate(-7 * Math.PI / 4)).thenReturn(0.70711);
        }

        @Test
        public void test() throws Exception {
            double result = statement.calculate(input);

            if (Double.isInfinite(result) || Double.isNaN(result)) {
                Assert.fail();
            }

            Assert.assertEquals(expected, result, delta);
        }

    }


