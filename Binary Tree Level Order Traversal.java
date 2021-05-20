class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = bfs.poll();
                arr.add(curr.val);
                if (curr.left != null) bfs.offer(curr.left);
                if (curr.right != null) bfs.offer(curr.right);
            }
            ans.add(arr);
        }
        return ans;
    }
}