class Solution {
    public void nextPermutation(int[] nums) {
        int el=-1;
        for(int i=nums.length-2;i>=0;i--){
            //finding the pivot element
            if(nums[i]<nums[i+1]){
                el=i;
                break;

            }
            
        }
        if (el!=-1){
        for(int i=nums.length-1;i>el;i--){
            if(nums[i]>nums[el]){
                swap(nums,i,el);
                break;
            }
        }
        }
        for (int left = el + 1, right = nums.length - 1; left < right; left++, right--) {
            swap(nums, left, right);
        }


    }
    
    public void swap(int [] a,int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}