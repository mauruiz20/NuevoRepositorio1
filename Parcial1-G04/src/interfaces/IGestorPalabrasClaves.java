
package interfaces;

import java.util.ArrayList;
import palabrasclaves.modelos.PalabraClave;

public interface IGestorPalabrasClaves {
    
    public static final String PALABRACLAVE_EXITO = "Se pudo crear la palabra clave";
    public static final String PALABRACLAVE_NOMBRE_INCORRECTO = "No se pudo crear la palabra clave porque el nombre es incorrecto";
    public static final String PALABRACLAVE_REPETIDO = "No se pudo crear la palabra clave porque ya existe otro con ese nombre";
    
    public String nuevaPalabraClave(String nombre);
    public ArrayList<PalabraClave> verPalabrasClaves();
    public PalabraClave verPalabraClave(String nombre);
}
