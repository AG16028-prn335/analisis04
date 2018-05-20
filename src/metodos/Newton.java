package metodos;

import metodos.Polynomial;

public class Newton {

    Polynomial p = new Polynomial();

    public Newton() {
    }

    public String[] Newton(double a[], double b[], double n) {
        String fac = "", fun = "";
        Object mat[][] = new Object[a.length][a.length + 1];
        for (int i = 0; i < a.length; i++) {
            mat[i][0] = a[i];
            mat[i][1] = b[i];
        }
        int cn = 2;
        for (int i = 1; i < a.length + 1; i++, cn++) {
            for (int j = 1; j < a.length; j++) {
                if (i == 1) {
                    mat[j][cn] = (((double) mat[j][cn - 1] - (double) mat[j - 1][cn - 1])) / (Double.parseDouble("" + a[j]) - Double.parseDouble("" + a[j - 1]));
                } else {
                    int o = j + i - 1;
                    if (o < a.length) {
                        mat[o][cn] = (((double) mat[o][cn - 1] - (double) mat[o - 1][cn - 1])) / (Double.parseDouble("" + a[o]) - Double.parseDouble("" + a[o - i]));
                    }
                }
            }
        }
        /*Esta linea imprime la matriz*/
        for (int s = 0; s < a.length; s++) {
            for (int j = 0; j < a.length + 1; j++) {
                if (mat[s][j] != null) {
                    System.out.print(mat[s][j] + " |\t");
                }
            }
            System.out.println("");
        }
        //Metodo para hacer el polinimio solo indicado.
        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                fun = String.valueOf(mat[i][1]);
            } else {
                fac += "(x-" + a[i - 1] + ")";
                fun += " + (" + mat[i][i + 1] + fac + ")";
            }
        }
        String ec=p.poli(fun);
        System.out.println("la funcion es:\nP(x) = " + ec);
        //imprimiendo polinomio
        String pol[]  = {ec,String.valueOf(p.Ecuacion(ec, n))};
        return pol; 
    }
}
