package tgiron;

import Function.AbstractFunction;

import static Function.MathUtil.e;

/**
 * Created by di452 on 21.05.2017.
 */
public class Cot extends AbstractFunction {

    private Sin sin;
    private Cos cos;

    public Cot(Sin sin, Cos cos) {
        this.sin = sin;
        this.cos = cos;
    }

    public Cot() {
        sin = new Sin();
        cos = new Cos();
    }

    @Override
    public double calculate(double x) {
        if (x == 0) {
            return Double.POSITIVE_INFINITY;
        }

        double temp_x = Math.abs(x);
        while (temp_x > 0) {
            temp_x -= Math.PI;
        }


        if (Math.abs(temp_x) < e) {
            return x < 0 ? Double.POSITIVE_INFINITY : Double.NEGATIVE_INFINITY;
        }

        return cos.calculate(x) / sin.calculate(x);
    }
}

