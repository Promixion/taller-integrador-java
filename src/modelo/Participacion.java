package modelo;
import modelo.enums.TipoEvento;

/**
 * Representa la participación de una selección en un partido.
 * Permite identificar si la selección actúa como local o visitante
 * y obtener estadísticas relacionadas con su desempeño durante el
 * encuentro, como goles convertidos y sanciones disciplinarias.
 *
 * @author Juan
 * @author Liset
 */


public class Participacion {
    private boolean esLocal;
    private Seleccion seleccion;
    private Partido partido;
    /**
     * Crea una participación sin inicializar sus atributos.
     */
    public Participacion(){

    }
    /**
     * Crea una participación con los datos especificados.
     *
     * @param esLocal indica si la selección juega como local.
     * @param partido partido en el que participa la selección.
     * @param seleccion selección participante.
     */
    public Participacion(boolean esLocal, Partido partido, Seleccion seleccion) {
        this.esLocal = esLocal;
        this.partido = partido;
        this.seleccion =  seleccion;
    }
    /**
     * Indica si la selección juega como local.
     *
     * @return {@code true} si juega como local;
     *         {@code false} en caso contrario.
     */
    public boolean isEsLocal() {
        return esLocal;
    }
    /**
     * Establece si la selección juega como local.
     *
     * @param esLocal valor a asignar.
     */
    public void setEsLocal(boolean esLocal) {
        this.esLocal = esLocal;
    }
    /**
     * Calcula la cantidad de goles convertidos por la selección
     * durante el partido.
     * <p>
     * Se contabilizan tanto los goles de jugada como los penales
     * convertidos.
     * </p>
     *
     * @return cantidad de goles anotados por la selección.
     */
    public int cantidadGoles(){
        int goles = 0;
        for (Evento evento : this.partido.getEventos()) {
            if (evento.getTipo() == TipoEvento.Gol || evento.getTipo() == TipoEvento.PenalConvertido) {
                if (this.seleccion.getJugadores().contains(evento.getJugador())) {
                    goles++;
                }
            }
        }
        return goles;
    }
    /**
     * Calcula la cantidad de tarjetas amarillas recibidas por los
     * jugadores de la selección durante el partido.
     * <p>
     * Las expulsiones por doble amarilla también son contabilizadas
     * como tarjetas amarillas.
     * </p>
     *
     * @return cantidad de tarjetas amarillas.
     */
    public int cantidadTarjAmarillas(){
        int amarillas = 0;
        for (Evento evento : this.partido.getEventos()) {
            if (evento.getTipo() == TipoEvento.TarjetaAmarilla || evento.getTipo() == TipoEvento.DobleAmarilla) {
                if (this.seleccion.getJugadores().contains(evento.getJugador())) {
                    amarillas++;
                }
            }
        }
        return amarillas;
    }
    /**
     * Calcula la cantidad de tarjetas rojas recibidas por los
     * jugadores de la selección durante el partido.
     * <p>
     * Las expulsiones por doble amarilla también son contabilizadas
     * como tarjetas rojas.
     * </p>
     *
     * @return cantidad de tarjetas rojas.
     */
    public int cantidadTarjRojas(){
        int rojas = 0;
        for (Evento evento : this.partido.getEventos()) {
            if (evento.getTipo() == TipoEvento.TarjetaRoja || evento.getTipo() == TipoEvento.DobleAmarilla) {
                if (this.seleccion.getJugadores().contains(evento.getJugador())) {
                    rojas++;
                }
            }
        }
        return rojas;
    }
    /**
     * Establece la selección participante.
     *
     * @param seleccion selección a asociar.
     */
    public void setSeleccion(Seleccion seleccion){
        this.seleccion = seleccion;
    }

    /**
     * Obtiene la selección participante.
     *
     * @return selección asociada.
     */
    public Seleccion getSeleccion(){
        return seleccion;
    }
    /**
     * Establece el partido asociado a la participación.
     *
     * @param partido partido a asociar.
     */
    public void setPartido(Partido partido) {
        this.partido = partido;
    }
    /**
     * Obtiene el partido asociado a la participación.
     *
     * @return partido asociado.
     */
    public Partido getPartido() {
        return partido;
    }    

}
