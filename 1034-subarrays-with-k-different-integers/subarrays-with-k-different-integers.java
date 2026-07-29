class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int left = 0;
        int count = 0;
        int ans = 0;

        int[] freq = new int[nums.length + 1];

        for (int right = 0; right < nums.length; right++) {
            if (freq[nums[right]] == 0) {
                count++;
            }

            freq[nums[right]]++;

            while (count > k) {
                freq[nums[left]]--;

                if (freq[nums[left]] == 0) {
                    count--;
                }

                left++;
            }

            ans += right - left + 1;
        }

        return ans;
    }
}