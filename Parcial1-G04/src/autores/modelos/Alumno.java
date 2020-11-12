
package autores.modelos;

import java.util.Objects;

public class Alumno extends Autor{
    
    private String cx;

    public Alumno(int dni, String apellidos, String nombres, String clave, String cx) {
        super(dni, apellidos, nombres, clave);
        this.cx = cx;
    }
    
    
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.println("#CX: " + cx);
    }

    public void asignarCx(String cx) {
        System.out.println("HOLasdasdasdasdasdA");
        this.cx = cx;
    }
    
    public String verCx(){
        return cx;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.cx);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj)){
            return true;
        }
        
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        if (!Objects.equals(this.cx, other.cx)) {
            return false;
        }
        return true;
    }
    
    

    
}