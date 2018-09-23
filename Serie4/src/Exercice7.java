import java.util.Scanner;
public class Exercice7 {
    public static void main(String[] args) {
        String noms = "Napoleon Bonaparte Bill Gates Claudia Schiffer Martina Hingis";
        String mot;
        int x=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Entre un prénom");

        mot=scanner.nextLine();
        char a[]=new char[mot.length()];
        
        // création du tableau 
        for(int i=0;i<mot.length();i++)
            a[i]=mot.charAt(i);
        
        //Lecture du tableau et voir si correspond à un mot
        for(int i=0;i<noms.length();i++) {
            if(noms.charAt(i)==a[0]) {
                for(int j=0; j<mot.length();j++) {
                    if(noms.charAt(j)==a[j]) {
                        System.out.println();
                        x+=1;
                    }
                   
                }
                
            }
        }
        if(x==mot.length()) System.out.println("Mot trouvé!");
        else System.out.println("Inconnu au bataillon!");
        System.out.println("Test " + noms.indexOf(mot));
        
    }
}
