package tgiron;

import Function.AbstractFunction;

import static Function.MathUtil.factorial;

/**
 * Created by di452 on 21.05.2017.
 */
public class Sin extends AbstractFunction {

    @Override
    public double calculate (double x) {
        double result = 0.0;

        for (int i = 0; i < 100; i++) {
            double d = Math.pow(-1, i) * Math.pow(x, 2 * i + 1) / factorial(2 * i + 1);
            if (Double.isNaN(d)) return result;
            result += d;
        }

        return result;
    }
}

