import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZigZagSequence {
    
    static int najdiNajdolgaCikCak(int a[]) {
		// Vasiot kod tuka
    	int rez=1,pomrez=1;
    	int tmp=a[0];
    	for(int i = 1; i < a.length; i++) {
    		if(tmp!=0) {
    			if(tmp<0) {
    				if(a[i]>0) {
    					pomrez++;
    				}else {
    					if(rez<pomrez) {
    						rez=pomrez;
    						pomrez=1;
    					}else {
    						pomrez=1;
    					}
    				}
    			}else {
    				if(a[i]<0) {
    					pomrez++;
    				}else {
    					if(rez<pomrez) {
    						rez=pomrez;
    						pomrez=1;
    					}else {
    						pomrez=1;
    					}
    				}
    			}
    		}
    		tmp=a[i];
    	}
    	if(rez<pomrez) {
    		rez=pomrez;
    	}
    	
    	return rez;
	}
    
    public static void main(String[] args) throws Exception {
        int i,j,k;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int a[] = new int[N];
        for (i=0;i<N;i++)
            a[i] = Integer.parseInt(br.readLine());
        
        int rez = najdiNajdolgaCikCak(a);
        System.out.println(rez);
        
        br.close();
       	
    }
    
}
