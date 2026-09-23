class Solution {
    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used);
        return results;
    }

    private void backtrack(int[] nums, List<Integer> current, boolean[] used) {
        if(current.size() == nums.length) {
            results.add(current);
        }

        for(int i=0; i<nums.length; i++) {
            if(used[i]) {
                continue;
            }

            current.add(nums[i]);
            used[i] = true;

            backtrack(nums, new ArrayList<>(current), used);

            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}
