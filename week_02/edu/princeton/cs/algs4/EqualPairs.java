package edu.princeton.cs.algs4;
import java.util.Arrays;
public class EqualPairs {
    public static int count(int[] a) {
        Arrays.sort(a); // Sắp xếp mất O(N log N)
        int n = a.length;
        int count = 0;
        int runLength = 1;

        // Quét mảng để đếm các nhóm phần tử bằng nhau liên tiếp
        for (int i = 1; i < n; i++) {
            if (a[i] == a[i - 1]) {
                runLength++;
            } else {
                // Nếu một nhóm có K phần tử bằng nhau, số cặp tạo ra là K * (K - 1) / 2
                count += (runLength * (runLength - 1)) / 2;
                runLength = 1;
            }
        }
        // Cộng nốt nhóm cuối cùng
        count += (runLength * (runLength - 1)) / 2;
        return count;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        StdOut.println("Số cặp bằng nhau: " + count(a));
    }
}
