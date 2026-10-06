class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        Deque<Character> st = new ArrayDeque<>();
        for (int i=0;i < n; i++) {
            char curr = s.charAt(i);
            if (curr == '(') {
                st.push(curr);
            }
            else{
                if (!st.isEmpty()){
                    char el = st.peek();
                    if (el == '('){
                        st.pop();
                    }
                    else{
                        st.push(curr);
                    }
                }
                else{
                    st.push(curr);
                }
            }
        }
        return st.size();
    }
}