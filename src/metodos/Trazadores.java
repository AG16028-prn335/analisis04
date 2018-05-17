package metodos;

import org.nfunk.jep.JEP;

public class Trazadores {
       JEP jp = new JEP();
public void trazadores (double x[], double y[], String funcion){
Object matriz[][] = new Object[x.length][x.length + 1];



}




//evaluar el polinomio
public double val(String func, double num) {
        jp.addVariable("x", num);
        jp.parseExpression(func);
        if (jp.hasError()) {
            System.out.println("Ecuancion no entendible:\n" + jp.getErrorInfo());
        }
        return jp.getValue();
    }
    
}
