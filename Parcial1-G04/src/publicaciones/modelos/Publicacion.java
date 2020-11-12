package publicaciones.modelos;

import autores.modelos.Autor;
import grupos.modelos.MiembroEnGrupo;
import idiomas.modelos.Idioma;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.PalabraClave;
import tipos.modelos.Tipo;


public class Publicacion {

    private String titulo;
    private LocalDate fechaPublicacion;
    private String enlace;
    private String resumen;
    private Autor autor;
    private Tipo unTipo;
    private Idioma unIdioma;
    private Lugar unLugar;
    private ArrayList<PalabraClave> PalabrasClaves;

    private MiembroEnGrupo unMiembro;

    public Publicacion(String titulo, MiembroEnGrupo unMiembro, LocalDate fechaPublicacion, Tipo unTipo,
            Idioma unIdioma, Lugar unLugar, ArrayList<PalabraClave> PalabrasClaves,
            String enlace, String resumen
    ) {
        this.titulo = titulo;
        this.fechaPublicacion = fechaPublicacion;
        this.enlace = enlace;
        this.resumen = resumen;
        this.unTipo = unTipo;
        this.unIdioma = unIdioma;
        this.unLugar = unLugar;
        this.PalabrasClaves = PalabrasClaves;
        this.unMiembro = unMiembro;
    }

    public void mostrar() {
        System.out.println("");
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + unMiembro.verUnAutor().verApellidos() + ", " + unMiembro.verUnAutor().verNombres());
        System.out.println("Grupo: " + unMiembro.verUnGrupo().verNombre());
        System.out.println("Rol: " + unMiembro.verUnRol());
        System.out.println("Fecha de publicacion: " + fechaPublicacion.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println(unTipo);
        System.out.println(unIdioma);
        System.out.println(unLugar);
        System.out.println("Palabras claves");
        System.out.println("------------");
        for (PalabraClave r : PalabrasClaves) {
            System.out.println("\t" + r);
        }
        System.out.println("Enlace: " + enlace);
        System.out.println("Resumen: " + resumen);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.titulo);
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
        final Publicacion other = (Publicacion) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return true;
    }

    public String verTitulo() {
        return titulo;
    }

    public void asignarTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate verFechaPublicacion() {
        return fechaPublicacion;
    }

    public void asignarFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String verEnlace() {
        return enlace;
    }

    public void asignarEnlace(String enlace) {
        this.enlace = enlace;
    }

    public String verResumen() {
        return resumen;
    }

    public void asignarResumen(String resumen) {
        this.resumen = resumen;
    }

    public Autor verAutor() {
        return autor;
    }

    public void asignarAutor(Autor autor) {
        this.autor = autor;
    }

    public Tipo verTipo() {
        return unTipo;
    }

    public void asignarTipo(Tipo unTipo) {
        this.unTipo = unTipo;
    }

    public Idioma verIdioma() {
        return unIdioma;
    }

    public void asginarIdioma(Idioma unIdioma) {
        this.unIdioma = unIdioma;
    }

    public Lugar verLugar() {
        return unLugar;
    }

    public void asignarLugar(Lugar unLugar) {
        this.unLugar = unLugar;
    }

    public ArrayList<PalabraClave> verPalabrasClaves() {
        return PalabrasClaves;
    }

    public void asignarPalabrasClaves(ArrayList<PalabraClave> PalabrasClaves) {
        this.PalabrasClaves = PalabrasClaves;
    }

    public MiembroEnGrupo verMiembro() {
        return unMiembro;
    }

    public void asignarMiembro(MiembroEnGrupo unMiembro) {
        this.unMiembro = unMiembro;
    }
    
    
}
