class Solution {
   public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

    for (int num : nums) {
    freq.put(num, freq.getOrDefault(num, 0) + 1);
    }
    PriorityQueue<Map.Entry<Integer,Integer>>pq=new PriorityQueue<>((a,b)-> b.getValue()-a.getValue());
    pq.addAll(freq.entrySet());
    int [] ans=new int[k];
    for(int i=0;i<k;i++){
        ans[i]=pq.poll().getKey();
    }
    return ans; 



    }
}