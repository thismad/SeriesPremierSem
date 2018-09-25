/*
 * Author: Mathis Dehez
 * Date: Sep 25, 2018
*/

public class Exercice8 {
	

		/* METHODES UTILTAIRES FOURNIES*/

		// affichage  d'un tableau d'entiers
		public static void print(int[] tab) {
			for (int i = 0; i < tab.length; ++i) {
				System.out.print(tab[i] + " ");
			}
			System.out.println();
		}

		// affichage  d'un tableau de doubles
		public static void print(double[] tab) {
			for (int i = 0; i < tab.length; ++i) {
				System.out.print(tab[i] + " ");
			}
			System.out.println();
		}
		
		public static void fillWithSquare(double[] numbers) {
			for(int i=0;i<numbers.length;i++) {
				numbers[i]=(i+1)/100;
			}
		}
		
		public static void exctractMaxDigit(double nbr) {
			nbr=Math.abs(nbr);
			do {
				
				
		}
			
			
		public static void main(String[] args) {
			int[] frequencies = new int[9];
			double[] numbers = new double[25];

			//  TEST 1.1
			System.out.println("Test 1.1 : ");
			fillWithSquare(numbers);
			print(numbers);
			System.out.println();
			// FIN TEST 1.1 

			//TEST 1.2
			System.out.println("Test 1.2 : ");
			System.out.println(extractMaxDigit(0));
			System.out.println(extractMaxDigit(632));
			System.out.println(extractMaxDigit(-221));
			System.out.println(extractMaxDigit(-554.15));
			System.out.println(extractMaxDigit(0.00421));
			System.out.println();
			// FIN TEST 1.2

			//  TEST 1.3
			System.out.println("Test 1.3 : ");
			analyze(numbers, frequencies);
			print(frequencies);
			System.out.println();
			// FIN TEST 1.3

			// TEST 1.4
			System.out.println("Test 1.4 : ");
			testBenford(frequencies, numbers.length);
			// FIN TEST 1.4
		}
	}
}