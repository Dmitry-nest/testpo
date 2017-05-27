import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SomebodyTest {
    SomebodyFactory factory;
    Console console;
    Chair chair;

    @Before
    public void Init(){
        factory = new SomebodyFactory();
        console = new Console();
        chair = new Chair();
    }

    /*ковыряющего !левой рукой! в зубах правой головы*/
    @Test
    public void pickByLeftHandTest() {
        factory.somebody.getHand(Side.LEFT).pickInTeeth(factory.somebody.getHead(Side.RIGHT).teeth);
        assertEquals(factory.somebody.getHead(Side.RIGHT).teeth.pickedBy, factory.leftHand);
    }

    /*!ковыряющего! левой рукой в зубах !правой головы!*/
    @Test
    public void pickInTeethOfRightHeadTest() {
        factory.somebody.getHand(Side.LEFT).pickInTeeth(factory.somebody.getHead(Side.RIGHT).teeth);
        assertTrue(factory.somebody.getHead(Side.RIGHT).teeth.isPicked);
        assertFalse(factory.somebody.getHead(Side.LEFT).teeth.isPicked);
    }

    /*положившего ноги на пульт управления */
    @Test
    public void putOnConsoleTest() {
        factory.somebody.legs.putOnConsole(console);
        assertEquals(console.putBy, factory.somebody.legs);
        assertTrue(factory.somebody.legs.isOnConsole);
    }

    /*положившего ноги на пульт управления */
    @Test
    public void loungeInChairTest() {
        factory.somebody.louge(chair);
        assertEquals(chair.loungeBy, factory.somebody);
        assertTrue(chair.lounged);
    }

    /*Правая голова, казалось, была всецело занята этим*/
    /* т.е. если зубы этой головы были поковыряны,
     * то голова как бы была занята этим
     */
    @Test
    public void wasBusyTest() {
        assertFalse(factory.somebody.getHead(Side.RIGHT).teeth.isPicked);
        factory.somebody.getHand(Side.LEFT).pickInTeeth(factory.somebody.getHead(Side.RIGHT).teeth);
        assertTrue(factory.somebody.getHead(Side.RIGHT).teeth.isPicked);
    }
    /*левая(голова) улыбалась широко и непринужденно*/
    @Test
    public void leftHeadSmileWideAndUnconstrainedTest() {
        factory.somebody.getHead(Side.LEFT).smile();
        assertTrue(factory.somebody.getHead(Side.LEFT).isSmile);
        assertEquals(factory.somebody.getHead(Side.LEFT).smileType, Emotions.WIDEANDUNCONSTRAINED);

    }
    /*правая(голова) не улыбалась широко и непринужденно*/
    @Test
    public void rightHeadDontSmileWideAndUnconstrainedTest() {
        factory.somebody.getHead(Side.LEFT).smile();
        assertFalse(factory.somebody.getHead(Side.RIGHT).isSmile);
        assertNotEquals(factory.somebody.getHead(Side.RIGHT).smileType, Emotions.WIDEANDUNCONSTRAINED);
    }
}