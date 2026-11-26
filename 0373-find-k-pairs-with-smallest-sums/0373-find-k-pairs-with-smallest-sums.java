class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> nums1[a.first]+nums2[a.second] - nums1[b.first]-nums2[b.second]);
        for(int i=0;i<n1;i++){
            pq.offer(new Pair(i,0));
        }
        for (int i=0;i<k;i++){
            Pair p = pq.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[p.first]);
            list.add(nums2[p.second]);
            result.add(list);
            if(p.second != n2-1){
                pq.offer(new Pair(p.first,p.second+1));
            }
        }
        return result;
    }
}