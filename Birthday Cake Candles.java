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
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */
    public static int max(List<Integer> candles){
        int max = candles.get(0);
        for (int i =1; i < candles.size();i++)
        {
            if (candles.get(i) >= max)
            {
                max = candles.get(i);
            }
        }
        return max;
    }
    public static int birthdayCakeCandles(List<Integer> candles, int i, int count, int max) {
    // Write your code here
        if (i == candles.size())
        {
            return count;
        }
        if (candles.get(i) == max)
        {
            count+=1;
        }
        return birthdayCakeCandles(candles, i+1, count, max);

    }
    public static int birthdayCakeCandles(List<Integer> candles) {
    // Write your code here
        return birthdayCakeCandles(candles,0,0, max(candles));

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.birthdayCakeCandles(candles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
