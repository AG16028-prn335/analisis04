package metodos;

import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

public class hermite {

    JEP jp = new JEP();

    public hermite() {
        jp.addStandardConstants();
        jp.addStandardFunctions();
        jp.addComplex();
        jp.setImplicitMul(true);
    }

    public double val(String func, double num) {
        jp.addVariable("x", num);
        jp.parseExpression(func);
        if (jp.hasError()) {
            System.out.println("Ecuancion no entendible:\n" + jp.getErrorInfo());
        }
        return jp.getValue();
    }

    public void Hermite(double x[], double y[], String funcion) {
        String pol = "", sal = "";
        double denominador = 0, numerador = 0;
        //lenando x, y
        Object matriz[][] = new Object[x.length][x.length + 1];
        for (int i = 0; i < x.length; i++) {
            matriz[i][0] = x[i];
            matriz[i][1] = y[i];
        }
        //llendando matriz
        int col = 2, cont = 0;
        for (int i = 1; i < x.length + 1; i++, col++) {
            for (int j = 1; j < x.length; j++) {
                if (i == 1) {
                    numerador = ((double) matriz[j][col - 1] - (double) matriz[j - 1][col - 1]);
                    denominador = Double.parseDouble("" + x[j]) - Double.parseDouble("" + x[j - 1]);
//                    if (numerador == 0 && denominador == 0) {
//                        sal = Derivar(funcion);
//                        matriz[j][col] = val(sal, (double) matriz[j][col]);
//                    } else {
//                        matriz[j][col] = numerador / denominador;
//                    }
                } else {
                    int o = j + i - 1;
                    if (o < x.length) {
                        numerador = ((double) matriz[o][col - 1] - (double) matriz[o - 1][col - 1]);
                        denominador = (Double.parseDouble("" + x[o]) - Double.parseDouble("" + x[o - i]));
//                        if (numerador == 0 && denominador == 0) {
//                            sal = Derivar(funcion);
//                            matriz[j][col] = val(sal, (double) matriz[j][col]);
//                        } else {
//                            matriz[j][col] = numerador / denominador;
//                        }
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

    }

    public String Derivar(String fun) {
        String deriv = "";
        DJep Derivar = new DJep();
        Derivar.addStandardFunctions();
        Derivar.addStandardConstants();
        Derivar.addComplex();
        Derivar.setAllowUndeclared(true);
        Derivar.setAllowAssignment(true);
        Derivar.setImplicitMul(true);
        Derivar.addStandardDiffRules();

        try {
            Node node = Derivar.parse(fun);
            Node diff = Derivar.differentiate(node, "x");
            Node sim = Derivar.simplify(diff);
            deriv = Derivar.toString(sim);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return deriv;
    }

}
