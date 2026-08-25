class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        int res = nums[0];

        if(nums[l] <= nums[r]) {
            return nums[0];
        }
        
        while(l <= r) {
            int mid = (l + r) / 2;

            if(nums[mid] >= nums[l]) {
                res = Math.min(res, nums[l]);
                l = mid + 1;
            } else {
                res = Math.min(res, nums[mid]);
                r = mid - 1;
            }
        }

        return res;
    }
}
