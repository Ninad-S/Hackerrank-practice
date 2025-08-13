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
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */
    public static int hourglassSum(List<List<Integer>> arr, ArrayList<Integer> sums, int i)
    {
        if (i > arr.size()-3)
        {
            int max = sums.get(0);
            for (int j = 1; j < sums.size(); j++)
            {
                if (sums.get(j) > max)
                {
                    max = sums.get(j);
                }
            }
            return max;
        }
        int sum = 0;
        sum += arr.get(i).get(i);
        sum += arr.get(i).get(i+1);
        sum += arr.get(i).get(i+2);
        sum += arr.get(i+1).get(i+1);
        sum += arr.get(i+2).get(i);
        sum += arr.get(i+2).get(i+1);
        sum += arr.get(i+2).get(i+2);
        sums.add(sum);       
        for (int j = 0; j <= arr.get(i).size()-3; j++)
        {
            int cSum = 0;
            cSum += arr.get(i).get(j);
            cSum += arr.get(i).get(j+1);
            cSum += arr.get(i).get(j+2);
            cSum += arr.get(i+1).get(j+1);
            cSum += arr.get(i+2).get(j);
            cSum += arr.get(i+2).get(j+1);
            cSum += arr.get(i+2).get(j+2);
            if (!sums.contains(cSum))
            {
                sums.add(cSum);
            }         
        }
        return hourglassSum(arr,sums,i+1);
    }
    public static int hourglassSum(List<List<Integer>> arr) {
    // Write your code here
        return hourglassSum(arr,new ArrayList<>(),0);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
