import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Stack;

public class CheckXML {	
   
	public static void main(String[] args) throws Exception{
          
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        String s = br.readLine();
		int n = Integer.parseInt(s);
		String [] redovi = new String[n];
	
		for(int i=0;i<n;i++)
			redovi[i] = br.readLine();
       
		int valid;
    	
        // Vasiot kod tuka
        // Moze da koristite dopolnitelni funkcii ako vi se potrebni
        
		valid = Validacija(redovi);
		System.out.println(valid);
        
        br.close();
	}
	private static int Validacija(String [] redovi) {
		String red = new String();
		Stack<String> stack = new Stack<>();
		for(int i=0;i<redovi.length;i++) {
			red = redovi[i];
			if(red.charAt(0)=='[' && red.charAt(red.length()-1)==']') {
				if(red.charAt(1)!='/') {
					stack.push(red);
				}else {
					if(stack.pop().substring(1).compareTo(red.substring(2))!=0) {
						return 0;
					}
				}
			}
		}
		if(stack.isEmpty())
			return 1;
		else
			return 0;
	}
}