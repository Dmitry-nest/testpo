
public class Hand {
    Side side;

    Hand(Side side) {
        this.side = side;
    }

    public void pickInTeeth(Teeth teeth){
        teeth.pickBy(this);
    }
}

