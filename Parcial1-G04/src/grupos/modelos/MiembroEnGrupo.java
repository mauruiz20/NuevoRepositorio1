
package grupos.modelos;

import autores.modelos.Autor;
import java.util.Objects;

public class MiembroEnGrupo {
    private Rol unRol;
    private Grupo unGrupo;
    private Autor unAutor;

    public MiembroEnGrupo(Autor unAutor, Grupo unGrupo, Rol unRol) {
        this.unRol = unRol;
        this.unGrupo = unGrupo;
        this.unAutor = unAutor;
    }

    public Rol verUnRol() {
        return unRol;
    }

    public void asignarUnRol(Rol unRol) {
        this.unRol = unRol;
    }

    public Grupo verUnGrupo() {
        return unGrupo;
    }

    public void asignarUnGrupo(Grupo unGrupo) {
        this.unGrupo = unGrupo;
    }

    public Autor verUnAutor() {
        return unAutor;
    }

    public void asignarUnAutor(Autor unAutor) {
        this.unAutor = unAutor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.unAutor);
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
        if (getClass() != obj.getClass()) { //Correccion TP4
            return false;
        }
        final MiembroEnGrupo other = (MiembroEnGrupo) obj;
        if (!Objects.equals(this.unAutor, other.unAutor)) {
            return false;
        }
        return true;
    }

    
    
}
