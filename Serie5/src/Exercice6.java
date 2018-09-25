/*
 * Author: Mathis Dehez
 * Date: Sep 25, 2018
*/

// En passant dans la methode on pointe vers la meme ref dans les 2 s mais s change de ref pour pointer sur autre chose.

public class Exercice6 {
	public static void main(String[] args) {
		String s="China blue";
		System.out.print(s);
		s=concatener(s, "Express");
		System.out.println(s);
	}
	public static String concatener(String s, String s2) {
		return s+=s2;
	}
}
