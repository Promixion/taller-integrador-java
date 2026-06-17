package modelo;
import modelo.enums.TipoEvento;

/**
 * Representa un evento de campo ocurrido durante un partido,
 * como un gol, una tarjeta o una sustitución.
 * Cada evento registra el minuto en que ocurrió y el
 * jugador involucrado.
 *
 * @author Juan
 * @author Liset
 */
public class Evento {
    private TipoEvento tipo;
    private int minuto;
    private Jugador jugador;

    public Evento(){
        
    }

    public Evento(TipoEvento tipo, int minuto) {
        this.tipo = tipo;
        this.minuto = minuto;
    }


    public Evento(TipoEvento tipo, int minuto, Jugador jugador) {
        this.tipo = tipo;
        this.minuto = minuto;
        this.jugador = jugador;
    }

    public TipoEvento getTipo() {
        return tipo;
    }

    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Evento)) return false;
        Evento e = (Evento) obj;
        return this.minuto == e.getMinuto() && this.tipo == e.getTipo();
    }
    
}
