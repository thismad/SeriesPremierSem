


class Courrier{
	private double poids;
	private boolean modeExpedition;
	private String adresse;

	public Courrier(double p, boolean m,String a) {
		poids=p;
		modeExpedition=m;
		adresse=a;
	}
	
	public double getPoids() {
		return poids;
	}

	public double getPoidsKg() {
		return poids/1000.0;
	}
	public boolean getModeExpedition() {
		return modeExpedition;
	}
	public String getAdress() {
		return adresse;
	}
	public double express(double prix) {
		if (getModeExpedition()) {
			return prix*2;
		}
		else return prix;
	}
	public boolean valide() {
		if(!adresse.equals("")) {
			return true;
		}
		else return false;
	}
	public double affranchir() {
		 return 0;
	}

	public void afficher() {
		
	}
}

class Lettre extends Courrier{
	private String format;

	public Lettre(double p,boolean m, String a, String f) {
		super(p,m,a);
		format=f;
	}

	public double affranchir() {
		double montant=0;
		if (super.valide()) {
			if(format.equals("A4"))montant=2.50;

			else montant=3.50;
			montant= montant + 1.0*getPoidsKg();
			if(this.getModeExpedition()==true)montant*=2;
			return montant;
		}
		
		else return 0;
	}
	public void afficher() {
		System.out.println("Format : "+format);
	}
}



class Colis extends Courrier{
	private double volume;
	public Colis(double p,boolean m, String a, double v) {
		super(p,m,a);
		volume=v;
	}
	public double affranchir() {
		double montant=0;
		if(valide()) {
			montant= 0.25*volume+super.getPoidsKg()*1.0;
			if(this.getModeExpedition()==true)montant*=2;
			return montant;
		}
		
		else return 0;
	}
	public void afficher() {
		System.out.println("Volume : "+volume);
	}
	public boolean valide() {
		boolean valide=true;
		valide=super.valide();
		if(volume>50.0) valide =false;
		return valide;
	}
}

class Publicite extends Courrier{
	public Publicite(double p,boolean m, String a) {
		super(p,m,a);
	}
	public double affranchir() {
		double montant=0;
		if(super.valide()) {
			montant = 5*super.getPoidsKg();
			if(getModeExpedition()==true) {
				montant*=2;
			}
			return montant;
			
		}
		else return 0;
	}

}
class Jacques{}


class Boite{
	private Courrier[] courrier;
	private double montant=0;
	public Boite(int length) {
		courrier = new Courrier[length];
	}
	public void ajouterCourrier(Courrier c) {
		int compteur =0;
		while(courrier[compteur]!=null) {
			compteur+=1;
		}
		courrier[compteur]=c;
	}

	public double affranchir() {

		for (int i=0;i<courrier.length && courrier[i]!=null;i++){
			montant+=courrier[i].affranchir();
		}
		return montant;
	}
	public int courriersInvalides() {
		int compteur=0;
		for (int i=0;i<courrier.length && courrier[i]!=null;i++) {	
			if(courrier[i].valide())compteur++;
		}
		return compteur;
	}

	public void afficher() {
		int compteurC=0;
		for (int i=0;i<courrier.length && courrier[i]!=null;i++) {
			System.out.println(courrier[i].getClass().getName());
			System.out.println("");
			if(!(courrier[i].valide())) {
				System.out.println("(Courrier invalide)");
				compteurC++;
			}
			System.out.println("Poids : "+courrier[i].getPoids());
			
			if (courrier[i].getModeExpedition())System.out.println("Express : oui");
			else System.out.println("Express : non");
			
			System.out.println("Destination : "+ courrier[i].getAdress());
			System.out.println("Prix : "+ courrier[i].affranchir());
			courrier[i].afficher();
			System.out.println("");
		}
		
	}
}



//PROGRAMME PRINCIPAL (A NE PAS MODIFIER)
class Exercice5 {

	public static void  main(String args[]) {
		//Cr'eation d'une boite-aux-lettres
		// 30  est la capacit'e maximale de la
		// boite aux lettres
		// (pas necessaire si vous dêcidez d'utiliser
		// un ArrayList).
		Boite boite = new Boite(30);
		Jacques jc = new Jacques();

		//Creation de divers courriers/colis..
		Lettre lettre1 = new Lettre(200, true, "Chemin des Acacias 28, 1009 Pully", "A3");
		Lettre lettre2 = new Lettre(800, false, "", "A4"); // invalide

		Publicite pub1 = new Publicite(1500, true, "Les Moilles  13A, 1913 Saillon");
		Publicite pub2 = new Publicite(3000, false, ""); // invalide

		Colis colis1 = new Colis(5000, true, "Grand rue 18, 1950 Sion", 30);
		Colis colis2 = new Colis(3000, true, "Chemin des fleurs 48, 2800 Delemont", 70); //Colis invalide !

		boite.ajouterCourrier(lettre1);
		boite.ajouterCourrier(lettre2);
		boite.ajouterCourrier(pub1);
		boite.ajouterCourrier(pub2);
		boite.ajouterCourrier(colis1);
		boite.ajouterCourrier(colis2);


		System.out.println("Le montant total d'affranchissement est de " +
						   boite.affranchir());
		boite.afficher();
		
		System.out.println("La boite contient " + boite.courriersInvalides()
						   + " courriers invalides");
	}
}






