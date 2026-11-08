import java.io.*;
import java.util.*;


public class LowestCommonAncestor {
    public static int lca(Node root, int v1, int v2){
        while(root!=null){
            if(v1<root.data && v2<root.data){
                root=root.left;
            }
            else if(v1>root.data && v2> root.data){
                root=root.right;
            }
            else break;
        }
        return root.data;
    }
    public static Node insert(Node root, int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left, data);
                root.left=cur;
            }
            else{
                cur=insert(root.right, data);
                root.right=cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Node root = null;
        while (n-- > 0 && scan.hasNextInt()) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1= scan.nextInt();
        int v2= scan.nextInt();

        scan.close();
        System.out.println(lca(root,v1,v2));

    }
}