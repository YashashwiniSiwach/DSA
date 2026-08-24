/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public int widthOfBinaryTree(TreeNode  root) {
        if(root == null) return 0;
        Queue<TreeNode> nodes=new LinkedList<>();
        Queue<Long> indices= new LinkedList<>();
        nodes.offer(root);
        indices.offer(0L);
        long ans=0;
        while(!nodes.isEmpty()){
            int size=nodes.size();
            long first=indices.peek();
            long last=first;
            for(int i=0;i<size;i++){
                TreeNode n=nodes.poll();
                long index=indices.poll();
                last=index;
                if(n.left!=null){
                    nodes.offer(n.left);
                    indices.offer(2*index);

                }
                if(n.right!=null){
                    nodes.offer(n.right);
                    indices.offer(2*index+1);

                }
            }
            ans=Math.max(ans,last-first+1);
        }
        return (int)ans;
    }
};