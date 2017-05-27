
public class SomebodyFactory {

    Hand leftHand;
    Hand rightHand;

    Head rightHead;
    Head leftHead;

    Legs legs;

    Teeth teethRightHead;
    Teeth teethLeftHead;

    Somebody somebody;

    public SomebodyFactory(){
        leftHand = new Hand(Side.LEFT);
        rightHand = new Hand(Side.RIGHT);

        teethRightHead = new Teeth();
        teethLeftHead = new Teeth();

        rightHead = this.createHead(Side.RIGHT, teethRightHead);
        leftHead = this.createHead(Side.LEFT, teethLeftHead);

        legs = new Legs();

        somebody = new Somebody(
                leftHand,
                rightHand,
                legs,
                leftHead,
                rightHead
        );
    }

    Head createHead(Side side, Teeth teeth) {
        return new Head(teeth, side);
    }
}
