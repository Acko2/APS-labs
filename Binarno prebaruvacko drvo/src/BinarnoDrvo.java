import java.util.Scanner;

class BNode<E extends Comparable<E>> {
	   
    public E info;
    public BNode<E> left;
    public BNode<E> right;
   
    public BNode(E info) {
        this.info = info;
        left = null;
        right = null;
    }
   
    public BNode(E info, BNode<E> left, BNode<E> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }
   
}

class BTree<E extends Comparable<E>> {
	   
    private BNode<E> root;
   
    public BTree() {
        root = null;
    }
   
    public void insert(E x) {
        root = insert(x, root);
    }
   
    private BNode<E> insert(E x, BNode<E> t) {
        if (t == null) {
            t = new BNode<E>(x, null, null);
        } else if (x.compareTo(t.info) < 0) {
            t.left = insert(x, t.left);
        } else if (x.compareTo(t.info) > 0) {
            t.right = insert(x, t.right);
        } else;
        return t;
    }
   
    
    public BNode<E> find(E x) {
        return find(x, root);
    }
    
    private BNode<E> find(E x, BNode<E> t) {
        if (t == null)
            return null;
       
        if (x.compareTo(t.info) < 0) {
            return find(x, t.left);
        } else if (x.compareTo(t.info) > 0) {
            return find(x, t.right);
        } else {
            return t;
        }
    }
   
   
    public int height(E number) {
        return height(find(number));
    }
   
    public int height(BNode<E> node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        return Math.max(height(node.left), height(node.right)) + 1;
    }
   
    public int nodesOnDepth(int number) {
        return nodesOnDepth(root,number,0);
    }
   
    private int nodesOnDepth(BNode<E> rt, int number,int depth) {
       
        if (rt != null && depth == number)
            return 1;
        if (rt == null)
            return 0;
        return nodesOnDepth(rt.left,number,depth+1) + nodesOnDepth(rt.right,number,depth+1);
    }
   
}
 
 
public class BinarnoDrvo {
 
    public static void main(String[] args) {
       
        Scanner scan = new Scanner(System.in);
       
        int n = scan.nextInt();
       
        BTree<Integer> tree = new BTree<>();
       
        for (int i=0; i<n; ++i)
            tree.insert(scan.nextInt());
       
        int tmp = scan.nextInt();
        int visina = tree.height(tmp);
        System.out.println(visina);
        System.out.println(tree.nodesOnDepth(visina));
    }
   
   
}
 
