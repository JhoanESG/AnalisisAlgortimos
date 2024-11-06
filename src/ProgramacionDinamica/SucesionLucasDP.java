package ProgramacionDinamica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SucesionLucasDP {

    public static void main(String[] args) {
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0,2);
        memo.put(1,1);
        int n = 5;
        int r = calcularLucasMemorizacion(n, memo);
        System.out.println(r);
    }

    public static int calcularLucasMemorizacion(int n, Map<Integer, Integer> memo){
        if(memo.containsKey(n)){
            return memo.get(n);
        }else{
            int valor = calcularLucasMemorizacion(n-1, memo) + calcularLucasMemorizacion(n-2, memo);
            memo.put(n, valor);
            return valor;
        }
    }

    public static int calcularLucasTabulacion(int n){
        List<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(1);
        for (int i = 2; i <= n; i++) {
            arr.add(arr.get(i-1)+arr.get(i-2));
        }
        return arr.get(n);
    }

}
