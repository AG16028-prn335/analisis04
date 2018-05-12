package analisis04;

import metodos.Lagrange;
import metodos.Newton;

public class Analisis04 {

    public static void main(String[] args) {
        Newton l = new Newton();
        double b[]={0,2,9,4,5};
        double a[]={0,1,2,3,4};
        l.Newton(a, b);
        
        Lagrange s = new Lagrange();
        s.Lagrange(a, b, 2);
    }
    
}
