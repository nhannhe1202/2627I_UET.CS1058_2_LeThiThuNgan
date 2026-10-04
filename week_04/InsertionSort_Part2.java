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

class Result2 {

    public static void insertionSort2(int n, List<Integer> arr) {
        // Write your code here
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(arr.get(j+1)<arr.get(j)){
                    Collections.swap(arr, j+1, j);
                }
                else break;
            }
            for(int x : arr) System.out.print(x + " "); System.out.println();

        }

    }

}

public class InsertionSort_Part2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result2.insertionSort2(n, arr);

        bufferedReader.close();
    }
}
