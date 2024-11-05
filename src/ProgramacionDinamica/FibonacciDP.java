package ProgramacionDinamica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FibonacciDP {

    public static void main(String[] args) {
        int n = 7;
        int r = fibonacciTabulacion(n);
        System.out.println(r);
    }

    public static int fibonacciMemorizacionV1(int n, Map<Integer, Integer> memo){
        if(n == 1 || n == 0){
            return n;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }else{
            int valorFibo = fibonacciMemorizacionV1(n-1, memo) + fibonacciMemorizacionV1(n-2, memo);
            memo.put(n, valorFibo);
            return valorFibo;
        }
    }

    public static int fibonacciMemorizacionV2(int n){
        ArrayList<Integer> memo = new ArrayList<>();
        memo.add(0);
        memo.add(1);
        return calcularFibo(n, memo, 2);
    }

    private static int calcularFibo(int n, ArrayList<Integer> memo, int index){
        if (n == 0 || n == 1) {
            return n;
        }

        if (n == index) {
            return memo.get(index-1) + memo.get(index-2);
        }else{
            memo.add(memo.get(index-1) + memo.get(index-2));
            return calcularFibo(n, memo, index+1);
        }
    }

    public static int fibonacciTabulacion(int n){
        if (n == 0 || n == 1) {
            return n;
        }

        Map<Integer,Integer> memo = new HashMap<>();
        memo.put(0, 0);
        memo.put(1, 1);
        for (int i = 2; i <= n; i++) {
            memo.put(i, memo.get(i-1)+memo.get(i-2));
        }

        return memo.get(n);
    }
}
