/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Pair{
    TreeNode node;
    int dis;
    Pair(TreeNode node,int dis){
        this.node=node;
        this.dis=dis;
    }
}
class Solution {
    private void buildParentMap(TreeNode node,TreeNode parent,Map<TreeNode,TreeNode> parentMap){
        if (node == null) return;
        parentMap.put(node,parent);
        buildParentMap(node.left,node,parentMap);
        buildParentMap(node.right,node,parentMap);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        buildParentMap(root,null,parentMap);
        
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);

        int distance = 0;
        while (!q.isEmpty() && distance < k){
            int size = q.size();
            for (int i =0;i < size;i++){
                TreeNode curr = q.poll();
                if (curr.left != null && !visited.contains(curr.left)){
                    q.offer(curr.left);
                    visited.add(curr.left);
                }
                if (curr.right!=null && !visited.contains(curr.right)){
                    q.offer(curr.right);
                    visited.add(curr.right);
                }
                TreeNode parent = parentMap.get(curr);
                if (parent != null && !visited.contains(parent)){
                    q.offer(parent);
                    visited.add(parent);
                }
            }
            distance++;
        }
        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()){
            result.add(q.poll().val);
        }
        return result;
    }
}