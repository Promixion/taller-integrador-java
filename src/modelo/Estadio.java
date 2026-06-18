package modelo;
import java.util.ArrayList;
/**
 * Representa un estadio perteneciente a una sede del mundial.
 * Cada estadio posee un nombre, una capacidad máxima y los
 * partidos que se disputan en él.
 *
 * @author Juan
 * @author Liset
 */
public class Estadio {
    private String nombre;
    private int capacidad;
    private Sede sede;
    private ArrayList<Partido> partido;
    /**
     * Crea un estadio sin datos iniciales.
     * Inicializa la lista de partidos vacía.
     */
    public Estadio(){
        this("", 0);
        this.partido = new ArrayList<>();
    }
    /**
     * Crea un estadio con el nombre y la capacidad especificados.
     *
     * @param nombre nombre del estadio.
     * @param capacidad capacidad máxima de espectadores.
     */
    public Estadio(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.partido = new ArrayList<>();
    }
    /**
     * Crea un estadio con el nombre, la capacidad y la sede especificados.
     *
     * @param nombre nombre del estadio.
     * @param capacidad capacidad máxima de espectadores.
     * @param sede sede a la que pertenece el estadio.
     */
    public Estadio(String nombre, int capacidad, Sede sede) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sede = sede;
        this.partido = new ArrayList<>();
    }    
    /**
     * Obtiene el nombre del estadio.
     *
     * @return el nombre del estadio.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del estadio.
     *
     * @param nombre el nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Obtiene la capacidad máxima del estadio.
     *
     * @return la capacidad del estadio.
     */
    public int getCapacidad() {
        return capacidad;
    }
    /**
     * Establece la capacidad máxima del estadio.
     *
     * @param capacidad la capacidad a asignar.
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    /**
     * Obtiene la sede a la que pertenece el estadio.
     *
     * @return la sede asociada.
     */
    public Sede getSede(){
        return sede;
    }
    /**
     * Establece la sede a la que pertenece el estadio.
     *
     * @param sede la sede a asociar.
     */
    public void setSede(Sede sede){
        this.sede = sede;
    }
    /**
     * Agrega un partido a la lista de encuentros disputados en el estadio.
     *
     * @param partido partido a registrar.
     */
    public void addPartido(Partido partido) {
        this.partido.add(partido);
    }
    /**
     * Obtiene la lista de partidos disputados en el estadio.
     *
     * @return lista de partidos asociados al estadio.
     */
    public ArrayList<Partido> getPartido() {
        return partido;
    }
    /**
     * Devuelve una representación en texto del estadio y sus datos principales.
     *
     * @return cadena con la información del estadio.
     */
    @Override
    public String toString() {
        return "\nnombre: " + nombre + ", capacidad: " + capacidad + ", sede:" + sede + ", partido: " + partido;
    } 

}
