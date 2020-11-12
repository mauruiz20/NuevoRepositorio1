
package interfaces;

import autores.modelos.Alumno;
import autores.modelos.Autor;
import autores.modelos.Cargo;
import autores.modelos.Profesor;
import java.util.ArrayList;

public interface IGestorAutores {
    
    public static final String AUTOR_EXITO = "Se pudo crear el autor";
    public static final String AUTOR_DATOS_INCORRECTOS = "No se pudo crear el autor porque los datos son incorrectos";
    public static final String AUTOR_REPETIDO = "No se pudo crear el autor porque ya existe otro con ese dni";
    public static final String AUTOR_MODIFICADO = "Se modifico los datos del autor";
    
    public String nuevoAutor(int dni, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida);
    public String nuevoAutor(int dni, String apellidos, String nombres, String cx, String clave, String claveRepetida);
    public String modificarAutor(Autor autor, String apellidos, String nombres, Cargo cargo, String clave, String claveRepetida);
    public String modificarAutor(Autor autor, String apellidos, String nombres, String cx, String clave, String claveRepetida);
    public boolean existeEsteAutor(Autor autor);
    public ArrayList<Autor> verAutores();
    public ArrayList<Profesor> verProfesores();
    public ArrayList<Alumno> verAlumnos();
    public Autor verAutor(int dni);
    
}
