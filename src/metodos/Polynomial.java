package metodos;

import org.lsmp.djep.sjep.PolynomialCreator;
import org.lsmp.djep.xjep.XJep;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;

public class Polynomial {

    JEP j = new JEP();
    XJep xj = new XJep();
    PolynomialCreator pc = new PolynomialCreator(xj);
    /**
     * Constructor of class
     */
    public Polynomial() {
        xj.setAllowUndeclared(true);
        xj.setImplicitMul(true);
        j.addStandardConstants();
        j.addStandardFunctions();
        j.addComplex();
        j.setImplicitMul(true);
    }
    /**
     * permite calcualr el polinomio mostrandolo en la forma mas simplificada posible 
     * @param cad es el parametro requerido por el metodo.. esta cadena es la que sera evaluada y convertida  a un polinomio 
     * @return retorna yael polinonio ... lo muestra desde el termino independiente hacia el valo de x^n mayor
     */
    public String poli(String cad) {
        String pol = "";
        try {
            Node n = xj.parse(cad);
            n = xj.preprocess(n);
            Node sim = pc.expand(n);
            pol = xj.toString(sim);

            pol = pol.replaceAll("\\+-", "-");
            pol = pol.replaceAll("\\*", "");
            return pol;
        } catch (Exception e) {
            return "ERROR NO PUEDO HACER ESTO DEL POLINOMIO XD ";
        }

    }
    /**
     * metodo que permite obtener un double del valor evaluado en el valor n de la ecuacion s
     * @param s funcion a evaluar 
     * @param n es el valor por el cual se sustituye la variable 
     * @return  retorna un double que es el valor de la funcion en el punto n
     */
    public double Ecuacion(String s, double n) {
        j.addVariable("x", n);
        j.parseExpression(s);
        if (j.hasError()) {
            System.out.println("Ecuancion no entendible:\n" + j.getErrorInfo());
        }
        return j.getValue();
    }
    /**
     * este metodo calcula el factorial de un numero
     * @param n numero para calcular factorial
     * @return retorna el valor del factorial del numero n 
     */
    public double Fact(double n) {
        double res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

}
