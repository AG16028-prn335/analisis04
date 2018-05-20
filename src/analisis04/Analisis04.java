package analisis04;

import metodos.Lagrange;
import metodos.Newton;
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

        hermite h = new hermite();
        double x[] = {1, 1, 2, 2,};
        double y[] = {0, 0, 0.69314718, 0.69314718};
        String funcion = "ln(x)";
        h.Hermite(x, y, funcion);
    }

}
package analisis04;

//package analisis04;

import metodos.Lagrange;
import metodos.Newton;
import metodos.hermite;

public class Analisis04 {
    
   public double[] puntosParticion(int puntos, double[] x, double[] y, double[] xi, double[] bj, double[] cj, double[] dj) {
        double li[] = new double[200];// almacena las componentes y de la particion del intervalo [a,b]
        double sx = 0;
        for (int k = 0; k < li.length; k++) {
            
            for (int i = 0; i < puntos-1; i++) {
            if (xi[k]>x[i] && xi[k]<x[i+1] ) {
                sx=y[i]+( bj[i]*(xi[k]-x[i]) )  +  (cj[i]*Math.pow(xi[k]-x[i], 2)) +(dj[i]*Math.pow(xi[k]-x[i], 3));
            }
        }
            li[k]=sx;
            
        }

        return li;
    }

    public static void main(String[] args) throws Exception {
        Newton l = new Newton();
        double b[] = {125350, 133420, 117183, 120323, 145311};
        //1910, 1930, 1950, 1960, 1980
        double a[] = {1910, 1930, 1950, 1960, 1980};
        //l.Newton(a, b);

//        Lagrange s = new Lagrange();
//        String p[] = s.Lagrange(a, b, 0.5);
//        for (int i = 0; i < p.length; i++) {
//            System.out.println("p:" + p[i]);
//        }

//        hermite h = new hermite();
//        double x[] = {1, 1, 2, 2};
//        double y[] = {0, 0, 0.69314718, 0.69314718};
//        String funcion = "ln(x)";
//        h.Hermite(x, y, funcion);
    }

}
