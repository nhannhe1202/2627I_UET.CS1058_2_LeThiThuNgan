package edu.princeton.cs.algs4;

import java.util.Arrays;

public class FourSum {

    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        Arrays.sort(a);

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && a[i] == a[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && a[j] == a[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) a[i] + a[j] + a[left] + a[right];

                    if (sum == 0L) {
                        count++;
                        while (left < right && a[left] == a[left + 1]) left++;
                        while (left < right && a[right] == a[right - 1]) right--;
                        left++;
                        right--;
                    }
                    else if (sum < 0L) {
                        left++; // Tổng nhỏ quá thì tăng vế trái lên
                    }
                    else {
                        right--; // Tổng lớn quá thì giảm vế phải xuống
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();

        Stopwatch timer = new Stopwatch();
        int count = count(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println("Số bộ bốn có tổng bằng 0: " + count);
    }
}
