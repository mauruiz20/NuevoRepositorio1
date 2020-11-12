package autores.modelos;

import interfaces.IGestorAutores;
import java.util.ArrayList;

public class GestorAutores implements IGestorAutores {

    ArrayList<Autor> autores = new ArrayList<>();
    ArrayList<Profesor> profesores = new ArrayList<>();
    ArrayList<Alumno> alumnos = new ArrayList<>();
    public static GestorAutores instancia;

    private GestorAutores() {
    }

    public static GestorAutores crear() {
        if (instancia == null) {
            instancia = new GestorAutores();
        }
        return instancia;
    }

    @Override
    public String nuevoAutor(int dni, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida) {

        if (!apellidos.isBlank() && apellidos != null && !nombres.isBlank() && nombres != null && cargo != null) {

            Autor unProfesor = new Profesor(dni, apellidos, nombres, clave, cargo);
            if (!autores.contains(unProfesor)) {
                autores.add(unProfesor);
                profesores.add((Profesor) unProfesor);
                return AUTOR_EXITO;
            } else {
                return AUTOR_REPETIDO;
            }
        } else {
            return AUTOR_DATOS_INCORRECTOS;
        }
    }

    @Override
    public String nuevoAutor(int dni, String apellidos, String nombres, String cx, String clave, String claveRepetida) {

        if (!apellidos.isBlank() && apellidos != null && !nombres.isBlank() && nombres != null && cx != null) {

            Autor unAlumno = new Alumno(dni, apellidos, nombres, clave, cx);
            if (!autores.contains(unAlumno)) {
                autores.add(unAlumno);
                alumnos.add((Alumno) unAlumno);
                return AUTOR_EXITO;
            } else {
                return AUTOR_REPETIDO;
            }
        } else {
            return AUTOR_DATOS_INCORRECTOS;
        }
    }

    @Override
    public String modificarAutor(Autor autor, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida) {

        for (Autor a : autores) {
            for (Profesor p : profesores) {
                if (a.equals(p)) {
                    if (a.equals(autor)) {
                        if (!apellidos.isBlank() && apellidos != null && !nombres.isBlank() && nombres != null && cargo != null) {
                            p.asignarNombres(nombres);
                            p.asignarApellidos(apellidos);
                            p.asginarCargo(cargo);
                            p.asignarClave(clave);
                            a.asignarApellidos(apellidos);
                            a.asignarNombres(nombres);
                            a.asignarClave(clave);

                            return AUTOR_MODIFICADO;
                        }
                    }
                }
            }
        }
        return AUTOR_DATOS_INCORRECTOS;
    }

    @Override
    public String modificarAutor(Autor autor, String apellidos, String nombres, String cx, String clave, String claveRepetida) {

        for (Autor a : autores) {
            for (Alumno al : alumnos) {
                if (al.equals(a)) {
                    if (a.equals(autor)) {
                        if (!apellidos.isBlank() && apellidos != null && !nombres.isBlank() && nombres != null && cx != null) {
                            al.asignarNombres(nombres);
                            al.asignarApellidos(apellidos);
                            al.asignarCx(cx);
                            al.asignarClave(clave);
                            a.asignarApellidos(apellidos);
                            a.asignarNombres(nombres);
                            a.asignarClave(clave);
                            
                            return AUTOR_MODIFICADO;
                        }
                    }
                }
            }
        }
        return AUTOR_DATOS_INCORRECTOS;
    }

    @Override
    public boolean existeEsteAutor(Autor autor) {
        if (autores.contains(autor)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<Autor> verAutores() {
        return autores;
    }

    @Override
    public ArrayList<Profesor> verProfesores() {
        return profesores;
    }

    @Override
    public ArrayList<Alumno> verAlumnos() {
        return alumnos;
    }

    @Override
    public Autor verAutor(int dni) {

        for (Autor a : autores) {
            if (a.verDni() == dni) {
                return a;
            }
        }
        return null;
    }
}
