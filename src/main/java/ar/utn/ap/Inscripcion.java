package ar.utn.ap;

import java.time.LocalDateTime;

public class Inscripcion {
    private Alumno alumno;
    private Materia materia;
    private LocalDateTime fecha;

    public Inscripcion(Alumno alumno, Materia materia){
        this.alumno = alumno;
        this.materia = materia;
        this.fecha = LocalDateTime.now();
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public boolean aprobada(){
        //ToDo
        //System.out.println(this.materia.getNombre());
        //System.out.println(this.alumno.getNombre());
        //this.materia.getCorrelativas();
        //this.alumno.getMatAprobadas();

        //Progr1
        //Mat1, Algebra
        //Pepe Mat1
        boolean aprobo = true;
        for (Materia matCorr:this.materia.getCorrelativas()) {
            boolean aproboCorrelativa = this.alumno.aprobo(matCorr);
            if(!aproboCorrelativa){
                aprobo = false;
            }
        }
        return aprobo;
    }
}
