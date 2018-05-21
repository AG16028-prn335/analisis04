package analisis04;

import metodos.Lagrange;
import metodos.Newton;
import metodos.Polynomial;
import metodos.hermite;

public class Analisis04 {

    public static void main(String[] args) throws Exception {
//        Newton l = new Newton();
//        double b[] = {125350,133420,117183,120323,145311};
//        double a[] = {1910,1930,1950,1960,1980};
//        l.Newton(a, b);
//
//        Lagrange s = new Lagrange();
//        String p[] = s.Lagrange(a, b, 1964);
//        for (int i = 0; i < p.length; i++) {
//            System.out.println("p:" + p[i]);
//        }
//
//        hermite h = new hermite();
//        double x[] = {1,1,2,2};
//        double y[] = {0, 0,0.69314718, 0.69314718};
//        String funcion = "ln(x)";
//        h.Hermite(x, y, funcion);
        Polynomial p = new Polynomial();
        System.out.println(""+p.Ecuacion(p.Derivar("x^2cos(5x+2)"), Math.PI/2));
    }

}
