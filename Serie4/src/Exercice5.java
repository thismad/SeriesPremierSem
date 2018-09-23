import java.util.Scanner;
public class Exercice5 {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int nMax=10;
    double resultat=0;
    double v1[]=new double[nMax];
    double v2[]=new double[nMax];
    int n;
    System.out.println("Entrez la taille effective des vecteurs");
    
   
    do {
        n=scanner.nextInt();
        if (!(n<=nMax && n>=1))System.out.println("Entre une valeur en 1 et "+nMax);
    } while (!(n<=nMax && n>=1));
    System.out.println("Rentrez les composantes des vecteurs :");
    for (int i=0;i<n;i++) {
        
            System.out.println("Pour v1 rentrez la composante en x"+i);
            v1[i]=scanner.nextDouble();
            System.out.println("Pour v2 rentrez la composante en x"+i);
            v2[i]=scanner.nextDouble();
        
    }
    for (int i =0;i<n;i++) resultat=resultat+v1[i]*v2[i];
    System.out.println("Le résultat :"+resultat);
}}