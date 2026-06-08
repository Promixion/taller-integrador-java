/**
 * Representa la participación de una selección en un partido.
 * <p>
 * Esta clase permite determinar si la selección juega como local o visitante
 * y obtener estadísticas relacionadas con su desempeño durante el partido,
 * como la cantidad de goles, tarjetas amarillas y tarjetas rojas recibidas.
 * </p>
 *
 * @author Juan
 * @author Liset
 */


public class Participacion {
    private boolean esLocal;
    private Seleccion seleccion;
    private Partido partido;
    
    public Participacion(){

    }

    public Participacion(boolean esLocal, Partido partido, Seleccion seleccion) {
        this.esLocal = esLocal;
        this.partido = partido;
        this.seleccion =  seleccion;
    }

    public boolean isEsLocal() {
        return esLocal;
    }

    public void setEsLocal(boolean esLocal) {
        this.esLocal = esLocal;
    }
    /**
     * Calcula la cantidad de goles convertidos por la selección
     * durante el partido.
     *
     * @return Cantidad de goles anotados por la selección.
     */
    public int cantidadGoles(){
        int goles = 0;
        for (Evento evento : this.partido.getEventos()) {
            if (evento.getTipo() == TipoEvento.Gol) {
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
     * Las dobles amarillas también son contabilizadas como amarillas.
     * </p>
     *
     * @return Cantidad de tarjetas amarillas.
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
     * Las dobles amarillas también son contabilizadas como expulsiones.
     * </p>
     *
     * @return Cantidad de tarjetas rojas.
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

    public void setSeleccion(Seleccion seleccion){
        this.seleccion = seleccion;
    }
    public Seleccion getSeleccion(){
        return seleccion;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Partido getPartido() {
        return partido;
    }    

}
