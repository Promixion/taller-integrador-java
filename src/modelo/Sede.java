package modelo;
import java.util.ArrayList;

/**
 * Representa una sede del mundial.
 * <p>
 * Una sede corresponde a una ciudad anfitriona donde pueden disputarse
 * partidos del torneo. Cada sede posee información geográfica y climática,
 * está asociada a un país y puede contener uno o más estadios.
 * </p>
 *
 * @author Juan
 * @author Liset
 */
public class Sede {
    private String ciudad;
    private float alturaNivelMar;
    private String clima;
    private String zonaHoraria;
    private Pais pais;
    private ArrayList<Estadio> estadios;

    public Sede(){
        this("", 0.0f, "", "");
        this.estadios = new ArrayList<>();
    }

    public Sede(String ciudad, float alturaNivelMar, String clima, String zonaHoraria) {
        this.ciudad = ciudad;
        this.alturaNivelMar = alturaNivelMar;
        this.clima = clima;
        this.zonaHoraria = zonaHoraria;
        this.estadios = new ArrayList<>();
    }

    public Sede(String ciudad, float alturaNivelMar, String clima, String zonaHoraria, Pais pais) {
        this.ciudad = ciudad;
        this.alturaNivelMar = alturaNivelMar;
        this.clima = clima;
        this.zonaHoraria = zonaHoraria;
        this.pais = pais;
        this.estadios = new ArrayList<>();
    }

    public Sede(String ciudad, float alturaNivelMar, String clima, String zonaHoraria, Pais pais,
            ArrayList<Estadio> estadios) {
        this.ciudad = ciudad;
        this.alturaNivelMar = alturaNivelMar;
        this.clima = clima;
        this.zonaHoraria = zonaHoraria;
        this.pais = pais;
        this.estadios = estadios;

    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public float getAlturaNivelMar() {
        return alturaNivelMar;
    }

    public void setAlturaNivelMar(float alturaNivelMar) {
        this.alturaNivelMar = alturaNivelMar;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getZonaHoraria() {
        return zonaHoraria;
    }

    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Pais getPais() {
        return pais;
    }


    public void addEstadio(Estadio estadio) {
        this.estadios.add(estadio);
    }

    public ArrayList<Estadio> getEstadios() {
        return estadios;
    }

    @Override
    public String toString() {
        return "\nciudad:" + ciudad + ", alturaNivelMar: " + alturaNivelMar + ", clima: " + clima + ", zonaHoraria: "
                + zonaHoraria + ", pais: " + pais + ", estadios: " + estadios;
    }


    @Override
    public boolean equals(Object nueva_sede) {
        if (this == nueva_sede) return true;                    
        if (nueva_sede == null || !(nueva_sede instanceof Sede)) return false; 
        return this.ciudad.toLowerCase().equals(((Sede) nueva_sede).getCiudad().toLowerCase());
    }

}
