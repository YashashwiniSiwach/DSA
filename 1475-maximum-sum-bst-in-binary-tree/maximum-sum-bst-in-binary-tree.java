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
     int ans = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    // returns: [isBST, min, max, sum]
    int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // Check whether current subtree is a BST
        if (left[0] == 1 && right[0] == 1 &&
            root.val > left[2] && root.val < right[1]) {

            int sum = left[3] + right[3] + root.val;

            ans = Math.max(ans, sum);

            int min = Math.min(root.val, left[1]);
            int max = Math.max(root.val, right[2]);

            return new int[]{1, min, max, sum};
        }

        // Not a BST
        return new int[]{0, 0, 0, 0};
    }
}
