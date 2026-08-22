class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root.left);
        q.offer(root.right);

        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null) {
                return false;
            }

            if (left.val != right.val) {
                return false;
            }

            // Outer pair
            q.offer(left.left);
            q.offer(right.right);

            // Inner pair
            q.offer(left.right);
            q.offer(right.left);
        }

        return true;
    }
}