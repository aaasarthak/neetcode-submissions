class Solution {
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '0' || visited[i][j] == 1) continue;

                islandCount++;
                visited[i][j] = 1;
                Queue<int[]> toBeTraversedLands = new LinkedList<>();
                toBeTraversedLands.add(new int[]{i,j});
                while(!toBeTraversedLands.isEmpty()) {
                    int[] land = toBeTraversedLands.poll();
                    int row = land[0];
                    int col = land[1];

                    for(int k=0; k<directions.length; k++) {
                        int[] direction = directions[k];
                        int newRow = row + direction[0];
                        int newCol = col + direction[1];
                        if(newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) {
                            continue;
                        }

                        if(grid[newRow][newCol] == '1' && visited[newRow][newCol] == 0) {
                            toBeTraversedLands.add(new int[]{newRow, newCol});
                            visited[newRow][newCol] = 1;
                        }
                    }
                }      
            }
        }

        return islandCount;
    }
}
