
package interfaces;

import java.util.ArrayList;
import tipos.modelos.Tipo;

public interface IGestorTipos {
    
    public static final String TIPO_EXITO = "Se pudo crear el tipo";
    public static final String TIPO_NOMBRE_INCORRECTO = "No se pudo crear el tipo porque el nombre es incorrecto";
    public static final String TIPO_REPETIDO = "No se pudo crear el tipo porque ya existe otro con ese nombre";
    
    public String nuevoTipo(String nombre);
    public ArrayList<Tipo> verTipos();
    public Tipo verTipo(String nombre);
}
