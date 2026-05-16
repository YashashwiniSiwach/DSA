class Solution {

    // Function to check if Koko can finish all bananas
    // with eating speed = k within h hours
    public boolean canEat(int[] piles, int h, int k) {

        long hours = 0;

        // Traverse every pile
        for (int pile : piles) {

            // ceil(pile / k)
            // Formula for ceiling division
            hours += (pile + k - 1) / k;
        }

        // If total hours needed is <= h,
        // then this speed works
        return hours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {

        // Minimum possible speed
        int low = 1;

        // Maximum possible speed
        int high = 0;

        // Find maximum pile
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        // Store final answer
        int ans = high;

        // Binary Search
        while (low <= high) {

            // Middle speed
            int mid = low + (high - low) / 2;

            // Check if this speed works
            if (canEat(piles, h, mid)) {

                // Store answer
                ans = mid;

                // Try smaller speed
                high = mid - 1;
            }
            else {

                // Need faster speed
                low = mid + 1;
            }
        }

        return ans;
    }
}