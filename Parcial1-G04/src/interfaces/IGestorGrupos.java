
package interfaces;

import grupos.modelos.Grupo;
import java.util.ArrayList;

public interface IGestorGrupos {
    
    public static final String GRUPO_EXITO = "Se pudo crear el grupo";
    public static final String GRUPO_NOMBRE_INCORRECTO = "No se pudo crear el grupo porque el nombre es incorrecto";
    public static final String GRUPO_REPETIDO = "No se pudo crear el grupo porque ya existe otro con ese nombre";
    public static final String GRUPO_MODIFICADO = "Se modifico la descripcion del grupo";
    
    public String nuevoGrupo(String nombre, String descripcion);
    public String modificarGrupo(Grupo grupo, String descripcion);
    public ArrayList<Grupo> verGrupos();
    public Grupo verGrupo(String nombre);
    public boolean existeEsteGrupo(Grupo grupo);
}
