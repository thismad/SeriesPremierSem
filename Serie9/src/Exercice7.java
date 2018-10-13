/*
 * Author: Mathis Dehez
 * Date: 9 oct. 2018
*/

public class Exercice7 {
	
		public static void main(String[] args) {
			Jeu maMain = new Jeu(10);
			maMain.piocher(new Terraib('b'));
			maMain.piocher(new Creature(6, "Golem", 4, 6));
			maMain.piocher(new Sortilege(1, "Croissance Gigantesque",
					"La créature ciblée gagne +3/+3 jusqu'à la fin du tour"));
			System.out.println("Là, j'ai en stock :");
			maMain.afficher();
			maMain.joue();
		}
	}

class Jeu{
	private Carte[] c;
	public Jeu(int n) {
		c=new Carte[n];
	}
	public void piocher(Carte c) {
		int compteur=0;
		while(compteur<this.c.length && this.c[compteur]!=null) {
			compteur++;
		}
		this.c[compteur]=c;
	}
	public void afficher() {
		for (int i=0; i<c.length && c[i]!=null;i++) {
			c[i].afficher();
		}
	}
	public void joue() {
		System.out.println("Je joue une carte.."+"\n La carte jouée est : \n");
		afficher();
	}
}

class Carte{
	private int cout;
	
	public Carte(int cout) {
		this.cout=cout;
	}
	
	public void afficher() {
		System.out.println("Cout :"+cout);
	}
}

class Terraib extends Carte{
	private String couleur;

	public Terraib(char c) {
		super(0);
		System.out.println("Un nouveau terrain");
		switch (c) {
		case 'B' : couleur="blanc";
		break;
		case 'b' : couleur="bleu";
		break;
		case 'n' : couleur = "noir";
		break;
		case 'r' : couleur = "rouge";
		break;
		case 'v' : couleur = "vert";
		}

	}
	
	public void afficher() {
		super.afficher();
		System.out.println("Un terrain "+couleur);
	}
}

class Creature extends Carte{
	private String nom;
	private int ptDegats;
	private int pdv;
	
	public Creature(int c,String n, int pt, int pdv) {
		super(c);
		System.out.println("Une nouvelle creature");
		nom=n;
		ptDegats=pt;
		this.pdv=pdv;
	}
	
	public void afficher() {
		super.afficher();
		System.out.println("Une créature "+nom+" "+ptDegats+"/"+pdv);
	}
}

class Sortilege extends Carte{
	private String nom;
	private String expl;
	public Sortilege(int c,String n ,String e) {
		super(c);
		System.out.println("Un nouveau sortilège de plus");
		nom=n;
		expl=e;
	}
	public void afficher() {
		super.afficher();
		System.out.println("Un sortilège "+nom+" : "+expl);
	}
}






















