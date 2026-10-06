class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        char [] str = s.toCharArray();
        recurse(str, 0,result);
        return result;
    }
    public void recurse(char [] str, int pos, List<String> result){
        if (pos == str.length) {
            result.add(new String(str));
            return;
        }
        if (Character.isLetter(str[pos])) {
            if (Character.isUpperCase(str[pos])) {
                str[pos] = Character.toLowerCase(str[pos]);
                recurse(str, pos + 1, result);
                str[pos] = Character.toUpperCase(str[pos]);
            }
            else{
                str[pos] = Character.toUpperCase(str[pos]);
                recurse(str, pos+1, result);
                str[pos] = Character.toLowerCase(str[pos]);
            }
        }
        recurse(str, pos+1, result);
    }
}