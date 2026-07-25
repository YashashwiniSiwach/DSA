import java.util.HashMap;
class Solution {
    public int characterReplacement(String s, int k) {
        int maxf=0;
        int l=0;
        int len=0;
        HashMap<Character,Integer> mpp=new HashMap<>();
        for(int r=0;r<s.length();r++){
           char ch=s.charAt(r);
           mpp.put(ch,mpp.getOrDefault(ch,0)+1);
           maxf=Math.max(maxf,mpp.get(ch));
           while((r-l+1)-maxf>k){
            char leftch=s.charAt(l);
            mpp.put(leftch,mpp.get(leftch)-1);
            l++;
           }
           len=Math.max(len,r-l+1);
        }
        return len;
    }
}