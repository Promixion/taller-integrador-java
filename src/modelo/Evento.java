package modelo;
import modelo.enums.TipoEvento;

/**
 * Representa un evento ocurrido durante el desarrollo de un partido,
 * como un gol, una tarjeta, una sustitución o una lesión.
 * Cada evento registra el tipo de acción, el minuto en que ocurrió
 * y el jugador involucrado.
 *
 * @author Juan
 * @author Liset
 */
public class Evento {
    private TipoEvento tipo;
    private int minuto;
    private Jugador jugador;
    /**
     * Crea un evento sin inicializar sus atributos.
     */
    public Evento(){
        
    }
    /**
     * Crea un evento con el tipo y minuto especificados.
     *
     * @param tipo tipo de evento ocurrido.
     * @param minuto minuto en el que ocurrió el evento.
     */
    public Evento(TipoEvento tipo, int minuto) {
        this.tipo = tipo;
        this.minuto = minuto;
    }

    /**
     * Crea un evento con el tipo, minuto y jugador especificados.
     *
     * @param tipo tipo de evento ocurrido.
     * @param minuto minuto en el que ocurrió el evento.
     * @param jugador jugador involucrado en el evento.
     */
    public Evento(TipoEvento tipo, int minuto, Jugador jugador) {
        this.tipo = tipo;
        this.minuto = minuto;
        this.jugador = jugador;
    }

    /**
     * Obtiene el tipo de evento.
     *
     * @return el tipo de evento.
     */
    public TipoEvento getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de evento.
     *
     * @param tipo el tipo de evento a asignar.
     */
    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }
    /**
     * Obtiene el minuto en el que ocurrió el evento.
     *
     * @return el minuto del evento.
     */
    public int getMinuto() {
        return minuto;
    }
    /**
     * Establece el minuto en el que ocurrió el evento.
     *
     * @param minuto el minuto a asignar.
     */
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    /**
     * Obtiene el jugador involucrado en el evento.
     *
     * @return el jugador asociado al evento.
     */
    public Jugador getJugador() {
        return jugador;
    }
    /**
     * Establece el jugador involucrado en el evento.
     *
     * @param jugador el jugador a asociar.
     */
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    /**
     * Determina si dos eventos son iguales.
     * Dos eventos se consideran iguales si poseen el mismo tipo
     * y ocurrieron en el mismo minuto.
     *
     * @param obj objeto a comparar.
     * @return {@code true} si los eventos son equivalentes;
     *         {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Evento)) return false;
        Evento e = (Evento) obj;
        return this.minuto == e.getMinuto() && this.tipo == e.getTipo();
    }
    
}
