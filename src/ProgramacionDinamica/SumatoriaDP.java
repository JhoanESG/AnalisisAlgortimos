package ProgramacionDinamica;

import java.util.*;

public class SumatoriaDP {

    public static void main(String[] args) {
        int n = 6;
        Map<Integer, Integer> memo = new HashMap<>();
        int r = sumatoriaTabulacionV2(11);
        System.out.println(r);
    }

    public static int sumatoriaMemorizacion(int n, Map<Integer,Integer> memo, int i){
        if (memo.containsKey(n)) {
            return memo.get(n);
        }else{
            if (memo.isEmpty()) {
                memo.put(1,1);
            }
            memo.put(i, memo.get(i-1)+i);
            return sumatoriaMemorizacion(n, memo, i+1);
        }
    }

    public static int sumatoriaTabulacion(int n){
        Map <Integer, Integer> memo = new LinkedHashMap<>();
        memo.put(0,0);
        for (int i = 1; i <= n ; i++) {
            memo.put(i, i + memo.get(i-1));
        }
        return memo.get(n);
    }

    public static int sumatoriaTabulacionV2(int n){
        List <Integer> memo = new ArrayList<>();
        memo.add(0);
        for (int i = 1; i <= n; i++) {
            memo.add(i+memo.get(i-1));
        }
        return memo.get(n);
    }

}
