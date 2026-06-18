package modelo;
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
    /**
     * Crea un director técnico sin inicializar sus atributos.
     */
    public DirectorTecnico(){
    }
    /**
     * Crea un director técnico con los datos especificados.
     *
     * @param nombre nombre del director técnico.
     * @param fecNacimiento año de nacimiento del director técnico.
     * @param fechaNombramiento fecha en la que fue designado para el cargo.
     */
    public DirectorTecnico(String nombre, int fecNacimiento, int fechaNombramiento) {
        super(nombre, fecNacimiento);
        this.fechaNombramiento = fechaNombramiento;
    }
    /**
     * Obtiene la fecha de nombramiento del director técnico.
     *
     * @return la fecha de nombramiento.
     */
    public int getFechaNombramiento() {
        return fechaNombramiento;
    }
    /**
     * Establece la fecha de nombramiento del director técnico.
     *
     * @param fechaNombramiento la fecha a asignar.
     */
    public void setFechaNombramiento(int fechaNombramiento) {
        this.fechaNombramiento = fechaNombramiento;
    }
    
}
