
public class Exercice3 {
public static void main(String[] args) {
}
}

class Vehicule{
	private String marque;
	private int dateAchat;
	private double prixAchat;
	private double prixCourant;
	
	public Vehicule(String marque, int dateAchat,double prixAchat) {
		this.marque=marque;
		this.dateAchat=dateAchat;
		this.prixAchat=prixAchat;
	}
	
	public void affiche() {
		System.out.println("La marque "+marque);
		System.out.println("La date d'achat "+dateAchat);
		System.out.println("Le prix d'achat "+prixAchat);
		System.out.println("Le prix courant "+ prixCourant);
	}
	
	public void calculePrix(int anneActuelle) {
		int AnneeDeDifference = anneActuelle-dateAchat;
		prixCourant = prixAchat * Math.pow(0.99, AnneeDeDifference);
	}
	
	public int getDateAchat() {
		return dateAchat;
	}
	public void setPrixCourant(double prixCourant) {
		this.prixCourant=prixCourant;
	}
	public double getPrixAchat() {
		return prixAchat;
	}
	public String getMarque(){
		return marque;
	}
}


class Voiture extends Vehicule{
	private int cylindree;
	private int nbrPortes;
	private int puissance;
	private double km;
	
	public Voiture(int cylindree, int nbrPortes,int puissance, double km, String marque, int dateAchat, double prixAchat) {
		super(marque,dateAchat,prixAchat);
		this.cylindree=cylindree;
		this.nbrPortes=nbrPortes;
		this.km=km;
	}
	public void affiche() {
		super.affiche();
		System.out.printf("Cylindree : %c \n nombre de portes : %d \n puissance : %e \n km : %x",cylindree,nbrPortes,puissance,km);
	}
	
	public void calculePrix(int anneActuelle) {
		double decote = (anneActuelle-this.getDateAchat())*0.02;
		// tester (int) 2.9 voir si ca met 3 ou 2
		decote+=0.05*(int)(km/10000);
		if(getMarque().equals("Renault") || getMarque().equals("Fiat")) {
			decote += 0.1;
		}
		else if (getMarque().equals("Ferrari") || getMarque().equals("Porsche")){
			decote-=0.2;
		}
	}
	
}

class Avion extends Vehicule{
	private String typeMoteur;
	private double heureDeVol;
	
	public Avion(String t,double h, double k, String m, int d, double p) {
		super(m,d,p);
		typeMoteur=t;
		heureDeVol=h;
		
	}
	
	public void affiche() {
		super.affiche();
		System.out.println(typeMoteur);
		System.out.print(heureDeVol);
	}
}