package ar.utn.ap;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String nombre;
    private String legajo;
    private List<Materia>matAprobadas;

    public Alumno(String nombre){
        this.nombre = nombre;
        this.matAprobadas = new ArrayList<Materia>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public List<Materia> getMatAprobadas() {
        return matAprobadas;
    }

    public void agregarMateriaAprobada(Materia materia){
        this.matAprobadas.add(materia);
    }

    public boolean aprobo(Materia materiaX){
        return this.matAprobadas.contains(materiaX);
    }
}