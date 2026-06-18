package modelo;
import modelo.enums.Rol;

/**
 * Representa a un integrante del cuerpo técnico de una selección.
 * Almacena sus datos personales y el rol específico que desempeña
 * dentro del equipo.
 *
 * @author Juan
 * @author Liset
 */
public class CuerpoTecnico extends Persona{
    private Rol rol;
    /**
     * Crea un integrante del cuerpo técnico sin inicializar sus atributos.
     */
    public CuerpoTecnico(){

    }
    /**
     * Crea un integrante del cuerpo técnico con los datos especificados.
     *
     * @param nombre nombre del integrante.
     * @param fecNacimiento año de nacimiento del integrante.
     * @param rol función desempeñada dentro del cuerpo técnico.
     */
    public CuerpoTecnico(String nombre, int fecNacimiento, Rol rol) {
        super(nombre, fecNacimiento);
        this.rol = rol;
    }
    /**
     * Obtiene el rol desempeñado por el integrante del cuerpo técnico.
     *
     * @return el rol asignado.
     */
    public Rol getRol() {
        return rol;
    }

    /**
     * Establece el rol desempeñado por el integrante del cuerpo técnico.
     *
     * @param rol el rol a asignar.
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    

}
