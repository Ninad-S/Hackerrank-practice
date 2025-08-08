class Solution {
    int countFreq(int[] arr, int target,int i, int count) {
        // code here
        if (i==arr.length)
        {
            return count;
        }
        if (arr[i]==target)
        {
            count++;
        }
        return countFreq(arr,target,i+1,count);
    }
    int countFreq(int[] arr, int target) {
        // code here
        return countFreq(arr,target,0,0);
    }
}
