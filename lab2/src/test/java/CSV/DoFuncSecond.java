package CSV;

import Function.CSVWriter;
import Function.SecondStatement;
import Logarifm.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by di452 on 22.05.2017.
 */
@Ignore
public class DoFuncSecond {

    private CSVWriter writer;
    private SecondStatement statement;

    @Before
    public void intiTest() {
        statement = new SecondStatement(new Ln(),new Log2(), new Log3(), new Log5(), new Log10());
        writer = new CSVWriter(statement);
    }

    @Test(timeout = 10000)
    public void test () throws Exception {
        writer.write(0.01,5, 0.2);
    }
}

