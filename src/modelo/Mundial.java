package modelo;
import java.util.ArrayList;
/**
 * Representa un mundial de fútbol.
 * Almacena la información general del torneo, incluyendo
 * sus sedes, países participantes, selecciones, árbitros,
 * grupos, fases y partidos disputados.
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

    public Mundial(){
        this(0, "", 0, 1);
        this.sedes = new ArrayList<>();
    }
    
    public Mundial(int anio, String mascota, int fechaDesde, int fechaHasta) {
        this.anio = anio;
        this.mascota = mascota;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.sedes = new ArrayList<>();
    }

    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public String getMascota() {
        return mascota;
    }
    public void setMascota(String mascota) {
        this.mascota = mascota;
    }
    public int getFechaDesde() {
        return fechaDesde;
    }
    public void setFechaDesde(int fechaDesde) {
        this.fechaDesde = fechaDesde;
    }
    public int getFechaHasta() {
        return fechaHasta;
    }
    public void setFechaHasta(int fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public ArrayList<Sede> getSedes() {
        return sedes;
    }

    public void addSede(Sede sede) {
        this.sedes.add(sede);
    }
    
    public void setSedes(ArrayList<Sede> sedes) {
        this.sedes = sedes;
    }

}
