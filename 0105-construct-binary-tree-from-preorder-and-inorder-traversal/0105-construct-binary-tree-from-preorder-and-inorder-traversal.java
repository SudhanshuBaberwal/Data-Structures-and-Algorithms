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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);
        int idx = indexOf(inorder,preorder[0]);
        int leftCount = idx;
        root.left = buildLeft(preorder,inorder,0,idx-1,1);
        root.right = buildRight(preorder,inorder,idx+1,n-1,1+leftCount);
        return root;
    }
    private TreeNode buildLeft(int [] preorder, int [] inorder,int start,int end,int preIdx){
        if (start > end) return null;
        TreeNode root = new TreeNode(preorder[preIdx]);
        int idx = indexOf(inorder,root.val);
        int leftCount = idx - start;
        root.left = buildLeft(preorder, inorder, start, idx - 1, preIdx + 1);
        root.right = buildRight(preorder, inorder, idx + 1, end, preIdx + 1 + leftCount);
        return root;
    }
    private TreeNode buildRight(int [] preorder, int [] inorder, int start,int end, int preIdx){
        if (start>end) return null;
        TreeNode root = new TreeNode(preorder[preIdx]);
        int idx = indexOf(inorder,root.val);
        int leftCount = idx - start;
        root.left = buildLeft(preorder, inorder, start, idx - 1, preIdx + 1);
        root.right = buildRight(preorder, inorder, idx + 1, end, preIdx + 1 + leftCount);
        return root;
    }
    private int indexOf(int[] arr, int element) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == element) return i;
        }
        return -1;
    }
}