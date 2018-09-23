import java.util.Scanner;
public class Exercice3 {
public static void main(String[] args) {
    int nbr;
    char a;
    char b;
    
    
    Scanner sc = new Scanner(System.in);
    System.out.println("Voulez vous rentrer un char (1) ou un int (2) ");
    nbr=sc.nextInt();
    
    if(nbr==1) {
        System.out.println("Balance un char ");
        a=sc.next().charAt(0);
        nbr=(int) a;
        System.out.println(nbr);
        
    }
    
    else {
        System.out.println("balance un int");
        nbr=sc.nextInt();
        a = (char) nbr;
        System.out.println(a);
    }
    
    
}
}
