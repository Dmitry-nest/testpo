public class Stuff {
    int count;
    Stuff() {
        this.count = 0;
    }

    public int raise() {
        count = count + 1;
        return count;
    }
}

