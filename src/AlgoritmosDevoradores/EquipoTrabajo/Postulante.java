package AlgoritmosDevoradores.EquipoTrabajo;

public class Postulante {

    private String nombre;
    private int salario;
    private int conocimiento;

    public Postulante(String nombre, int salario, int conocimiento) {
        this.nombre = nombre;
        this.salario = salario;
        this.conocimiento = conocimiento;
    }

    public int relacionConocimientoSalario(){
        return salario/conocimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getConocimiento() {
        return conocimiento;
    }

    public void setConocimiento(int conocimiento) {
        this.conocimiento = conocimiento;
    }

    @Override
    public String toString() {
        return "Postulante{" +
                "nombre='" + nombre + '\'' +
                ", salario=" + salario +
                ", conocimiento=" + conocimiento +
                '}';
    }
}
