package Function;

/**
 * Created by di452 on 21.05.2017.
 */
public class MathUtil {

    //public static final int n = 100;

    public static final double e = 0.00001;
    public static final double d = 0.01;
    public static final double delta = 0.2;

    public static double factorial(int n) {
        double r = 1;
        for (int i = 2; i <= n; ++i) {
            r *= i;
        }
        return r;
    }
}
