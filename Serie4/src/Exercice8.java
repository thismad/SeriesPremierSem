import java.util.Scanner;
public class Exercice8 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palindrome;
        String palindromeEp;
        int uni;
        int compteur=0;
        char tChar[];
        palindrome=scanner.nextLine();
        palindrome=palindrome.toLowerCase();
        tChar=palindrome.toCharArray();

        for(int i=0;i<tChar.length;i++) {
        uni=(int) tChar[i];
        if(uni>122 || uni <97) {
            palindrome=palindrome.replaceFirst((char) uni+"", "");
        }
        }
        
        for(int i=0;i<palindrome.length();i++) {
            if(palindrome.charAt(i)==palindrome.charAt(palindrome.length()-i-1)) compteur +=1;
        }
        if(compteur==palindrome.length()) System.out.println("C'est un palindrome");
        else System.out.println("Ce n'est pas un palindrome");


    }
        
}
