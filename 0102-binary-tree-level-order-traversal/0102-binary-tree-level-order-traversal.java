class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) {
            return ans;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = q.size();

            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                list.add(curr.val);

                if(curr.left != null) {
                    q.offer(curr.left);
                }
                if(curr.right != null) {
                    q.offer(curr.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}