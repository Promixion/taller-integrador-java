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

    public Jugador(){
        this.eventos = new ArrayList<>();
    }

    public Jugador(String nombre, int fecNacimiento, int dorsal, Posicion posicion, float peso, float altura) {
        super(nombre, fecNacimiento);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.peso = peso;
        this.altura = altura;
        this.eventos = new ArrayList<>();
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void addEventos(Evento evento) {
        this.eventos.add(evento);
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }
    
}
