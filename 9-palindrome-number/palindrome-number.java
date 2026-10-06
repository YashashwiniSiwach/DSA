class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int org=x;
        long r=0;
        while(x>0){
            int dig=x%10;
            r=r*10+dig;
            x/=10;
        }
        return org==r;
    }
}