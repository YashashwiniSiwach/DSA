class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> queue = new LinkedList<>();

        int m = image.length;
        int n = image[0].length;

        int originalColor = image[sr][sc];

        if (originalColor == color) {
            return image;
        }

        queue.add(new int[]{sr, sc});
        image[sr][sc] = color;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int i = current[0];
            int j = current[1];

            if (i + 1 < m && image[i + 1][j] == originalColor) {
                image[i + 1][j] = color;
                queue.add(new int[]{i + 1, j});
            }

            if (i - 1 >= 0 && image[i - 1][j] == originalColor) {
                image[i - 1][j] = color;
                queue.add(new int[]{i - 1, j});
            }

            if (j + 1 < n && image[i][j + 1] == originalColor) {
                image[i][j + 1] = color;
                queue.add(new int[]{i, j + 1});
            }

            if (j - 1 >= 0 && image[i][j - 1] == originalColor) {
                image[i][j - 1] = color;
                queue.add(new int[]{i, j - 1});
            }
        }

        return image;
    }
}
