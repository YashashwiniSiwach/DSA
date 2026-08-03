class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Boolean bb;
        if(hand.length%groupSize!=0){
            return false;
        }
        Arrays.sort(hand);
        HashMap<Integer,Integer> mpp= new HashMap<>();
        for(int e:hand){
            mpp.put(e,mpp.getOrDefault(e,0)+1);
        }
        for(int card:hand){
            if(mpp.get(card)==0){
                continue;
            }
            
            for(int i=0;i<groupSize;i++){
               int current=card+i;
               if(!mpp.containsKey(current) || mpp.get(current) == 0){
                    return false;
               }
               mpp.put(current,mpp.get(current)-1);
            }
        }
        return true;
    }
}