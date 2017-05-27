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

/**
 * Created by di452 on 22.05.2017.
 */
@RunWith(Parameterized.class)
public class TestFirstStatementWithAllOtherFunc {


        private double input;
        private double expected;

        private FirstStatement statement;

        public TestFirstStatementWithAllOtherFunc(double input, double expected) {
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
            Cos cos = new Cos();
            Sec sec = new Sec();
            Cot cot = new Cot();
            Tan tan = new Tan();
            Csc csc = new Csc();
            statement = new FirstStatement(csc, cos, sec, cot, tan);
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


