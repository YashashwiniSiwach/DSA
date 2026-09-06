import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Prefix sum 0 occurs once before the array starts
        map.put(0, 1);

        int sum = 0;
        int ans = 0;

        for (int num : nums) {
            sum += num;

            // If this prefix sum existed before,
            // the elements between that position and here sum to k.
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}
