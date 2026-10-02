class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        generate(n,k,1,list);
        return result;
    }

    private void generate(int n , int  k ,int start, List<Integer> list){
        if (list.size() == k) {
            result.add(new ArrayList<>(list));  
            return;
        }
        for(int i = start; i <= n ; i++){
            list.add(i);
            generate(n,k,i+1,list);
            list.remove(list.size() - 1);
        }
    }
}