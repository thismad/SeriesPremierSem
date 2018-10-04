/*
 * Author: Mathis Dehez
 * Date: Oct 3, 2018
 */

class Exercice5 {

	public static void main(String[] args) {
	
		
		Client Pedro=new Client("Pedro","Geneve",1000.0,2000.0);
		Client Alexandra=new Client("Alexandra","Lausanne",3000.0,4000.0);
		Bank SwissBank=new Bank();
		Pedro.afficherClient();
		Alexandra.afficherClient();
		SwissBank.bouclement(Pedro);
		SwissBank.bouclement(Alexandra);
	    
		Pedro.afficherClient();
		Alexandra.afficherClient();
	}
}
class Client{
	private String nom;
	private String ville;
	private double comptePrive;
	private double compteEpargne;
	
	public Client(String n, String v, double comptePrive, double compteEpargne) {
	this.nom=n;
	this.ville=v;
	this.comptePrive=comptePrive;
	this.compteEpargne=compteEpargne;
	}
	
	public double getComptePrive() {
		return this.comptePrive;
	}
	public double getCompteEpargne() {
		return this.compteEpargne;
	}
	private String getVille() {
		return this.ville;
	}
	private String getName() {
		return this.nom;
	}
	public void setComptePrive(double c) {
		comptePrive=c;
	}
	public void setCompteEpargne(double c) {
		compteEpargne=c;
	}
	public void afficherClient() {
		System.out.println("Client " +this.nom  + " de " + this.ville);
		System.out.println("   Compte prive:     " + this.comptePrive + " francs");
		System.out.println("   Compte d'epargne: " + this.compteEpargne + " francs");
	}
	
}

class Bank{
	//est ce que c est copié par référence ou est ce que c est un nouvel objet?
	private double tauxPrive =0.01;
	private double tauxEpargne =0.02;
	
	public void bouclement(Client nom) {
		nom.setComptePrive(calculPrive(nom));
		nom.setCompteEpargne(calculEpargne(nom));
	}
	private double calculPrive(Client nom) {
		return tauxPrive*nom.getComptePrive()+nom.getComptePrive();
	}
	private double calculEpargne(Client nom) {
		return tauxEpargne*nom.getCompteEpargne()+nom.getCompteEpargne();
	}
}































