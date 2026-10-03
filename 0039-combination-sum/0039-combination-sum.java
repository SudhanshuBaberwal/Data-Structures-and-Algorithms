class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        generateCombinationsSum(0,candidates,target,result,list);
        return result;
    }
    private void generateCombinationsSum(int index , int [] arr , int target,List<List<Integer>> ans , List<Integer> ds){
        if (index == arr.length){
            if (target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if (arr[index] <= target){
            ds.add(arr[index]);
            generateCombinationsSum(index,arr,target-arr[index],ans,ds);
            ds.remove(ds.size()-1);
        }
        generateCombinationsSum(index+1,arr,target,ans,ds);
    }
}