import java.util.Scanner;
public class ZadacaMaraton {
	
	static class Atleticar{
		String ime;
		String pol;
		int vozrast;
		double vreme;
		String zemja;
		public Atleticar(){}
		public Atleticar(String ime, String pol, int vozrast, double vreme, String zemja) {
			super();
			this.ime = ime;
			this.pol = pol;
			this.vozrast = vozrast;
			this.vreme = vreme;
			this.zemja = zemja;
		}

		public String getIme() {
			return ime;
		}

		public void setIme(String ime) {
			this.ime = ime;
		}

		public String getPol() {
			return pol;
		}

		public void setPol(String pol) {
			this.pol = pol;
		}

		public int getVozrast() {
			return vozrast;
		}

		public void setVozrast(int vozrast) {
			this.vozrast = vozrast;
		}

		public double getVreme() {
			return vreme;
		}

		public void setVreme(double vreme) {
			this.vreme = vreme;
		}

		public String getZemja() {
			return zemja;
		}

		public void setZemja(String zemja) {
			this.zemja = zemja;
		}
		
		public String toString() {
			return ime + "\n" + vozrast + "\n" + zemja + "\n" + vreme;
		}
		
	}
	
	interface IMaraton{
		public int atleticariOd(String s);
		public Atleticar najdobroVreme();
	}
	
	static class Maraton implements IMaraton{
		private String mesto;
		private int godina;
		private Atleticar [] atleticari;
		public Maraton(){}
		public Maraton(String mesto, int godina, Atleticar[] atleticari) {
			super();
			this.mesto = mesto;
			this.godina = godina;
			this.atleticari = atleticari;
		}
		public String getMesto() {
			return mesto;
		}
		public void setMesto(String mesto) {
			this.mesto = mesto;
		}
		public int getGodina() {
			return godina;
		}
		public void setGodina(int godina) {
			this.godina = godina;
		}
		public Atleticar[] getAtleticari() {
			return atleticari;
		}
		public void setAtleticari(Atleticar[] atleticari) {
			this.atleticari = atleticari;
		}
		public Atleticar najdobroVreme() {
			double min=atleticari[0].getVreme();
			int index = 0;
			for(int i = 1; i < atleticari.length; i++) {
				if(atleticari[i].getVreme() < min) {
					min = atleticari[i].getVreme();
					index = i;
				}
			}
			return atleticari[index];
		}
		public int atleticariOd(String s) {
			int br = 0;
			int n = atleticari.length;
			for(int i = 0; i < n; i++) {
				if(s.equals(atleticari[i].getZemja())) {
					br++;
				}
			}
			return br;
		}
		public String toString() {
			String s;
			s = mesto + "\n" + godina + "\n";
			for(int i = 0; i < atleticari.length; i++) {
				s += atleticari[i].toString() + "\n";
			}
			return s;
		}
	}
	
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        Atleticar[] atleticari = new Atleticar[n];
        
        String ime;
        String pol;
        int vozrast;
        double vreme;
        String zemja;
        
        input.nextLine();
            
        for(int i=0;i<n;i++)
        {
            ime = input.nextLine();
            pol = input.nextLine();
            vozrast = input.nextInt();
            vreme = input.nextDouble();
            input.nextLine();
            zemja = input.nextLine();
            atleticari[i]=new Atleticar(ime,pol,vozrast,vreme,zemja);
        }
        
        String mesto;
        int godina;
        String zemjaP;
        mesto = input.nextLine();
        godina = input.nextInt();
        input.nextLine();
        
        Maraton m1 = new Maraton(mesto, godina, atleticari);
        System.out.print(m1.toString());
        
        zemjaP = input.nextLine();
        System.out.println("Prvo mesto: " + m1.najdobroVreme().toString());
        System.out.println("Ima vkupno " + m1.atleticariOd(zemjaP) + " atleticar/i od " + zemjaP);
    }
}
