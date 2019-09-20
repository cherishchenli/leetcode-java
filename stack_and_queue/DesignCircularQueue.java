package stack_and_queue;

public class DesignCircularQueue {

	int[] queue;
	int size, front, rear;

	/** Initialize your data structure here. Set the size of the queue to be k. */
	public DesignCircularQueue(int k) {
		queue = new int[k];
		size = 0;
		front = 0;
		rear = -1;
	}

	/**
	 * Insert an element into the circular queue. Return true if the operation is
	 * successful.
	 */
	public boolean enQueue(int value) {
		if (isFull())
			return false;

		rear = (rear + 1) % queue.length;
		queue[rear] = value;
		size++;
		return true;
	}

	/**
	 * Delete an element from the circular queue. Return true if the operation is
	 * successful.
	 */
	public boolean deQueue() {
		if (isEmpty())
			return false;
		queue[front] = 0;
		front = (front + 1) % queue.length;
		size--;
		return true;
	}

	/** Get the front item from the queue. */
	public int Front() {
		return isEmpty() ? -1 : queue[front];
	}

	/** Get the last item from the queue. */
	public int Rear() {
		return isEmpty() ? -1 : queue[rear];
	}

	/** Checks whether the circular queue is empty or not. */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Checks whether the circular queue is full or not. */
	public boolean isFull() {
		return size == queue.length;
	}

}
