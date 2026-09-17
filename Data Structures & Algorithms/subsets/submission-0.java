class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, nums, results);
        return new ArrayList<>(results);
    }

    private void backtrack(List<Integer> current, int index, int[] nums, List<List<Integer>> results) {
        if(index >= nums.length) {
            results.add(new ArrayList<>(current));
            return;
        };

        current.add(nums[index]);
        backtrack(current, index + 1, nums, results);

        current.remove(current.size() - 1);
        backtrack(current, index + 1, nums, results);
    }
}
