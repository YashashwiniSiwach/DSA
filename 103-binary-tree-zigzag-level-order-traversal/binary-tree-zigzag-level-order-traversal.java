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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        boolean reverse = false;
        if(root==null){
            return ans;
        }
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode a=q.poll();
                level.add(a.val);
                if (a.left != null) {
                    q.offer(a.left);
                }   
                if (a.right != null) {
                    q.offer(a.right);
                }
                
                
        }
        if (reverse) {
                Collections.reverse(level);
            }
        ans.add(level);
         reverse = !reverse;
        }
        return ans;
        
    }
}