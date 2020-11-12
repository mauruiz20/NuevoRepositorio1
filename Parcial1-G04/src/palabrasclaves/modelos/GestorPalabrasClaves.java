
package palabrasclaves.modelos;

import interfaces.IGestorPalabrasClaves;
import java.util.ArrayList;

public class GestorPalabrasClaves implements IGestorPalabrasClaves {

    ArrayList<PalabraClave> palabrasClaves = new ArrayList<>();
    public static GestorPalabrasClaves instancia;
    
    private GestorPalabrasClaves(){
    };
    
    public static GestorPalabrasClaves crear(){
        if(instancia == null)
            instancia = new GestorPalabrasClaves();
        return instancia;
    }
    
    @Override
    public String nuevaPalabraClave(String nombre) {
        
        if(!nombre.isBlank() && nombre != null){
            
            PalabraClave UnaPalabraClave = new PalabraClave(nombre);
            if(!palabrasClaves.contains(UnaPalabraClave)){
                palabrasClaves.add(UnaPalabraClave);
                return PALABRACLAVE_EXITO;
            }
            else{
                return PALABRACLAVE_REPETIDO;
            }
        }else{
            return PALABRACLAVE_NOMBRE_INCORRECTO;
        }
    }

    @Override
    public ArrayList<PalabraClave> verPalabrasClaves() {
        return palabrasClaves;
    }

    @Override
    public PalabraClave verPalabraClave(String nombre) {
        
        for(PalabraClave pc : palabrasClaves){
            if(pc.verNombre().equalsIgnoreCase(nombre)){
                return pc;
            }
        }
        return null;
    }
    
}
