class Solution {
    public int findMin(int[] nums) {
        if( nums.length == 1 || nums[0] < nums[nums.length - 1]) {
            return nums[0];
        } else if(nums.length == 2) {
          return Math.min(nums[0], nums[1]);
        } else {
            int left = 0, right = nums.length - 1;
            int mid = -1;
            while(left != right) {
                mid = (left + right)/2;
                if(right - left == 1) {
                    return Math.min(nums[left], nums[right]);
                }
                if((nums[left] > nums[mid] && nums[right] > nums[mid]) && (right - left == 2)) {
                    return nums[mid];
                } else if ((nums[left] < nums[mid] && nums[right] < nums[mid])) {
                    left = mid + 1;
                    mid=left;
                } else if((nums[left] > nums[mid] && nums[right] < nums[mid])) {
                    left = mid + 1;
                    mid = left;
                }else if(nums[left] < nums[mid] && nums[right] > nums[mid]) {
                    right = mid - 1;
                    mid = right;
                } else {
                    if(nums[mid - 1] < nums[mid + 1]) {
                        right = mid;
                        mid = right;
                    } else {
                        left = mid;
                        mid = left;
                    }
                }
            }

            return nums[mid];
        }
    }
}
