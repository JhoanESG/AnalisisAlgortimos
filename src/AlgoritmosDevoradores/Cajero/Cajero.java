package AlgoritmosDevoradores.Cajero;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cajero {

//    El problema a resolver es suministrar la cantidad de dinero solicitada en billetes usando sólo los
//    tipos de billetes especificados y de manera que el número total de billetes sea mínimo. La
//    cantidad que puede ser cambiada debe ser divisible por 10000. Existe una disponibilidad limitada
//    de cada nominación. Así:

//    Nominacion:         Cantidad:
//    10.000              300
//    20.000              200
//    50.000              100
//    100.000             50

//    La salida debe presentar el número de billetes entregados por cada nominación. Si no hay
//    suficiente cantidad de billetes para entregar el dinero solicitado se le debe informar al usuario.
//    Utilice el Algoritmo Devorador para resolver este problema.


    public static LinkedHashMap<Integer, Integer> bills = new LinkedHashMap<>();

    public static void main(String[] args) {
        bills.put(100000, 50);
        bills.put(50000, 100);
        bills.put(20000, 200);
        bills.put(10000, 300);

        int amount = 4000;
        LinkedHashMap<Integer, Integer> withdrawal = new LinkedHashMap<>();
        calculateWithdrawal(amount, withdrawal);
        boolean possible = isPossibleMakeWithdrawal(withdrawal, amount);
        printWithdrawal(withdrawal, possible);
    }

    //Metodo que calcula la cantidad de billetes para el retiro desde la mayor denominacion hasta la menor
    private static void calculateWithdrawal(int amount, LinkedHashMap<Integer, Integer> withdrawal ){
        Iterator<Integer> denominations = bills.keySet().iterator();

        boolean flag = true;
        int key = denominations.next();
        int aux;
        while (flag) {
            if ((amount - key) >= 0) {
                aux = bills.get(key);
                bills.put(key, aux - 1);
                amount -= key;
                if (!withdrawal.containsKey(key)) {
                    withdrawal.put(key, 1);
                } else {
                    withdrawal.put(key, withdrawal.get(key) + 1);
                }
            } else {
                if (denominations.hasNext()) {
                    key = denominations.next();
                } else {
                    flag = false;
                }
            }
        }
    }

    // Metodo para determinar si es posible realizar el retiro señalado por el cliente
    public static boolean isPossibleMakeWithdrawal(Map<Integer, Integer> mapWithdrawal, int amount){
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : mapWithdrawal.entrySet()) {
            sum += entry.getValue()*entry.getKey();
        }
        //Abreviacion de la decision para saber si el monto del retiro es el mismo del calculado por el cajero
        return sum == amount;
    }

    // Método genérico para imprimir el el retiro, si es posible, o negarlo si no es posible
    public static <K, V> void printWithdrawal(Map<K, V> map, boolean possible) {

        if (!possible) {
            System.out.println("El cajero no puede realizar el retiro");
        } else {
            System.out.println("El cajero le entregara: ");
            for (Map.Entry<K, V> entry : map.entrySet()) {
                System.out.println(entry.getValue() + " billetes de " + entry.getKey());
            }
        }
    }
}