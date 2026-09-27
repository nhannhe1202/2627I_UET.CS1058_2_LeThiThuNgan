import java.io.*;

public class BalancedBrackets {
    public static class Stack {
        private Node first = null;

        private static class Node {
            int item;
            Node next;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public void push(int item) {
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
        }

        public int pop() {
            int item = first.item;
            first = first.next;
            return item;
        }

        public int peek() {
            return first.item;
        }
    }

    public static String isBalanced(String s) {
        Stack a = new Stack();
        int m = s.length();
        for (int i = 0; i < m; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                a.push(ch);
            }
            else if (!a.isEmpty() && ch == ')' && a.peek() == '(') {
                a.pop();
            }
            else if (!a.isEmpty() && ch == ']' && a.peek() == '[') {
                a.pop();
            }
            else if (!a.isEmpty() && ch == '}' && a.peek() == '{') {
                a.pop();
            }
            else {
                return "NO";
            }
        }
        if (!a.isEmpty()) return "NO";
        return "YES";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String tTemp = br.readLine();
        if (tTemp != null && !tTemp.trim().isEmpty()) {
            int t = Integer.parseInt(tTemp.trim());

            for (int tItr = 0; tItr < t; tItr++) {
                String s = br.readLine();
                String result = isBalanced(s);
                bw.write(result + "\n");
            }
        }
        bw.flush();
    }
}
