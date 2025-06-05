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
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams(String s) {
    // Write your code here
        boolean[] alphabets = new boolean[26];
        for (int i = 0; i < s.length(); i++)
        {
            if ((s.charAt(i) >= 65 && s.charAt(i) <= 90) || (s.charAt(i) >= 97 && s.charAt(i) <= 122))
            {
                if (s.charAt(i) >= 65 && s.charAt(i) <= 90)
                {
                    alphabets[s.charAt(i)-65] = true;
                }
                else if (s.charAt(i) >= 97 && s.charAt(i) <= 122)
                {
                    alphabets[s.charAt(i)-97] = true;
                }
                
            }
        }
        for (int i = 0; i < alphabets.length; i++)
        {
            if (alphabets[i] == false)
            {
                return "not pangram";
            }
        }
        return "pangram";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
