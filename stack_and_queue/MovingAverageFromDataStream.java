package stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream {

	private Queue<Integer> queue;
	private int sum, size;

	public MovingAverageFromDataStream(int size) {
		queue = new LinkedList<>();
		this.size = size;
		this.sum = 0;
	}

	public double next(int val) {
		if (queue.size() == size)
			sum -= queue.poll();
		sum += val;
		queue.offer(val);
		return (double) sum / queue.size();
	}

}
