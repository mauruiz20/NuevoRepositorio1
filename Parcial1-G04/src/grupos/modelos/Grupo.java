package grupos.modelos;

import autores.modelos.Autor;
import java.util.ArrayList;
import java.util.Objects;

public class Grupo {

    private String nombre;
    private String descripcion;

    private ArrayList<MiembroEnGrupo> miembros = new ArrayList<>();

    public Grupo(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String verNombre() {
        return nombre;
    }

    public void asignarNombre(String nombre) {
        this.nombre = nombre;
    }

    public String verDescripcion() {
        return descripcion;
    }

    public void asignarDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void mostrar() {
        System.out.println("\nGrupo: " + nombre + ", Descripcion: " + descripcion);
        if (this.tieneMiembros()) {
            System.out.println("\t====Miembros====");
            for (MiembroEnGrupo m : miembros) {
                System.out.println("\tAutor: " + m.verUnAutor().verApellidos() + ", " + m.verUnAutor().verNombres() + ", Rol: " + m.verUnRol());
            }
        } else {
            System.out.println("\tNo posee ningun miembro");
        }

    }

    public ArrayList<MiembroEnGrupo> verMiembros() {
        return miembros;
    }

    public void agregarMiembro(Autor autor, Rol rol) {

        if (this.nombre.equalsIgnoreCase("Super Administradores")) {
            rol = Rol.ADMINISTRADOR;
        }

        MiembroEnGrupo NuevoMiembro = new MiembroEnGrupo(autor, this, rol);

        if (!miembros.contains(NuevoMiembro)) {
            miembros.add(NuevoMiembro);

            autor.agregarGrupo(this, rol);

        }
    }

    public void quitarMiembro(Autor miembro) {
        
        MiembroEnGrupo m = new MiembroEnGrupo(miembro, this, Rol.COLABORADOR); //Correccion TP4
        
        if(this.miembros.contains(m)){
            miembros.remove(m);
            miembro.quitarGrupo(this);
        }    
    }

    public boolean esSuperAdministradores() {
        return nombre.equalsIgnoreCase("Super Administradores");
    }

    public boolean tieneMiembros() {
        return !miembros.isEmpty();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.nombre);
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
        final Grupo other = (Grupo) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

}
