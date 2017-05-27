package Function;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by di452 on 21.05.2017.
 */
public class CSVWriter {

    private AbstractFunction function;

    private String SEPARATOR = ";";
    private String FILE_NAME = "data.csv";

    public CSVWriter (AbstractFunction function) {
        this.function = function;
    }

    public void write(double from, double to, double step){
        try {
            FileWriter writer = new FileWriter(FILE_NAME, false);

            for (double x = from; x < to; x += step) {
                double value = function.calculate(x);
                writer.append(String.format(Locale.US, "%f%s%f\n", x, SEPARATOR, value));
            }
            writer.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}

