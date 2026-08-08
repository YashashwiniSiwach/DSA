class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int [] cc=new int[n];
        for(int i=0;i<n;i++){
            cc[i]=1;
        }
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                cc[i]=cc[i-1]+1;
            }
        }
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                cc[i]=Math.max(cc[i], cc[i + 1] + 1);
            }
        }
        int total=0;
        for(int e:cc){
            total+=e;
        }
        return total;
    }
}