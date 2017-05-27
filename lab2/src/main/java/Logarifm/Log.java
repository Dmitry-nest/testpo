package Logarifm;

import Function.AbstractFunction;

import static Function.MathUtil.e;

/**
 * Created by di452 on 21.05.2017.
 */
public class Log extends AbstractFunction {


    @Override
    public double calculate (double x) {
        if(x == 0) {
            return Double.NEGATIVE_INFINITY;
        }
        if(x < 0) {
            return Double.NaN;
        }


        double result = 0;
        for(double i = 0, temp_result = 1; Math.abs(temp_result - result) > e; i++) {
            temp_result = result;
            result += 2.0 / (2.0 * i + 1) * Math.pow(((x - 1.0) / (x + 1.0)), 2.0 * i + 1.0);
        }
        return result;
    }
}