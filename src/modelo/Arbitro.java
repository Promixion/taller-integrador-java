package modelo;
import java.util.ArrayList;

/**
 * Representa a un árbitro participante del mundial.
 * Almacena sus datos personales, país de procedencia,
 * años de experiencia y los arbitrajes en los que participó.
 *
 * @author Juan
 * @author Liset
 */

public class Arbitro extends Persona{
    private int aniosExperiencia;
    private Pais pais;
    private ArrayList<Arbitraje> arbitraje;
    
    /**
     * Crea un árbitro sin inicializar sus datos personales.
     * Inicializa la colección de arbitrajes vacía.
     */
    public Arbitro(){
        this.arbitraje = new ArrayList<>();
    }
    /**
     * Crea un árbitro con los datos especificados.
     *
     * @param nombre nombre del árbitro.
     * @param fecNacimiento año de nacimiento del árbitro.
     * @param aniosExperiencia cantidad de años de experiencia.
     */
    public Arbitro(String nombre, int fecNacimiento, int aniosExperiencia) {
        super(nombre, fecNacimiento);
        this.aniosExperiencia = aniosExperiencia;
        this.arbitraje = new ArrayList<>();
    }
    /**
     * Obtiene la cantidad de años de experiencia del árbitro.
     *
     * @return los años de experiencia.
     */
    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    /**
     * Establece la cantidad de años de experiencia del árbitro.
     *
     * @param aniosExperiencia los años de experiencia a asignar.
     */
    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }
    /**
     * Obtiene el país al que representa el árbitro.
     *
     * @return el país asociado al árbitro.
     */
    public Pais getPais() {
        return pais;
    }
    /**
     * Establece el país al que representa el árbitro.
     *
     * @param pais el país a asociar.
     */
    public void setPais(Pais pais) {
        this.pais = pais;
    }
    /**
     * Agrega un arbitraje a la lista de participaciones del árbitro.
     *
     * @param arbitraje arbitraje a registrar.
     */
    public void addArbitraje(Arbitraje arbitraje) {
        this.arbitraje.add(arbitraje);
    }

}
