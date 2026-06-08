/**
 * Representa a un integrante del cuerpo técnico de una selección,
 * almacenando sus datos personales y el rol que desempeña.
 *
 * @author Juan
 * @author Liset
 */
public class CuerpoTecnico extends Persona{
    private Rol rol;

    public CuerpoTecnico(){

    }

    public CuerpoTecnico(String nombre, int fecNacimiento, Rol rol) {
        super(nombre, fecNacimiento);
        this.rol = rol;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    

}
