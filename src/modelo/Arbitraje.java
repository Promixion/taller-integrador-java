package modelo;
import modelo.enums.CategoriaArbitro;

/**
 * Representa la participación de un árbitro en un partido determinado,
 * indicando el rol que desempeña dentro del equipo arbitral.
 * <p>
 * Actúa como una clase asociativa entre {@link Partido} y {@link Arbitro},
 * permitiendo registrar la función específica que cumple un árbitro en un
 * encuentro.
 * </p>
 *
 * @author Juan
 * @author Liset
 */

public class Arbitraje {
    private CategoriaArbitro rol;
    private Partido partido;
    private Arbitro arbitro;

    /**
     * Crea una instancia de arbitraje sin inicializar sus atributos.
     */
    public Arbitraje(){

    }
    /**
     * Crea una instancia de arbitraje con el rol especificado.
     *
     * @param rol categoría o función que desempeña el árbitro.
     */
    public Arbitraje(CategoriaArbitro rol) {
        this.rol = rol;

    }
    /**
     * Obtiene el rol desempeñado por el árbitro.
     *
     * @return la categoría arbitral asignada.
     */
    public CategoriaArbitro getRol() {
        return rol;
    }
    /**
     * Establece el rol desempeñado por el árbitro.
     *
     * @param rol la categoría arbitral a asignar.
     */
    public void setRol(CategoriaArbitro rol) {
        this.rol = rol;
    }
    /**
     * Obtiene el partido asociado al arbitraje.
     *
     * @return el partido correspondiente.
     */
    public Partido getPartido() {
        return partido;
    }
    /**
     * Establece el partido asociado al arbitraje.
     *
     * @param partido el partido a asociar.
     */
    public void setPartido(Partido partido) {
        this.partido = partido;
    }
    /**
     * Obtiene el árbitro asignado al partido.
     *
     * @return el árbitro asociado.
     */
    public Arbitro getArbitro() {
        return arbitro;
    }
    /**
     * Establece el árbitro asignado al partido.
     *
     * @param arbitro el árbitro a asociar.
     */
    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

}
