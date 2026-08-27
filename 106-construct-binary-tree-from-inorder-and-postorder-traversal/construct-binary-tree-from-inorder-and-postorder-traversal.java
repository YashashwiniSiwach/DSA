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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null ||
            inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        return canBuild(inorder, 0, inorder.length - 1,
                        postorder, 0, postorder.length - 1);
    }

    private TreeNode canBuild(int[] inorder, int inStart, int inEnd,
                              int[] postorder, int postStart, int postEnd) {

        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inStart;

        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }

        int leftSize = rootIndex - inStart;

        root.left = canBuild(
            inorder,
            inStart,
            rootIndex - 1,
            postorder,
            postStart,
            postStart + leftSize - 1
        );

        root.right = canBuild(
            inorder,
            rootIndex + 1,
            inEnd,
            postorder,
            postStart + leftSize,
            postEnd - 1
        );

        return root;
    }
}
