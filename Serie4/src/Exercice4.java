import java.util.Scanner;

public class Exercice4 {

    public static void main(String[] args) {
        int uni;
        char lettre;
        char lettreModifie;
        Scanner scanner = new Scanner(System.in);

        do { 
            System.out.println("Saisissez une lettre");
            lettre=scanner.next().charAt(0);
            uni=(int) lettre;
            if (uni<65 || (uni<97 && uni>90) || uni >122) {
                System.out.println("Pas valide !");
            }
            else {
                if (uni>=97) {
                    uni=uni-32;
                    lettreModifie=(char) uni;
                    System.out.println("La lettre en majuscule est la suivante : "+lettreModifie);
                }
                else {
                    uni=uni+32;
                    lettreModifie=(char) uni;
                    System.out.println("La lettre en minuscule est la suivante : " +lettreModifie);
                }
            }
        }while (uni<65 || (uni<97 && uni>90) || uni >122);
        
        
   
    }
     
    
}


