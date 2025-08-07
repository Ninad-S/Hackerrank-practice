class Solution {
    public int min(int arr[], int i, int min) {
        // Code here
        if (i==arr.length)
        {
            return min;
        }
        if (arr[i] < min)
        {
            min = arr[i];
        }
        return min(arr,i+1,min);
    }
    public int min(int arr[]) {
        // Code here
        return min(arr,1,arr[0]);
    }
    public int findKRotation(int arr[], int i, int min) {
        // Code here
        if (arr[i]==min)
            return i;
        return findKRotation(arr,i+1,min);
    }
    public int findKRotation(int arr[]) {
        // Code here
        return findKRotation(arr,0,min(arr));
        
    }
}
