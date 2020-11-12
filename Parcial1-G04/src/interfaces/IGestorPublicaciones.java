
package interfaces;

import autores.modelos.Autor;
import grupos.modelos.MiembroEnGrupo;
import idiomas.modelos.Idioma;
import java.time.LocalDate;
import java.util.ArrayList;
import lugares.modelos.Lugar;
import palabrasclaves.modelos.PalabraClave;
import publicaciones.modelos.Publicacion;
import tipos.modelos.Tipo;

public interface IGestorPublicaciones {
    
    public static final String PUBLICACION_EXITO = "Se pudo crear la publicacion";
    public static final String PUBLICACION_DATOS_INCORRECTO = "No se pudo crear la publicacion porque los datos son incorrectos";
    public static final String PUBLICACION_REPETIDO = "No se pudo crear la publicacion porque ya existe otro con ese titulo";
    public static final String PUBLICACION_MODIFICADA = "Se modifico los datos de la publicacion";
    
    public String nuevaPublicacion(String titulo, MiembroEnGrupo miembroEnGrupo, LocalDate fechaPublicacion, Tipo tipo, Idioma idioma, Lugar lugar,
                                    ArrayList<PalabraClave> palabrasClaves, String enlace, String resumen);

    public String modificarPublicacion(Publicacion publicacion, MiembroEnGrupo miembroEnGrupo, LocalDate fechaPublicacion, Tipo tipo, Idioma idioma,
                                        Lugar lugar, ArrayList<PalabraClave> palabrasClaves, String enlace, String resumen);
    
    public boolean hayPublicacionesConEstaPalabraClave(PalabraClave palabraClave);
    public boolean hayPublicacionesConEsteLugar(Lugar lugar);
    public boolean hayPublicacionesConEsteIdioma(Idioma idioma);
    public boolean hayPublicacionesConEsteTipo(Tipo tipo);
    public boolean hayPublicacionesConEsteAutor(Autor autor);
    public boolean existeEstaPublicacion(Publicacion publicacion);
    public ArrayList<Publicacion> verPublicaciones();
    public Publicacion verPublicacion(String titulo);
}
