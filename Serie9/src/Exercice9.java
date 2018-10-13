import java.util.*;
/*
 * 
 * Author: Mathis Dehez
 * Date: 9 oct. 2018
*/
import java.util.Scanner;
public class Exercice9 {
public static void main (String[] args) {
	/*
	Scanner sc = new Scanner(System.in);
	Acle crypt = new Acle("Acle", "WUZZ");
	String s;
	System.out.println("Entrez un mot à crypter : ");
	s=sc.nextLine();
	s=crypt.code(s);
	System.out.println("Message codé : "+s);
	
	s=crypt.deCode(s);
	System.out.println("Message décodé : " +s);
	*/
	
	// TEST A CLE ALEATOIRE
	Scanner sc = new Scanner(System.in);
	Code acle2 = new AcleAleatoire(5);
	System.out.println("Entrez un mot à crypter : ");
	String s;
	String cryptage;
	s=sc.nextLine();
	
	
	
	System.out.print("Avec le code : " + acle2.getCle());
	acle2.affiche();
	cryptage = acle2.code(s);
	System.out.print("Codage de " +s + " : ");
	System.out.println(cryptage);
	System.out.print("Decodage de " + cryptage + " : ");
	System.out.println(acle2.deCode(cryptage));
	System.out.println("-----------------------------------");
	System.out.println();
	// FIN TEST A CLE ALEATOIRE 
}
}

/*class Crack{
	private String mdc;
	public Crack(String s) {
		mdc=s;
	}
	
	public void activateQ() {
		System.out.println("Cle :		Message :");
		int[] tabCrypte=stringToChiffres(mdc);
		int[] swap=new int[4];
		int[] cleTab=new int[4];
		int a=0;
		int b=0;
		int c=0;
		int d=0;
		String cle="";
		String msg="";
		for (int i = 1; i<27;i++) {
			a=tabCrypte[0]-i;
			swap[0]=(a<=0? a +26: a);
			for (int j=1;j<27;j++) {
				b=tabCrypte[1]-j;
				swap[1]=(b<=0? b+26 : b);
				for (int h=1;h<27;h++) {
					c=tabCrypte[2]-h;
					swap[2]=(c<=0? c+26 : c);
					for(int k=1;k<27;k++) {
						d=tabCrypte[3]-k;
						swap[3] = (d<=0? d+26 : d);
						msg=chiffresToString(swap);
						cleTab[0]=i;
						cleTab[1]=j;
						cleTab[2]=h;
						cleTab[3]=k;
						cle=chiffresToString(cleTab);
						if(duoVC(cle.substring(0, 2)) && duoVC(msg.substring(0, 2)))System.out.println(cle+"		"+msg);
				
						
					}
				}
			}
		}
		
	}
	
	
	private boolean duoVC(String s) {
		
		char c=s.charAt(0);
		char b=s.charAt(1);
		if(voyelle(c) && voyelle(b))return false;
		else if  ((voyelle(c) && (!voyelle(b)) || (voyelle(b) && (!voyelle(c))))) return true;
		else return false;
		
	}
	private boolean voyelle(char c) {
		if(c=='A'||c=='E'||c=='I'||c=='O'||c=='U')return true;
		else return false;
	}
	
	
	private String chiffresToString(int[] c) {
		String s="";
		for(int i=0;i<c.length;i++) {
			s+=(char)(c[i]+64);
		}
		return s;
	}
	private int[] stringToChiffres(String s) {
		int tabCode[]=new int[s.length()];
		for(int i=0;i<s.length();i++) {
			tabCode[i]=(int)s.charAt(i)-64;
		}
		return tabCode;
	}
}
*/

abstract class Code{
	private String nom;
	public Code(String s) {
		nom=s;
	}
	abstract public String code(String s);
	abstract public String deCode(String s);
	abstract public String getCle();

	public void affiche() {
		System.out.println(nom);
	}
}

class Acle extends Code{
	private String cle;
	public Acle(String n,String c) {
		super(n);
		cle=c;
	}
	//on convertit en tableaux de chiffres la String à coder et la clé puis 
	// on les additionne pour sortir qu'un seul tableau de chiffres codés;
	public String code(String s) {
		int[] msgToChiffres=stringToChiffres(s);
		int[] cleToString=stringToChiffres(this.cle);
		int compteur=0;
		int addition;
		int cleToStringLength = cleToString.length;
		while (compteur<msgToChiffres.length) {
			//we add the 2 tables and we need to loop compteur of the key if its smaller.
			addition = msgToChiffres[compteur]+cleToString[compteur%cleToStringLength];
			msgToChiffres[compteur]=(addition<=26? addition : addition-26);
			compteur++;
		}

		return ChiffresToString(msgToChiffres);
	}
	public String deCode(String s) {
		int[] msgToChiffres=stringToChiffres(s);
		int[] cleToChiffres=stringToChiffres(this.cle);
		int compteur=0;
		int soustraction;
		int cleToChiffresLength = cleToChiffres.length;
		while (compteur<msgToChiffres.length) {
			//we add the 2 tables and we need to loop compteur of the key if its smaller.
			soustraction = msgToChiffres[compteur]-cleToChiffres[compteur%cleToChiffresLength];
			msgToChiffres[compteur]=(soustraction<=0? soustraction +26: soustraction);
			compteur++;
		}

		return ChiffresToString(msgToChiffres);
	}
	public String getCle() {
		return cle;
	}

	public void setCle(String s) {
		this.cle=s;
	}


	//methode for string to tab
	private int[] stringToChiffres(String s) {
		int tabCode[]=new int[s.length()];
		for(int i=0;i<s.length();i++) {
			tabCode[i]=(int)s.charAt(i)-64;
		}
		return tabCode;
	}
	//method for tab to string
	private String ChiffresToString(int[] c) {
		String s="";
		for(int i=0;i<c.length;i++) {
			s+=(char)(c[i]+64);
		}
		return s;
	}
}

class AcleAleatoire extends Acle{
	private int cleLongueur;

	public AcleAleatoire(int longueur) {
		super("a cle aleatoire","");
		cleLongueur=longueur;
		genereCle();
	}


	private void genereCle() {
		String cle="";
		for (int i =0; i<cleLongueur;i++) {
			//mauvaise utilisation de Math.random qui retourne entre 0 et 1
			cle+=(char)( Math.random()%26+65);
		}
		super.setCle(cle);;
	}
	public String getCle() {
		return super.getCle();
	}

}




























