class Solution {
    public void dfs(TreeNode root, List<String> path,
                    List<String> paths) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            paths.add(String.join("", path) + root.val);
            return;
        }

        path.add(root.val + "->");
        dfs(root.left, path, paths);
        dfs(root.right, path, paths);
        path.remove(path.size() - 1);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfs(root, new ArrayList<>(), paths);
        return paths;
    }
}