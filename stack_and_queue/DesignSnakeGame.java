package stack_and_queue;

import java.util.*;

public class DesignSnakeGame {

	private int score, width, height, food[][];
	private Deque<int[]> snake;

	/**
	 * Initialize your data structure here.
	 * 
	 * @param width
	 *            - screen width
	 * @param height
	 *            - screen height
	 * @param food
	 *            - A list of food positions E.g food = [[1,1], [1,0]] means the
	 *            first food is positioned at [1,1], the second is at [1,0].
	 */
	public DesignSnakeGame(int width, int height, int[][] food) {
		this.score = 0;
		this.width = width;
		this.height = height;
		this.food = food;

		snake = new LinkedList<>();
		snake.addLast(new int[] { 0, 0 });
	}

	/**
	 * Moves the snake.
	 * 
	 * @param direction
	 *            - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
	 * @return The game's score after the move. Return -1 if game over. Game over
	 *         when snake crosses the screen boundary or bites its body.
	 */
	public int move(String direction) {
		int[] head = snake.peekFirst(), newHead = Arrays.copyOf(head, 2), tail = snake.removeLast();
		switch (direction) {
		case "U":
			newHead[0]--;
			break;
		case "L":
			newHead[1]--;
			break;
		case "R":
			newHead[1]++;
			break;
		case "D":
			newHead[0]++;
			break;
		}
		if (newHead[0] < 0 || newHead[1] < 0 || newHead[0] >= height || newHead[1] >= width)
			return -1;

		if (snake.stream().filter(e -> Arrays.equals(e, newHead)).findFirst().isPresent())
			return -1;

		snake.addFirst(newHead);
		if (score < food.length && Arrays.equals(newHead, food[score])) {
			score++;
			snake.addLast(tail);
		}
		return score;
	}

}
