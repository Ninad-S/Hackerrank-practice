class Solution {
    public static boolean isPowerofTwo(int n, int p) {
        // code here
        if (n==1 || n==2)
        {
            return true;
        }
        if (p==n)
        {
            return true;
        }
        if (p > n)
        {
            return false;
        }
        return isPowerofTwo(n,p*2);
    }
    public static boolean isPowerofTwo(int n) {
        // code here
        return isPowerofTwo(n,2);
    }
}
