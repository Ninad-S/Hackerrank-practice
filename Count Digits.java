// User function Template for Java

class Solution {
    static int evenlyDivides(int n, String s, int count, int i) {
        // code here
        if (i == s.length())
        {
            return count;
        }
        
        if (s.charAt(i) != '0' && 
        n % Integer.parseInt(Character.toString(s.charAt(i))) == 0)
        {
            count++;
        }
        return evenlyDivides(n,s,count,i+1);
        
    }
    static int evenlyDivides(int n) {
        // code here
        return evenlyDivides(n,"" + n,0,0);
    }
}
