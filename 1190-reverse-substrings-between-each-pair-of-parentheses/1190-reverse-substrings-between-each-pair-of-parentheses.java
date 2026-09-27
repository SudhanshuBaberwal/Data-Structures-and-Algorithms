class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Deque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char current = s.charAt(i);
            if (current == ')') {
                StringBuilder sb = new StringBuilder();
                while (st.peek() != '(') {
                    sb.append(st.pop());
                }
                st.pop();
                String str = sb.toString();
                int k = 0;
                while (k < str.length()) {
                    st.push(str.charAt(k));
                    k++;
                }
            } else {
                st.push(current);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}