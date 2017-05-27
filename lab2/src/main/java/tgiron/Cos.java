package tgiron;

import Function.AbstractFunction;

/**
 * Created by di452 on 21.05.2017.
 */
public class Cos extends AbstractFunction {

    private Sin sin;

    public Cos() {
        this.sin = new Sin();
    }

    public Cos(Sin sin) {
        this.sin = sin;
    }

    @Override
    public double calculate (double x) {
        return sin.calculate(x + Math.PI / 2);
    }
}
