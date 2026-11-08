import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Node1 {
    int val;
    int ht;
    Node1 left;
    Node1 right;

    static Node1 newNode(int data) {
        Node1 temp = new Node1();
        temp.val = data;
        temp.left = null;
        temp.right = null;
        return temp;
    }


    static int ht_hidden(Node1 T)
    {
        int lh, rh;
        if (T == null)
        {
            return(0);
        }
        if (T.left == null)
        {
            lh = 0;
        }
        else
        {
            lh = 1 + T.left.ht;
        }
        if (T.right == null)
        {
            rh = 0;
        }
        else
        {
            rh = 1 + T.right.ht;
        }
        if (lh > rh)
        {
            return(lh);
        }
        return(rh);
    }
    static Node1 rotate_right_hidden(Node1 x)
    {
        Node1 y;
        y = x.left;
        x.left = y.right;
        y.right = x;
        x.ht = ht_hidden(x);
        y.ht = ht_hidden(y);
        return(y);
    }
    static Node1  rotate_left_hidden(Node1 x)
    {
        Node1 y;
        y = x.right;
        x.right = y.left;
        y.left = x;
        x.ht = ht_hidden(x);
        y.ht = ht_hidden(y);
        return(y);
    }
    static Node1 RR_hidden(Node1 T)
    {
        T = rotate_left_hidden(T);
        return(T);
    }
    static Node1 LL_hidden(Node1 T)
    {
        T = rotate_right_hidden(T);
        return(T);
    }
    static Node1 LR_hidden(Node1 T)
    {
        T.left = rotate_left_hidden(T.left);
        T = rotate_right_hidden(T);
        return(T);
    }
    static Node1 RL_hidden(Node1 T)
    {
        T.right = rotate_right_hidden(T.right);
        T = rotate_left_hidden(T);
        return(T);
    }
    static int BF_hidden(Node1 T)
    {
        int lh, rh;
        if (T == null)
        {
            return(0);
        }
        if (T.left == null)
        {
            lh = 0;
        }
        else
        {
            lh = 1 + T.left.ht;
        }
        if (T.right == null)
        {
            rh = 0;
        }
        else
        {
            rh = 1 + T.right.ht;
        }
        return(lh - rh);
    }
    static void inorder_hidden(Node1 T)
    {
        if (T != null)
        {
            inorder_hidden(T.left);
            // printf("%d(BF=%d) ", T->val, BF_hidden(T));
            System.out.print(T.val+"(BF="+BF_hidden(T)+") ");
            inorder_hidden(T.right);
        }
    }

    static void preorder_hidden(Node1 T)
    {
        if (T != null)
        {
            System.out.print(T.val+"(BF="+BF_hidden(T)+") ");
            preorder_hidden(T.left);
            preorder_hidden(T.right);
        }
    }



    static Node1 hiddenInsert(Node1 T,int x)
    {
        if (T == null)
        {
            T = newNode(x);
        }
        else if (x > T.val)
        {
            T.right = hiddenInsert(T.right, x);
            if (BF_hidden(T) == -2)
            {
                if (x > T.right.val)
                {
                    T = RR_hidden(T);
                }
                else
                {
                    T = RL_hidden(T);
                }
            }
        }
        else if (x < T.val)
        {
            T.left = hiddenInsert(T.left, x);
            if (BF_hidden(T) == 2){
                if (x < T.left.val)
                {
                    T = LL_hidden(T);
                }
                else
                {
                    T = LR_hidden(T);
                }
            }
        }
        T.ht = ht_hidden(T);
        return(T);
    }

	/* Class node is defined as :
    class Node 
    	int val;	//Value
    	int ht;		//Height
    	Node left;	//Left child
    	Node right;	//Right child

	*/

    static Node1 insert(Node1 root,int val){
        return hiddenInsert(root, val);
    }


}

public class avl {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n;
        Scanner in = new Scanner(System.in);
        n=in.nextInt();


        Node1 root=null;

        for(int i=0;i<n;i++)
        {
            int val;
            val=in.nextInt();
            root=root.hiddenInsert(root,val);
        }
        int nv;
        nv=in.nextInt();
        root=root.insert(root,nv);
        Node1.inorder_hidden(root);
        System.out.println("");
        Node1.preorder_hidden(root);
        System.out.println("");
    }
}