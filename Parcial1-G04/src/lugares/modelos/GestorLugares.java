
package lugares.modelos;

import interfaces.IGestorLugares;
import java.util.ArrayList;

public class GestorLugares implements IGestorLugares{
    
    ArrayList<Lugar> lugares = new ArrayList<>();
    public static GestorLugares instancia;
    
    private GestorLugares(){
    };
    
    public static GestorLugares crear(){
        if(instancia == null)
            instancia = new GestorLugares();
        return instancia;
    }
    
    @Override
    public String nuevoLugar(String nombre) {
        
        if(!nombre.isBlank() && nombre != null){
            
            Lugar UnLugar = new Lugar(nombre);
            if(!lugares.contains(UnLugar)){
                lugares.add(UnLugar);
                return LUGAR_EXITO;
            }
            else{
                return LUGAR_REPETIDO;
            }
        }else{
            return LUGAR_NOMBRE_INCORRECTO;
        }
    }

    @Override
    public ArrayList<Lugar> verLugares() {
        return lugares;
    }

    @Override
    public Lugar verLugar(String nombre) {
        
        for(Lugar l : lugares){
            if(l.verNombre().equalsIgnoreCase(nombre)){
                return l;
            }
        }
        return null;
    }
    
}
