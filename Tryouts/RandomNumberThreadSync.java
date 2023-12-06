import javax.xml.crypto.Data;

class DataStore1 {
    private int num;
    private boolean hasNum = false;

    synchronized void setNum(int x) {
        num = x;
    }

    synchronized int getNum() {
        return num;
    }

    synchronized void setHasNum(boolean n) {
        hasNum = n;
    }

    synchronized boolean getHasNum() {
        return hasNum;
    }
}


class RandGen extends Thread {
    DataStore1 ds;

    RandGen(DataStore1 ds) {
        this.ds = ds;
    }

    public void run() {
        while (true) {
            while (!ds.getHasNum()) {
                int num = (int) (Math.random() * 100);
                ds.setNum(num);
                ds.setHasNum(true);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

class IfEven extends Thread {
    DataStore1 ds;
    IfEven(DataStore1 ds) {
        this.ds = ds;
    }

    public void run() {
        while(true) {
            if(ds.getHasNum() && ds.getNum() % 2 == 0) {
                System.out.println("Even");
                ds.setHasNum(false);
            }
        }
    }
}

class IfOdd extends Thread {
    DataStore1 ds;
    IfOdd(DataStore1 ds) {
        this.ds = ds;
    }

    public void run() {
        while(true) {
            if(ds.getHasNum() && ds.getNum() % 2 == 1) {
                System.out.println("Odd");
                ds.setHasNum(false);
            }
        }
    }
}


public class RandomNumberThreadSync {
    public static void main(String[] args) {
        DataStore1 ds1 = new DataStore1();

        RandGen rg = new RandGen(ds1);
        IfEven ie = new IfEven(ds1);
        IfOdd io = new IfOdd(ds1);

        rg.start();
        ie.start();
        io.start();
    }
}
