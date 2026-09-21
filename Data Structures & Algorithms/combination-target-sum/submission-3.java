class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Set<List<Integer>> results = new HashSet<>();
        backtrack(0, target, new ArrayList<>(), nums, results, 0);
        return new ArrayList<>(results);
    }

    private void backtrack(int currentSum, int target, List<Integer> current, int[] nums, Set<List<Integer>> results, int index) {
        if(currentSum > target || index >= nums.length) {
            return;
        }

        if(currentSum == target) {
            var clonedCurrent = new ArrayList<>(current);
            Collections.sort(clonedCurrent);

            results.add(new ArrayList<>(clonedCurrent));
            return;
        }

        currentSum += nums[index];
        current.add(nums[index]);
        backtrack(currentSum, target, current, nums, results, index);

        currentSum -= nums[index];
        current.remove(current.size() - 1);
        backtrack(currentSum, target, current, nums, results, index + 1);
    }
}
