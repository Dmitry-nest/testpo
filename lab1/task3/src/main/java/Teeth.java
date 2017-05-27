public class Teeth {
    Boolean isPicked;
    Hand pickedBy;

    Teeth (){
        this.isPicked = false;
    }
    public void pickBy(Hand hand){
        this.pickedBy = hand;
        this.isPicked = true;
    }
}

