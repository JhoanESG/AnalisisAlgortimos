package AlgoritmosDevoradores.Contenerdor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Contenedor {

//    Una empresa de exportaciones requiere de una aplicación que permita llenar un container con
//    objetos sin exceder el peso máximo soportado por éste, logrando una maximización de valor. Cada
//    objeto tiene un peso y un valor asociado. Es importante anotar, que los objetos pueden fraccionarse.
//    La aplicación debe:
//
//    • Permitir fijar el peso máximo soportado por el container.
//    • Agregar un número de objetos, con su peso y su valor
//    • Mostrar los objetos seleccionados
//    • Mostrar el valor de la carga
//
//    Por ejemplo, si se tienen los siguientes objetos y un peso máximo de 520 toneladas:

//                  A       B       C       D       E
//    Cantidad      3       2       4       5       3
//    Peso          210     230     150     40      80
//    Valor         15      50      20      55      92

    private static ArrayList<Objeto> objetos = new ArrayList<>();
    private static double [] partes;
    public static void main(String[] args) {
        objetos.add(new Objeto("A",3,210,15));
        objetos.add(new Objeto("B",2,230,50));
        objetos.add(new Objeto("C",4,150,20));
        objetos.add(new Objeto("D",5,40,55));
        objetos.add(new Objeto("E",3,80,92));
        partes = new double[] {1, 0.75, 0.5, 0.25};

        ordenarPorValorDescendente(objetos);

        int pesoContenedor = 520;
        ArrayList<Objeto> objetosEmpacables = new ArrayList<>();

        determinarObjetosEmpacables(objetosEmpacables, pesoContenedor);
    }

    // Método estático para insertar objetos en un ArrayList ordenado por valor
    public static void ordenarPorValorDescendente(List<Objeto> objetos) {
        // Ordenar la lista por valor en orden descendente
        objetos.sort(Comparator.comparingInt(Objeto::getValor).reversed());

    }

    private static  void determinarObjetosEmpacables(ArrayList<Objeto> objetosEmpacables, int pesoContenedor){
        boolean flag = true;
        Objeto iterador = objetos.getFirst();
        int index = 0;

    }

}
