package modelo;
import java.util.ArrayList;
/**
 * Representa un grupo del mundial.
 * Un grupo agrupa selecciones participantes y puede estar
 * asociado a una fase determinada del torneo.
 *
 * @author Juan
 * @author Liset
 */
public class Grupo {
    private String identificacion;
    private String descripcion;
    private Fase fase;
    private ArrayList<Seleccion> seleccion;

    public Grupo(){

    }

    public Grupo(String identificacion, String descripcion) {
        this.identificacion = identificacion;
        this.descripcion = descripcion;
        this.seleccion = new ArrayList<>();
    }

    public Grupo(String identificacion, String descripcion, Fase fase) {
        this.identificacion = identificacion;
        this.descripcion = descripcion;
        this.fase = fase;
        this.seleccion = new ArrayList<>();
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Calcula la cantidad de puntos obtenidos por una selección
     * en los partidos correspondientes a la fase del grupo.
     *
     * Se asignan:
     * - 3 puntos por victoria.
     * - 1 punto por empate.
     * - 0 puntos por derrota.
     *
     * @param s selección a evaluar
     * @return cantidad total de puntos obtenidos
     */
    public int obtenerPuntos(Seleccion s){
        int puntos = 0;

        for (Partido partido : this.fase.getPartidos()) {
            Participacion partLocal = partido.getParticipacionLocal();
            Participacion partVisitante = partido.getParticipacionVisitante();

            boolean esLocal = partLocal.getSeleccion().equals(s);
            boolean esVisitante = partVisitante.getSeleccion().equals(s);

            if (!esLocal && !esVisitante) continue;

            int golesLocal = partLocal.cantidadGoles();
            int golesVisitante = partVisitante.cantidadGoles();

            if (golesLocal == golesVisitante) {
                puntos += 1; 
            } else if (esLocal && golesLocal > golesVisitante) {
                puntos += 3; 
            } else if (esVisitante && golesVisitante > golesLocal) {
                puntos += 3; 
            }

        }

        return puntos;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public void addSeleccion(Seleccion seleccion) {
        this.seleccion.add(seleccion);
    }

    public ArrayList<Seleccion> getSeleccion() {
        return seleccion;
    }     
    
}
