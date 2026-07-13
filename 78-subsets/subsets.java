class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans =new ArrayList<>();
        int n=nums.length;
        int subsets=1<<n;
        for(int i=0;i<subsets;i++ ){
                List<Integer> nu=new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i & (1<<j))!=0){
                    nu.add(nums[j]);
                }
            }ans.add(nu);

        }
        
        return ans;
    }
}