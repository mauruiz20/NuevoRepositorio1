
package grupos.modelos;

import interfaces.IGestorGrupos;
import java.util.ArrayList;

public class GestorGrupos implements IGestorGrupos{
    
    ArrayList<Grupo> grupos = new ArrayList<>();
    public static GestorGrupos instancia;
    
    private GestorGrupos(){
    }
    public static GestorGrupos crear(){
        if(instancia == null)
            instancia = new GestorGrupos();
        return instancia;
    }
    
    public String nuevoGrupo(String nombre, String descripcion){
        
        if(!nombre.isBlank() && nombre != null){
            
            Grupo unGrupo = new Grupo(nombre,descripcion);
            if(!grupos.contains(unGrupo)){
                grupos.add(unGrupo);
                return GRUPO_EXITO;
            }
            else{
                return GRUPO_REPETIDO;
            }
        }else{
            return GRUPO_NOMBRE_INCORRECTO;
        }
    }
    public String modificarGrupo(Grupo grupo, String descripcion){
        
        for(Grupo g : grupos){
            if(g.equals(grupo)){
                g.asignarDescripcion(descripcion);
                return GRUPO_MODIFICADO;
            }
        }
        return GRUPO_NOMBRE_INCORRECTO;
    }
    public ArrayList<Grupo> verGrupos(){
        return grupos;
    }
    public Grupo verGrupo(String nombre){
        
        for(Grupo g : grupos){
            if(g.verNombre().equalsIgnoreCase(nombre)){
                return g;
            }
        }
        return null;
    }
    public boolean existeEsteGrupo(Grupo grupo){
        if(grupos.contains(grupo)){
            return true;
        }else{
            return false;
        }
    }
}
