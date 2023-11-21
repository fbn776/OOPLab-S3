class Storage {
    int i = 0;
    int[] data = new int[10];

    private int getRand() {
        return (int) (Math.random() * 100);
    }

    void produce(int a) throws InterruptedException {
        while(i == data.length - 1) {
            wait();
        }

        data[++i] = a;
        System.out.println("Added: " + a);
        notifyAll();
    }

    int consume() throws InterruptedException {
        while(i == 0) {
            wait();
        }
        int item = this.data[i--];
        System.out.println("Got: " + item);
        notifyAll();
        return item;
    }

    private boolean isFull() {
        return i == data.length - 1;
    }
}

class Producer extends Thread {
    private final Storage store;
    public Producer(Storage store) {
        this.store = store;
    }

    public void run() {
        try {
            while (true) {
                int item = produceItem();
                store.produce(item);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    private int produceItem() {
        return (int) (Math.random() * 100);
    }
}

class Consumer extends Thread{
    private final Storage store;
    public Consumer(Storage store) {
        this.store = store;
    }

    public void run() {
        try {
            while (true) {
                store.consume();
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Exception");
        }

    }
}

public class ThreadSync {
    public static void main(String[] args) {
        Storage s = new Storage();

        Producer producerThread = new Producer(s);
        Consumer consumerThread = new Consumer(s);

        producerThread.start();
        consumerThread.start();
    }
}