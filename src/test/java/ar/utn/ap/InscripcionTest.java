package ar.utn.ap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InscripcionTest {
    private Materia prog1;
    private Materia prog2;
    private Alumno alumno;

    @Before
    public void SetUp(){
        prog1 = new Materia("Prog 1");
        prog2 = new Materia("Prog 2");
        alumno = new Alumno("Pepe");
    }

    @Test
    public void TestMatSinCorr(){
        Inscripcion inscripcion = new Inscripcion(alumno, prog1);
        assertTrue(inscripcion.aprobada());
    }

    @Test
    public void TestMatConCorrYAlumConCorrAprob(){
        //Test donde la materia tiene correlativas y el alumno tiene las correlativas aprobadas
        prog2.agrerarMateria(prog1);
        alumno.agregarMateriaAprobada(prog1);
        Inscripcion inscripcion = new Inscripcion(alumno, prog2);
        assertTrue(inscripcion.aprobada());
    }

    @Test
    public void TestMatConCorrYAlumSinCorrAprob(){
        //Test donde la materia tiene correlativas y el alumno NO tiene las correlativas aprobadas
        prog2.agrerarMateria(prog1);
        Inscripcion inscripcion = new Inscripcion(alumno, prog2);
        assertFalse("Falla que la materia tenga correlativas y el alumno no tenga las correlativas aprobadas",
                inscripcion.aprobada());
    }
}