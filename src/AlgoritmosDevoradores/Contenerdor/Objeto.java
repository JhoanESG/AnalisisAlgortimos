package AlgoritmosDevoradores.Contenerdor;

import java.util.Comparator;
import java.util.List;

public class Objeto {

    public String identificador;
    private int cantidad = 0;
    private int peso = 0;
    private int valor = 0;

    public Objeto(String identificador, int cantidad, int peso, int valor) {
        this.identificador = identificador;
        this.cantidad = cantidad;
        this.peso = peso;
        this.valor = valor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Objeto{" +
                "cantidad=" + cantidad +
                ", peso=" + peso +
                ", valor=" + valor +
                '}';
    }
}
