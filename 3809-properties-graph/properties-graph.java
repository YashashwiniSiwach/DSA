class Solution {
    class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa == pb) return;

            if (rank[pa] < rank[pb]) {
                parent[pa] = pb;
            } else if (rank[pa] > rank[pb]) {
                parent[pb] = pa;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }
        }
    }

    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;
        HashSet<Integer>[] sets = new HashSet[n];

        for (int i = 0; i < n; i++) {
            sets[i] = new HashSet<>();
            for (int x : properties[i]) {
                sets[i].add(x);
            }
        }

        DSU dsu = new DSU(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                HashSet<Integer> a = sets[i];
                HashSet<Integer> b = sets[j];

                if (a.size() > b.size()) {
                    HashSet<Integer> temp = a;
                    a = b;
                    b = temp;
                }

                int common = 0;

                for (int x : a) {
                    if (b.contains(x)) {
                        common++;
                        if (common >= k) {
                            dsu.union(i, j);
                            break;
                        }
                    }
                }
            }
        }

        HashSet<Integer> components = new HashSet<>();

        for (int i = 0; i < n; i++) {
            components.add(dsu.find(i));
        }

        return components.size();
    }
}