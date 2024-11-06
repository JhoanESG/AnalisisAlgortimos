package ProgramacionDinamica;

public class Misterio {

    public static void main(String[] args) {
        int [][] matriz = misterio(10,4);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j]+"   ");
            }
            System.out.println();
        }
    }

    public static int[][] misterio (int n, int k){
        int[][] memo = new int[n+1][k+1];
        for (int i = 0; i <=n; i++){
            for (int j = 0; j <= Math.min(i,k);j++){
                calcular(memo, i, j);

            }
        }
        return memo;
    }

    private static int calcular(int[][]memo, int i, int j){
        if (j==0) return memo[i][j] = 3*i;
        else
            if (j==i)  return memo[i][j] = (int) Math.pow(i,j);


        if (memo[i][j]!=0){
            return memo[i][j];
        }

        memo[i][j] = calcular(memo, i-1,j-1) + 4 * calcular(memo, i, j-1);
        return memo[i][j];
    }



}
