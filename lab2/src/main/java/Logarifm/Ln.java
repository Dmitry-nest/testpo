package Logarifm;

import Function.AbstractFunction;

/**
 * Created by di452 on 21.05.2017.
 */
public class Ln extends AbstractFunction {

    private Log log;

    public Ln () {this.log = new Log();}
    public Ln (Log log) {this.log = log;}

    @Override
    public double calculate(double x) {
        return log.calculate(x)/log.calculate(Math.E);
    }

}