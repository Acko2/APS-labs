import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Math;

public class Array<E> {
	private E data[];
	private int size;
	public Array(int size) {
		data = (E[]) new Object[size];
		this.size = size;
	}
	public void set(int position, E o) {
			data[position] = o;
		
	}
	public E get(int position) {
		return data[position];
	}
	

	public static int brojDoProsek(Array<Integer> niza){
		int sum = 0,bdp;
		float prosek,min;
		for(int i = 0; i < niza.size; i++) {
			sum += niza.get(i);
		}
		prosek = (float)sum / niza.size;
		min = Math.abs(niza.get(0)-prosek);
		bdp = niza.get(0);
		for(int i = 1; i < niza.size; i++) {
			float tmp = Math.abs(niza.get(i)-prosek);
			if(tmp < min) {
				bdp = niza.get(i);
				min = tmp;
			}
			if(tmp == min) {
				if(niza.get(i) < bdp) {
					bdp = niza.get(i);
					min = tmp;
				}
			}
		}
		return bdp;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in)); 
		String s = stdin.readLine();
		int N = Integer.parseInt(s);
		
        //Vashiot kod tuka...
        Array<Integer> niza = new Array<Integer>(N);
        for(int i = 0; i < N; i++) {
        	s = stdin.readLine();
        	niza.set(i,Integer.parseInt(s));
        }
		System.out.println(brojDoProsek(niza));		
	}
	
	

}
