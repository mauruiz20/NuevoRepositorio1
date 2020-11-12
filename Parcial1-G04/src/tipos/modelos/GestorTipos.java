
package tipos.modelos;

import interfaces.IGestorTipos;
import java.util.ArrayList;

public class GestorTipos implements IGestorTipos{

    private ArrayList<Tipo> tipos = new ArrayList<>();
    private static GestorTipos instancia;
    
    private GestorTipos(){
    }
    
    public static GestorTipos crear(){
        if(instancia == null)
            instancia = new GestorTipos();
        return instancia;
    }
    
    @Override
    public String nuevoTipo(String nombre) {
        if((!nombre.isBlank()) && (nombre != null)){
            
            Tipo unTipo = new Tipo(nombre);
            
            if(!tipos.contains(unTipo)){
                tipos.add(unTipo);  
                return TIPO_EXITO;
            }
            else{
                return TIPO_REPETIDO;
            }
                       
        }else {
            return TIPO_NOMBRE_INCORRECTO;
        }
    }

    @Override
    public ArrayList<Tipo> verTipos() {
        return tipos;
    }

    @Override
    public Tipo verTipo(String nombre) {
        
        for(Tipo t : tipos){
            if(t.verNombre().equalsIgnoreCase(nombre)){
                return t;
            }
        }
        return null;
    }
    
}
