package publicaciones.modelos;

import autores.modelos.Autor;
import grupos.modelos.MiembroEnGrupo;
import idiomas.modelos.Idioma;
import interfaces.IGestorPublicaciones;
import java.time.LocalDate;
import java.util.ArrayList;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.PalabraClave;
import tipos.modelos.Tipo;

public class GestorPublicaciones implements IGestorPublicaciones {

    ArrayList<Publicacion> publicaciones = new ArrayList<>();
    public static GestorPublicaciones instancia;

    private GestorPublicaciones() {
    }

    public static GestorPublicaciones crear() {
        if (instancia == null) {
            instancia = new GestorPublicaciones();
        }
        return instancia;
    }

    @Override
    public String nuevaPublicacion(String titulo, MiembroEnGrupo miembroEnGrupo, LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar, ArrayList<PalabraClave> palabrasClaves, String enlace, String resumen) {

        if (!titulo.isBlank() && titulo != null && miembroEnGrupo != null && fechaPublicacion != null && tipo != null && idioma != null && lugar != null && palabrasClaves != null && !enlace.isBlank() && enlace != null && !resumen.isBlank() && resumen != null) {
            Publicacion unaPublicacion = new Publicacion(titulo, miembroEnGrupo, fechaPublicacion, tipo, idioma, lugar, palabrasClaves, enlace, resumen);

            if (!publicaciones.contains(unaPublicacion)) {
                publicaciones.add(unaPublicacion);
                return PUBLICACION_EXITO;
            }
            return PUBLICACION_REPETIDO;
        }
        return PUBLICACION_DATOS_INCORRECTO;
    }

    @Override
    public String modificarPublicacion(Publicacion publicacion, MiembroEnGrupo miembroEnGrupo, LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar, ArrayList<PalabraClave> palabrasClaves, String enlace, String resumen) {

        for (Publicacion p : publicaciones) {
            if (p.equals(publicacion)) {
                p.asignarMiembro(miembroEnGrupo);
                p.asignarFechaPublicacion(fechaPublicacion);
                p.asignarTipo(tipo);
                p.asginarIdioma(idioma);
                p.asignarLugar(lugar);
                p.asignarPalabrasClaves(palabrasClaves);
                p.asignarEnlace(enlace);
                p.asignarResumen(resumen);
                return PUBLICACION_MODIFICADA;
            }

        }
        return PUBLICACION_DATOS_INCORRECTO;
    }

    @Override
    public boolean hayPublicacionesConEstaPalabraClave(PalabraClave palabraClave) {
        for (Publicacion p : publicaciones) {
            if (p.verPalabrasClaves().contains(palabraClave)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hayPublicacionesConEsteLugar(Lugar lugar) {
        for (Publicacion p : publicaciones) {
            if (p.verLugar().equals(lugar)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hayPublicacionesConEsteIdioma(Idioma idioma) {
        for (Publicacion p : publicaciones) {
            if (p.verIdioma().equals(idioma)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hayPublicacionesConEsteTipo(Tipo tipo) {
        for (Publicacion p : publicaciones) {
            if (p.verTipo().equals(tipo)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hayPublicacionesConEsteAutor(Autor autor) {
        for (Publicacion p : publicaciones) {
            if (p.verAutor().equals(autor)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existeEstaPublicacion(Publicacion publicacion) {
        if (publicaciones.contains(publicacion)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ArrayList<Publicacion> verPublicaciones() {
        return publicaciones;
    }

    @Override
    public Publicacion verPublicacion(String titulo) {
        for(Publicacion p : publicaciones){
            if(p.verTitulo().equalsIgnoreCase(titulo)){
                return p;
            }
        }
        return null;
    }

}
