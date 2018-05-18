package metodos;

public class Lagrange {

    Polynomial ss = new Polynomial();

    public Lagrange() {
    }

    /**
     *
     * @param x en este vector estan las abscisas
     * @param y este vector controla las ordenadas
     * @param n es el numero a evaluar el polinimio filas
     */
    public String[] Lagrange(double x[], double y[], double n) {
        String s, s1;
        double res = 0;
        String ecu[] = new String[y.length];
        String dd = "";
        for (int j = 0; j < y.length; j++) {
            s = "";
            s1 = "";
            for (int i = 0; i < x.length; i++) {
                if (i != j) {
                    s += "(x -" + x[i] + ")";
                    s1 += "(" + x[j] + " -" + x[i] + ")";
                }
            }
            s += "(" + y[j] + ")";
            ecu[j] = s + "/(" + s1 + ")";
        }
        for (int i = 0; i < ecu.length; i++) {
            ecu[i] = ss.poli(ecu[i]);
            dd += "+ " + ecu[i];
        }
        dd = ss.poli(dd);
        String pol[] = {dd, String.valueOf(ss.Ecuacion(dd, n)), ErrorLangrage(x, y, n)};
        return pol;
    }

    public String ErrorLangrage(double a[], double b[], double v) {
        String s = "", er;
        for (int i = 0; i < a.length; i++) {
            s += "(x -" + a[i] + ")";
        }
        er = "((" + b[b.length - 1] + ")/(" + ss.Fact(a[a.length - 1] + 1) + "))" + s;
        return ss.Ecuacion(er, v) + "%";
    }

}
