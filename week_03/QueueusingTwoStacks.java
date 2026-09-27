import java.io.*;
public class QueueusingTwoStacks {
    public static class Queue {
        private Node first = null;;
        private Node last = null;

        private static class Node {
            int item;
            Node next;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public void push(int item) {
            Node oldfirst = last;
            last = new Node();
            last.item = item;
            last.next = null;
            if (isEmpty()) {
                first = last;
            } else {
                oldfirst.next = last;
            }
        }

        public int pop() {
            if(isEmpty()){
                return -1;
            }
            int item = first.item;
            first = first.next;
            if(isEmpty()){
                last = null;
            }
            return item;
        }

        public int peek() {
            if(isEmpty()){
                return -1;
            }
            return first.item;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String tTemp = br.readLine();
        if (tTemp != null && !tTemp.trim().isEmpty()) {
            int q = Integer.parseInt(tTemp.trim());
            Queue queue = new Queue();
            for (int tItr = 0; tItr < q; tItr++) {
                String s = br.readLine();
                if(s.charAt(0)=='1'){
                    String[] parts = s.split(" ");
                    int value = Integer.parseInt(parts[1]);
                    queue.push(value);
                } else if(s.charAt(0)=='2'){
                    queue.pop();
                } else if(s.charAt(0)=='3'){
                    bw.write(queue.peek() + "\n");
                }
            }
        }
        bw.flush();
    }
}
