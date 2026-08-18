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
    public int maxDepth(TreeNode root) {
        return maxD(root,0);
    }
    private static int maxD(TreeNode root,int count){
        if(root==null){
            return count;
        }
        int ans1=maxD(root.left,count+1);
        int ans2=maxD(root.right,count+1);
        return Math.max(ans1,ans2);
    }

}