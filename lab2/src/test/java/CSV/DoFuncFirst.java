package CSV;

import Function.CSVWriter;
import Function.FirstStatement;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import tgiron.*;

/**
 * Created by di452 on 22.05.2017.
 */
@Ignore
public class DoFuncFirst {

    private CSVWriter writer;
    private FirstStatement statement;

    @Before
    public void intiTest() {
        statement = new FirstStatement(new Csc(), new Cos(), new Sec(), new Cot(), new Tan());
        writer = new CSVWriter(statement);
    }

    @Test(timeout = 10000)
    public void test () throws Exception {
        writer.write(-2*Math.PI,0.01, 0.3);
    }
}

