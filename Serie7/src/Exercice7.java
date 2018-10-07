import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Exercice7 {

    public static void main(String[] args) {
        // Les articles vendus dans le supermarché
        Article choufleur = new Article("Chou-fleur extra", 3.50, false);
        Article roman = new Article("Les malheurs de Sophie", 16.50, true);
        Article camembert = new Article("Cremeux 100%MG", 5.80, false);
        Article cdrom = new Article("C++ en trois jours", 48.50, false);
        Article boisson = new Article("Petit-lait", 2.50, true);
        Article petitspois = new Article("Pois surgeles", 4.35, false);
        Article poisson = new Article("Sardines", 6.50, false);
        Article biscuits = new Article("Cookies de grand-mere", 3.20, false);
        Article poires = new Article("Poires Williams", 4.80, false);
        Article cafe = new Article("100% Arabica", 6.90, true);
        Article pain = new Article("Pain d'epautre", 6.90, false);

        // Les caddies du supermarché
        Caddie caddie1 = new Caddie();
        Caddie caddie2 = new Caddie();
        Caddie caddie3 = new Caddie();

        // Les caisses du supermarché
        // le premier argument est le numero de la caisse
        // le second argument est le montant initial de la caisse.
        Caisse caisse1 = new Caisse(1, 0.0);
        Caisse caisse2 = new Caisse(2, 0.0);

        // les clients font leurs achats
        // le second argument de la méthode remplir
        // correspond à une quantité

        // remplissage du 1er caddie
        caddie1.remplir(choufleur, 2);
        caddie1.remplir(cdrom, 1);
        caddie1.remplir(biscuits, 4);
        caddie1.remplir(boisson, 6);
        caddie1.remplir(poisson, 2);

        // remplissage du 2eme caddie
        caddie2.remplir(roman, 1);
        caddie2.remplir(camembert, 1);
        caddie2.remplir(petitspois, 2);
        caddie2.remplir(poires, 2);

        // remplissage du 3eme caddie
        caddie3.remplir(cafe, 2);
        caddie3.remplir(pain, 1);
        caddie3.remplir(camembert, 2);

        // Les clients passent à la caisse
        caisse1.scanner(caddie1);
        caisse1.scanner(caddie2);
        caisse2.scanner(caddie3);
        
        caisse1.totalCaisse();
        caisse2.totalCaisse();
    }
}  
    class Article{
        private String nom;
        private double prix;
        private boolean action;
        
        public Article(String nom, double prix, boolean action) {
            this.nom=nom;
            this.prix=prix;
            this.action=action;
        }
        public double getPrix() {
            return prix;
        }
        public boolean getAction() {
            return action;
        }
        public String getNom() {
            return nom;
        }
    }

    class Achat{
        private Article article;
        private int quantite;
        
        public Achat(Article article, int qte) {
            this.article=article;
            quantite=qte;
        }
        
        public Article getArticle() {
            return article;
        }
        public void afficher () {
          double prixTotArticle=article.getPrix()*quantite;
          
            if(article.getAction()==true) {
                System.out.println(article.getNom()+" : "+ article.getPrix()+" x "
            +quantite+" = "+prixTotArticle/2+" (1/2 prix)");
            }
            else {
                System.out.println(article.getNom()+" : "+ article.getPrix()+" x "
                        +quantite+" = "+prixTotArticle);
            }
        }
        public double getPrix() {
            if (this.article.getAction()==true)
            return (article.getPrix()/2)*quantite;
            else return article.getPrix()*quantite;
        }
    }

    class Caddie{
        private ArrayList <Achat> achats=new ArrayList<Achat>();
        
        public void remplir(Article article, int nb) {
                achats.add(new Achat(article, nb));
           
        }
        
        public int getSize() {
            return achats.size();
        }
        public Achat getIndex(int i) {
            return achats.get(i);
        }
        
    }


    class Caisse{
        private int numCaisse;
        private double total;
        
        public Caisse(int numCaisse, double total) {
            this.numCaisse=numCaisse;
            this.total=total;
        }
        
        public void scanner(Caddie caddie) {
            double totalTemp=0;
            Date dateCourante = new Date();
            SimpleDateFormat formatDate=new SimpleDateFormat("dd/MM/yy");
            System.out.println(formatDate.format(dateCourante));
            System.out.println();
            System.out.println("Caisse numero "+numCaisse);
            for (int i=0; i<caddie.getSize();i++) {
                caddie.getIndex(i).afficher();
                totalTemp += caddie.getIndex(i).getPrix();
            }
            System.out.println();
            System.out.println("Prix à payer "+totalTemp);
            
            for (int i=0;i<20;i++) {
                System.out.print("=");
            }
            System.out.println();
            for (int i=0;i<20;i++) {
                System.out.print("=");
            }
            System.out.println();
            total+=totalTemp;
        }
        public void totalCaisse() {
            System.out.println("La caisse "+numCaisse+" a encaisse "+total);
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

