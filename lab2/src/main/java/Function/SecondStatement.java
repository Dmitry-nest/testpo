package Function;

import Logarifm.*;

/**
 * Created by di452 on 21.05.2017.
 */
public class   SecondStatement extends AbstractFunction {

    private Ln ln;
    private Log2 log2;
    private Log3 log3;
    private Log5 log5;
    private Log10 log10;

    public SecondStatement(Ln ln, Log2 log2, Log3 log3, Log5 log5, Log10 log10) {
        this.ln = ln;
        this.log2 = log2;
        this.log3 = log3;
        this.log5 = log5;
        this.log10 = log10;
    }


    public double calculate(double x) {

        if (!(x>0)) return Double.NaN;

        double var1 = (((log3.calculate(x)/log2.calculate(x))+ln.calculate(x))+log2.calculate(x))-log2.calculate(x);
        double var2 = (log5.calculate(x)+(Math.pow((log10.calculate(x)*log5.calculate(x)),2)))*log3.calculate(x);
        return  var1+var2;

    }

}