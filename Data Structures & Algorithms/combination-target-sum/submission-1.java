class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Set<List<Integer>> results = new HashSet<>();
        backtrack(0, target, new ArrayList<>(), nums, results, 0);
        return new ArrayList<>(results);
    }

    private void backtrack(int currentSum, int target, List<Integer> current, int[] nums, Set<List<Integer>> results, int index) {
        if(currentSum > target) {
            return;
        }

        if(currentSum == target) {
            var clonedCurrent = new ArrayList<>(current);
            Collections.sort(clonedCurrent);

            results.add(new ArrayList<>(clonedCurrent));
            return;
        }

        for(int i=index; i<nums.length; i++) {
            currentSum += nums[i];
            current.add(nums[i]);

            backtrack(currentSum, target, current, nums, results, i);

            currentSum -= nums[i];
            current.remove(current.size() - 1);
        }
    }
}
