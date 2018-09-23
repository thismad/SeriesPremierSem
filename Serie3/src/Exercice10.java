
import java.util.*;
import java.lang.Math;
public class Exercice10 {
public static void main(String[] arg) {
    double g=9.81;
    double H0=0;
    double eps=0;
    double nbr;
    double v1 =0;
    double v;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Saisissez la hauteur initiale ");
    H0=scanner.nextDouble();
    
    System.out.println("Saisissez eps ");
    eps=scanner.nextDouble();
    
    System.out.println("Saisissez nbr ");
    nbr=scanner.nextDouble();
    
    v=Math.sqrt(2*H0*g);
    for (int i=0;i<nbr;i++) {
        v1=eps*v;
        H0=(v1*v1)/(2*g);
    }
    System.out.println();
}
}