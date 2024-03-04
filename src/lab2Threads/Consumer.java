package lab2Threads;

public class Consumer extends Thread {
    private final int numberItems;
    private final Store store;

    public Consumer(int numberItems, Store store) {
        this.numberItems = numberItems;
        this.store = store;
        start();
    }

    @Override
    public void run() {
        for (int i = 0; i < numberItems; i++) {
            Item item = store.getItem();
            System.out.println("Get Item - " + item.getId());
        }
    }
}