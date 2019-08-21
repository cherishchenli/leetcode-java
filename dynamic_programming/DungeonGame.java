package dynamic_programming;

public class DungeonGame {
	
    public int solution(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[] hp = new int[n];
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1)
                    hp[j] = 1 - dungeon[i][j];
                else if (i == m - 1)
                    hp[j] = hp[j+1] - dungeon[i][j];
                else if (j == n - 1)
                    hp[j] = hp[j] - dungeon[i][j];
                else
                    hp[j] = Math.min(hp[j], hp[j+1]) - dungeon[i][j];
                hp[j] = Math.max(1, hp[j]);
            }
        }
        
        return hp[0];
    }
    
}
