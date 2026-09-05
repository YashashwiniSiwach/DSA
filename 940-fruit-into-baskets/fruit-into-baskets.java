class Solution {
    public int totalFruit(int[] fruits) {
        int l=0;
        int maxl=0;
        Map<Integer,Integer>mpp= new HashMap<>();   
        for(int r=0;r<fruits.length;r++){
            mpp.put(fruits[r],mpp.getOrDefault(fruits[r], 0) + 1);

            while(mpp.size()>2){
                mpp.put(fruits[l],mpp.get(fruits[l])-1);

                if(mpp.get(fruits[l])==0){
                    mpp.remove(fruits[l]);
                }
                l++;
            }
            maxl=Math.max(r-l+1,maxl);
        }
        return maxl;
    }
}