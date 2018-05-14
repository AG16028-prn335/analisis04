package analisis04;

import metodos.Lagrange;
import metodos.Newton;
import metodos.hermite;

public class Analisis04 {

    public static void main(String[] args) {
//        Newton l = new Newton();
//        double b[]={0,2,9,4,5};
//        double a[]={0,1,2,3,4};
//        l.Newton(a, b);
//        
//        Lagrange s = new Lagrange();
//        s.Lagrange(a, b, 2);
        
        hermite h= new hermite();
        double x[]={1, 1, 2, 2};
        double y[]={0, 0, 0.69314718, 0.69314718};
        String funcion="ln(x)";
        h.Hermite(x, y, funcion);
    }
    
}
