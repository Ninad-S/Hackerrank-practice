class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr, ArrayList<Integer> res, int i) {
        if (i == arr.length)
        {
            return res;
        }
        boolean exists = false;
        for (int j = i+1; j < arr.length; j++)
        {
            if (arr[j] > arr[i])
            {
                res.add(arr[j]);
                exists = true;
                break;
            }
        }
        if (!exists)
        {
            res.add(-1);
        }
        return nextLargerElement(arr,res,i+1);
    }
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        
        return nextLargerElement(arr,res,0);
    }
}
