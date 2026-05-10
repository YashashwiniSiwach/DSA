class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int el=nums[i];
            int count=0;
            if (ans.contains(el)) {
                continue;
            }

            for(int j=0;j<nums.length;j++){
            if(nums[i]==nums[j]){
                count++;
            }

        }
        if(count>nums.length/3){
            ans.add(el);
        }
        }
        return ans;
    }
}