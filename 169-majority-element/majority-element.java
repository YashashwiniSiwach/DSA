class Solution {
    public int majorityElement(int[] nums) {
        int el=0;
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(cnt==0){
                el=nums[i];
            }
            if(nums[i]==el){
                cnt++;
            }
            else{
            cnt--;
        }
        }
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==el){
                count++;
            }
        }
        if(count>nums.length/2){
            return el;
        }
        return -1;
    }
}