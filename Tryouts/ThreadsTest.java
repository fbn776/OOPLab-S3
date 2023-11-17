class Data {
    public static boolean hasNumber = false;
    public static int number;
}

class NumberGenerator extends Thread {
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Data.hasNumber = true;
        Data.number = 38352;
    }
}

class SqNumber extends Thread {
    public void run() {
        while (true) {
            System.out.println("Getting number...");
            if (Data.hasNumber) {
                System.out.println("Square of number is: " + Data.number * Data.number);
                break;
            }
        }
    }
}


public class ThreadsTest {
    public static void main(String[] args) {
        NumberGenerator ng = new NumberGenerator();
        SqNumber sn = new SqNumber();

        ng.start();
        sn.start();
    }
}
