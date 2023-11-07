class EvenException extends Exception {
    public String toString() {
        return "Even number";
    }
}

class OddException extends Exception {
    public String toString() {
        return "Odd number";
    }
}

class Number {
    public static void isEvenOrOdd(int n) throws EvenException, OddException {
        if(n % 2 == 0) {
            throw new EvenException();
        }
        throw new OddException();
    }
}

public class ExceptionHandling {
    public static void main(String args[]) {
        try {
            Number.isEvenOrOdd(3);
        } catch (EvenException e) {
            System.out.println(e);
        } catch (OddException e) {
            System.out.println(e);
        }
    }
}
