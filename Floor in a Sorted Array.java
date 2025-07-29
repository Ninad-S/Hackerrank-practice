class Solution {
    public int findFloor(int[] arr, int x, int i) {
        // code here
        if (arr[i] > x)
        {
            return i - 1;
        }
        if (arr[arr.length-1] <=x)
        {
            return arr.length-1;
        }
        return findFloor(arr,x,i+1);
    }
    public int findFloor(int[] arr, int x) {
        // code here
        return findFloor(arr,x,0);
    }
}
