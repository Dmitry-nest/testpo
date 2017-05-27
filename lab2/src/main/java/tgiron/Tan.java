package tgiron;

import Function.AbstractFunction;

import static Function.MathUtil.e;

/**
 * Created by di452 on 21.05.2017.
 */
public class Tan extends AbstractFunction {

    private Sin sin;
    private Cos cos;

    public Tan() {
        this.sin = new Sin();
        this.cos = new Cos();
    }

    public Tan(Sin sin, Cos cos) {
        this.sin = sin;
        this.cos = cos;
    }

    @Override
    public double calculate(double x) {
        double temp_x = Math.abs(x);
        int flag = 0;

        while (temp_x > 0) {
            temp_x -= Math.PI / 2;
            flag++;
        }

        if (Math.abs(temp_x) < e && flag % 2 != 0) {
            return x > 0 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
        }

        return sin.calculate(x) / cos.calculate(x);
    }
}


