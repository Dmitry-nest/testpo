import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HandTest {
    Teeth teeth;
    Hand hand;

    @Before
    public void Init(){
        teeth = new Teeth();
        hand = new Hand(Side.LEFT);
    }
}
