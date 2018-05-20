package analisis04;

//package analisis04;

import metodos.Lagrange;
import metodos.Newton;
import metodos.hermite;

public class Analisis04 {

    public static void main(String[] args) throws Exception {
//        Newton l = new Newton();
        double b[] = {0,0.841570,0.909297};
        //1910, 1930, 1950, 1960, 1980
        double a[] = {0,1,2};
//        l.Newton(a, b);

        Lagrange s = new Lagrange();
        String p[] = s.Lagrange(a, b, 0.5);
        for (int i = 0; i < p.length; i++) {
            System.out.println("p:" + p[i]);
        }

//        hermite h = new hermite();
//        double x[] = {1, 1, 2, 2};
//        double y[] = {0, 0, 0.69314718, 0.69314718};
//        String funcion = "ln(x)";
//        h.Hermite(x, y, funcion);
    }

}
