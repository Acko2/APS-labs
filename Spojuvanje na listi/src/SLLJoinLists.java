import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

class SLLNode<E>{
	protected E element;
	protected SLLNode<E> succ;
	
	public SLLNode(E element,SLLNode<E> succ) {
		this.element = element;
		this.succ = succ;
	}
	@Override
	public String toString(){
		return element.toString();
	}
	
}
class SLL<E extends Comparable<E>>{
	private SLLNode<E> first;
	
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
	
	public Iterator<E> iterator(){
		return new LRIterator<E>();
	}
	
	private class LRIterator<E> implements Iterator<E> {
        private SLLNode<E> place, prev, curr;
        private LRIterator() {
            place = (SLLNode<E>) first;
            curr = prev = null;
        }
        public boolean hasNext() {
            return (place != null);
        }
        public E next() {
            if (place == null)
                throw new NoSuchElementException();
            E nextElem = place.element;
            prev = curr;
            curr = place;
            place = place.succ;
            return nextElem;
        }
        public void remove() {
            //Not implemented
        }
    }
	public SLL<E> joinLists(SLL<E> list2){
		SLL<E> rezultat = new SLL<E>();
		SLLNode<E> tmp1 = this.getFirst(), tmp2 = list2.getFirst();
		
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
			if(tmp1.element.compareTo(tmp2.element)<0) {
				rezultat.insertLast(tmp1.element);
				tmp1 = tmp1.succ;
			}else if(tmp1.element.compareTo(tmp2.element)>0){
				rezultat.insertLast(tmp2.element);
				tmp2 = tmp2.succ;
			}else {
				rezultat.insertLast(tmp1.element);
				tmp1 = tmp1.succ;
				tmp2 = tmp2.succ;
			}
		}
		return rezultat;
	}
}
public class SLLJoinLists {
	public static void main(String[] args) throws IOException {

		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
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

		spoeni = lista1.joinLists(lista2);
		Iterator<Integer> it = spoeni.iterator();
		while (it.hasNext()) {
			System.out.print(it.next());
            if(it.hasNext())
                System.out.print(" ");
		}
        System.out.println();
	}
}
