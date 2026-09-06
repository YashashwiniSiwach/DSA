class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int mlen=Integer.MAX_VALUE;
        int s=0;
        int sum=0;
        for(int r=0;r<nums.length;r++){
            sum += nums[r];
            while(sum>=target){
                mlen=Math.min(mlen,r-s+1);
                sum -=nums[s];
                s++;
            }
            
        }
        return mlen==Integer.MAX_VALUE?0:mlen;
    }
}