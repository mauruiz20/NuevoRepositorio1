package principal.controladores;

import autores.modelos.Cargo;
import autores.modelos.GestorAutores;
import grupos.modelos.GestorGrupos;
import grupos.modelos.MiembroEnGrupo;
import grupos.modelos.Rol;
import idiomas.modelos.GestorIdiomas;
import interfaces.IGestorAutores;
import interfaces.IGestorGrupos;
import interfaces.IGestorIdiomas;
import interfaces.IGestorLugares;
import interfaces.IGestorPalabrasClaves;
import interfaces.IGestorPublicaciones;
import interfaces.IGestorTipos;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import lugares.modelos.GestorLugares;
import palabrasclaves.modelos.GestorPalabrasClaves;
import publicaciones.modelos.GestorPublicaciones;
import tipos.modelos.GestorTipos;

public class ControladorPrincipal {

    public static void main(String[] args) {
        
        System.out.println("\nTipos:");
        IGestorTipos gt = GestorTipos.crear();
        System.out.println(gt.nuevoTipo("Tipo 1"));
        System.out.println(gt.nuevoTipo("Tipo 1"));
        System.out.println(gt.nuevoTipo("Tipo 2"));
        System.out.println(gt.verTipo("tipo 2"));
        
        System.out.println("\nPalabrasClaves:");
        IGestorPalabrasClaves gpc = GestorPalabrasClaves.crear();
        System.out.println(gpc.nuevaPalabraClave("PalabraClave 1"));
        System.out.println(gpc.nuevaPalabraClave("PalabraClave 1"));
        System.out.println(gpc.nuevaPalabraClave("PalabraClave 2"));
        System.out.println(gpc.verPalabraClave("palabraclave 2"));
        
        System.out.println("\nLugares: ");
        IGestorLugares gl = GestorLugares.crear();
        System.out.println(gl.nuevoLugar("Lugar 1"));
        System.out.println(gl.nuevoLugar("Lugar 1"));
        System.out.println(gl.nuevoLugar("Lugar 2"));
        System.out.println(gl.verLugar("lugar 2"));
        
        System.out.println("\nIdiomas: ");
        IGestorIdiomas gi = GestorIdiomas.crear();
        System.out.println(gi.nuevoIdioma("Idioma 1"));
        System.out.println(gi.nuevoIdioma("Idioma 1"));
        System.out.println(gi.nuevoIdioma("Idioma 2"));
        System.out.println(gi.verIdioma("Idioma 2"));
        
        System.out.println("\nGrupos: ");
        IGestorGrupos gg = GestorGrupos.crear();
        System.out.println(gg.nuevoGrupo("Grupo 1", "Descripcion 1"));
        System.out.println(gg.nuevoGrupo("Grupo 1", "Descripcion 2"));
        System.out.println(gg.nuevoGrupo("Grupo 2", "Descripcion 2"));
        gg.verGrupo("Grupo 2").mostrar();
        
        System.out.println("\nAutores: ");
        IGestorAutores ga = GestorAutores.crear();
        System.out.println(ga.nuevoAutor(1, "Apellidos 1", "Nombres 1", Cargo.ADG, "Clave 1", "ClaveRepetida 1"));
        System.out.println(ga.nuevoAutor(1, "Apellidos 2", "Nombres 2", "CX 2", "Clave 2", "ClaveRepetida 2"));
        System.out.println(ga.nuevoAutor(1, "Apellidos 3", "Nombres 3", Cargo.TITULAR, "Clave 3", "ClaveRepetida 3"));
        System.out.println(ga.nuevoAutor(2, "Apellidos 4", "Nombres 4", Cargo.ASOCIADO, "Clave 4", "ClaveRepetida 4"));
        System.out.println(ga.nuevoAutor(3, "Apellidos 5", "Nombres 5", "CX 5", "Clave 5", "ClaveRepetida 5"));
        ga.verAutor(1).mostrar();
        ga.verAutor(2).mostrar();
        ga.verAutor(3).mostrar();
      
        LocalDate fecha1 = LocalDate.parse("2020-01-01");
        LocalDate fecha2 = LocalDate.now();
        
        System.out.println("\nPublicaciones: ");
        IGestorPublicaciones gp = GestorPublicaciones.crear();
        System.out.println(gp.nuevaPublicacion("Titulo 1", new MiembroEnGrupo(ga.verAutores().get(0), gg.verGrupos().get(0), Rol.ADMINISTRADOR), fecha1, gt.verTipos().get(0), gi.verIdiomas().get(0), gl.verLugares().get(0), gpc.verPalabrasClaves(), "Enlace 1", "Resumen 1"));
        System.out.println(gp.nuevaPublicacion("Titulo 1", new MiembroEnGrupo(ga.verAutores().get(0), gg.verGrupos().get(0), Rol.ADMINISTRADOR), fecha1, gt.verTipos().get(0), gi.verIdiomas().get(0), gl.verLugares().get(0), gpc.verPalabrasClaves(), "Enlace 1", "Resumen 1"));
        System.out.println(gp.nuevaPublicacion("Titulo 2", new MiembroEnGrupo(ga.verAutores().get(1), gg.verGrupos().get(1), Rol.COLABORADOR), fecha2, gt.verTipos().get(1), gi.verIdiomas().get(1), gl.verLugares().get(1), gpc.verPalabrasClaves(), "Enlace 2", "Resumen 2"));
        gp.verPublicacion("Titulo 1").mostrar();
        gp.verPublicacion("Titulo 2").mostrar();
//        ArrayList<Alumno> alumnos = new ArrayList<>();
//        ArrayList<Profesor> profesores = new ArrayList<>();
//        ArrayList<Idioma> idiomas = new ArrayList<>();
//        ArrayList<Lugar> lugares = new ArrayList<>();
//        ArrayList<PalabraClave> palabrasclaves = new ArrayList<>();
//        ArrayList<Tipo> tipos = new ArrayList<>();
//        ArrayList<Grupo> grupos = new ArrayList<>();
//        
//        //Creando la lista donde estarán los profesores y alumnos
//        ArrayList<Autor> autores = new ArrayList<>();
//
//        System.out.println("\n------------------AUTORES------------------\n");
//        Autor alumno1 = new Alumno(1, "ApellidoAlumno1", "NombreAlumno1", "Clave1", "CX1");
//        Autor alumno2 = new Alumno(2, "ApellidoAlumno2", "NombreAlumno2", "Clave2", "CX2");
//        Autor alumno3 = new Alumno(3, "ApellidoAlumno3", "NombreAlumno3", "Clave3", "CX3");
//        Autor alumno4 = new Alumno(4, "ApellidoAlumno4", "NombreAlumno4", "Clave4", "CX4");
//        Autor alumno5 = new Alumno(5, "ApellidoAlumno5", "NombreAlumno5", "Clave5", "CX5");
//        Autor alumno6 = new Alumno(1, "ApellidoAlumno6", "NombreAlumno6", "Clave6", "CX6"); //DNI repetido con otro alumno
//        
//        autores.add(alumno1);
//        if(!autores.contains(alumno2))
//            autores.add(alumno2);
//        if(!autores.contains(alumno3))
//            autores.add(alumno3);
//        if(!autores.contains(alumno4))
//            autores.add(alumno4);
//        if(!autores.contains(alumno5))
//            autores.add(alumno5);
//        if(!autores.contains(alumno6))
//            autores.add(alumno6);
//        
////        for(Alumno al: alumnos)
////            al.mostrar();
//        
////        System.out.println("\n------------------PROFESORES------------------\n");
//        Autor profesor1 = new Profesor(10, "ApellidoProfesor1", "NombreProfesor1", "Clave1", Cargo.JTP);
//        Autor profesor2 = new Profesor(20, "ApellidoProfesor2", "NombreProfesor2", "Clave2", Cargo.ADG);
//        Autor profesor3 = new Profesor(30, "ApellidoProfesor3", "NombreProfesor3", "Clave3", Cargo.ADJUNTO);
//        Autor profesor4 = new Profesor(40, "ApellidoProfesor4", "NombreProfesor4", "Clave4", Cargo.ASOCIADO);
//        Autor profesor5 = new Profesor(50, "ApellidoProfesor5", "NombreProfesor5", "Clave5", Cargo.TITULAR);
//        Autor profesor6 = new Profesor(10, "ApellidoProfesor6", "NombreProfesor6", "Clave6", Cargo.TITULAR); 
//            //DNI repetido con otro profesor
//        Autor profesor7 = new Profesor(1, "ApellidoProfesor7", "NombreProfesor7", "Clave7", Cargo.TITULAR); 
//            //DNI repetido con otro alumno
//        Autor alumno7 = new Alumno(10, "ApellidoAlumno7", "NombreAlumno7", "Clave7", "CX7"); 
//            //DNI repetido con otro profesor
//        Autor alumno8 = new Alumno(8, "ApellidoProfesor8", "NombreProfesor8", "Clave8", "CX1"); 
//            //CX repetido con otro alumno
//        
//        if(!autores.contains(profesor1))
//            autores.add(profesor1);
//        if(!autores.contains(profesor2))
//            autores.add(profesor2);
//        if(!autores.contains(profesor3))
//            autores.add(profesor3);
//        if(!autores.contains(profesor4))
//            autores.add(profesor4);
//        if(!autores.contains(profesor5))
//            autores.add(profesor5);           
//        if(!autores.contains(profesor5))
//            autores.add(profesor5);           
//        if(!autores.contains(profesor6))
//            autores.add(profesor6);     
//        if (!autores.contains(profesor7)) 
//            autores.add(profesor7);    
//        if (!autores.contains(alumno7)) 
//            autores.add(alumno7);    
//        if (!autores.contains(alumno8)) 
//            autores.add(alumno8);    
//        
//        for(Autor au: autores)
//             au.mostrar();
//        
//        System.out.println("\n------------------GRUPOS------------------\n");
//        Grupo grupo1 = new Grupo("Grupo 1", "Descripcion 1");
//        Grupo grupo2 = new Grupo("Grupo 2", "Descripcion 2");
//        Grupo grupo3 = new Grupo("Grupo 3", "Descripcion 3");
//        Grupo grupo4 = new Grupo("Grupo 4", "Descripcion 4");
//        Grupo grupo5 = new Grupo("Grupo 5", "Descripcion 5");
//        Grupo grupo6 = new Grupo("Grupo 1", "Descripcion 6"); //Nombre repetido
//        
//        grupos.add(grupo1);
//        if (!grupos.contains(grupo2))
//            grupos.add(grupo2);
//        if (!grupos.contains(grupo3))
//            grupos.add(grupo3);
//        if (!grupos.contains(grupo4))
//            grupos.add(grupo4);
//        if (!grupos.contains(grupo5))
//            grupos.add(grupo5);
//        if (!grupos.contains(grupo6))
//            grupos.add(grupo6);
//
//        for(Grupo gr: grupos)
//            gr.mostrar();
//        
//        System.out.println("\n------------------METODOS VARIOS------------------\n");
//        
//        grupo1.agregarMiembro(alumno1, Rol.COLABORADOR);
//        grupo1.agregarMiembro(profesor1, Rol.ADMINISTRADOR);
//        grupo1.agregarMiembro(profesor1, Rol.COLABORADOR);     //Verifico que no se puega agregar miembros en el grupo en el que ya pertenece el autor
//        grupo1.agregarMiembro(profesor1, Rol.ADMINISTRADOR);
//        grupo1.mostrar();
//
//        grupo2.agregarMiembro(alumno1, Rol.ADMINISTRADOR);
//        grupo2.mostrar();
//
//        alumno1.agregarGrupo(grupo2, Rol.COLABORADOR);         //Verifico que no se pueda agregar grupos en los que ya pertenece el autor                         
//        alumno1.agregarGrupo(grupo2, Rol.ADMINISTRADOR);
//        alumno1.mostrar();
//
//        profesor1.mostrar();
//
//        grupo1.quitarMiembro(alumno1);
//        grupo1.mostrar();
//        alumno1.mostrar();
//
//        Grupo GrupoSuper = new Grupo("Super Administradores", "Descripcion Super");
//        GrupoSuper.agregarMiembro(alumno5, Rol.COLABORADOR);
//        GrupoSuper.mostrar();
//
//        System.out.println("");
//        if (GrupoSuper.esSuperAdministradores()) {
//            System.out.println("GrupoSuper es Super Administradores");
//        } else {
//            System.out.println("GrupoSuper no es Super Administradores");
//        }
//        if (grupo1.esSuperAdministradores()) {
//            System.out.println("grupo1 es Super Administradores");
//        } else {
//            System.out.println("grupo2 no es Super Administradores");
//        }
//        
//        System.out.println("");
//        if (alumno5.esSuperAdministrador()) {
//            System.out.println("alumno5 es Super Administrador");
//        } else {
//            System.out.println("alumno5 no es Super Administrador");
//        }
//        if (profesor1.esSuperAdministrador()) {
//            System.out.println("profesor1 es Super Administrador");
//        } else {
//            System.out.println("profesor1 no es Super Administrador");
//        }
//        
//        System.out.println("\n------------------IDIOMAS------------------\n");
//        Idioma idioma1 = new Idioma("Idioma 1");
//        Idioma idioma2 = new Idioma("Idioma 2");
//        Idioma idioma3 = new Idioma("Idioma 3");
//        Idioma idioma4 = new Idioma("Idioma 4");
//        Idioma idioma5 = new Idioma("Idioma 5");
//        Idioma idioma6 = new Idioma("Idioma 1"); //Nombre repetido
//        
//        idiomas.add(idioma1);
//        if(!idiomas.contains(idioma2))
//            idiomas.add(idioma2);
//        if(!idiomas.contains(idioma3))
//            idiomas.add(idioma3);
//        if(!idiomas.contains(idioma4))
//            idiomas.add(idioma4);
//        if(!idiomas.contains(idioma5))
//            idiomas.add(idioma5);
//        if(!idiomas.contains(idioma6))
//            idiomas.add(idioma6);
//        
//        for(Idioma id: idiomas)
//            System.out.println(id);
//
//        System.out.println("\n------------------LUGARES------------------\n");
//        Lugar lugar1 = new Lugar("Lugar 1");
//        Lugar lugar2 = new Lugar("Lugar 2");
//        Lugar lugar3 = new Lugar("Lugar 3");
//        Lugar lugar4 = new Lugar("Lugar 4");
//        Lugar lugar5 = new Lugar("Lugar 5");
//        Lugar lugar6 = new Lugar("Lugar 1"); //Nombre repetido
//        
//        lugares.add(lugar1);
//        if(!lugares.contains(lugar2))
//            lugares.add(lugar2);
//        if(!lugares.contains(lugar3))
//            lugares.add(lugar3);
//        if(!lugares.contains(lugar4))
//            lugares.add(lugar4);
//        if(!lugares.contains(lugar5))
//            lugares.add(lugar5);
//        if(!lugares.contains(lugar6))
//            lugares.add(lugar6);
//
//        for(Lugar lg: lugares)
//            System.out.println(lg);
//        
//        System.out.println("\n------------------TIPOS------------------\n");
//        Tipo tipo1 = new Tipo("Tipo 1");
//        Tipo tipo2 = new Tipo("Tipo 2");
//        Tipo tipo3 = new Tipo("Tipo 3");
//        Tipo tipo4 = new Tipo("Tipo 4");
//        Tipo tipo5 = new Tipo("Tipo 5");
//        Tipo tipo6 = new Tipo("Tipo 1"); //Nombre repetido
//        
//        tipos.add(tipo1);
//        if(!tipos.contains(tipo2))
//            tipos.add(tipo2);
//        if(!tipos.contains(tipo3))
//            tipos.add(tipo3);
//        if(!tipos.contains(tipo4))
//            tipos.add(tipo4);
//        if(!tipos.contains(tipo5))
//            tipos.add(tipo5);
//        if(!tipos.contains(tipo6))
//            tipos.add(tipo6);
//        
//        for(Tipo tp: tipos)
//            System.out.println(tp);
//        
//        System.out.println("\n------------------PALABRAS CLAVES------------------\n");
//        PalabraClave palabraclave1 = new PalabraClave("PalabraClave1");
//        PalabraClave palabraclave2 = new PalabraClave("PalabraClave2");
//        PalabraClave palabraclave3 = new PalabraClave("PalabraClave3");
//        PalabraClave palabraclave4 = new PalabraClave("PalabraClave4");
//        PalabraClave palabraclave5 = new PalabraClave("PalabraClave5");
//        PalabraClave palabraclave6 = new PalabraClave("PalabraClave1"); //Nombre repetido
//        
//        palabrasclaves.add(palabraclave1);
//        if(!palabrasclaves.contains(palabraclave2))
//            palabrasclaves.add(palabraclave2);
//        if(!palabrasclaves.contains(palabraclave3))
//            palabrasclaves.add(palabraclave3);
//        if(!palabrasclaves.contains(palabraclave4))
//            palabrasclaves.add(palabraclave4);
//        if(!palabrasclaves.contains(palabraclave5))
//            palabrasclaves.add(palabraclave5);
//        if(!palabrasclaves.contains(palabraclave6))
//            palabrasclaves.add(palabraclave6);
//        
//        PalabraClave[] palabras1 = new PalabraClave[]{palabraclave1,palabraclave2};
//        PalabraClave[] palabras2 = new PalabraClave[]{palabraclave3,palabraclave2,palabraclave5};
//        PalabraClave[] palabras3 = new PalabraClave[]{palabraclave2,palabraclave4};
//        PalabraClave[] palabras4 = new PalabraClave[]{palabraclave5,palabraclave3,palabraclave4};
//        
//        for(PalabraClave pc: palabrasclaves)
//            System.out.println(pc);
//
//        LocalDate fecha1 = LocalDate.of(2020, 6, 24);
//        LocalDate fecha2 = LocalDate.of(2020, 4, 12);
//        LocalDate fecha3 = LocalDate.of(2020, 9, 9);
//        LocalDate fecha4 = LocalDate.of(2019, 1, 3);
//        LocalDate fecha5 = LocalDate.of(2020, 2, 29);
//               
//        //Alumnos y Profesores como autores
//        MiembroEnGrupo miembro1 = new MiembroEnGrupo(autores.get(0),grupos.get(0),Rol.ADMINISTRADOR);
//        MiembroEnGrupo miembro2 = new MiembroEnGrupo(autores.get(8),grupos.get(3),Rol.COLABORADOR);
//        MiembroEnGrupo miembro3 = new MiembroEnGrupo(autores.get(4),grupos.get(2),Rol.ADMINISTRADOR);
//        MiembroEnGrupo miembro4 = new MiembroEnGrupo(autores.get(1),grupos.get(1),Rol.COLABORADOR);
//        MiembroEnGrupo miembro5 = new MiembroEnGrupo(autores.get(7),grupos.get(4),Rol.ADMINISTRADOR);
//
//        System.out.println("\n------------------PUBLICACIONES------------------");
//        ArrayList<Publicacion> publicaciones = new ArrayList<>();
//
//        Publicacion publicacion1 = new Publicacion("Titulo 1", miembro1, fecha1, tipo1, idiomas.get(0), lugares.get(0), palabrasclaves, "Enlace 1", "Resumen 1");
//        Publicacion publicacion2 = new Publicacion("Titulo 2", miembro2, fecha2, tipos.get(3), idioma2, lugar2, new ArrayList<>(Arrays.asList(palabras1)), "Enlace 2", "Resumen 2");
//        Publicacion publicacion3 = new Publicacion("Titulo 3", miembro3, fecha3, tipo3, idioma3, lugares.get(4), new ArrayList<>(Arrays.asList(palabras2)), "Enlace 3", "Resumen 3");
//        Publicacion publicacion4 = new Publicacion("Titulo 4", miembro4, fecha4, tipo4, idiomas.get(4), lugar4, new ArrayList<>(Arrays.asList(palabras3)), "Enlace 4", "Resumen 4");
//        Publicacion publicacion5 = new Publicacion("Titulo 5", miembro5, fecha5, tipos.get(4), idioma5, lugar3, new ArrayList<>(Arrays.asList(palabras4)), "Enlace 5", "Resumen 5");
//        Publicacion publicacion6 = new Publicacion("Titulo 1", miembro5, fecha5, tipos.get(4), idioma5, lugar3, new ArrayList<>(Arrays.asList(palabras4)), "Enlace 5", "Resumen 5");
//                                            //Titulo repetido
//                                            
//        publicaciones.add(publicacion1);
//        if(!publicaciones.contains(publicacion2))
//            publicaciones.add(publicacion2);
//        if(!publicaciones.contains(publicacion3))
//            publicaciones.add(publicacion3);
//        if(!publicaciones.contains(publicacion4))
//            publicaciones.add(publicacion4);
//        if(!publicaciones.contains(publicacion5))
//            publicaciones.add(publicacion5);
//        if(!publicaciones.contains(publicacion6))
//            publicaciones.add(publicacion6);
//
//        for (Publicacion pb : publicaciones) {
//            System.out.print("\n\n========Publicacion: " + (publicaciones.indexOf(pb)+1) + "#========");
//            pb.mostrar();
//        }

//        VentanaAMGrupo ventanaGrupo = new VentanaAMGrupo(null); //se instancia la ventana
//
//        ventanaGrupo.setLocationRelativeTo(null); //se centra la ventana
//        ventanaGrupo.setVisible(true); //se hace visible la ventana
//        
//        VentanaAMAlumno ventanaAlumno = new VentanaAMAlumno(null); //se instancia la ventana
//        ventanaAlumno.setLocationRelativeTo(null); //se centra la ventana
//        ventanaAlumno.setVisible(true); //se hace visible la ventana
//       
//        VentanaAMProfesor ventanaProfesor = new VentanaAMProfesor(null); //se instancia la ventana
//        ventanaProfesor.setLocationRelativeTo(null); //se centra la ventana
//        ventanaProfesor.setVisible(true); //se hace visible la ventana        
//       
//        VentanaAIdioma ventanaIdioma = new VentanaAIdioma(null); //se instancia la ventana
//        ventanaIdioma.setLocationRelativeTo(null); //se centra la ventana
//        ventanaIdioma.setVisible(true); //se hace visible la ventana                
//        
//        VentanaALugar ventanaLugar = new VentanaALugar(null); //se instancia la ventana
//        ventanaLugar.setLocationRelativeTo(null); //se centra la ventana
//        ventanaLugar.setVisible(true); //se hace visible la ventana                        
//        
//        VentanaAPalabraClave ventanaPalabraClave = new VentanaAPalabraClave(null); //se instancia la ventana
//        ventanaPalabraClave.setLocationRelativeTo(null); //se centra la ventana
//        ventanaPalabraClave.setVisible(true); //se hace visible la ventana                                
//        
//        VentanaATipo ventanaTipo = new VentanaATipo(null); //se instancia la ventana
//        ventanaTipo.setLocationRelativeTo(null); //se centra la ventana
//        ventanaTipo.setVisible(true); //se hace visible la ventana   ve ventanaPalabraClave = new VentanaAPalabraClave(null); // 
    }
}
