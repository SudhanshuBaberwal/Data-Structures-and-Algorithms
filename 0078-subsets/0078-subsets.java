class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        recur(nums, 0, new ArrayList());
        return result;
    }
    private void recur(int nums[], int i, List<Integer> l) {
        if (i == nums.length) {
            result.add(new ArrayList(l));
            return;
        }
        l.add(nums[i]);
        recur(nums, i + 1, l);
        l.remove(l.size() - 1);
        recur(nums, i + 1, l);
    }
}