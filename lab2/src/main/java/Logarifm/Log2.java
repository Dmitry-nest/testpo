package Logarifm;

import Function.AbstractFunction;

/**
 * Created by di452 on 21.05.2017.
 */
public class Log2 extends AbstractFunction {

    private Log log;

    public Log2 () {
        this.log = new Log();
    }

    public Log2 (Log log) {
        this.log = log;
    }

    @Override
    public double calculate(double x) {
        return log.calculate(x)/log.calculate(2);
    }

}
