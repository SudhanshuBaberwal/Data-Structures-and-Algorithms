class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        helper(set, s, 0, new StringBuilder());
        List<String> result = new ArrayList<>(set);
        return result;
    }

    private void helper(Set<String> set, String s, int idx, StringBuilder sb) {
        int n = s.length();
        if (idx == n) {
            String curr = sb.toString();
            if (checkValidity(curr)) {
                int len = curr.length();
                int prev = 0;
                for (String element : set) {
                    prev = element.length();
                    break;
                }
                if (prev <= len) {
                    if(prev < len) set.clear();
                    set.add(curr);
                }
            }
            return;
        }
        char ch = s.charAt(idx);
        sb.append(ch);
        helper(set, s, idx+1, sb);
        sb.deleteCharAt(sb.length() - 1);
        if (ch == '(' || ch == ')') {
            helper(set, s, idx+1, sb);
        }
    }
    private boolean checkValidity(String s) {
        int count = 0;
        int n = s.length();
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') count++;
            else if(ch == ')') {
                if(count == 0) return false;
                else count--;
            }
        }
        return (count == 0);
    }
}