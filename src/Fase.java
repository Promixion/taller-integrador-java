import java.util.ArrayList;

public class Fase {
    private NombreFase nombre;
    private ArrayList<Grupo> grupos;
    private ArrayList<Partido> partidos;

    public Fase(){

    }

    public Fase(NombreFase nombre) {
        this.nombre = nombre;
    }
    

    public void setGrupos(ArrayList<Grupo> grupos) {
        this.grupos = grupos;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(Partido partido) {
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

    public void setGrupos(Grupo grupo) {
        this.grupos.add(grupo);
    }
    
    

}
