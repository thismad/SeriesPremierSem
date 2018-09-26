import java.util.ArrayList;
/*
 * Author: Mathis Dehez
 * Date: Sep 26, 2018
*/

public class Exercice9 {
	public static void main(String[] args) {
		int[] nombres= {1210,45,27,220,54,284,9890,120,1184};
		System.out.println("Les paires de nombres amicaux sont : ");
		 afficherAmicaux(nombres);
	}
	
	public static void afficherAmicaux(int[] nombres){
		int[][] diviseurs = new int[nombres.length][10000];
		int n =0;
		// j'itère sur le tableau de base pour sortir un nombre
		for(int i=0; i<nombres.length;i++) {
			n=0;
		// Je cherche les diviseurs en parcourant tous les nombres inférieurs
			for(int j=1; j<=nombres[i]; j++) {
				if (divise((nombres[i]), j)) {			
					diviseurs[i][n]=j;
							n+=1;
				}
			}
		}
		for (int i=0; i<diviseurs.length;i++) {
			for (int j=0; (j<diviseurs.length) && i!=j;j++) {
				if(somme(diviseurs[i])==somme(diviseurs[j])) {
					System.out.println("sont amicaux : "+nombres[i]+" et "+nombres[j]);
				}
			}
		}
	}
	
	public static boolean divise(int nombre1, int nombre) {
		 if (nombre1%nombre==0) return true; 
		 else return false;
	}
	public static int somme(int[] diviseurs) {
		int total=0; 
		for (int i=0; i< diviseurs.length;i++) total+=diviseurs[i];
		return total;
	}
}
