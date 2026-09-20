package edu.princeton.cs.algs4;

import java.util.Arrays;

public class BinarySearch {

    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        int result = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(a[mid]==key){
                result = mid;
                hi = mid - 1; // continue searching in the left half
            }
            else if (key < a[mid]) hi = mid - 1;
            else lo = mid + 1;
        }
        return result;
    }

    @Deprecated
    public static int rank(int key, int[] a) {
        return indexOf(a, key);
    }

    public static void main(String[] args) {

        // read the integers from a file
        In in = new In(args[0]);
        int[] allowlist = in.readAllInts();

        // sort the array
        Arrays.sort(allowlist);

        // read integer key from standard input; print if not in allowlist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (BinarySearch.indexOf(allowlist, key) != -1)
                StdOut.println(BinarySearch.indexOf(allowlist, key));
            else
                StdOut.println(-1);
        }
    }
}