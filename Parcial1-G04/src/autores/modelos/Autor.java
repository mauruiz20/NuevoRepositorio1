package autores.modelos;

import grupos.modelos.Grupo;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.Rol;
import java.util.ArrayList;

public abstract class Autor {

    private int dni;
    private String apellidos;
    private String nombres;
    private String clave;

    private ArrayList<MiembroEnGrupo> grupos = new ArrayList<>();

    public Autor(int dni, String apellidos, String nombres, String clave) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.clave = clave;
    }

    public int verDni() {
        return dni;
    }

    public void asignarDni(int dni) {
        this.dni = dni;
    }

    public String verApellidos() {
        return apellidos;
    }

    public void asignarApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String verNombres() {
        return nombres;
    }

    public void asignarNombres(String nombres) {
        this.nombres = nombres;
    }

    public String verClave() {
        return clave;
    }

    public void asignarClave(String clave) {
        this.clave = clave;
    }

    public void mostrar() {
        System.out.println("\n[" + dni + "] " + apellidos + ", " + nombres);
        if (!grupos.isEmpty()) {
            System.out.println("\t====Grupos====");
            for (MiembroEnGrupo m : grupos) {
                System.out.println("\tGrupo: " + m.verUnGrupo().verNombre() + ", Rol: " + m.verUnRol());
            }
        } else {
            System.out.println("\tNo pertenece a ningun grupo");
        }
    }

    public ArrayList verGrupos() {
        return grupos;
    }

    public void agregarGrupo(Grupo grupo, Rol rol) {

        MiembroEnGrupo NuevoGrupo = new MiembroEnGrupo(this, grupo, rol);
        int bandera = 0;

        if (grupos.isEmpty()) {
            grupos.add(NuevoGrupo);
            grupo.agregarMiembro(this, rol);
        } else {

            for (MiembroEnGrupo m : grupos) {
                if (m.verUnGrupo().equals(grupo)) {
                    bandera = 1;
                }
            }
            if (bandera == 0) {
                grupos.add(NuevoGrupo);
                if (!grupo.verMiembros().contains(NuevoGrupo)) {
                    grupo.agregarMiembro(this, rol);
                }
            }

        }

    }

    public void quitarGrupo(Grupo grupo) {

        MiembroEnGrupo m = new MiembroEnGrupo(this, grupo, Rol.COLABORADOR); //Correccion TP4
        
        if(this.grupos.contains(m)){
            grupos.remove(m);
            grupo.quitarMiembro(this);
        }
    }

    public boolean esSuperAdministrador() {

        for (MiembroEnGrupo m : grupos) {
            if (m.verUnGrupo().esSuperAdministradores()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.dni;
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
        if (getClass().getSuperclass() != obj.getClass().getSuperclass()) {
            return false;
        }
        final Autor other = (Autor) obj;
        if (this.dni != other.dni) {
            return false;
        }
        return true;
    }

}
