class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       List<List<Integer>>ans=new ArrayList<>();
       Arrays.sort(candidates);
       combi(candidates,target,0,new ArrayList<>(),ans);
       return ans;
    }
    private void combi(int[] candidates,int target,int start,List<Integer> current,List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            current.add(candidates[i]);
            combi(candidates,target - candidates[i],i+1,current,result);
            current.remove(current.size() - 1);
        }
    }
}