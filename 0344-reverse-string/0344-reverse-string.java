class Solution {
    private char [] reverse(char [] s , int left , int right){
        if (left>=right) return s;
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        return reverse(s , left+1,right-1);
    }
    public void reverseString(char[] s) {
        reverse(s,0,s.length-1);
    }
}