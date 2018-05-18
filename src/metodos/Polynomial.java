
package metodos;

import org.lsmp.djep.sjep.PolynomialCreator;
import org.lsmp.djep.xjep.XJep;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;


public class Polynomial {
    JEP j = new JEP();
     XJep xj = new XJep();
    PolynomialCreator pc = new PolynomialCreator(xj);
    public Polynomial() {
        xj.setAllowUndeclared(true);
        xj.setImplicitMul(true);
        j.addStandardConstants();
        j.addStandardFunctions();
        j.addComplex();
        j.setImplicitMul(true);}
    public String poli(String cad){
        String pol="";
        try {
            Node n =xj.parse(cad);
            n=xj.preprocess(n);
            Node sim = pc.expand(n);
            pol = xj.toString(sim);
            
            pol=pol.replaceAll("\\+-", "-");
            pol=pol.replaceAll("\\*", "");
            return pol;
        } catch (Exception e) {
           return "ERROR NO PUEDO HACER ESTO DEL POLINOMIO XD ";
        }
        
    }
           public double Ecuacion(String s, double n) {
        j.addVariable("x", n);
        j.parseExpression(s);
        if (j.hasError()) {
            System.out.println("Ecuancion no entendible:\n" + j.getErrorInfo());
        }
        return j.getValue();
    }
    public double Fact(double n){
        double res=1;
        for (int i =1; i <=n; i++) {
            res*=i;
        }
        return res;
    }
    
}
