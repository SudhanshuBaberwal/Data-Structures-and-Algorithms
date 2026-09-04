class Solution {
    public int arrangeCoins(int n) {
        long total = (long)(n);
        int result = (-1 + ((int) (Math.sqrt(1 + 8*total)))) / 2;
        return result;
    }
}