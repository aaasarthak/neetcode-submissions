class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for(int i=0; i < nums.length; i++) {
            if(!numsMap.containsKey(target - nums[i])) {
                numsMap.put(nums[i], i);
            } else {
                return new int[]{numsMap.get(target - nums[i]), i};
            }
        }
        return new int[]{0,0};
    }
}
