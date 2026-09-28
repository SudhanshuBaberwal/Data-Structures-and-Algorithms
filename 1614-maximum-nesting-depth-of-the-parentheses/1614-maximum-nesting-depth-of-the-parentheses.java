class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int ans = 0;
        int k = 0;
        for (int i = 0 ; i < n; i++){
            char curr = s.charAt(i);
            if (curr == '('){
                k++;
            }
            else if (curr == ')'){
                ans = Math.max(k,ans);
                k--;
            }
        }
        return ans;
    }
}