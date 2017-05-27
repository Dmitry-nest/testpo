public class Legs {
    public boolean isOnConsole;

    void putOnConsole (Console console){
        this.isOnConsole = true;
        console.putBy = this;
    }
}

