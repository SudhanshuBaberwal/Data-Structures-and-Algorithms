class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) {
            return -1;
        }
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for (int it : bloomDay) {
            left = Math.min(left, it);
            right = Math.max(right, it);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int bouquets = helper(bloomDay,mid,k);
            if (bouquets < m){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
    private int helper(int [] bloodDay , int day, int k){
        int bouquets = 0;
        int count = 0;
        for (int flower : bloodDay){
            if (flower <= day){
                count++;
                if (count == k){
                    bouquets++;
                    count =0;
                }
            }
            else{
                count=0;
            }
        }
        return bouquets;
    }
}