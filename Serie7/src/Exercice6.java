import java.util.Scanner;
public class Exercice6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x;
        double y;
        Point pt1 = new Point();
        Point pt2 = new Point();
        Point pt3 = new Point();
        for (int i=0;i<3;i++) {
            System.out.println("Construction d'un nouveau point");
            System.out.println("Rentrez coordonnées x: ");
            x=scanner.nextDouble();
            System.out.println("Rentrez coordonnées y: ");
            y=scanner.nextDouble();
            
            switch (i) {
            case 0 : pt1.setX(x);
            pt1.setY(y);

            case 1 : pt2.setX(x);
            pt2.setY(y);
            case 2 : pt3.setX(x);
            pt3.setY(y);
            }

        }
        Triangle triangle = new Triangle(pt1,pt2,pt3);
        triangle.perimetre();
    }
}

  class Point{
    private double x;
    private double y;
    
 
    public double getX() {
    return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void setX(double x) {
        this.x=x;
    }
    public void setY(double y) {
        this.y=y;
    }
    
    
}

class Triangle{
   private Point pt1;
   private Point pt2;
   private Point pt3;
   
   public Triangle(Point pt1,Point pt2, Point pt3) {
       this.pt1=pt1;
       this.pt2=pt2;
       this.pt3=pt3;
   }
   private double distance(Point p, Point v) {
       return Math.sqrt(Math.pow(p.getX()-v.getX(), 2)+Math.pow(p.getY()-v.getY(), 2));
   }
   public void perimetre() {
       double d1=distance(pt1,pt2);
       double d2=distance(pt2,pt3);
       double d3=distance(pt3,pt1);
       double p = d1+d2+d3;
       System.out.println("Le périmètre est : "+p);
       System.out.println("");
       if (d1==d2 || d1==d3 || d2==d3) System.out.println("Le triangle est isocèle");
       else System.out.println("Le triangle n'est pas isocèle");
   }
}