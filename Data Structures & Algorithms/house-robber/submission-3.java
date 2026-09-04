class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return nums[0] > nums[1] ? nums[0] : nums[1];

        int maxSecondLast = nums[0];
        int maxLast = nums[0] > nums[1] ? nums[0] : nums[1];
        for(int i=2; i<nums.length; i++) {
            int temp = Math.max(maxLast, maxSecondLast + nums[i]);
            maxSecondLast = maxLast;
            maxLast = temp;
        }

        return maxLast;
    }
}
