import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

interface Stack<E>{
	public boolean isEmpty();
	public E peek();
	public void clear();
	public void push(E x);
	public E pop();
}

class ArrayStack<E> implements Stack<E>{
	private E[] elems;
	private int depth;
	
	public ArrayStack(int maxDepth) {
		elems = (E[]) new Object[maxDepth];
		depth = 0;
	}
	
	public boolean isEmpty() {
		return depth==0;
	}
	public E peek() {
		if(depth==0) {
			throw new NoSuchElementException();
		}
		return elems[depth-1];
	}
	public void clear() {
		for(int i = 0; i < depth; i++) elems[i]=null;
		depth = 0;
	}
	public void push(E x) {
		elems[depth++] = x;
	}
	public E pop(){
		if(depth == 0) {
			throw new NoSuchElementException();
		}
		E tmp = elems[--depth];
		elems[depth] = null;
		return tmp;
	}
}

public class PostFixEvaluation {
	
	public static int PFN(char[] exp) {
		ArrayStack<Integer> stack = new ArrayStack<>(100);
		int br1,br2,broj;
		String br = "";
		for(int i = 0; i < exp.length; i++) {
			br = "";
			while((i<exp.length)&& Character.isDigit(exp[i])) {
				br+=exp[i];
				i++;
			}
			if(!"".equals(br)) {
				broj = Integer.parseInt(br);
				stack.push(broj);
			}
			if(exp[i]=='+' || exp[i]=='-' || exp[i]=='*' || exp[i]=='/') {
				br2 = stack.pop();
				br1 = stack.pop();
				if(exp[i]=='+') {
					broj = br1+br2;
					stack.push(broj);
				}
				if(exp[i]=='-') {
					broj = br1-br2;
					stack.push(broj);
				}
				if(exp[i]=='*') {
					broj = br1*br2;
					stack.push(broj);
				}
				if(exp[i]=='/') {
					broj = br1/br2;
					stack.push(broj);
				}
			}
		}
		return stack.pop();
	}
	
	public static void main(String[] args) throws Exception{
          
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String expression = br.readLine();
        char exp[] = expression.toCharArray();
        
        System.out.print(PFN(exp));      
        br.close();

	}

}
