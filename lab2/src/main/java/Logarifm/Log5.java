package Logarifm;

import Function.AbstractFunction;

/**
 * Created by di452 on 21.05.2017.
 */
public class Log5 extends AbstractFunction {

    private Log log;

    public Log5 () {
        this.log = new Log();
    }

    public Log5 (Log log) {
        this.log = log;
    }

    @Override
    public double calculate(double x) {
        return log.calculate(x)/log.calculate(5);
    }

}