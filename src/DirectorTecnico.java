/**
 * Representa al director técnico de una selección nacional.
 * Almacena sus datos personales y la fecha en la que fue
 * nombrado para ocupar dicho cargo.
 *
 * @author Juan
 * @author Liset
 */
public class DirectorTecnico extends Persona{
    private int fechaNombramiento;

    public DirectorTecnico(){
    }

    public DirectorTecnico(String nombre, int fecNacimiento, int fechaNombramiento) {
        super(nombre, fecNacimiento);
        this.fechaNombramiento = fechaNombramiento;
    }

    public int getFechaNombramiento() {
        return fechaNombramiento;
    }

    public void setFechaNombramiento(int fechaNombramiento) {
        this.fechaNombramiento = fechaNombramiento;
    }
    
}
