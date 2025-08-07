class Solution {
    public static int kthSmallest(int[] arr, int k, int i) {
        // Your code here
        if (i == k-1)
        {
            return arr[i];
        }
        return kthSmallest(arr,k,i+1);
    }
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        Arrays.sort(arr);
        return kthSmallest(arr,k,0);
    }
}
