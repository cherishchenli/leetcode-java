package backtracking;

public class SudokuSolver {

	public void solution(char[][] board) {
		backtrack(board, 0, 0);
	}

	private boolean backtrack(char[][] board, int row, int col) {
		for (int i = row; i < 9; i++, col = 0) {
			for (int j = col; j < 9; j++) {
				if (board[i][j] != '.')
					continue;
				for (char c = '1'; c <= '9'; c++) {
					if (isValid(board, i, j, c)) {
						board[i][j] = c;
						if (backtrack(board, i, j + 1))
							return true;
						else
							board[i][j] = '.';
					}
				}
				return false;
			}
		}
		return true;
	}

	private boolean isValid(char[][] board, int row, int col, char c) {
		for (int i = 0; i < 9; i++) {
			// check row
			if (board[i][col] == c)
				return false;

			// check column
			if (board[row][i] == c)
				return false;

			// check block
			if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
				return false;
		}
		return true;
	}

}
