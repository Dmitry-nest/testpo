import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HeadTest {
    Head leftHead;
    Head rightHead;
    Teeth teethForLeftHead;
    Teeth teethForRightHead;

    @Before
    public void Init(){
        teethForLeftHead = new Teeth();
        teethForRightHead = new Teeth();
        leftHead = new Head(teethForLeftHead, Side.LEFT);
        rightHead = new Head(teethForRightHead, Side.RIGHT);
    }
}
