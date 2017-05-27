import java.util.ArrayList;
import java.util.List;

/*Артур, нервничая, вошел следом и был ошеломлен,
* увидев развалившегося в кресле человека,
* положившего ноги на пульт управления и
* ковыряющего левой рукой в зубах правой
* головы. Правая голова, казалось,
* была всецело занята этим, но зато левая улыбалась
* широко и непринужденно. Количество вещей, видя которые,
 * Артур не верил своим глазам, все росло. Его челюсть отвисла.
 */
public class Main {
    Head createHead(Side side) {
        return new Head(new Teeth(), side);
    }

    Somebody createSomebody() {
        Main main = new Main();

        Hand left = new Hand(Side.LEFT);
        Hand right = new Hand(Side.RIGHT);

        Legs legs = new Legs();
        return new Somebody(
                left,
                right,
                legs,
                main.createHead(Side.RIGHT),
                main.createHead(Side.LEFT)
        );
    }

    public static void main(String[] args) {
        Main main = new Main();
    }
}

