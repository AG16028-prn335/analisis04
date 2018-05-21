package metodos;

public class hermite {

    Polynomial p = new Polynomial();

    public hermite() {
    }

    public String[] Hermite(double x[], double y[], double x1[], double y1[], double n) {
        String pol = "", sal = "";
        int co = 0, con = 1;
//        
//        //lenando x, y
        Object matriz[][] = new Object[x.length][x.length + 1];
        for (int i = 0; i < x.length; i++) {
            matriz[i][0] = x[i];
            matriz[i][1] = y[i];
        }
//        //llendando matriz
        int cn = 2;
            for (int i = 1; i < x.length + 1; i++, cn++) {
            for (int j = 1; j < x.length; j++) {
                if (i == 1) {
                    if ((((double) matriz[j][cn - 1] - (double) matriz[j - 1][cn - 1]))==0 && (Double.parseDouble("" + x[j]) - Double.parseDouble("" + x[j - 1]))==0) {
                        matriz[j][cn]=x1[i];
                    }else{
                        matriz[j][cn] = (((double) matriz[j][cn - 1] - (double) matriz[j - 1][cn - 1])) / (Double.parseDouble("" + x[j]) - Double.parseDouble("" + x[j - 1]));                        
                    }
                } else {
                    int o = j + i - 1;
                    if (o < x.length) {
                         if ((((double) matriz[o][cn - 1] - (double) matriz[o - 1][cn - 1]))==0 && (Double.parseDouble("" + x[o]) - Double.parseDouble("" + x[o - 1]))==0) {
                             matriz[j][cn]=x1[o];
                        }else{
                             matriz[o][cn] = (((double) matriz[o][cn - 1] - (double) matriz[o - 1][cn - 1])) / (Double.parseDouble("" + x[o]) - Double.parseDouble("" + x[o - i]));
                         }
                    }
                }
            }
        }
        //imprimiendo matriz
        for (int s = 0; s < x.length; s++) {
            for (int j = 0; j < x.length + 1; j++) {
                if (matriz[s][j] != null) {
                    System.out.print(matriz[s][j] + " |\t");
                }
            }
            System.out.println("");
        }
        String fun="",fac="";
        double bn []= new double[x.length+1];
        for (int i = 0; i < x.length; i++) {
                bn[i]=(double)matriz[i][i+1];
        }
        String factor = "(x-$)";
        for (int i = 0; i < x.length; i++) {
                if (bn[i] < 0) {
                    fun += " " + bn[i];
                } else {
                    fun += " +" + bn[i];
                }

                for (int j = 0; j < i; j++) {
                    if (bn[i] != 0) {
                        fun += factor.replace("$", String.valueOf(x[j]));
                    }
                }
            }
        
String[] p1 ={p.poli(fun),""+p.Ecuacion(p.poli(fun), n),ErrorHermite(x, bn[bn.length-1], n)};
        for (int i = 0; i <p1.length; i++) {
            System.out.println(""+p1[i]);
        }
return p1; 
    }
    public String ErrorHermite(double a[], double ult, double v) {
        String s = "", er;
        for (int i = 0; i < a.length; i++) {
            s += "(x -" + a[i] + ")^2";
        }
        er = "(" + ult + ")" + s;
        return p.Ecuacion(er, v) + "";
    }
}
