class Solution {
    public String makeGood(String s) {

        Deque<Character> st = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {

            char current = s.charAt(i);

            if (!st.isEmpty()
                    && Character.toLowerCase(st.peek()) == Character.toLowerCase(current)
                    && st.peek() != current) {

                st.pop();

            } else {
                st.push(current);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Character ch : st) {
            sb.append(ch);
        }

        return new StringBuilder(sb).reverse().toString();
    }
}