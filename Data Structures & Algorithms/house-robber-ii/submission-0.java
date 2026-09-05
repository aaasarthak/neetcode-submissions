class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return nums[0] > nums[1] ? nums[0] : nums[1];

        int lastMaxRob = nums[0] > nums[1] ? nums[0] : nums[1];
        int secondLastMaxRob = nums[0];

        for(int i=2; i<nums.length - 1; i++) {
            int temp = Math.max(lastMaxRob, secondLastMaxRob + nums[i]);
            secondLastMaxRob = lastMaxRob;
            lastMaxRob = temp;
        }

        int maximum1 = lastMaxRob;

        lastMaxRob = nums[1] > nums[2] ? nums[1] : nums[2];
        secondLastMaxRob = nums[1];

        if(nums.length == 3) {
            return Math.max(maximum1, nums[1] > nums[2] ? nums[1] : nums[2]);
        }

        for(int i=3; i<nums.length; i++) {
            int temp = Math.max(lastMaxRob, secondLastMaxRob + nums[i]);
            secondLastMaxRob = lastMaxRob;
            lastMaxRob = temp;
        }

        int maximum2 = lastMaxRob;
        return Math.max(maximum1, maximum2);
    }
}
