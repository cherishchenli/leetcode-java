package backtracking;

public class WordSearch {

	public boolean solution(char[][] board, String word) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				if (find(board, word, 0, row, col))
					return true;
			}
		}
		return false;
	}

	private boolean find(char[][] board, String word, int i, int row, int col) {
		if (i >= word.length())
			return true;
		if (row >= board.length || row < 0 || col >= board[0].length || col < 0 || board[row][col] != word.charAt(i))
			return false;

		char c = board[row][col];
		board[row][col] = '%';

		boolean exist = find(board, word, i + 1, row + 1, col) || find(board, word, i + 1, row - 1, col)
				|| find(board, word, i + 1, row, col + 1) || find(board, word, i + 1, row, col - 1);

		board[row][col] = c;
		return exist;
	}

}
