package AlgoritmosDevoradores.Mochila;

import java.util.*;
import java.util.concurrent.ExecutionException;

public class Mochila {

    public static void main(String[] args) {

        ArrayList <Elemento> elementos = new ArrayList<>();

        elementos.add(new Elemento("A", 210,15,3));
        elementos.add(new Elemento("B",230,50,2));
        elementos.add(new Elemento("C",150,20,4));
        elementos.add(new Elemento("D",40,55,5));
        elementos.add(new Elemento("E",80,92,3));

        int pesoMaximo = 400;
        List <Elemento> mochila = new ArrayList<>();

        String heuristica = "RelacionPesoValor";

        switch (heuristica){
            case "MayorValor":
                mochila = llenarMochilaValor(pesoMaximo, elementos);
                break;
            case "MenorPeso":
                mochila = llenarMochilaMenorPeso(pesoMaximo, elementos);
                break;
            case "RelacionPesoValor":
                mochila = llenarMochilaRelacionPesoValor(pesoMaximo, elementos);
                break;
        }

        mostrarMochila(mochila);
    }

    public static List<Elemento> llenarMochilaValor(int pesoMaximo, List<Elemento> elementos){
        List<Elemento> seleccionados = new ArrayList<>();
        elementos.sort(Comparator.comparing(Elemento::getValor).reversed());
        for (Elemento elemento:elementos){
            int aux = pesoMaximo/elemento.getPeso();
            if( aux > 0 && elemento.getCantidad() > 0 ){
                int cantidad = Math.min(aux, elemento.getCantidad());
                seleccionados.add(new Elemento(elemento.getId(), elemento.getPeso(), elemento.getValor(), cantidad));
                elemento.setCantidad(elemento.getCantidad()-cantidad);
                pesoMaximo = pesoMaximo - (cantidad* elemento.getPeso());
            }
        }
        return seleccionados;
    }

    public static List<Elemento> llenarMochilaMenorPeso(int pesoMaximo, List<Elemento> elementos){
        List<Elemento> seleccionados = new ArrayList<>();
        elementos.sort(Comparator.comparing(Elemento::getPeso));
        for(Elemento elemento:elementos){
            int aux = pesoMaximo/elemento.getPeso();
            if (aux > 0 && elemento.getCantidad() > 0) {
                int cantidad = Math.min(aux, elemento.getCantidad());
                seleccionados.add(new Elemento(elemento.getId(), elemento.getPeso(), elemento.getValor(), cantidad));
                elemento.setCantidad(elemento.getCantidad()-cantidad);
                pesoMaximo = pesoMaximo - (elemento.getPeso() * cantidad);
            }
        }
        return seleccionados;
    }

    public static List<Elemento> llenarMochilaRelacionPesoValor(int pesoMaximo, List<Elemento> elementos){
        List<Elemento> seleccionados = new ArrayList<>();
        elementos.sort(Comparator.comparing(Elemento::relacionValorPeso).reversed());
        for (Elemento elemento:elementos){
            int aux = pesoMaximo/elemento.getPeso();
            if (aux > 0 && elemento.getCantidad() > 0) {
                int cantidad = Math.min(aux, elemento.getCantidad());
                seleccionados.add(new Elemento(elemento.getId(), elemento.getPeso(), elemento.getValor(),cantidad));
                elemento.setCantidad(elemento.getCantidad()-cantidad);
                pesoMaximo = pesoMaximo - (elemento.getPeso() * cantidad);
            }
        }
        return seleccionados;
    }

    public static void mostrarMochila(List<Elemento> mochila){
        int valorTotal = 0, pesoTotal = 0;
        for(Elemento elemento:mochila){
            System.out.println(elemento.textear());
            valorTotal += elemento.getValor() * elemento.getCantidad();
            pesoTotal += elemento.getPeso() * elemento.getCantidad();
        }
        System.out.println("El valor total de la mochila es: " + valorTotal + "\n" +
                "El peso total de la mochila es: " + pesoTotal);
    }

}
