class Solution {
    private int convert(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = convert(nums[i]);
            arr[i][1] = nums[i];
            arr[i][2] = i;
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        int[] target = new int[n];
        for (int i = 0; i < n; i++) {
            int originalIndex = arr[i][2];
            target[originalIndex] = i;
        }
        boolean[] visited = new boolean[n];
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] || target[i] == i) {
                continue;
            }
            int current = i;
            int cycleLength = 0;
            while (!visited[current]) {
                visited[current] = true;
                current = target[current];
                cycleLength++;
            }
            swaps += cycleLength - 1;
        }
        return swaps;
    }
}
