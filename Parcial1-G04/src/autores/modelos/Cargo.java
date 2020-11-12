
package autores.modelos;

public enum Cargo{
    TITULAR("Titular"),
    ASOCIADO("Asociado"),
    ADJUNTO("Adjunto"),
    JTP("Jefe de Trabajos Practicos"),
    ADG("Aux. Docente Graduado");
    
    private String valor;
    
    private Cargo(String valor){
        this.valor = valor;
    }
    public String toString(){
        return this.valor;
    }
}

