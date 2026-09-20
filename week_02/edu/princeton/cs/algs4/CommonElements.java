package edu.princeton.cs.algs4;

public class CommonElements {
    public static void printCommon(int[] a, int[] b) {
        int i = 0;
        int j = 0;

        // Quét mảng đồng thời trong thời gian tuyến tính O(N)
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                // Tìm thấy phần tử chung
                StdOut.print(a[i] + " ");
                i++;
                j++;
            }
        }
        StdOut.println();
    }
    public static void main(String[] args) {
        In in = new In(args[0]);
        String line1 = in.readLine();
        int[] a = convertStringToIntArray(line1);
        String line2 = in.readLine();
        int[] b = convertStringToIntArray(line2);
        printCommon(a, b);
    }

    private static int[] convertStringToIntArray(String line) {
        if (line == null || line.trim().isEmpty()) {
            return new int[0];
        }
        String[] tokens = line.trim().split("\\s+");
        int[] result = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            result[i] = Integer.parseInt(tokens[i]);
        }
        return result;
    }
}
