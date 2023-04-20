package ar.utn.ap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Materia prog1 = new Materia("Prog 1");
        Materia prog2 = new Materia("Prog 2");
        Materia mat1 = new Materia("Mat 1");
        Materia mat2 = new Materia("Mat 2");
        Materia algebra = new Materia("Algebra");

        Alumno pepe = new Alumno("Pepe");
        Alumno juan = new Alumno("Juan");

        Map<String,Alumno> repoAlumnos = new HashMap<String,Alumno>();
        repoAlumnos.put("Pepe",pepe);
        repoAlumnos.put("Juan",juan);

        pepe.agregarMateriaAprobada(mat1);
        pepe.agregarMateriaAprobada(prog1);
        //pepe.agregarMateriaAprobada(algebra);
        juan.agregarMateriaAprobada(algebra);

        prog2.agrerarMateria(prog1);
        mat2.agrerarMateria(mat1);
        mat2.agrerarMateria(algebra);

        Map<String,Materia> repoMaterias = new HashMap<String,Materia>();
        repoMaterias.put("Prog 1",prog1);
        repoMaterias.put("Prog 2",prog2);
        repoMaterias.put("Mat 1",mat1);
        repoMaterias.put("Mat 2",mat2);
        repoMaterias.put("Algebra",algebra);

        //String ruta = "C:\\Users\\J.Pintos\\IdeaProjects\\correlativas\\src\\test\\java\\resources\\inscripcionesTest2.csv";
        String ruta = args[0];
        Path archivoInscripciones = Paths.get(ruta);

        try {
            List<String> lineasArch = Files.readAllLines(archivoInscripciones);
            boolean primero = true;
            for (String linea: lineasArch) {
                if(primero){
                    primero = false;
                }else{
                    if (!linea.isBlank()){
                        //Pepe,Prog2 -> String[]{"Pepe","Prog2"}
                        String renglon = procesarLinea(repoAlumnos, repoMaterias, linea);
                        try {
                            escribirRenglon(args, renglon);
                        }catch (IOException e) {
                            System.out.println("Falló escritura de archivo");
                            System.exit(1);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Falló lectura de archivo");
            System.exit(1);
        }

        /*Inscripcion inscr1 = new Inscripcion(juan, prog1);//true
        Inscripcion inscr2 = new Inscripcion(juan, mat2);//false
        Inscripcion inscr3 = new Inscripcion(pepe, mat2);//false

        System.out.println("\nInscr 1");
        System.out.println(inscr1.aprobada());
        System.out.println("\nInscr 2");
        System.out.println(inscr2.aprobada());
        System.out.println("\nInscr 3");
        System.out.println(inscr3.aprobada());*/
    }

    private static void escribirRenglon(String[] args, String renglon) throws IOException {
        String lineToAppend = renglon+"\n";
        byte[] byteArr = lineToAppend.getBytes();
        Files.write(Paths.get(args[1]), byteArr, StandardOpenOption.APPEND);
    }

    private static String procesarLinea(Map<String, Alumno> repoAlumnos, Map<String, Materia> repoMaterias, String linea) {
        //creado con refactor -> Extraer metodo
        String[] split = linea.split(",");
        String nombreAlumno = split[0];
        String nombreMateria = split[1];
        Materia materia = repoMaterias.get(nombreMateria);
        Alumno alumno = repoAlumnos.get(nombreAlumno);
        Inscripcion inscripcion = new Inscripcion(alumno,materia);
        String aprobado = "";
        if(inscripcion.aprobada()){
            aprobado = "Aprobada";
        }else{
            aprobado = "Reprobada";
        }
        String renglon = alumno.getNombre() + " " + materia.getNombre() + " " + aprobado;
        System.out.println(renglon);
        return renglon;
    }
}