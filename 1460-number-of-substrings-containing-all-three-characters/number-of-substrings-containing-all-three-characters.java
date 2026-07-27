class Solution {
    public int numberOfSubstrings(String s) {
        int[] lastSeen = {-1, -1, -1};
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            lastSeen[s.charAt(i) - 'a'] = i;

            int minIndex = Math.min(lastSeen[0],
                            Math.min(lastSeen[1], lastSeen[2]));

            ans += minIndex + 1;
        }

        return ans;
    }
}