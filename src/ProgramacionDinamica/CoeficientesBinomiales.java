package ProgramacionDinamica;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoeficientesBinomiales {

    Map<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        int n = 5;
//        int [][] coe = calcularCoeficientesTabulacionTaller(n);
//        for (int i = 0; i < coe.length; i++) {
//            for (int j = 0; j <= i; j++) {
//                System.out.print(coe[i][j]);
//            }
//            System.out.println("\n");
//        }

        int [][] permutacion = permutacion(3,2);

        for (int i = 0; i < permutacion.length; i++) {
            for (int j = 0; j < permutacion[0].length; j++) {
                System.out.print(permutacion[i][j]);
            }
            System.out.println("\n");
        }
    }

    public static int [][] calcularCoeficientesTabulacion(int n){
        int [][] tablaCoeficientes = new int[n+1][n+1];
        for (int i = 0; i <= n ; i++) {
            tablaCoeficientes [i][0] = 1;
            tablaCoeficientes [i][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                tablaCoeficientes [i][j] = tablaCoeficientes[i-1][j-1] + tablaCoeficientes[i-1][j];
            }
        }
        return tablaCoeficientes;
    }



    public static int [][] calcularCoeficientesTabulacionTaller(int n){
        int [][] tablaCoeficientes = new int[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            tablaCoeficientes[i][0] = 4;
            tablaCoeficientes[i][i] = 4;
        }

        for (int i = 2; i <= n ; i++) {
            for (int j = 1; j < i; j++) {
                tablaCoeficientes[i][j] = tablaCoeficientes[i][j-1] + tablaCoeficientes[i-1][j];
            }
        }
        return tablaCoeficientes;
    }

    public static int[][] permutacion(int n, int k){

        int[][] c = new int[n+1][k+1];
        int i, j;
        for (i = 0; i <= n; i++){
            for (j = 0; j <= Math.min(i, k); j++){
                if (j == 0) {
                    c[i][j] = 1;
                }else{
                    c[i][j] = c[i-1][j] + j * c[i-1][j-1];
                }
            }
        }
        return c;
    }

}
