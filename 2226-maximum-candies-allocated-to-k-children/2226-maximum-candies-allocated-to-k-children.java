class Solution {

    public int maximumCandies(int[] candies, long k) {
        long total = 0;
        int right = 0;
        for (int candy : candies) {
            total += candy;
            right = Math.max(right, candy);
        }
        if (total < k) {
            return 0;
        }
        int left = 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (helper(candies, k, mid)) {
                left = mid;
            } 
            else {
                right = mid - 1;
            }
        }
        return left;
    }
    private boolean helper(int[] candies, long k, int mid) {
        long count = 0;
        for (int candy : candies) {
            count += candy / mid;
            if (count >= k) {
                return true;
            }
        }
        return false;
    }
}