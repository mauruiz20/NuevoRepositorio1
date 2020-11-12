
package autores.modelos;

public class Profesor extends Autor{
    
    private Cargo cargo;

    public Profesor(int dni, String apellidos, String nombres, String clave, Cargo cargo) {
        super(dni,apellidos,nombres,clave);
        this.cargo = cargo;
    }
    
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.println("#Cargo: " + cargo);
    }

    public void asginarCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Cargo verCargo() {
        return cargo;
    }
}
