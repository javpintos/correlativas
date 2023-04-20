package ar.utn.ap;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private String nombre;
    private List<Materia> correlativas;

    public Materia (String nombre){
        this.nombre = nombre;
        this.correlativas = new ArrayList<Materia>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Materia> getCorrelativas() {
        return correlativas;
    }

    public void agrerarMateria(Materia mat){
        this.correlativas.add(mat);
    }

    public boolean puedeCursar(Alumno alumno){
        //ToDo
        return false;
    }
}
