class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int index = -1;
        if(nums[0] < nums[nums.length - 1]) {
            var res = Arrays.binarySearch(nums, target);
            return res >= 0 ? res : -1;
        } else {
            while(left <= right) {
                int mid = (left + right) / 2;
                if(nums[mid] == target) {
                    index = mid;
                    break;
                }
                if(target < nums[mid]) {
                    if(nums[mid] >= nums[left]) {
                        if(target < nums[left]) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    } else {
                        right = mid - 1;
                    }
                } else {
                    if(nums[mid] > nums[left]) {
                        left = mid + 1;
                    } else {
                        if(target > nums[right]) {
                            right = mid - 1;
                        } else {
                            left = mid + 1;
                        }
                    }
                }
            }
            return index;
        }

    }
}
