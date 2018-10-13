

class Exercice3 {

	public static void main(String[] args) {
		// Construction d'un terrain:
		Terrain t = new Terrain();
		t.ajouterForme(new Rectangle(100,100));
		t.ajouterForme(new Cercle(50));
		t.afficherSurfaceTotale();
	}

}

    class Terrain {

	private Forme[] forme;
	public Terrain() {
		forme = new Forme[10];
	}

	private double calculerSurfaceTotale() {
		double surface=0;
		for (int i=0; i<forme.length && forme[i]!=null;i++) {
			surface+=forme[i].calculerSurface();
		}
		return surface;
	}

	public void afficherSurfaceTotale() {
		double surfaceTotale = calculerSurfaceTotale();
		System.out.println("La surface totale est " + surfaceTotale);
	}
	public void ajouterForme(Forme a) {
		int i =0;
		while (i<forme.length && forme[i]!=null){
			i++;
		}
		forme[i]=a;
	}
}

class Rectangle extends Forme{

	private double largeur;
	private double hauteur;

	public Rectangle(double largeur, double hauteur) {
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}

	public double getLargeur() {
		return largeur;
	}

	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}

	public double getHauteur() {
		return hauteur;
	}

	public double calculerSurface() {
		return (largeur * hauteur);
	}
}

class Cercle extends Forme{
	private double rayon;
	public Cercle(double rayon) {
		this.rayon=rayon;
		
	}
	
	public double calculerSurface() {
		return Math.PI*Math.pow(this.rayon, 2);
	}
}

 abstract class Forme{
	abstract public double calculerSurface();
	
}





























