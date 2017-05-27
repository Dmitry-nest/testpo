package tgiron;

import Function.AbstractFunction;

import static Function.MathUtil.e;

/**
 * Created by di452 on 21.05.2017.
 */
public class Sec extends AbstractFunction {

    private Cos cos;

    public Sec() {
        cos = new Cos();
    }

    public Sec(Cos cos) {
        this.cos = cos;
    }

    @Override
    public double calculate (double x) {
        double temp_x = Math.abs(x);
        int flag = 0;

        while (temp_x > 0 && temp_x > e) {
            temp_x -= Math.PI/2;
            flag++;
        }

        if (Math.abs(temp_x) < e && flag % 2 == 1) {
            return temp_x > 0  ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        }

        return 1 / cos.calculate(x);
    }
}