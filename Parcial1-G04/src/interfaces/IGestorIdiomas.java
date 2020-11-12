
package interfaces;

import idiomas.modelos.Idioma;
import java.util.ArrayList;

public interface IGestorIdiomas {
    
    public static final String IDIOMA_EXITO = "Se pudo crear el idioma";
    public static final String IDIOMA_NOMBRE_INCORRECTO = "No se pudo crear el idioma porque el nombre es incorrecto";
    public static final String IDIOMA_REPETIDO = "No se pudo crear el idioma porque ya existe otro con ese nombre";
    
    public String nuevoIdioma(String nombre);
    public ArrayList<Idioma> verIdiomas();
    public Idioma verIdioma(String nombre);
}
