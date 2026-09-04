class Solution {
    public int climbStairs(int n) {
        if(n == 1) return 1;

        int[] ways = new int[n + 1];
        ways[1] = 1;
        ways[2] = 2;

        return climbStairs(n, ways);
    }

    private int climbStairs(int n, int[] ways) {  
        if(ways[n] > 0) return ways[n];

        ways[n] = climbStairs(n-1, ways) + climbStairs(n-2, ways);
        return ways[n];
    }
}
