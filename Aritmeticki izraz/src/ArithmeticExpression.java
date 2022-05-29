import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArithmeticExpression {
    
    // funkcija za presmetuvanje na izrazot pocnuvajki
    // od indeks l, zavrsuvajki vo indeks r
    static int presmetaj(char c[], int l, int r) {
        // Vasiot kod tuka
    	int rez=0;
    	if(l==r) {
    		return Character.getNumericValue(c[l]);
    	}else {
    		int br=0;
    		for(int i=l;i<=r;i++) {
    			if(c[i]=='(') br++;
    			if(c[i]==')') br--;
    			if(c[i]=='+' && br==1){
    				rez = presmetaj(c,l+1,i-1) + presmetaj(c,i+1,r-1);
    				break;
    			}
    			if(c[i]=='-' && br==1) {
    				rez = presmetaj(c,l+1,i-1) - presmetaj(c,i+1,r-1);
    				break;
    			}
    		}
    		return rez;
    	}
    }
    
    public static void main(String[] args) throws Exception {
        int i,j,k;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String expression = br.readLine();
        char exp[] = expression.toCharArray();
        
        int rez = presmetaj(exp, 0, exp.length-1);
        System.out.println(rez);
        
        br.close();
    }
    
}