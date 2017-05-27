import org.junit.Test;

import static org.junit.Assert.*;
public class task1tests {
    final double MAX_ALLOWED_DELTA = 1e-3;
    final double EPS = 1e-10;

    static double delta(double d1, double d2) {
        return Math.abs(d1 - d2);
    }

    @Test
    public void TestingWith0Degr() throws BoundException {
        double Degr0 = 1;
        assertTrue("Compare for 0 degrees", delta(task1.sec(0), Degr0) <= MAX_ALLOWED_DELTA);
    }

    @Test
    public void compareWith30degrTableValue() throws BoundException{
        double DEGR30 = 2 / Math.sqrt(3);
        assertTrue("Compare for 30 degrees", delta(task1.sec(Math.PI/6), DEGR30) < MAX_ALLOWED_DELTA);
    }

    @Test
    public void compareWith45degrTableValue() throws BoundException {
        double DEGR45 = Math.sqrt(2);
        assertTrue("Compare for 45 degrees", delta(task1.sec(Math.PI/ 4), DEGR45) < MAX_ALLOWED_DELTA);
    }

    @Test
    public void compareWith60degrTableValue() throws BoundException {
        double DEGR60 = 2;
        //double mysec = task1.sec(Math.PI/3);
        //double sec = 1 / Math.cos(Math.PI/3);
        //System.out.print(" mysec " + mysec + " sec " + sec);
        assertTrue("Compare for 60 degrees", delta(task1.sec(Math.PI / 3), DEGR60) < MAX_ALLOWED_DELTA);
    }

    @Test
    public void compareWith180degrTableValue() throws BoundException{
        double DEGR180 = 1 / Math.cos(Math.PI);
        assertTrue("Compare for 180 degrees", delta(task1.sec(Math.PI), DEGR180) < MAX_ALLOWED_DELTA);
    }

    @Test
    public void compareWithNeg30degrTableValue() throws BoundException  {
        double DEGR30 = 1 / Math.cos(-Math.PI/6);
        assertTrue("Compare for negative 30 degrees", delta(task1.sec(-Math.PI/6), DEGR30) < MAX_ALLOWED_DELTA);
    }

    @Test
    public void compareWithNeg45degrTableValue()  throws BoundException {
        double DEGR45 = 1 / Math.cos(-Math.PI/4);
        assertTrue("Compare for negative 45 degrees", delta(task1.sec(-Math.PI/4), DEGR45) < MAX_ALLOWED_DELTA);
    }

    @Test
    public void compareWithNeg60degrTableValue()  throws BoundException {
        double DEGR60 = 1 / Math.cos(-Math.PI/3);
        //double mysec = task1.sec(-Math.PI/3);
        //double sec = 1 / Math.cos(-Math.PI/3);
        //System.out.print(" mysec " + mysec + " sec " + sec);
        assertTrue("Compare for negative 60 degrees", delta(task1.sec(-Math.PI/3), DEGR60) < MAX_ALLOWED_DELTA);
    }

    @Test
    public void compareWith90degrNegTableValue()  throws BoundException {
        double DEGR90 = 1/Math.cos(-Math.PI/2);
        assertTrue("Compare for negative 90 degrees", delta(task1.sec(-Math.PI/2), DEGR90) < MAX_ALLOWED_DELTA);
    }

    @Test
    public void validateOutputSignForPositiveInputValue_1() throws BoundException  {
        double randomPoint = Math.random()/2;
        System.out.print(randomPoint);
        double value = task1.sec(randomPoint);
        System.out.println(value);
        assertTrue(value >=1);

    }
    @Test
    public void validateOutputSignForPositiveInputValue_3() throws BoundException {
        double randomPoint = Math.PI/2 + (Math.random() / 2 +0.5);
        System.out.print(randomPoint);
        double value = task1.sec(randomPoint);
        System.out.println(value);
        assertTrue(value <= -1);
    }

    @Test
    public void validateOutputSignForPositiveInputValue_2() throws BoundException  {
        double randomPoint = Math.random() / 2 + 0.5;
        System.out.print(randomPoint);
        double value = task1.sec(randomPoint);
        System.out.print(value);
        assertTrue(value >= Math.PI/6 && value <= Math.PI/2 );
    }

    @Test
    public void validateOutputSignForNegativeInputValue_1() throws BoundException  {
        double randomPoint = -Math.random() / 2;
        System.out.print(randomPoint);
        double value = task1.sec(randomPoint);
        System.out.println(" " + value );
        assertTrue(value >= 1);
    }

    @Test
    public void validateOutputSignForNegativeInputValue_2() throws BoundException  {
        double randomPoint = -Math.random() / 2 - 0.5;
        double value = task1.sec(randomPoint);
        assertTrue(value <= -Math.PI/6 && value >= -Math.PI/2 );
    }

    @Test
    public void validateOutputSignForNegativeInputValue_3() throws BoundException {
        double randomPoint = -Math.PI/2 - (Math.random() / 2 +0.5);
        System.out.print(randomPoint);
        double value = task1.sec(randomPoint);
        System.out.println(value);
        assertTrue(value <= -1);
    }

    @Test
    public void validateOuptuptForZeroInputValue()   throws BoundException {
        double value = task1.sec(0);
        assertTrue(value == 1);
    }
  @Test
    public void validateBoundaryValues_1() throws BoundException   {

        try {
            task1.sec(Math.PI/2 - EPS);
                throw new BoundException("Exception is thrown");
        } catch (BoundException e) {
            fail("Exception is thrown");
        }

        try {
            task1.sec(Math.PI/2 + EPS);
            throw new BoundException("Exception is thrown");

        } catch (BoundException ignored) {
            fail("Exception not thrown");
        }
    }

    @Test
    public void validateBoundaryValues_2()   {

        try {
            task1.sec(-Math.PI/2 + EPS);
            throw new BoundException("Exception is thrown");
        } catch (BoundException e) {
            fail("Exception is thrown");
        }

        try {
            task1.sec(-Math.PI/2 - EPS);
            throw new BoundException("Exception is thrown");

        } catch (BoundException e) {
            fail("Exception thrown");
        }

    }

    @Test
    public void validateBoundaryValues_3()   {
        double value1 = task1.sec(0 + EPS);
        double value2 = task1.sec(0 - EPS);

        assertTrue(value1 >=1  && value2 >=1);
    }

    @Test
    public void validateInfinityInputValue() {

        try {
            task1.sec(Double.POSITIVE_INFINITY);
            throw new BoundException("Exeption throw");

        } catch (BoundException e) {
            fail("Exception thrown");
        }

        try {
            double vol = task1.sec(Double.NEGATIVE_INFINITY);
            System.out.print(vol);
            throw new BoundException("Exeption throw");

        } catch (BoundException e) {
            fail("Exception thrown");

        }
    }
}