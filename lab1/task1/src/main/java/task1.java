/**
 * Created by Дмитрий on 25.03.2017.
 */
public class task1 {
    static double sec(double x) {
        double result = 0;
        int index = 0;
        long[] E= new long[]{1, -1, 5, -61, 1385, -50521, 2702765, -199360981, 19391512145L, -2404879675441L, 370371188237525L,-69348874393137901L};
        for (long f = 0; f < 12; f++) {
            double divident = Math.abs( E[index]);
            double divider = factorial(2 * f);
            double factor = Math.pow(x, 2 * f);

            result += divident / divider * factor;
             index++;
        }
        return result;
    }

    private static long factorial(long f){
        if (f==0) return 1;
        return f * factorial(f-1);
    }


}


