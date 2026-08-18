class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean isbalancedleft = isBalanced(root.left);
        boolean isbalancedright = isBalanced(root.right);

        int leftheight = maxD(root.left, 0);
        int rightheight = maxD(root.right, 0);

        if (Math.abs(leftheight - rightheight) > 1) {
            return false;
        }

        return isbalancedleft && isbalancedright;
    }

    private static int maxD(TreeNode root, int count) {
        if (root == null) {
            return count;
        }

        int ans1 = maxD(root.left, count + 1);
        int ans2 = maxD(root.right, count + 1);

        return Math.max(ans1, ans2);
    }
}
