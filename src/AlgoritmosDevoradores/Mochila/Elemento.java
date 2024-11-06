package AlgoritmosDevoradores.Mochila;
public class Elemento {

    private String id;
    private int peso;
    private int valor;
    private int cantidad;

    public Elemento(String id, int peso, int valor, int cantidad) {
        this.id = id;
        this.peso = peso;
        this.valor = valor;
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int relacionValorPeso(){
        return valor/peso;
    }

    public String textear() {
        return "Elemento{" +
                "identificador=" + id +
                ", peso=" + peso +
                ", valor=" + valor +
                ", cantidad=" + cantidad +
                '}';
    }
}
