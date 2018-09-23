import java.util.ArrayList;
public class Exercice10 {
    public static void main(String[] args) {
        ArrayList<Integer> tab = new ArrayList<Integer>();
        ArrayList<Integer> tabImpaire = new ArrayList<Integer>();
        int j=0;
        boolean etat=true;
        tabImpaire.add(2);
        tab.add(2);
        for (double i=3;i<=100;i++) {
            if(!(i%2==0)) {
                tabImpaire.add((int) i);


                do {
                    if((i%tabImpaire.get(j)==0)) {
                        etat=false;
                    }

                    j+=1;
                }while(tabImpaire.get(j-1)<=Math.sqrt(i));
                if (etat) tab.add((int) i);
                etat=true;
                j=0;

            }
        }
        for (int i=0;i<tab.size();i++) {
            System.out.println(tab.get(i));

        }

    }
}
