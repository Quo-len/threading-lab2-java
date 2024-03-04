package lab2Threads;

public class FindLowestValue implements Runnable {

	private int[] array;
	private int startIdx;
	private int endIdx;
	private ArrayOperations operation;
	
	public FindLowestValue(ArrayOperations operation, int[] array, int startIdx, int endIdx) {
		this.startIdx = startIdx;
		this.endIdx = endIdx;
		this.array = array;
		this.operation = operation;
	}
	
	@Override
	public void run() {
		int currentMinIdx = 0;
		for(int i = startIdx; i < endIdx; i++) {
			if (array[i] < array[currentMinIdx])
				currentMinIdx = i;
		}
		operation.updateMinVal(currentMinIdx);
		operation.countdown();
	}

}
