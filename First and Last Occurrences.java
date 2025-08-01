// User function Template for Java

class GFG {
    ArrayList<Integer> find(int arr[], int x, int i, ArrayList<Integer> list, boolean found) {
        // code here
        if (i == arr.length)
        {
           if (!found)
           {
               list.add(-1);
               list.add(-1);
               return list;
           }
           if (list.size() == 1)
           {
               list.add(list.get(0));
               return list;
           }
           while (list.size() > 2)
           {
               list.remove(1);
           }
           return list;
           
        }
        if (arr[i]==x)
        {
            found = true;
            list.add(i);
        }
        return find(arr,x,i+1,list,found);
        
    }
    ArrayList<Integer> find(int arr[], int x) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        return find(arr,x,0,list,false);
    }
}
