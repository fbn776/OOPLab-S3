class Storage {
    private final int capacity;
    private final int[] buffer;
    private int count;

    public Storage(int capacity) {
        this.capacity = capacity;
        this.buffer = new int[capacity];
        this.count = 0;
    }

    public synchronized void produce(int item) throws InterruptedException {
        while (count == capacity) {
            wait();
        }

        buffer[count++] = item;
        System.out.println("Produced: " + item);

        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (count == 0) {
            wait();
        }
        System.out.println("Consumed: " + buffer[(count--) - 1]);
        notify();
    }
}

class Producer extends Thread {
    private final Storage buffer;
    public Producer(Storage buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                buffer.produce(i);
                sleep(100);
            }
        } catch (InterruptedException e) {}
    }
}

class Consumer extends Thread {
    private final Storage buffer;
    public Consumer(Storage buffer) {
        this.buffer = buffer;
    }
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                buffer.consume();
                sleep(200);
            }
        } catch (InterruptedException e) {}
    }
}

public class Assignment2ProducerConsumer {
    public static void main(String[] args) {
        Storage buffer = new Storage(5);
        Thread producerThread = new Producer(buffer);
        Thread consumerThread = new Consumer(buffer);
        producerThread.start();
        consumerThread.start();
    }
}