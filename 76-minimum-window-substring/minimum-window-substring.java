class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] need = new int[128];

        // Count required characters
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;
        int right = 0;
        int count = t.length(); // characters still needed
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char r = s.charAt(right);

            // If character is needed, reduce count
            if (need[r] > 0) {
                count--;
            }
            need[r]--;
            right++;

            // When all characters are found
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char l = s.charAt(left);
                need[l]++;

                // If removing this character makes window invalid
                if (need[l] > 0) {
                    count++;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE 
                ? "" 
                : s.substring(start, start + minLen);
    }
}