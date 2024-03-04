package lab2Threads;

public class Producer extends Thread {

    private final int numberItems;
    private final Store store;
    public Producer(int numberItems, Store store) {
        this.numberItems = numberItems;
        this.store = store;
        start();
    }

    private int id = 0;
    @Override
    public void run() {
        for (int i = 0; i < numberItems; i++) {
            Item item = new Item(++id);
            store.addItem(item);
            System.out.println("Produced Item - " + item.getId());
        }
    }
}