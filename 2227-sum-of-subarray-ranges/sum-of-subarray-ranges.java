class Solution {
    public long subArrayRanges(int[] nums) {
        return sumMax(nums) - sumMin(nums);
    }

    private long sumMin(int[] nums) {
        int n = nums.length;
        int[] prev = new int[n];
        int[] next = new int[n];
        Stack<Integer> st = new Stack<>();

        // Previous Smaller
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Smaller or Equal
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;
            ans += (long) nums[i] * left * right;
        }

        return ans;
    }

    private long sumMax(int[] nums) {
        int n = nums.length;
        int[] prev = new int[n];
        int[] next = new int[n];
        Stack<Integer> st = new Stack<>();

        // Previous Greater
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            prev[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Next Greater or Equal
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;
            ans += (long) nums[i] * left * right;
        }

        return ans;
    }
}