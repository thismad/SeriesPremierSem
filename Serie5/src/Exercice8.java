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
		
		public static double[] fillWithSquare(double[] numbers) {
			for(int i=0;i<numbers.length;i++) {
				numbers[i]=Math.pow((i+1.0),2)/100;
			}
			return numbers;
		}

		public static int extractMaxDigit(double nbr) {
			int decimal;
			nbr=Math.abs(nbr);
			if(nbr>10) {
				do {
					nbr=nbr/10;
				}while(nbr>10);
				decimal=(int)nbr;
				return decimal;
			}
			else if ((nbr<10) && (nbr >=1)){
				decimal=(int)nbr;
				return decimal;
			}	
			else if(nbr<1 && nbr>0) {
				do {
					nbr=nbr*10;
				}while (nbr<1);
				decimal=(int) nbr;
				return decimal;
			}
			else return 0;
		}

		public static void analyze(double[] numbers, int[] occurences) {
			for (int i =0; i<occurences.length;i++) {
				for(int j=0;j<numbers.length;j++) {
					if (i+1==extractMaxDigit(numbers[j])) {
						occurences[i]+=1;
					}
				}
			}
		}

		public static void testBenford(int occurences[],int b) {
			int total=0;
			int benford[]= {1,2,3,4,5,6,7,8,9};
			
			for (int i=0; i<occurences.length;i++) {
				total+=occurences[i];
			}
			for (int i=0; i<occurences.length;i++) {

				System.out.println(i+" : "+(double)(occurences[i])/total+", Benford : "+Math.log10(1+(double)1/benford[i]));
			}
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
