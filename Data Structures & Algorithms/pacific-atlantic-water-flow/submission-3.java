class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (canReachOcean(
                        heights, i, j, true, new boolean[heights.length][heights[0].length])
                    && canReachOcean(
                        heights, i, j, false, new boolean[heights.length][heights[0].length])) {
                    resultList.add(List.of(i, j));
                }
            }
        }

        return resultList;
    }

    private boolean canReachOcean(
        int[][] heights, int row, int col, boolean isFindingPacificOcean, boolean[][] visited) {
        visited[row][col] = true;
        if (isFindingPacificOcean && (row == 0 || col == 0)) {
            return true;
        }

        if (!isFindingPacificOcean && (row == heights.length - 1 || col == heights[0].length - 1)) {
            return true;
        }

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : directions) {
            int neighborRow = row + dir[0];
            int neighborCol = col + dir[1];
            if (neighborRow >= 0 && neighborRow < heights.length && neighborCol >= 0
                && neighborCol < heights[0].length && !visited[neighborRow][neighborCol]) {
                if (heights[neighborRow][neighborCol] <= heights[row][col]) {
                    if (canReachOcean(
                            heights, neighborRow, neighborCol, isFindingPacificOcean, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}