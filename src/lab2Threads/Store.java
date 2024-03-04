package lab2Threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Store {
    private final int storeSize = 3;

    Semaphore emptyStorage = new Semaphore(0);
    Semaphore fullStorage = new Semaphore(storeSize);

    Semaphore freeStorage = new Semaphore(1);
    private final List<Item> items = new ArrayList<>(storeSize);

    public void addItem(Item item){
        try {
            fullStorage.acquire();
          //  freeStorage.acquire();
            items.add(item);
            emptyStorage.release();
          //  freeStorage.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(items.size());
    }

    public Item getItem(){
        try {
            emptyStorage.acquire();
         //  freeStorage.acquire();
            Item item = items.get(0);
            items.remove(0);
            fullStorage.release();
         //   freeStorage.release();
            return item;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}