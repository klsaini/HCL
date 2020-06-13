/*
Design a  ordered binary tree and then write an algorithm to print the traversal of leaves from right to left. That is your method traverseLeaves() should return leaves in the order Right to left. For example :
Return of traverseLeaves() will contain   leaves in the leaf in the below order 

 

          13 ->  7  ->4   ->1 
*/

import java.util.Stack;

class Node1{
    int data;
    Node1 left;
    Node1 right;
    public Node1(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BST {
    Node1 root=null;
    public void insert(int data) {
        Node1 newNode = new Node1(data);
        if(root == null){
            root = newNode;
            return;
        }
        else {
            Node1 current = root, parent = null;

            while(true) {
                parent = current;
                if(data < current.data) {
                    current = current.left;
                    if(current == null) {
                        parent.left = newNode;
                        return;
                    }
                }
                else {
                    current = current.right;
                    if(current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }
    static void PrintLeafLeftToRight(Node1 root)
    {
        Stack<Node1> s1 = new Stack<>();

        Stack<Node1> s2 = new Stack<>();;
        s1.push(root);

        while (!s1.empty())
        {
            Node1 curr = s1.peek();
            s1.pop();
            if (curr.right!=null)
                s1.push(curr.right);
            if (curr.left!=null)
                s1.push(curr.left);
            else if (curr.left==null && curr.right==null)
                s2.push(curr);
        }
        while (!s2.empty())
        {
            System.out.print(s2.peek().data +" ");
            s2.pop();
        }
    }
    public static void main(String[] args) {
        BST bt = new BST();
        bt.insert(8);
        bt.insert(3);
        bt.insert(10);
        bt.insert(1);
        bt.insert(6);
        bt.insert(14);
        bt.insert(4);
        bt.insert(7);
        bt.insert(13);
        PrintLeafLeftToRight(bt.root);
    }

}
