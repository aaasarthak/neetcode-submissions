class Solution {
    public int numIslands(char[][] grid) {
        Set<String> visited = new HashSet<>();
        int count = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(explore(grid, i, j, visited)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean explore(char[][] grid, Integer i, Integer j, Set<String> visited) {
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0) {
            return false;
        }

        String index =  i.toString()+ ',' + (String) j.toString();
        if(visited.contains(index)) {
            return false;
        }

        if(grid[i][j] == '0') {
            return false;
        }

        visited.add(index);

        explore(grid, i+1, j, visited);
        explore(grid, i-1, j, visited);
        explore(grid, i, j+1, visited);
        explore(grid, i, j-1, visited);

        return true;
    }
}
