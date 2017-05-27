import org.junit.Before;
import org.junit.Test;


import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EyesTest {
    Stuff stuff;
    Arthur arthur;
    Eyes eyes;

    @Before
    public void Init(){
        stuff = new Stuff();
        eyes = new Eyes();
        arthur = new Arthur(eyes);
    }

    @Test
    public void believeTrueTest(){
        eyes.believe(true);
        assertTrue(eyes.belief);
    }

    @Test
    public void believeFalseTest(){
        eyes.believe(false);
        assertFalse(eyes.belief);
    }

    @Test
    public void lookAtTest() {
        assertEquals(eyes.lookAtStuff(stuff),stuff.count);
    }
}
