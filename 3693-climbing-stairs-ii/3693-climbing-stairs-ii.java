class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for(int i = 1; i <= n; i++) {
            int oneStep = dp[i - 1] + costs[i - 1] + 1;
            int best = oneStep;

            if(i >= 2) {
                int twoStep = dp[i - 2] + costs[i - 1] + 4;
                best = Math.min(best, twoStep);
            }

            if(i >= 3) {
                int threeStep = dp[i - 3] + costs[i - 1] + 9;
                best = Math.min(best, threeStep);
            }

            dp[i] = best;
        }

        return dp[n];
    }
}