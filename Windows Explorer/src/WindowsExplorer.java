import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Iterator;
import java.util.NoSuchElementException;

interface Tree<E> {
    ////////////Accessors ////////////

    public Node<E> root();

    public Node<E> parent(Node<E> node);

    public int childCount(Node<E> node);

    ////////////Transformers ////////////
    public void makeRoot(E elem);

    public Node<E> addChild(Node<E> node, E elem);

    public void remove(Node<E> node);

    ////////////Iterator ////////////
    public Iterator<E> children(Node<E> node);
    
}

interface Node<E> {

    	public E getElement();

    	public void setElement(E elem);
}


class SLLTree<E> implements Tree<E> {
    
    public SLLNode<E> root;

    public SLLTree() {
        root = null;
    }

    public Node<E> root() {
        return root;
    }

    public Node<E> parent(Node<E> node) {
        return ((SLLNode<E>) node).parent;
    }

    public int childCount(Node<E> node) {
        SLLNode<E> tmp = ((SLLNode<E>) node).firstChild;
        int num = 0;
        while (tmp != null) {
            tmp = tmp.sibling;
            num++;
        }
        return num;
    }

    public void makeRoot(E elem) {
        root = new SLLNode<E>(elem);
    }

    public Node<E> addChild(Node<E> node, E elem) {
        SLLNode<E> tmp = new SLLNode<E>(elem);
        SLLNode<E> curr = (SLLNode<E>) node;
        tmp.sibling = curr.firstChild;
        curr.firstChild = tmp;
        tmp.parent = curr;
        return tmp;
    }

    public void remove(Node<E> node) {
        SLLNode<E> curr = (SLLNode<E>) node;
        if (curr.parent != null) {
            if (curr.parent.firstChild == curr) {
                // The node is the first child of its parent
                // Reconnect the parent to the next sibling
                curr.parent.firstChild = curr.sibling;
            } else {
                // The node is not the first child of its parent
                // Start from the first and search the node in the sibling list and remove it
                SLLNode<E> tmp = curr.parent.firstChild;
                while (tmp.sibling != curr) {
                    tmp = tmp.sibling;
                }
                tmp.sibling = curr.sibling;
            }
        } else {
            root = null;
        }
    }

    class SLLTreeIterator<T> implements Iterator<T> {

        SLLNode<T> start, current;

        public SLLTreeIterator(SLLNode<T> node) {
            start = node;
            current = node;
        }

        public boolean hasNext() {
            return (current != null);
        }

        public T next() throws NoSuchElementException {
            if (current != null) {
                SLLNode<T> tmp = current;
                current = current.sibling;
                return tmp.getElement();
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            if (current != null) {
                current = current.sibling;
            }
        }
    }

    public Iterator<E> children(Node<E> node) {
        return new SLLTreeIterator<E>(((SLLNode<E>) node).firstChild);
    }
    
    void printTreeRecursive(Node<E> node, int level) {
        if (node == null)
            return;
        int i;
        SLLNode<E> tmp;

        for (i=0;i<level;i++)
            System.out.print(" ");
        System.out.println(node.getElement().toString());
        tmp = ((SLLNode<E>)node).firstChild;
        while (tmp != null) {
            printTreeRecursive(tmp, level+1);
            tmp = tmp.sibling;
        }
    }
    
    public void printTree() {
        printTreeRecursive(root, 0);
    }
    
}

class SLLNode<P> implements Node<P> {

    // Holds the links to the needed nodes
    public SLLNode<P> parent, sibling, firstChild;
    // Hold the data
    public P element;

    public SLLNode(P o) {
        element = o;
        parent = sibling = firstChild = null;
    }

    public P getElement() {
        return element;
    }

    public void setElement(P o) {
        element = o;
    }
}

public class WindowsExplorer {
	public static void printPath(SLLNode<String> tmp) {
		if(tmp.parent==null) {
			System.out.print(tmp.element+"\\");
			return;
		}
		printPath(tmp.parent);
		System.out.print(tmp.element+"\\");
	}
	public static void print(SLLNode<String>  tmp,int n) {
		while(tmp!=null) {
			for(int i=0;i<n;i++) {
				System.out.print(" ");
			}
			System.out.println(tmp.element);
			print(tmp.firstChild,n+1);
			tmp = tmp.sibling;
		}
	}
    
    public static void main(String[] args) throws Exception {
        int i,j,k;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String commands[] = new String[N];
        
        for (i=0;i<N;i++)
            commands[i] = br.readLine();
            
        br.close();
        
        SLLTree<String> tree = new SLLTree<String>();
        tree.makeRoot("c:");
        
        // vasiot kod stoi ovde
        SLLNode<String> tmp = tree.root;
        for(i=0;i<N;i++) {
        	String [] pom = commands[i].split(" ");
        	
        	if(pom[0].equals("CREATE")) {
        		SLLNode<String> temp = tmp.firstChild;
        		if(temp == null || (temp.element.compareTo(pom[1])) > 0) {
        			tree.addChild(tmp, pom[1]);
        		}else {
        			SLLNode<String> vm = new SLLNode<>(pom[1]);
        			while(temp.sibling!=null) {
        				if(pom[1].compareTo(temp.sibling.element) < 0) {
        					vm.sibling = temp.sibling;
        					temp.sibling = vm;
        					vm.parent = tmp;
        					break;
        				}
        				temp=temp.sibling;
        			}
        			vm.parent = tmp;
        			temp.sibling = vm;
        		}
        		
        	}
        	
        	if(pom[0].equals("OPEN")) {
        		SLLNode<String> tmp1 = tmp.firstChild;
        		while(tmp1!=null) {
        			if(tmp1.element.equals(pom[1])) {
        				tmp = tmp1;
        				break;
        			}
        			tmp1 = tmp1.sibling;
        		}
        	}
        	
        	if(pom[0].equals("DELETE")) {
        		SLLNode<String> tmp1 = tmp.firstChild;
        		while(tmp1!=null) {
        			if(tmp1.element.equals(pom[1])) {
        				tree.remove(tmp1);
        				break;
        			}
        			tmp1=tmp1.sibling;
        		}
        	}
        	
        	if(pom[0].equals("BACK")) {
        		tmp = tmp.parent;
        	}
        	
        	if(pom[0].equals("PATH")) {
        		printPath(tmp);
        		System.out.print("\n");
        	}
        	
        	if(pom[0].equals("PRINT")) {
        		print(tree.root,0);
        	}
        }
        
    }
    
}
