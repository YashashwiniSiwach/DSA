class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int c=0;
        int el=0;
        for(int i=0;i<n;i++){
            if(c==0){
                c=1;
                el=nums[i];
            }
            else if(el==nums[i]){
                c++;
            }
            else{
                c--;
            }
        }
        int cnt1=0;
        for(int i=0;i<n;i++){
            if(nums[i]==el){
                cnt1++;
            }
        }
        if(cnt1>n/2){
            return el;
        }
        return -1;
    }
}