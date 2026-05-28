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
