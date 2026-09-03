class Solution {

    public int[] rearrangeArray(int[] nums) {
        // int n = nums.length;
        // for (int i = 0; i < n; i++) {
        //     if (i % 2 == 0) {
        //         if (nums[i] < 0) {
        //             int idx = i + 1;
        //             while (idx < n && nums[idx] < 0) {
        //                 idx++;
        //             }
        //             int temp = nums[idx];
        //             for (int j = idx; j > i; j--) {
        //                 nums[j] = nums[j - 1];
        //             }
        //             nums[i] = temp;
        //         }
        //     }
        //     else {
        //         if (nums[i] > 0) {
        //             int idx = i + 1;
        //             while (idx < n && nums[idx] > 0) {
        //                 idx++;
        //             }
        //             int temp = nums[idx];
        //             for (int j = idx; j > i; j--) {
        //                 nums[j] = nums[j - 1];
        //             }
        //             nums[i] = temp;
        //         }
        //     }
        // }
        // return nums;
        int[] ans = new int[nums.length];
        int pos = 0;
        int neg = 1;
        for (int num : nums) {
            if (num > 0) {
                ans[pos] = num;
                pos += 2;
            } else {
                ans[neg] = num;
                neg += 2;
            }
        }
        return ans;
    }
}