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
    /**
     * Crea un grupo sin inicializar sus atributos.
     */
    public Grupo(){
        this.seleccion = new ArrayList<>();
    }
    /**
     * Crea un grupo con la identificación y descripción especificadas.
     *
     * @param identificacion identificador del grupo.
     * @param descripcion descripción del grupo.
     */
    public Grupo(String identificacion, String descripcion) {
        this.identificacion = identificacion;
        this.descripcion = descripcion;
        this.seleccion = new ArrayList<>();
    }
    /**
     * Crea un grupo con la identificación, descripción y fase especificadas.
     *
     * @param identificacion identificador del grupo.
     * @param descripcion descripción del grupo.
     * @param fase fase a la que pertenece el grupo.
     */
    public Grupo(String identificacion, String descripcion, Fase fase) {
        this.identificacion = identificacion;
        this.descripcion = descripcion;
        this.fase = fase;
        this.seleccion = new ArrayList<>();
    }

    /**
     * Obtiene el identificador del grupo.
     *
     * @return identificador del grupo.
     */
    public String getIdentificacion() {
        return identificacion;
    }
    /**
     * Establece el identificador del grupo.
     *
     * @param identificacion identificador a asignar.
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    /**
     * Obtiene la descripción del grupo.
     *
     * @return descripción del grupo.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del grupo.
     *
     * @param descripcion descripción a asignar.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Calcula la cantidad de puntos obtenidos por una selección
     * en los partidos correspondientes a la fase del grupo.
     * <p>
     * Se asignan:
     * </p>
     * <ul>
     * <li>3 puntos por victoria.</li>
     * <li>1 punto por empate.</li>
     * <li>0 puntos por derrota.</li>
     * </ul>
     *
     * @param s selección a evaluar.
     * @return cantidad total de puntos obtenidos.
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
    /**
     * Obtiene la fase a la que pertenece el grupo.
     *
     * @return fase asociada al grupo.
     */
    public Fase getFase() {
        return fase;
    }
    /**
     * Establece la fase a la que pertenece el grupo.
     *
     * @param fase fase a asociar.
     */
    public void setFase(Fase fase) {
        this.fase = fase;
    }
    /**
     * Agrega una selección al grupo.
     *
     * @param seleccion selección a incorporar.
     */
    public void addSeleccion(Seleccion seleccion) {
        this.seleccion.add(seleccion);
    }
    /**
     * Obtiene las selecciones que integran el grupo.
     *
     * @return lista de selecciones del grupo.
     */
    public ArrayList<Seleccion> getSeleccion() {
        return seleccion;
    }     
    
}
