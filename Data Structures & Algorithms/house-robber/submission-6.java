class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        
        int[] maxAmount = new int[nums.length];
        for(int i=0; i<n; i++) {
            maxAmount[i] = -1;
        }
        maxAmount[0] = nums[0];
        maxAmount[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        rob(n-1, nums, maxAmount);
        return maxAmount[n-1];
    }

    private int rob(int n, int[] nums, int[] maxAmount) {
        if(maxAmount[n] != -1) return maxAmount[n];

        maxAmount[n] = Math.max(rob(n - 1, nums, maxAmount), rob(n-2, nums, maxAmount) + nums[n]);
        return maxAmount[n];
    }
}
