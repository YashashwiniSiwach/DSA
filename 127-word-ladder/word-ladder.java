class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        int ans = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String word = queue.poll();

                if (word.equals(endWord)) {
                    return ans;
                }

                char[] chars = word.toCharArray();

                // Change one character at a time
                for (int j = 0; j < chars.length; j++) {

                    char original = chars[j];

                    for (char c = 'a'; c <= 'z'; c++) {

                        chars[j] = c;
                        String newWord = new String(chars);

                        if (set.contains(newWord)) {
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }

                    chars[j] = original;
                }
            }

            ans++;
        }

        return 0;
    }
}