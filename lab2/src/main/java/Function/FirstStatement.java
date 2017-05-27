package Function;

import tgiron.*;

/**
 * Created by di452 on 21.05.2017.
 */
public class FirstStatement extends AbstractFunction {

    private Cos cos;
    private Sec sec;
    private Csc csc;
    private Cot cot;
    private Tan tan;

    public FirstStatement(Csc csc, Cos cos, Sec sec, Cot cot, Tan tan) {

        this.csc = csc;
        this.cos = cos;
        this.sec = sec;
        this.cot = cot;
        this.tan = tan;
    }

    @Override
    public double calculate (double x) {
        if ( x <= 0) {

            double var1 = (Math.pow(tan.calculate(x),3) - cos.calculate(x))/cot.calculate(x);
            double var2 = sec.calculate(x)/cos.calculate(x);
            double var3 = Math.pow(var1-var2, 2);


            return var3;


            //return (((((sec.calculate(x) * cot.calculate(x)) * (csc.calculate(x) * tan.calculate(x))) / Math.pow(Math.pow(csc.calculate(x), 2) , 3)) / cos.calculate(x)) + (sec.calculate(x) + ((tan.calculate(x) + (csc.calculate(x) / csc.calculate(x))) + (csc.calculate(x) + cos.calculate(x)))));
        }
        else return Double.NaN;
    }

}