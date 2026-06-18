package modelo;
import java.util.ArrayList;

import modelo.enums.Posicion;
/**
 * Representa a un jugador perteneciente a una selección.
 * Almacena sus datos personales, características físicas,
 * posición dentro del campo de juego y los eventos en los
 * que participó durante el torneo.
 *
 * @author Juan
 * @author Liset
 */
public class Jugador extends Persona {
    private int dorsal;
    private Posicion posicion;
    private float peso;
    private float altura;
    private ArrayList<Evento> eventos;
    /**
     * Crea un jugador sin inicializar sus datos personales.
     * Inicializa la lista de eventos vacía.
     */
    public Jugador(){
        this.eventos = new ArrayList<>();
    }
    /**
     * Crea un jugador con los datos especificados.
     *
     * @param nombre nombre del jugador.
     * @param fecNacimiento año de nacimiento del jugador.
     * @param dorsal número de camiseta.
     * @param posicion posición que ocupa en el campo.
     * @param peso peso del jugador en kilogramos.
     * @param altura altura del jugador en metros.
     */
    public Jugador(String nombre, int fecNacimiento, int dorsal, Posicion posicion, float peso, float altura) {
        super(nombre, fecNacimiento);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.peso = peso;
        this.altura = altura;
        this.eventos = new ArrayList<>();
    }
    /**
     * Obtiene el número de camiseta del jugador.
     *
     * @return dorsal del jugador.
     */
    public int getDorsal() {
        return dorsal;
    }
    /**
     * Establece el número de camiseta del jugador.
     *
     * @param dorsal dorsal a asignar.
     */
    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }
    /**
     * Obtiene la posición del jugador.
     *
     * @return posición del jugador.
     */
    public Posicion getPosicion() {
        return posicion;
    }
    /**
     * Establece la posición del jugador.
     *
     * @param posicion posición a asignar.
     */
    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }
    /**
     * Obtiene el peso del jugador.
     *
     * @return peso en kilogramos.
     */
    public float getPeso() {
        return peso;
    }
    /**
     * Establece el peso del jugador.
     *
     * @param peso peso a asignar en kilogramos.
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }
    /**
     * Obtiene la altura del jugador.
     *
     * @return altura en metros.
     */
    public float getAltura() {
        return altura;
    }
    /**
     * Establece la altura del jugador.
     *
     * @param altura altura a asignar en metros.
     */
    public void setAltura(float altura) {
        this.altura = altura;
    }
    /**
     * Registra un evento en el que participó el jugador.
     *
     * @param evento evento a agregar.
     */
    public void addEventos(Evento evento) {
        this.eventos.add(evento);
    }
    /**
     * Obtiene la lista de eventos asociados al jugador.
     *
     * @return lista de eventos del jugador.
     */
    public ArrayList<Evento> getEventos() {
        return eventos;
    }
    
}
