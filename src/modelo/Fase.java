package modelo;
import java.util.ArrayList;

import modelo.enums.NombreFase;
/**
 * Representa una fase del mundial.
 * Una fase agrupa los partidos que se disputan en una determinada
 * instancia del torneo y, cuando corresponde, los grupos que forman
 * parte de ella.
 *
 * @author Juan
 * @author Liset
 */
public class Fase {
    private NombreFase nombre;
    private ArrayList<Grupo> grupos;
    private ArrayList<Partido> partidos;
    /**
     * Crea una fase sin nombre asignado.
     * Inicializa las colecciones de grupos y partidos vacías.
     */
    public Fase(){
        this.grupos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }
    /**
     * Crea una fase con el nombre especificado.
     *
     * @param nombre nombre de la fase del torneo.
     */
    public Fase(NombreFase nombre) {
        this.nombre = nombre;
        this.grupos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }
    
    /**
     * Obtiene los partidos asociados a la fase.
     *
     * @return lista de partidos de la fase.
     */
    public ArrayList<Partido> getPartidos() {
        return partidos;
    }
    /**
     * Agrega un partido a la fase.
     *
     * @param partido partido a incorporar.
     */
    public void addPartidos(Partido partido) {
        this.partidos.add(partido);
    }
    /**
     * Obtiene el nombre de la fase.
     *
     * @return el nombre de la fase.
     */
    public NombreFase getNombre() {
        return nombre;
    }
    /**
     * Establece el nombre de la fase.
     *
     * @param nombre nombre a asignar.
     */
    public void setNombre(NombreFase nombre) {
        this.nombre = nombre;
    }
    /**
     * Obtiene los grupos pertenecientes a la fase.
     *
     * @return lista de grupos de la fase.
     */
    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }
    /**
     * Agrega un grupo a la fase.
     *
     * @param grupo grupo a incorporar.
     */
    public void addGrupos(Grupo grupo) {
        this.grupos.add(grupo);
    }

}
