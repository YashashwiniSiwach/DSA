class Solution {
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> rows= new ArrayList<>();
               for (int j = 0; j <= i; j++) {
            if(j==0||j==i){
                rows.add(1);
            }
            else{
                int val=triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j);
                rows.add(val);
            }
               }
        triangle.add(rows);

    }
    return triangle;
    }
}