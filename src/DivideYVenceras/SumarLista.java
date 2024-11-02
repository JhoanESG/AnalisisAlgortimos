package DivideYVenceras;

public class SumarLista {

//    Implementar una función que, dada una lista de números enteros, calcule la suma
//    total de sus elementos mediante la división recursiva del arreglo.

    public static void main(String[] args) {
        int [] array = {1,2,3,4,5,6,7,8,9};
        int suma = sumarLista(array, 0, array.length-1);
        System.out.println("La suma de los elementos de la lista es: " + suma);
    }

    public static int sumarLista(int[] array, int start, int end) {
        if (start == end) {
            return array[start];
        }else{
            int middle = (start + end) / 2;
            return sumarLista(array, start, middle) + sumarLista(array, middle + 1, end);
        }
    }


}
