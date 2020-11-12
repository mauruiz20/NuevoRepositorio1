
package interfaces;

import java.util.ArrayList;
import lugares.modelos.Lugar;

public interface IGestorLugares {
    
    public static final String LUGAR_EXITO = "Se pudo crear el lugar";
    public static final String LUGAR_NOMBRE_INCORRECTO = "No se pudo crear el lugar porque el nombre es incorrecto";
    public static final String LUGAR_REPETIDO = "No se pudo crear el lugar porque ya existe otro con ese nombre";
    
    public String nuevoLugar(String nombre);
    public ArrayList<Lugar> verLugares();
    public Lugar verLugar(String nombre);
}
