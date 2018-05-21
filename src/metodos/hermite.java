package metodos;

public class hermite {

    Polynomial p = new Polynomial();

    public hermite() {
    }

    public void Hermite(double x[], double y[], String funcion) {
        String pol = "", sal = "";
        double nx[], Derivada[] = {1};
        int co = 0, con = 1;
        for (int i = 1; i < x.length; i++) {
            if (x[i] != x[i - 1]) {
                co++;
            }
        }
        nx = new double[2 * (co + 1)];
        co=2 * (co + 1)-1;
        for (int i = 1; i < x.length; i++) {
            con=1;
            if (i != 1) {
                if (x[i] != x[i - 1]) {
                        nx[co] = x[i];
                        co--;
                } else {
                    for (int j = i; j <x.length; j++) {
                        if (x[j]==x[j-1]) {
                            con++;
                        }else{
                            break;
                        }
                    }
                    nx[co]=con;
                    co--;
                    i+=con-2;
                }
            } else {
                nx[co] = x[i - 1];
                    co--;
                    for (int j = 1; j <x.length; j++) {
                        if (x[j]==x[j-1]) {
                            con++;
                        }else{
                            break;
                        }
                    }
                    nx[co]=con;
                    co--;
                    i+=con-2;
            }
        }
        con=0;
        for (int i = 0; i <nx.length; i++) {
            if (i%2==0) {
                con+=nx[i]-1;
            }
        }
        Derivada= new double[con+(nx.length)/2];
        //con este metodo se ordena todo lo de los numeros repetidos
        co=0;
        con=0;
        for (int i = 0; i <(nx.length)/2; i++) {
            double burbuja=nx[i];
            nx[i]=nx[nx.length-1-i];
            nx[nx.length-1-i]=burbuja;
        }
        for (int i = 0; i <nx.length; i++) {
            if (i%2==0) {
                Derivada[co]=nx[i];
                co+=(int) nx[i+1];
            }
        }
        for (int i = 0; i <Derivada.length; i++) {
            System.out.println("der: "+Derivada[i]);
        }
        //lenando x, y
//        Object matriz[][] = new Object[x.length][x.length + 1];
//        for (int i = 0; i < x.length; i++) {
//            matriz[i][0] = x[i];
//            matriz[i][1] = y[i];
//        }
//        //llendando matriz
//        int cn = 2;
//        if (!funcion.equals("")) {
//            for (int i = 1; i < x.length + 1; i++, cn++) {
//            for (int j = 1; j < x.length; j++) {
//                if (i == 1) {
//                    if ((((double) matriz[j][cn - 1] - (double) matriz[j - 1][cn - 1]))==0 && (Double.parseDouble("" + x[j]) - Double.parseDouble("" + x[j - 1]))==0) {
//                        matriz[j][cn]=Derivada[0];
//                        System.out.println("hola");
//                    }else{
//                        matriz[j][cn] = (((double) matriz[j][cn - 1] - (double) matriz[j - 1][cn - 1])) / (Double.parseDouble("" + x[j]) - Double.parseDouble("" + x[j - 1]));                        
//                    }
//                } else {
//                    int o = j + i - 1;
//                    if (o < x.length) {
//                         if ((((double) matriz[o][cn - 1] - (double) matriz[o - 1][cn - 1]))==0 && (Double.parseDouble("" + x[o]) - Double.parseDouble("" + x[o - 1]))==0) {
//                             matriz[j][cn]=Derivada[0];
//                             System.out.println("hola");
//                        }else{
//                             matriz[o][cn] = (((double) matriz[o][cn - 1] - (double) matriz[o - 1][cn - 1])) / (Double.parseDouble("" + x[o]) - Double.parseDouble("" + x[o - i]));
//                         }
//                    }
//                }
//            }
//        }
//        }
//        //imprimiendo matriz
//        for (int s = 0; s < x.length; s++) {
//            for (int j = 0; j < x.length + 1; j++) {
//                if (matriz[s][j] != null) {
//                    System.out.print(matriz[s][j] + " |\t");
//                }
//            }
//            System.out.println("");
//        }

    }
}
