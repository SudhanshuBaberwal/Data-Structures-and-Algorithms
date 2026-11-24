class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> dist(b) - dist(a));

        for (int [] point : points){
            pq.offer(point);
            if (pq.size() > k){
                pq.poll();
            }
        }

        int [][] ans = new int [k][];
        for (int i =0;i<k;i++){
            ans[i] = pq.poll();
        }
        return ans;
    }
    private int dist(int [] arr){
        int x = arr[0];
        int y = arr[1];
        return x*x+y*y;
    }
}