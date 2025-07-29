class Solution {
    static ArrayList<Integer> leaders(int arr[],int i, ArrayList<Integer> nums) {
        // code here
            if (i==arr.length)
            {
                return nums;
            }
            boolean met = true;
            for (int j = i+1; j < arr.length; j++)
            {
                if (arr[j] > arr[i])
                {
                    met = false;
                }
            }
            if (met)
            {
                nums.add(arr[i]);
            }
            return leaders(arr,i+1,nums);
        
    }
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> nums = new ArrayList<>();
       
        return leaders(arr,0,nums);
        
    }
}
