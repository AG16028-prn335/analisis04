package metodos;

import org.nfunk.jep.JEP;

public class Lagrange {
    JEP j = new JEP();
     public Lagrange() {
        j.addStandardConstants();
        j.addStandardFunctions();
        j.addComplex();
        j.setImplicitMul(true);
    }
       public double Ecuacion(String s, double n) {
        j.addVariable("x", n);
        j.parseExpression(s);
        if (j.hasError()) {
            System.out.println("Ecuancion no entendible:\n" + j.getErrorInfo());
        }
        return j.getValue();
    }
    public void Lagrange(double x[],double y[],double n) {
        String s,s1;
        double res=0;
        double c[]= new double[x.length];
        for (int j = 0; j <y.length; j++) {
            s="";
            s1="";
             for (int i = 0; i < x.length; i++) {
                 if (i!=j) {
                     s += "(x -" + x[i] + ")";
                     s1+="("+x[j]+" -"+x[i]+")";
                 }
        }
             System.out.println("y:"+y[j]);
             s+=y[j];
             s="("+s+")/("+s1+")";
             System.out.println("s:"+s);
             System.out.println("f:"+Ecuacion(s,n));
             c[j]=Ecuacion(s,n);
        }
        for (int i = 0; i <c.length; i++) {
             res+=c[i]; 
            }
        System.out.println("el resultado de P("+n+") es: "+res);
        ErrorLangrage(x,y,n);
    }
    public void ErrorLangrage(double a[],double b[], double v){
        String s="",er;
        for (int i = 0; i <a.length; i++) {
            s+="(x -"+a[i]+")";
        }
        er="(("+b[b.length-1]+")/(("+a.length+")!))"+s;
        System.out.println("error:"+Ecuacion(er,v));
    }
   
}

