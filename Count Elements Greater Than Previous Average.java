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
     * Complete the 'countResponseTimeRegressions' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY responseTimes as parameter.
     */
     public static int countResponseTimeRegressions(List<Integer> responseTimes, int i, int count) {
    // Write your code here
        if (responseTimes.size() == 0)
        {
            return 0;
        }
        if (i==responseTimes.size())
        {
            return count;
        }
        double avg = 0;
        for (int j = 0; j < i; j++)
        {
            avg += responseTimes.get(j);
        }
        avg /= i;
        if (responseTimes.get(i) > avg)
        {
            count++;
        }
        return countResponseTimeRegressions(responseTimes, i+1,count);
        
    }
    public static int countResponseTimeRegressions(List<Integer> responseTimes) {
    // Write your code here
        return countResponseTimeRegressions(responseTimes,1,0);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int responseTimesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> responseTimes = IntStream.range(0, responseTimesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.countResponseTimeRegressions(responseTimes);

        System.out.println(result);

        bufferedReader.close();
    }
}
