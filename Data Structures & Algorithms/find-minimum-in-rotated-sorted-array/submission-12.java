class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        if(nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }

        for(int i=1, j=2; i<nums.length || j<nums.length; i+=2,j+=2) {
            if(nums[i] < nums[i-1]) {
                return nums[i];
            }

            if(nums[j] < nums[j-1]) {
                return nums[j];
            }
        }

        return 1;
    }
}
