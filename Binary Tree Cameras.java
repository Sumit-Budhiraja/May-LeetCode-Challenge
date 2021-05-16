class Solution {
   int res = 0;
    public int minCameraCover(TreeNode root) {
        return (dfs(root) =="notCovered" ? 1 : 0) + res;
    }

    public String dfs(TreeNode root) {
        if (root == null) return "covered";
        String left = dfs(root.left), right = dfs(root.right);
        if (left == "notCovered" || right == "notCovered") {
            res++;
            return "havingCamera";
        }
        return left == "havingCamera" || right == "havingCamera" ? "covered" : "notCovered";
   
    }
}