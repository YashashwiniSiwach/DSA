class Solution {
    public void sortColors(int[] nums) {
        int [] b=new int[3];
        int[] c=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            b[nums[i]]++;
        }
         for (int i = 1; i < 3; i++) {
            b[i] += b[i - 1];
        }

        for(int i=nums.length-1;i>=0;i--){
            c[b[nums[i]]-1]=nums[i];
            b[nums[i]]--;
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=c[i];
        }
    }
}