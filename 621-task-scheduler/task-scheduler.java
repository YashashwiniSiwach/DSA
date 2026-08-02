class Solution {
    public int leastInterval(char[] tasks, int n) {
        int ans=0;
        int [] freq= new int[26];
        for(char ch:tasks){
            freq[ch -'A']++;
        }
        int maxfreq=0;
        for(int count:freq){
            maxfreq=Math.max(maxfreq,count);
        }

        int maxcount=0;
        for(int count:freq){
            if(count==maxfreq){
            maxcount++;
            }

        }
        ans=(maxfreq - 1) * (n + 1) + maxcount;

        return Math.max(ans,tasks.length);

    }
}