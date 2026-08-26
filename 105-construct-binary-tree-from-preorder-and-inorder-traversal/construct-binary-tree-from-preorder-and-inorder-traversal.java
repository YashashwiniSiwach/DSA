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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0) {
            return null;
        }

        return build(preorder, 0, preorder.length - 1,
                     inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int ps, int pe,
                           int[] inorder, int is, int ie) {

        if (ps > pe || is > ie) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[ps]);

        int index = is;
        while (inorder[index] != root.val) {
            index++;
        }

        int leftSize = index - is;

        root.left = build(preorder, ps + 1, ps + leftSize,
                          inorder, is, index - 1);

        root.right = build(preorder, ps + leftSize + 1, pe,
                           inorder, index + 1, ie);

        return root;
    }
}