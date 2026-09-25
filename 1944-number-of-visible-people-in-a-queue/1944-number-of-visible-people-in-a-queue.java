class Solution {
    public int[] canSeePersonsCount(int[] nums) {

        Stack<Integer> st = new Stack<>();
        int ans[] = new int[nums.length];

        for(int i=nums.length-1;i>=0;i--) {

            int count = 0;

            while(!st.isEmpty() && st.peek() < nums[i]) {
                st.pop();
                count++;
            }
        count = !st.isEmpty()?count+1:count;

        ans[i] = count;
        st.push(nums[i]);
        }

        return ans;
        
    }
}