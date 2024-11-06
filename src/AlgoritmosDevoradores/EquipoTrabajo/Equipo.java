package AlgoritmosDevoradores.EquipoTrabajo;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Equipo {

    public static void main(String[] args) {
        List<Postulante> postulantes = new ArrayList<>();
        postulantes.add(new Postulante("Juan", 20,5));
        postulantes.add(new Postulante("Andrew",9,3));
        postulantes.add(new Postulante("Mary",7,5));
        postulantes.add(new Postulante("Ada",8,2));
        postulantes.add(new Postulante("Steve",15,4));
        postulantes.add(new Postulante("Grace",17,3));
        postulantes.add(new Postulante("Richard",13,4));
        postulantes.add(new Postulante("William",10,3));

        int presupuesto = 70;

        List<Postulante> equipo = construirEquipo(presupuesto, postulantes);
        mostrarEquipo(equipo);
    }

    public static List<Postulante> construirEquipo(int presupuesto, List<Postulante> postulantes){
        List<Postulante> equipo = new ArrayList<>();
        postulantes.sort(Comparator.comparing(Postulante::relacionConocimientoSalario));
        for(Postulante postulante: postulantes){
            if ((presupuesto-postulante.getSalario()) >= 0 ){
                equipo.add(postulante);
                presupuesto = presupuesto - postulante.getSalario();
            }
        }
        return equipo;
    }

    public static void mostrarEquipo(List<Postulante> equipo){
        for(Postulante postulante:equipo){
            System.out.println(postulante.toString());
        }
    }
}
