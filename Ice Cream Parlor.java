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
     * Complete the 'icecreamParlor' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER m
     *  2. INTEGER_ARRAY arr
     */
    public static List<Integer> icecreamParlor(int m, List<Integer> arr, int i, List<Integer> result) {
    // Write your code here
        if (i == arr.size()+1)
        {
            return result;
        }
        for (int j = 2; j < arr.size()+1; j++)
        {
            if (arr.get(i-1)+ arr.get(j-1) == m && i != j)
            {
                result.add(i); result.add(j);
                return result;
            }
        }
        return icecreamParlor(m, arr, i+1, result);
    }
    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
    // Write your code here
        List<Integer> result = new ArrayList<>();
        return icecreamParlor(m,arr,1,result);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int m = Integer.parseInt(bufferedReader.readLine().trim());

                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> result = Result.icecreamParlor(m, arr);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
