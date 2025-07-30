class Solution {
    int majorityElement(int arr[]) {
        // code here
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int a : arr) 
        {
            countMap.put(a, countMap.getOrDefault(a, 0) + 1);           
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) 
        {
            if (entry.getValue() > arr.length/2)
                return entry.getKey();
        }
        return -1;
    }
}
