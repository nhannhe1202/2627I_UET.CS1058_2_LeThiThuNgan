import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TongM {
    public static int countWays(List<Integer> a, int index, int m) {
        if (m == 0) {
            return 1;
        }
        if (m < 0 || index == a.size()) {
            return 0;
        }
        int chon = countWays(a, index + 1, m - a.get(index));
        int khongChon = countWays(a, index + 1, m);
        return chon + khongChon;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập số lượng phần tử n và tổng mục tiêu m
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        System.out.println(countWays(a, 0, m));

        sc.close();
    }
}
