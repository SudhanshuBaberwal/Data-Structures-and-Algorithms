class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        boolean [] isVisited = new boolean[nums.length];
        generate(nums,list,isVisited);
        return result;
    }
    private void generate(int[] nums, List<Integer> list , boolean [] isVisited) {
        if (list.size() == nums.length){
            result.add(new ArrayList<>(list));  
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (isVisited[i]) continue;
            isVisited[i] = true;
            list.add(nums[i]);
            generate(nums,list,isVisited);
            list.remove(list.size() - 1);
            isVisited[i] = false;
        }
    }
}