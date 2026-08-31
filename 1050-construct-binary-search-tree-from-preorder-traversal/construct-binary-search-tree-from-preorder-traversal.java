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

    public TreeNode bstFromPreorder(int[] preorder) {
        int[] index = {0};
        return build(preorder, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int[] index, int min, int max) {
        if (index[0] >= preorder.length) {
            return null;
        }

        int value = preorder[index[0]];

        if (value < min || value > max) {
            return null;
        }

        TreeNode root = new TreeNode(value);
        index[0]++;

        root.left = build(preorder, index, min, value);
        root.right = build(preorder, index, value, max);

        return root;
    }
}
