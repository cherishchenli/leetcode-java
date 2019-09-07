package backtracking;

public class UniquePathsIII {

	private int count = 0, m = 0, n = 0, toVisit = 1;

	public int solution(int[][] grid) {
		m = grid.length;
		n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		int startRow = 0, startCol = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0)
					toVisit++;
				else if (grid[i][j] == 1) {
					startRow = i;
					startCol = j;
				}
			}
		}

		backtrack(grid, visited, startRow, startCol);
		return count;
	}

	private void backtrack(int[][] grid, boolean[][] visited, int r, int c) {
		if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == -1)
			return;
		if (visited[r][c])
			return;

		if (toVisit == 0) {
			if (grid[r][c] == 2)
				count++;
			return;
		}

		visited[r][c] = true;
		toVisit--;
		
		backtrack(grid, visited, r + 1, c);
		backtrack(grid, visited, r - 1, c);
		backtrack(grid, visited, r, c + 1);
		backtrack(grid, visited, r, c - 1);
		
		toVisit++;
		visited[r][c] = false;
	}

}
