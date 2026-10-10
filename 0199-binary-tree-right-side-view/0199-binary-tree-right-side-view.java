class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        right(root, list, 0);
        return list;
    }

    public void right(TreeNode root, List<Integer> list, int height) {

        if(root == null) {
            return;
        }
        if(height == list.size()) {
            list.add(root.val);
        }
        right(root.right, list, height + 1);
        right(root.left, list, height + 1);
    }
}