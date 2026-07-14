class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        int[] sieve = new int[n]; // 0 = prime, 1 = not prime

        for (int i = 2; i * i < n; i++) {
            if (sieve[i] == 0) {
                for (int j = i * i; j < n; j += i) {
                    sieve[j] = 1;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (sieve[i] == 0) {
                count++;
            }
        }

        return count;
    }
}