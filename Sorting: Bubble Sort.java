import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'countSwaps' function below.
     *
     * The function accepts INTEGER_ARRAY a as parameter.
     */
    public static void countSwaps(List<Integer> a, int i, int swaps) {
    // Write your code here
        if (i==a.size())
        {
            System.out.println("Array is sorted in " + swaps + " swaps.");
            System.out.println("First Element: " + a.get(0));
            System.out.println("Last Element: " + a.get(a.size()-1));
            return;
        }
        for (int j = 0; j < a.size() - 1; j++) {
        
            if (a.get(j) > a.get(j+1)) {
                int temp = a.get(j);
                a.set(j,a.get(j+1));
                a.set(j+1,temp);
                swaps++;
            }
        }
        countSwaps(a,i+1,swaps);
    }
    public static void countSwaps(List<Integer> a) {
    // Write your code here
        countSwaps(a,0,0);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.countSwaps(a);

        bufferedReader.close();
    }
}
