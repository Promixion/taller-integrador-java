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

    public Fase(){
        this.grupos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    public Fase(NombreFase nombre) {
        this.nombre = nombre;
        this.grupos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }
    

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void addPartidos(Partido partido) {
        this.partidos.add(partido);
    }

    public NombreFase getNombre() {
        return nombre;
    }

    public void setNombre(NombreFase nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public void addGrupos(Grupo grupo) {
        this.grupos.add(grupo);
    }

}
