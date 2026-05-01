public class Jugador {
    private int dorsal;
    private Posicion posicion;
    private float peso;
    private float altura;

    public Jugador(){

    }

    public Jugador(int dorsal, Posicion posicion, float peso, float altura) {
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.peso = peso;
        this.altura = altura;
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
    
    
}
