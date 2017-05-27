package tgiron;

import Function.AbstractFunction;

import static Function.MathUtil.e;

/**
 * Created by di452 on 21.05.2017.
 */
public class Csc extends AbstractFunction {

    private Sin sin;

    public Csc() {
        sin = new Sin();
    }

    public Csc(Sin sin) {
        this.sin = sin;
    }

    @Override
    public double calculate (double x) {
        double temp_x = Math.abs(x);
        int flag = 0;

        while (temp_x > 0 && temp_x > e) {
            temp_x -= Math.PI/2;
            flag++;
        }

        if (Math.abs(temp_x) < e && flag % 2 == 0) {
            return temp_x > 0  ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        }

        return 1 / sin.calculate(x);
    }
}