
public class Eyes {
    Boolean belief;
    public void believe(Boolean b) {
        this.belief = b;
    }

    public int lookAtStuff(Stuff stuff) {
        return stuff.raise();
    }
}

