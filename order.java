import java.util.LinkedList;
import java.util.Queue;

public class order {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree{
        static int idx = -1;
        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }
    //PreOrder traversal
    public static void preorder(Node root){
        if(root == null){
            System.out.println(-1 + " ");
            return ; 
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    //inorder traversal

    public static void inorder(Node root){
        if(root == null){
            System.out.print(-1 + " ");
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    //Postorder traversal

    public static void postorder(Node root){
        if(root == null){
            System.out.print(-1+" ");
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+ " ");
    }
    //levelorder traversal

    public static void levelorder(Node root){
        if(root ==null){
            return;
        }
        Queue<Node>q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(curr.data + " ");
                if(curr.left !=null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
    }
    //count no of nodes
    public static int countnodes(Node root){
        if(root == null){
            return 0 ;
        }
        int leftnodes = countnodes(root.left);
        int rightnodes = countnodes(root.right);
        return leftnodes + rightnodes + 1;
    }

    //sum of nodes
    public static int sumnodes(Node root){
        if(root == null){
            return 0 ;
        }
        int leftnodes = sumnodes(root.left);
        int rightnodes = sumnodes(root.right);
        return leftnodes + rightnodes + root.data;
    }
    //height of tree

    public static int height(Node root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    //Diameter approach1
    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int diam1 = height(root.left)+ height(root.right)+1;
        int diam2 = height(root.left);
        int diam3 = height(root.right);
        return Math.max(diam1,Math.max(diam2,diam3));
    }

    //Diameter approach2
    static class Treeinfo{
        int ht;
        int diam;
    Treeinfo(int ht ,int diam){
        this.ht = ht;
        this.diam = diam;
    }
}
    public static Treeinfo Diameter(Node root){
       if(root == null){
        return new Treeinfo(0,0);
       } 
       Treeinfo left = Diameter(root.left);
       Treeinfo right = Diameter(root.right);


       int myHeight = Math.max(left.ht, right.ht) + 1;


       int diam1 = left.diam;
       int diam2 = right.diam;
       int diam3 = left.ht + right.ht + 1;


       int myDiam = Math.max( Math.max(diam1, diam2),diam3);
      Treeinfo myinfo = new Treeinfo(myHeight,myDiam);
       return myinfo;

    }

    //subtree of another tree
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        // System.out.println(root.data);
        preorder(root);
    }
}
