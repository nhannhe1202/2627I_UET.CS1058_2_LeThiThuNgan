import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class EqualStacks {
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
            if(isEmpty()){
                return 0;
            }
            int item = first.item;
            first = first.next;
            return item;
        }

        public int peek() {
            return first.item;
        }
    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        Stack stack3 = new Stack();

        int sum1 = 0, sum2 = 0, sum3 = 0;

        for (int i = h1.size() - 1; i >= 0; i--) {
            sum1 += h1.get(i);
            stack1.push(sum1);
        }

        for (int i = h2.size() - 1; i >= 0; i--) {
            sum2 += h2.get(i);
            stack2.push(sum2);
        }

        for (int i = h3.size() - 1; i >= 0; i--) {
            sum3 += h3.get(i);
            stack3.push(sum3);
        }
        while(true){
            if(stack1.isEmpty() || stack2.isEmpty()||stack3.isEmpty()){
                return 0;
            }
            if(stack1.peek()==stack2.peek() && stack2.peek()==stack3.peek()){
                return stack1.peek();
            }
            if(stack1.peek()>=stack2.peek() && stack1.peek()>=stack3.peek()){
                stack1.pop();
            } else if(stack2.peek()>=stack1.peek() && stack2.peek()>=stack3.peek()){
                stack2.pop();
            } else {
                stack3.pop();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = EqualStacks.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
