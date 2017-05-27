import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class LegsTest {
    Legs legs;
    Console console;

    @Before
    public void Init(){
        legs = new Legs();
        console = new Console();
    }

    /*человека,положившего ноги на пульт управления*/
    @Test
    public void putOnControlPanelTrueTest(){
        legs.putOnConsole(console);
        assertTrue(legs.isOnConsole);
    }

    /*человека,положившего ноги на пульт управления*/
    @Test
    public void putOnControlPanelFalseTest(){
        assertFalse(legs.isOnConsole);
    }
}
