package Function;

/**
 * Created by di452 on 21.05.2017.
 */
public class Main extends AbstractFunction {

    private FirstStatement firstStatement;
    private SecondStatement secondStatement;

    public Main(FirstStatement firstStatement, SecondStatement secondStatement) {
        this.firstStatement = firstStatement;
        this.secondStatement = secondStatement;
    }

    @Override
    public double calculate (double x) {
        if(x <= 0) {
            return firstStatement.calculate(x);
        } else {
            return secondStatement.calculate(x);
        }
    }
}
