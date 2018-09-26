import java.util.Scanner;
import java.util.ArrayList;
/*
 * Author: Mathis Dehez
 * Date: Sep 26, 2018
*/

public class Exercice11 {
	public static void main(String [] args) {
		String[] phrase = lirePhrase();
		
		for (int i=0; i<phrase.length;i++) {
			cesure(phrase[i]);
		}
	}
	
	public static String[] lirePhrase() {
		Scanner scanner = new Scanner(System.in);
		int n=0;
		System.out.println("Entre une phrase!");
		String lecture= scanner.nextLine();
		ArrayList<String> tabChar=new ArrayList<String>();
		
		for (int i=0; i<lecture.length();i++) {
			if (lecture.charAt(i)==' ') {
				
				tabChar.add(lecture.substring(n, i-1));
				n=tabChar.get(i).length()+1;
						
			}
			else if ((i==lecture.length()-1)) {
				tabChar.add(lecture.substring(n, i));

			}
		}
		String[] tabString = tabChar.toArray(new String[tabChar.size()]);
		return tabString;
	}
	public static boolean voyelle(char c) {
		switch (c) {
		case 'a': return true;
		case 'e': return true;
		case 'i': return true;
		case 'o': return true;
		case 'u': return true;
		case 'y': return true;
		default : return false;
		}
	}
	
	public static boolean queVoyelles(String s) {
		int compteur=0;
		for(int i = 0; i<s.length();i++) {
			if(voyelle(s.charAt(i))) {
				compteur+=1;
			}
		}
		return compteur==s.length();
	}
	
	public static void cesure(String mot) {
		String intermediaire="";
		boolean voyellePresente=false;
		System.out.println("Le résultat est : \n");
		for (int i=0;i<mot.length();i++) {
			intermediaire=intermediaire.concat(mot.charAt(i)+"");
			if(voyelle(mot.charAt(i))) {
				voyellePresente=true;
			}
			if(intermediaire.length()>=2 && i<intermediaire.length()-1 && voyellePresente 
					&& !queVoyelles(intermediaire.substring(i,i+1)) && i<mot.length()-1){
				System.out.println("Le résultat est : \n");
				System.out.println(intermediaire+"-");
				intermediaire="";
				voyellePresente=false;
			}
				
			}
		System.out.println(intermediaire);
		System.out.println();
		}

	}
	

