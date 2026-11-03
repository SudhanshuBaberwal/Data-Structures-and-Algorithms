/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            int size = q.size();
            long sum=0;
            for (int i=0;i<size;i++){
                TreeNode curr = q.poll();
                sum+=(long) curr.val;
                if (curr.left!=null) q.offer(curr.left);
                if (curr.right!=null) q.offer(curr.right);
            }
            Double avg = (double)sum/size;
            result.add(avg);
        }
        return result;
    }
}