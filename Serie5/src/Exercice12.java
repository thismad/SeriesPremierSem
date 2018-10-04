/*
 * Author: Mathis Dehez
 * Date: Oct 1, 2018
 */
import java.util.Scanner;
public class Exercice12 {
	public static void main(String[] args) {

		int[] laCombinaison = {3,5,6,1};
		int[] combinaison = new int [4];
		int[] reponse = {0,0};
		//tirerCombinaison(laCombinaison);

		int compteur=0;
		do {
			System.out.println("Rentrez une combinaison");
			demanderCoup(combinaison);
			reponse[0]=0;
			reponse[0]=0;
			System.out.println(compare(laCombinaison,combinaison,reponse)+" "+reponse[0]);
			afficheCombinaison(combinaison);
			afficheReponse(reponse);
			System.out.print("\n");
			compteur+=1;
		}while(reponse[0]<4 && compteur <10);

	}

	static void tirerCombinaison(int[] uneCombinaison) {
		for (int i =0; i<uneCombinaison.length;i++) {
			uneCombinaison[i]=hasard(6);
		}
	}
	static int hasard(int max) {
		return (1+(int)(Math.random()*max));
	}

	static void demanderCoup(int[] uneCombinaison) {
		Scanner scanner = new Scanner(System.in);
		for (int i=0; i<4;i++) {
			uneCombinaison[i]=scanner.nextInt();
		}
	}

	static boolean compare (int[] combinaison1,  int[] combinaison2, int[] reponse) {
		boolean[] test=new boolean[4];
		int stop=0;
		
		for (int i =0; i<4; i++) {
			stop=0;
					for (int j = 0; j<4; j++) {
				if(combinaison1[j]==combinaison2[i] && i==j ) {
					reponse[0]+=1;
					

					if(test[j]==true)reponse[1]-=1;
					test[j]=true;
					break;
					
				}
				else if(combinaison1[j]==combinaison2[i] && test[j]==false && stop ==0) {
					reponse[1]+=1;
					test[j]=true;
					stop+=1;
				}
			}
		}
		if (reponse[0]==4)return true;
		else return false;
	}

	static void afficheCombinaison(int[] combinaison) {
		for (int i=0;i<4;i++) {
			System.out.print(combinaison[i]+" ");
		}
	}

	static void afficheReponse(int[] reponse) {
		for(int i=0; i<2;i++) {
			for (int j =0;j<reponse[i];j++) {
				if (i==0)System.out.print("#");
				else System.out.print("O");
			}
		}

	}
}