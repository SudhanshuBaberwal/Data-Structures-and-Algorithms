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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root,targetSum,result, new ArrayList());
        return result;
    }
    public void helper(TreeNode root, int targetSum, List<List<Integer>> result , List<Integer> list){
        if (root== null) return;
        list.add(root.val);
        if (root.left == null && root.right == null){
            if (targetSum == root.val){
                result.add(new ArrayList(list));
            }
        }
        else{
            helper(root.left,targetSum-root.val,result,list);
            helper(root.right,targetSum-root.val,result,list);
        }
        list.remove(list.size()-1);
    }
}