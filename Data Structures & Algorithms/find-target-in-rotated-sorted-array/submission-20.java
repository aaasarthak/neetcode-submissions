class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int res = -1;

        while(left <= right) {
            if (nums[left] < nums[right]) {
                int result = Arrays.binarySearch(Arrays.copyOfRange(nums, left, right + 1), target);
                res = result < 0 ? -1 : left + result;
            }

            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                res = mid;
                break;
            }

            if(nums[mid] >= nums[left]) {
                if(target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if(target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return res;
    }
}