package metodos;

import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

public class hermite {

    JEP jp = new JEP();

    public void Hermite(double x[], double y[], String funcion) {
        String pol = "", sal = "";
        double denominador = 0, numerador = 0, val=0;
        //lenando x, y
        Object matriz[][] = new Object[x.length][x.length + 1];
        for (int i = 0; i < x.length; i++) {
            matriz[i][0] = x[i];
            matriz[i][1] = y[i];
        }
        //llendando matriz
        int cn = 2;
        for (int i = 1; i < x.length + 1; i++, cn++) {
            for (int j = 1; j < x.length; j++) {
                if (i == 1) {
                    numerador=(((double) matriz[j][cn - 1] - (double) matriz[j - 1][cn - 1]));
                    denominador=(Double.parseDouble("" + x[j]) - Double.parseDouble("" + x[j - 1]));
                    if(numerador ==0 && denominador==0){
                         sal = Derivar(funcion);
                        val=val(sal,x[j]);
                        matriz[j][cn]=val;
                    }else{
                    matriz[j][cn] = numerador / denominador;
                    }
                } else {
                    int o = j + i - 1;
                    if (o < x.length) {
                        numerador=(((double) matriz[o][cn - 1] - (double) matriz[o - 1][cn - 1]));
                        denominador=(Double.parseDouble("" + x[o]) - Double.parseDouble("" + x[o - i]));
                        if(numerador ==0 && denominador==0){
                         sal = Derivar(funcion);
                        val=val(sal,x[j]);
                        matriz[j][cn]=val;
                    }else{
                        matriz[o][cn] = numerador / denominador;
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

    }

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
