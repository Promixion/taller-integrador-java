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
    /**
     * Crea una sede con valores por defecto.
     * Inicializa la colección de estadios vacía.
     */
    public Sede(){
        this("", 0.0f, "", "");
        this.estadios = new ArrayList<>();
    }
    /**
     * Crea una sede con los datos especificados.
     *
     * @param ciudad ciudad anfitriona.
     * @param alturaNivelMar altura sobre el nivel del mar.
     * @param clima clima predominante.
     * @param zonaHoraria zona horaria de la sede.
     */
    public Sede(String ciudad, float alturaNivelMar, String clima, String zonaHoraria) {
        this.ciudad = ciudad;
        this.alturaNivelMar = alturaNivelMar;
        this.clima = clima;
        this.zonaHoraria = zonaHoraria;
        this.estadios = new ArrayList<>();
    }
    /**
     * Crea una sede asociada a un país.
     *
     * @param ciudad ciudad anfitriona.
     * @param alturaNivelMar altura sobre el nivel del mar.
     * @param clima clima predominante.
     * @param zonaHoraria zona horaria de la sede.
     * @param pais país al que pertenece la sede.
     */
    public Sede(String ciudad, float alturaNivelMar, String clima, String zonaHoraria, Pais pais) {
        this.ciudad = ciudad;
        this.alturaNivelMar = alturaNivelMar;
        this.clima = clima;
        this.zonaHoraria = zonaHoraria;
        this.pais = pais;
        this.estadios = new ArrayList<>();
    }
    /**
     * Crea una sede con todos sus atributos inicializados.
     *
     * @param ciudad ciudad anfitriona.
     * @param alturaNivelMar altura sobre el nivel del mar.
     * @param clima clima predominante.
     * @param zonaHoraria zona horaria de la sede.
     * @param pais país al que pertenece la sede.
     * @param estadios lista de estadios de la sede.
     */
    public Sede(String ciudad, float alturaNivelMar, String clima, String zonaHoraria, Pais pais,
            ArrayList<Estadio> estadios) {
        this.ciudad = ciudad;
        this.alturaNivelMar = alturaNivelMar;
        this.clima = clima;
        this.zonaHoraria = zonaHoraria;
        this.pais = pais;
        this.estadios = estadios;

    }

    /**
     * Obtiene la ciudad de la sede.
     *
     * @return ciudad anfitriona.
     */
    public String getCiudad() {
        return ciudad;
    }
    /**
     * Establece la ciudad de la sede.
     *
     * @param ciudad ciudad a asignar.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    /**
     * Obtiene la altura sobre el nivel del mar.
     *
     * @return altura en metros.
     */
    public float getAlturaNivelMar() {
        return alturaNivelMar;
    }
    /**
     * Establece la altura sobre el nivel del mar.
     *
     * @param alturaNivelMar altura a asignar.
     */
    public void setAlturaNivelMar(float alturaNivelMar) {
        this.alturaNivelMar = alturaNivelMar;
    }

    /**
     * Obtiene el clima predominante de la sede.
     *
     * @return clima de la sede.
     */
    public String getClima() {
        return clima;
    }
    /**
     * Establece el clima predominante de la sede.
     *
     * @param clima clima a asignar.
     */
    public void setClima(String clima) {
        this.clima = clima;
    }
    /**
     * Obtiene la zona horaria de la sede.
     *
     * @return zona horaria.
     */
    public String getZonaHoraria() {
        return zonaHoraria;
    }
    /**
     * Establece la zona horaria de la sede.
     *
     * @param zonaHoraria zona horaria a asignar.
     */
    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }
    /**
     * Establece el país al que pertenece la sede.
     *
     * @param pais país a asociar.
     */
    public void setPais(Pais pais) {
        this.pais = pais;
    }
    /**
     * Obtiene el país al que pertenece la sede.
     *
     * @return país asociado.
     */
    public Pais getPais() {
        return pais;
    }

    /**
     * Agrega un estadio a la sede.
     *
     * @param estadio estadio a incorporar.
     */
    public void addEstadio(Estadio estadio) {
        this.estadios.add(estadio);
    }
    /**
     * Obtiene los estadios de la sede.
     *
     * @return lista de estadios.
     */
    public ArrayList<Estadio> getEstadios() {
        return estadios;
    }
    /**
     * Devuelve una representación textual de la sede y sus atributos.
     *
     * @return cadena con la información de la sede.
     */
    @Override
    public String toString() {
        return "\nciudad:" + ciudad + ", alturaNivelMar: " + alturaNivelMar + ", clima: " + clima + ", zonaHoraria: "
                + zonaHoraria + ", pais: " + pais + ", estadios: " + estadios;
    }

    /**
     * Compara dos sedes considerando únicamente el nombre de la ciudad,
     * ignorando diferencias entre mayúsculas y minúsculas.
     *
     * @param nueva_sede objeto a comparar.
     * @return {@code true} si ambas sedes corresponden a la misma ciudad;
     *         {@code false} en caso contrario.
     */
    @Override
    public boolean equals(Object nueva_sede) {
        if (this == nueva_sede) return true;                    
        if (nueva_sede == null || !(nueva_sede instanceof Sede)) return false; 
        return this.ciudad.toLowerCase().equals(((Sede) nueva_sede).getCiudad().toLowerCase());
    }

}
