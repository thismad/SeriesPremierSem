/*
 * Author: Mathis Dehez
 * Date: Sep 25, 2018
 */
import java.util.Scanner;
public class Exercice3 {
	static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) {
    
	double largeur = lireDonnee("largeur");
	double hauteur = lireDonnee("hauteur");
	
	boolean donneesOk=testerDonnees(largeur,hauteur);
	
	
	if (donneesOk) calculer(largeur,hauteur);
	else afficherErreur();
	
	}
	
	static void afficherErreur() {
		System.out.println("largeur ou hauteur négative");
	}
	
	
	
	
	
	
	static void calculer (double l, double h) {
		double aire, perimetre;
		char sw;
		System.out.println("tapez s pour surface, p pour perimetre");
		sw=scanner.next().charAt(0);
		
		switch (sw) {
		 case 'p': ;
		 perimetre=l*2+2*h;
		 System.out.println(perimetre);
		 break;
		 
		 case 's': ;
		 aire=l*h;
		System.out.println(aire);
		 break;
		 
		 }
		 
		
	}
	
	
	static double lireDonnee(String s) {
		double nbr;
		System.out.println("Veuillez rentrer la "+s);
		nbr=scanner.nextDouble();
		return nbr;
	}
	
	
	static boolean testerDonnees(double l, double h) {
		if (l>=0 && h>=0) return true;
		else return false;
	}
}
