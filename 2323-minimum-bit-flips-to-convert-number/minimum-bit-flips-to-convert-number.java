class Solution {
    public int minBitFlips(int start, int goal) {
        int num=start^goal;
        int cnt=0;
        for(int i=0;i<32;i++){
            if((num & (1<<i))!=0){
                cnt=cnt+1;
            }
        }
        return cnt;
    }
}