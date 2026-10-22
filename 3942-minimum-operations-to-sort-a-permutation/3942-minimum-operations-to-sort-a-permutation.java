class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if(n < 3) {
            if(n == 1 || nums[0] < nums[1]) return 0;
            else return 1;
        }
        boolean inc = true;
        boolean dec = true;
        int incIdx = -1;
        int decIdx = -1;
        boolean check = false;
        for(int i=0; i<n-1; i++) {
            if(nums[i] > nums[i+1]) {
                if(check) {
                    inc = false;
                    break;
                } else {
                    check = true;
                    incIdx = i + 1;
                }
            }
        }
        if(!check) return 0;
        if(nums[n-1] > nums[0]) inc = false;
        check = false;
        for(int i=0; i<n-1; i++) {
            if(nums[i] < nums[i+1]) {
                if(check) {
                    dec = false;
                    break;
                } else {
                    check = true;
                    decIdx = i + 1;
                }
            }
        }
        if(!check) return 1;
        if(nums[0] > nums[n-1]) dec = false;
        if(!(inc || dec)) return -1;
        int result = Integer.MAX_VALUE;
        if(inc) {
            result = Math.min(result, incIdx);
            result = Math.min(result, n + 2 - incIdx);
        }
        if(dec) {
            result = Math.min(result, decIdx + 1);
            result = Math.min(result, n - decIdx + 1);
        }
        return result;
    }
}