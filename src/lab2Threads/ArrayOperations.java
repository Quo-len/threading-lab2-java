package lab2Threads;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class ArrayOperations {
	
	private int numOfThreads;
	private int[] array;
	private int minValIdx = 0;
	private CountDownLatch latch;
	
	public ArrayOperations(int size, int numOfThreads) {
		this.array = new int[size];
		this.numOfThreads = numOfThreads;
		this.latch = new CountDownLatch(numOfThreads);
	}
	
	public void setRandomMin() {
		Random rand = new Random();
		int idx = rand.nextInt(0, this.array.length);
		array[idx] = -1;
		System.out.println("New min set: " + "idx:" + idx + " " + "num:" + array[idx]);
	}
	
	public void findMinElementParallel() {
		int[] indexes = splitArrIntoChunks();
		
		for(int i = 0; i < numOfThreads; i++) {
			new Thread(new FindLowestValue(this, array, indexes[i], indexes[i+1])).start();;
		}
		
		try {
		    latch.await(); 
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		System.out.println("Minimal element in array - " + array[minValIdx]);
		System.out.println("Index of minimal element in array - " + minValIdx);
	}

	public void initializeArray() {
		for(int i = 0; i < array.length; i++) {
			array[i] = i;
		}
	}
	
	public int[] splitArrIntoChunks() {
		int part = array.length / numOfThreads;
	    int[] indexes = new int[numOfThreads + 1];

	    int idx = 0;
	    for (int i = 0; i < numOfThreads; i++) {
	        indexes[i] = idx;
	        idx += part;
	    }
	    indexes[numOfThreads] = array.length;

	    return indexes;
	}
	
	public void countdown() {
		latch.countDown();
    }
	
	public synchronized void updateMinVal(int minIndex) {
        if (array[minIndex] < this.array[minValIdx]) {
            this.minValIdx = minIndex;
        }
    }
	
}
