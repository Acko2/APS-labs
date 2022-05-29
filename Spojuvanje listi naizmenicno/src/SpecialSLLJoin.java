import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SLLNode<E>{
	protected E element;
	protected SLLNode<E> succ;
	
	public SLLNode(E element, SLLNode<E> succ){
		this.element = element;
		this.succ = succ;
	}
	@Override
	public String toString(){
		return element.toString();
	}
}

class SLL<E>{
	SLLNode<E> first;
	
	public SLL() {
		super();
		this.first = null;
	}
	
	public void insertFirst(E o) {
		SLLNode<E> ins = new SLLNode<E>(o,first);
		first = ins;
	}
	public void insertAfter(E o,SLLNode<E> node) {
		if(node != null) {
			SLLNode<E> ins = new SLLNode<E>(o,node.succ);
			node.succ = ins;
		}
	}
	public void insertBefore(E o,SLLNode<E> before) {
		if(first != null) {
			SLLNode<E> tmp = first;
			if(first == before) {
				this.insertFirst(o);
				return;
			}
			while(tmp.succ != before) {
				tmp = tmp.succ;
			}
			if(tmp.succ == before) {
				SLLNode<E> ins = new SLLNode<E>(o,before);
				tmp.succ = ins;
			}else {
				System.out.println("Elementot ne postoi vo listata");
			}
			
		}else {
			System.out.println("Listata e prazna");
		}
	}
	
	public void insertLast(E o) {
		if (first != null) {
			SLLNode<E> tmp = first;
			while (tmp.succ != null)
				tmp = tmp.succ;
			SLLNode<E> ins = new SLLNode<E>(o, null);
			tmp.succ = ins;
		}else {
			insertFirst(o);
		}
	}
	
	public String toString() {
        String s = new String();
        if(first!=null) {
            SLLNode<E> tmp = first;
            s += tmp + "->";
            while(tmp.succ!=null) {
                tmp = tmp.succ;
                s += tmp + "->";
            }
        } else {
            s = "Prazna lista!!!";
        }
        return s;
    }
	public SLLNode<E> getFirst(){
		return first;
	}
}

public class SpecialSLLJoin {
	
	public static SLL<Integer> specialJoin(SLL<Integer> lista1,SLL<Integer> lista2){
		SLL<Integer> rezultat = new SLL<Integer>();
		SLLNode<Integer> tmp1 = lista1.getFirst(), tmp2 = lista2.getFirst();
		int flag1 = 0, flag2 = 2;
		while(tmp1 != null || tmp2 != null) {
			if(tmp1 == null) {
				rezultat.insertLast(tmp2.element);
				tmp2 = tmp2.succ;
				continue;
			}
			if(tmp2 == null) {
				rezultat.insertLast(tmp1.element);
				tmp1 = tmp1.succ;
				continue;
			}
			if(flag1 < 2) {
				rezultat.insertLast(tmp1.element);
				tmp1 = tmp1.succ;
				flag1++;
				if(flag1 == 2) flag2 = 0;
			}
			if(flag2 < 2) {
				rezultat.insertLast(tmp2.element);
				tmp2 = tmp2.succ;
				flag2++;
				if(flag2 == 2) flag1 = 0;
			}
		}
		
		return rezultat;
	}
	
	
	public static void main(String[] args) throws IOException{
	
		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		String s = stdin.readLine();
		int N = Integer.parseInt(s);
		s = stdin.readLine();
		String[] pomniza = s.split(" ");
		SLL<Integer> lista1 = new SLL<Integer>();
		SLL<Integer> lista2 = new SLL<Integer>();
		SLL<Integer> spoeni = new SLL<Integer>();
		for (int i = 0; i < N; i++) {
			lista1.insertLast(Integer.parseInt(pomniza[i]));
		}

		s = stdin.readLine();
		N = Integer.parseInt(s);
		s = stdin.readLine();
		pomniza = s.split(" ");
		for (int i = 0; i < N; i++) {
			lista2.insertLast(Integer.parseInt(pomniza[i]));
		}
		
		spoeni = specialJoin(lista1,lista2);
		System.out.println(spoeni);
		
	}
}
