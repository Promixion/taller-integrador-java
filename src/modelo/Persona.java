package modelo;
/**
 * Representa una persona dentro del sistema.
 * <p>
 * Una persona posee un nombre y un año de nacimiento.
 * Esta clase sirve como base para otras entidades que
 * requieran información personal básica.
 * </p>
 *
 * @author Juan
 * @author Liset
 */
public class Persona {
    private String nombre;
    private int fecNacimiento;
    /**
     * Crea una persona sin inicializar sus atributos.
     */
    public Persona(){
        
    }
    /**
     * Crea una persona con los datos especificados.
     *
     * @param nombre nombre de la persona.
     * @param fecNacimiento año de nacimiento de la persona.
     */
    public Persona(String nombre, int fecNacimiento) {
        this.nombre = nombre;
        this.fecNacimiento = fecNacimiento;
    }
    /**
     * Obtiene el nombre de la persona.
     *
     * @return nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Establece el nombre de la persona.
     *
     * @param nombre nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Obtiene el año de nacimiento de la persona.
     *
     * @return año de nacimiento.
     */
    public int getFecNacimiento() {
        return fecNacimiento;
    }
    /**
     * Establece el año de nacimiento de la persona.
     *
     * @param fecNacimiento año de nacimiento a asignar.
     */
    public void setFecNacimiento(int fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

}
