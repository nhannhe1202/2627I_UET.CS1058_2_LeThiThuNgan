package edu.princeton.cs.algs4;

public class DoublingTest {
    private static final int MAXIMUM_INTEGER = 1000000;


    // This class should not be instantiated.
    private DoublingTest() { }

    public static double timeTrial(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniformInt(-MAXIMUM_INTEGER, MAXIMUM_INTEGER);
        }
        Stopwatch timer = new Stopwatch();
        int ignore = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    /**
     * Prints table of running times to call {@code ThreeSum.count()}
     * for arrays of size 250, 500, 1000, 2000, and so forth.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        int STEPS = 5;
        int[] nValues = new int[STEPS];
        double[] tValues = new double[STEPS];

        // 1. Chạy đo đạc và lưu kết quả
        int currentN = 250;
        for (int i = 0; i < STEPS; i++) {
            nValues[i] = currentN;
            tValues[i] = timeTrial(currentN);
            StdOut.printf("%7d %7.1f\n", nValues[i], tValues[i]);
            currentN *= 2;
        }

        // 2. Tự động thiết lập scale (đồ thị chuẩn từ x: 0->45, log-log từ x: 55->100)
        StdDraw.setXscale(-5, 105);
        StdDraw.setYscale(-5, 105);
        StdDraw.setPenRadius(0.008);

        double maxN = nValues[STEPS - 1];
        double maxT = tValues[STEPS - 1] > 0 ? tValues[STEPS - 1] : 1.0;
        double minLogN = Math.log(250);
        double maxLogN = Math.log(maxN);

        // 3. Vẽ đồ thị co giãn hoàn hảo
        for (int i = 0; i < STEPS; i++) {
            // Đồ thị chuẩn (Màu đỏ)
            double stdX = (nValues[i] / maxN) * 45.0;
            double stdY = (tValues[i] / maxT) * 100.0;
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.point(stdX, stdY);

            // Đồ thị Log-Log (Màu xanh)
            double logX = 55.0 + ((Math.log(nValues[i]) - minLogN) / (maxLogN - minLogN)) * 45.0;
            double logY = (i / (double)(STEPS - 1)) * 100.0;
            StdDraw.setPenColor(StdDraw.BOOK_BLUE);
            StdDraw.point(logX, logY);
        }
        StdDraw.show();
    }
}
