
package idiomas.modelos;

import java.util.Objects;

public class Idioma {
    private String nombre;

    public Idioma(String nombre) {
        this.nombre = nombre;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String verNombre() {
        return nombre;
    }
    
    public String toString(){
        return "Idioma: " + nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Idioma other = (Idioma) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
}
