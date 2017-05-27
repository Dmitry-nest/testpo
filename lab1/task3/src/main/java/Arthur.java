public class Arthur {
    Emotions emotion;
    boolean inRoom;
    Eyes eyes;
    Boolean jawIsDown;

    Arthur(Eyes eyes) {
        this.eyes = eyes;
        this.emotion = Emotions.NONE;
        this.jawIsDown = false;
    }

    public void changeEmotion(Emotions emotion) {
        this.emotion = emotion;
    }

    void comeIn(Room room){
        this.changeEmotion(Emotions.NERVOUNESS);
        room.isVisited = true;
        room.isVisitedAfterSomenone = true;
    }

    void see(Somebody somebody){
        somebody.isSeen = true;
        this.changeEmotion(Emotions.STUNNED); //ошеломлен
    }

    void see(Stuff stuff){
        stuff.raise();
        if(stuff.count > 2 || stuff.count == 2){
            this.changeEmotion(Emotions.UNBELIEVING);
        }
        if(this.emotion == Emotions.UNBELIEVING){
            this.jawIsDown = true;
        }
    }
}