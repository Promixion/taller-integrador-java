package modelo;
import java.util.ArrayList;
/**
 * Representa un mundial de fútbol.
 * Almacena la información general del torneo, incluyendo
 * el año de realización, la mascota oficial, el período
 * de disputa y las sedes donde se desarrollan los partidos.
 *
 * @author Juan
 * @author Liset
 */
public class Mundial {
    private int anio;
    private String mascota;
    private int fechaDesde;
    private int fechaHasta;
    private ArrayList<Sede> sedes;
    /**
     * Crea un mundial con valores por defecto.
     * Inicializa la lista de sedes vacía.
     */
    public Mundial(){
        this(0, "", 0, 1);
        this.sedes = new ArrayList<>();
    }
    /**
     * Crea un mundial con los datos especificados.
     *
     * @param anio año de realización del mundial.
     * @param mascota mascota oficial del torneo.
     * @param fechaDesde fecha de inicio del torneo.
     * @param fechaHasta fecha de finalización del torneo.
     */
    public Mundial(int anio, String mascota, int fechaDesde, int fechaHasta) {
        this.anio = anio;
        this.mascota = mascota;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.sedes = new ArrayList<>();
    }
    /**
     * Obtiene el año en que se disputa el mundial.
     *
     * @return año del mundial.
     */
    public int getAnio() {
        return anio;
    }
    /**
     * Establece el año en que se disputa el mundial.
     *
     * @param anio año a asignar.
     */
    public void setAnio(int anio) {
        this.anio = anio;
    }
    /**
     * Obtiene la mascota oficial del torneo.
     *
     * @return mascota oficial.
     */
    public String getMascota() {
        return mascota;
    }
    /**
     * Establece la mascota oficial del torneo.
     *
     * @param mascota mascota a asignar.
     */
    public void setMascota(String mascota) {
        this.mascota = mascota;
    }
    /**
     * Obtiene la fecha de inicio del mundial.
     *
     * @return fecha de inicio.
     */
    public int getFechaDesde() {
        return fechaDesde;
    }
    /**
     * Establece la fecha de inicio del mundial.
     *
     * @param fechaDesde fecha de inicio a asignar.
     */
    public void setFechaDesde(int fechaDesde) {
        this.fechaDesde = fechaDesde;
    }
    /**
     * Obtiene la fecha de finalización del mundial.
     *
     * @return fecha de finalización.
     */
    public int getFechaHasta() {
        return fechaHasta;
    }
    /**
     * Establece la fecha de finalización del mundial.
     *
     * @param fechaHasta fecha de finalización a asignar.
     */
    public void setFechaHasta(int fechaHasta) {
        this.fechaHasta = fechaHasta;
    }
    /**
     * Obtiene las sedes del torneo.
     *
     * @return lista de sedes.
     */
    public ArrayList<Sede> getSedes() {
        return sedes;
    }
    /**
     * Agrega una sede al mundial.
     *
     * @param sede sede a incorporar.
     */
    public void addSede(Sede sede) {
        this.sedes.add(sede);
    }
    /**
     * Reemplaza la lista completa de sedes del mundial.
     *
     * @param sedes nueva lista de sedes.
     */
    public void setSedes(ArrayList<Sede> sedes) {
        this.sedes = sedes;
    }

}
