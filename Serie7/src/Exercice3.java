/*
 * Author: Mathis Dehez
 * Date: Oct 3, 2018
*/


class Surfaces {

	public static void main(String[] args) {
		// Construction d'un terrain:
		Terrain t = new Terrain(1.0, 2.0, 3.0, 4.0,5,6,7,8);
		t.afficherSurfaceTotale();
	}

}

class Terrain {

	private Rectangle r1;
	private Rectangle r2;
	private Rectangle r3;
	private Cercle c1;
	private Cercle c2;

	public Terrain(double l1, double h1, double l2, double h2, 
			double l3, double h3, double c1, double c2) {
		// Construction des 2 rectangles d�finissant le terrain:
		r1 = new Rectangle(l1, h1);
		r2 = new Rectangle(l2, h2);
		r3 = new Rectangle(l3,h3);
		this.c1 = new Cercle(c1);
		this.c2 = new Cercle(c2);
	}

	private double calculerSurfaceTotale() {
		return r1.calculerSurface() + r2.calculerSurface()+r3.calculerSurface()
		+c1.calculerSurface()+c2.calculerSurface();
	}

	public void afficherSurfaceTotale() {
		double surfaceTotale = calculerSurfaceTotale();
		System.out.println("La surface totale est " + surfaceTotale);
	}
}

class Rectangle {

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

class Cercle{
	private double rayon;
	public Cercle(double rayon) {
		this.rayon=rayon;
		
	}
	
	public double calculerSurface() {
		return Math.PI*Math.pow(this.rayon, 2);
	}
}































