class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m, int i, ArrayList<Integer> differeneces) {
        // your code here
        if (m == arr.size())
        {
            return arr.get(arr.size()-1) - arr.get(0);
        }
        if (i > arr.size()-m)
        {
            Collections.sort(differeneces);
            return differeneces.get(0);
        }
        differeneces.add(arr.get(i+m-1) - arr.get(i));
        return findMinDiff(arr,m,i+1,differeneces);
        
    }
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here
        Collections.sort(arr);
        ArrayList<Integer> differeneces = new ArrayList<>();
        
        return findMinDiff(arr,m,0,differeneces);
        
    }
}
