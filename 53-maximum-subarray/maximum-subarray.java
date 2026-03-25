class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum=Integer.MIN_VALUE;
        int sum=0;
        int ansstart=-1;
        int ansEnd=-1;
        int start=0;
        for(int i=0;i<nums.length;i++){
            if(sum==0) {
                start=i;
            }
            
                sum+=nums[i];
                if(sum>maxsum){
                    maxsum=sum;
                    ansstart=start;
                    ansEnd=i;
                }
                if(sum<0){
                    sum=0;
                }

            }


    
        return maxsum;
    }
}