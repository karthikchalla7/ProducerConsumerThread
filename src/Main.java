public class Main {

    public static void main(String[] args) {
        SharedResource shared = new SharedResource(3);
        Thread produceThread = new Thread(new Producer(shared));
        Thread consumeThread = new Thread(new Consumer(shared));
        produceThread.start();
        consumeThread.start();
    }
}
