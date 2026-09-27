import java.io.*;
import java.util.StringTokenizer;

public class SimpleTextEditor {
    public static class Stack {
        private Node first = null;

        private static class Node {
            StringBuilder item;
            Node next;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public void push(StringBuilder item) {
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
        }

        public StringBuilder pop() {
            if(isEmpty()){
                return new StringBuilder();
            }
            StringBuilder item = first.item;
            first = first.next;
            return item;
        }

        public StringBuilder peek() {
            return first.item;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String tTemp = br.readLine();
        StringBuilder res = new StringBuilder();
        Stack stack = new Stack();
        stack.push(new StringBuilder(""));
        if (tTemp != null && !tTemp.trim().isEmpty()) {
            int q = Integer.parseInt(tTemp.trim());

            for (int tItr = 0; tItr < q; tItr++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int type = Integer.parseInt(st.nextToken());
                if(type == 1){
                    String value = st.nextToken();
                    res.append(value);
                    stack.push(new StringBuilder(res));
                } else if(type == 2){
                    int k = Integer.parseInt(st.nextToken());
                    res.delete(res.length() - k, res.length());
                    stack.push(new StringBuilder(res));
                } else if(type == 3){
                    int k = Integer.parseInt(st.nextToken());
                    bw.write(res.charAt(k - 1) + "\n");
                } else if(type == 4){
                    stack.pop();
                    res = new StringBuilder(stack.peek());
                }
            }
        }
        bw.flush();
    }
}
