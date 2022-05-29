import java.util.Scanner;


 //вашиот код
class Patuvanje{
	private String ime;
	private int cena;
	public Patuvanje(String ime, int cena) {
		super();
		this.ime = ime;
		this.cena = cena;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
	}
	public int vratiVremeVoDenovi() {
		return 0;
	}
}

class GodishenOdmor extends Patuvanje{
	private int vreme;

	public GodishenOdmor(String ime, int cena, int vreme) {
		super(ime, cena);
		this.vreme = vreme;
	}

	public int getVreme() {
		return vreme;
	}
	
	
}

class PraznicnoPatuvanje extends Patuvanje{
	private int pocD;
	private int pocM;
	private int krajD;
	private int krajM;
	
	public PraznicnoPatuvanje(String ime, int cena, int pocD, int pocM, int krajD, int krajM) {
		super(ime, cena);
		this.pocD = pocD;
		this.pocM = pocM;
		this.krajD = krajD;
		this.krajM = krajM;
	}
	public int getPocD() {
		return pocD;
	}
	public int getPocM() {
		return pocM;
	}
	public int getKrajD() {
		return krajD;
	}
	public int getKrajM() {
		return krajM;
	}
	
}

public class Test {

	
	public static void main(String[] args) {
		
		
		int n;
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		
		Patuvanje nizaPatuvanje[]=new Patuvanje[n];
		
		for (int i=0;i<n;i++){
			int tip=in.nextInt();
			if (tip==0){
				String ime=in.next();
				int cena =in.nextInt();
				int vreme=in.nextInt();
				nizaPatuvanje[i]=new GodishenOdmor(ime,cena,vreme);
			}
			else {
				String ime=in.next();
				int cena =in.nextInt();
				int pocD=in.nextInt();
                int pocM=in.nextInt();
				int krajD=in.nextInt();
				int krajM=in.nextInt();
				nizaPatuvanje[i]=new PraznicnoPatuvanje(ime,cena,pocD,pocM, krajD,krajM);
				
			}
		}
		
		//решение на барање 1
		
        //решение на барање 2
		
        //решение на барање 3   
  		
		//решение на барање 4
		
		

	}

}
