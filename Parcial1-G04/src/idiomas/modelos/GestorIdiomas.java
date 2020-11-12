
package idiomas.modelos;

import interfaces.IGestorIdiomas;
import java.util.ArrayList;

public class GestorIdiomas implements IGestorIdiomas{
    
    ArrayList<Idioma> idiomas = new ArrayList<>();
    public static GestorIdiomas instancia;
    
    private GestorIdiomas(){
    }
    
    public static GestorIdiomas crear(){
        if(instancia == null)
            instancia = new GestorIdiomas();
        return instancia;
    }
    
    @Override
    public String nuevoIdioma(String nombre) {
        
        if(!nombre.isBlank() && nombre != null){
            
            Idioma unIdioma = new Idioma(nombre);
            if(!idiomas.contains(unIdioma)){
                idiomas.add(unIdioma);
                return IDIOMA_EXITO;
            }
            else{
                return IDIOMA_REPETIDO;
            }
        }else{
            return IDIOMA_NOMBRE_INCORRECTO;
        }
    }

    @Override
    public ArrayList<Idioma> verIdiomas() {
        return idiomas;
    }

    @Override
    public Idioma verIdioma(String nombre) {
        
        for(Idioma i : idiomas){
            if(i.verNombre().equalsIgnoreCase(nombre)){
                return i;
            }
        }
        return null;
    }
}
