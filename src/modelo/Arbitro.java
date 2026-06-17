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
    

    public Arbitro(){
        this.arbitraje = new ArrayList<>();
    }

    public Arbitro(String nombre, int fecNacimiento, int aniosExperiencia) {
        super(nombre, fecNacimiento);
        this.aniosExperiencia = aniosExperiencia;
        this.arbitraje = new ArrayList<>();
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public void addArbitraje(Arbitraje arbitraje) {
        this.arbitraje.add(arbitraje);
    }

}
