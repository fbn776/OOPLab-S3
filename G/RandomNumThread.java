
class DataStore {
    private static int num;
    public static synchronized int getNum() {
        return num;
    }
    public static synchronized void setNum(int num) {
        DataStore.num = num;
    }
}

class RandomNumGen extends Thread {
    public void run() {
        while (true) {
            int randomNum = (int) (Math.random() * 100);
            DataStore.setNum(randomNum);
            System.out.println("Generated: " + randomNum);
            try {
                notifyAll();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Error happened");
            }
        }
    }
}

class EvenNum extends Thread {
    public void run() {
        while (true) {
            int num = DataStore.getNum();
            if (num % 2 == 0) {
                System.out.println("EVEN; Square: " + num * num);
            }
        }
    }
}

class OddNum extends Thread {
    public void run() {
        while (true) {
            int number = DataStore.getNum();
            if (number % 2 != 0) {
                System.out.println("ODD; Cube: " + number * number * number);
            }
        }
    }
}


public class RandomNumThread {
    public static void main(String[] args) {

        RandomNumGen rgc = new RandomNumGen();
        EvenNum en = new EvenNum();
        OddNum on = new OddNum();

        rgc.start();
        en.start();
        on.start();

        try {
            rgc.join();
            en.join();
            on.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
