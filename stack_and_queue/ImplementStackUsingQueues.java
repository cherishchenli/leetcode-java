package stack_and_queue;

import java.util.Queue;
import java.util.LinkedList;

public class ImplementStackUsingQueues {

	Queue<Integer> queue;

	/** Initialize your data structure here. */
	public ImplementStackUsingQueues() {
		queue = new LinkedList<>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		queue.add(x);
		for (int i = 0; i < queue.size() - 1; i++)
			queue.add(queue.poll());
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return queue.poll();
	}

	/** Get the top element. */
	public int top() {
		return queue.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return queue.isEmpty();
	}

}
