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
    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        for(int i=n-2;i>=0;i--){
            if(arr.get(i)>arr.get(i+1)){
                Collections.swap(arr, i, i + 1);
                for(int j=0;j<n;j++){
                    if(j==i){
                        System.out.print(arr.get(i+1)+" ");
                    }
                    else{
                        System.out.print(arr.get(j)+" ");
                    }
                }
                System.out.println();
            }
            else{
                break;

            }
        }
        System.out.println(arr.toString().replace("[", "").replace("]", "").replace(",", ""));
        return;
    }

}

public class InsertionSort_Part1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.insertionSort1(n, arr);

        bufferedReader.close();
    }
}
