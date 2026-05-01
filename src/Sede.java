import java.util.ArrayList;

public class Sede {
    private String ciudad;
    private float alturaNivelMar;
    private String clima;
    private String zonaHoraria;
    private Pais pais;
    private Mundial mundial;
    private ArrayList<Estadio> estadios;

    public Sede(){

    }

    public Sede(String ciudad, float alturaNivelMar, String clima, String zonaHoraria) {
        this.ciudad = ciudad;
        this.alturaNivelMar = alturaNivelMar;
        this.clima = clima;
        this.zonaHoraria = zonaHoraria;
    }

    public Sede(String ciudad, float alturaNivelMar, String clima, String zonaHoraria, Pais pais) {
        this.ciudad = ciudad;
        this.alturaNivelMar = alturaNivelMar;
        this.clima = clima;
        this.zonaHoraria = zonaHoraria;
        this.pais = pais;
    }

    public Sede(String ciudad, float alturaNivelMar, String clima, String zonaHoraria, Pais pais, Mundial mundial) {
        this.ciudad = ciudad;
        this.alturaNivelMar = alturaNivelMar;
        this.clima = clima;
        this.zonaHoraria = zonaHoraria;
        this.pais = pais;
        this.mundial = mundial;
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

    public Mundial getMundial() {
        return mundial;
    }

    public void setMundial(Mundial mundial) {
        this.mundial = mundial;
    }

    public void addEstadio(Estadio estadio) {
        this.estadios.add(estadio);
    }

    public ArrayList<Estadio> getEstadios() {
        return estadios;
    }
    
    
}
