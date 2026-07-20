class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int maxArea = 0;
        int[] arr = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    arr[j]++;
                } else {
                    arr[j] = 0;
                }
            }

            maxArea = Math.max(maxArea, lra(arr));
        }

        return maxArea;
    }

    public int lra(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int max = 0;
        int n = arr.length;

        for (int i = 0; i <= n; i++) {
            int curr = (i == n) ? 0 : arr[i];

            while (!st.isEmpty() && arr[st.peek()] > curr) {
                int height = arr[st.pop()];

                int width;
                if (st.isEmpty()) {
                    width = i;
                } else {
                    width = i - st.peek() - 1;
                }

                max = Math.max(max, height * width);
            }

            st.push(i);
        }

        return max;
    }
}