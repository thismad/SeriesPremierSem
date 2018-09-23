import java.util.Scanner;
public class Exercice6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.println("Entre la taille du tableau");
        n=scanner.nextInt();
        int t[][]= new int[n][n];
        for(int i=0;i<n;i++) t[i][0]=1;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i==j)t[i][i]=1;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                    t[i][j]=t[i-1][j-1]+t[i-1][j];
                  
            }
          
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                  
                    System.out.print(t[i][j]+"   ");
            }
            System.out.println("\n");
        }
    }
}
