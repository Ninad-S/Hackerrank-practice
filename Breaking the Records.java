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
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */
    public static List<Integer> breakingRecords(List<Integer> scores,int high, int low, int highCount, int lowCount,int i) {
    // Write your code here
        if (i== scores.size())
        {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(highCount);
            res.add(lowCount);
            return res;
        }
        if (scores.get(i) > high)
        {
            high = scores.get(i);
            highCount++;
        }
        if (scores.get(i) < low)
        {
            low = scores.get(i);
            lowCount++;
        }
        return breakingRecords(scores,high,low,highCount,lowCount,i+1);
    }
    public static List<Integer> breakingRecords(List<Integer> scores) {
    // Write your code here
       return breakingRecords(scores, scores.get(0), scores.get(0), 0, 0, 0);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
