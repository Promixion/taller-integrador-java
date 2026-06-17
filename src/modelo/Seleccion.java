package modelo;
import java.util.ArrayList;
/**
 * Representa una selección nacional participante del mundial.
 * <p>
 * Una selección está asociada a un país y posee información sobre
 * su federación, indumentaria, ranking FIFA, grupo asignado,
 * jugadores, directores técnicos, cuerpo técnico y participaciones
 * en partidos.
 * </p>
 *
 * @author Juan
 * @author Liset
 */
public class Seleccion {
    private String nombreFederacion;
    private String camisetaPrincipal;
    private String camisetaSecundaria;
    private boolean cabezaGrupo;
    private int rankingFIFA;
    private ArrayList<Participacion> participaciones;
    private Grupo grupo;
    private Pais pais;
    private ArrayList<Jugador> jugadores;
    private ArrayList<DirectorTecnico> directoresTecnicos;
    private ArrayList<CuerpoTecnico> cuerposTecnicos;

    public Seleccion(String nombreFederacion, String camisetaPrincipal, String camisetaSecundaria, boolean cabezaGrupo,
            int rankingFIFA) {
        this.nombreFederacion = nombreFederacion;
        this.camisetaPrincipal = camisetaPrincipal;
        this.camisetaSecundaria = camisetaSecundaria;
        this.cabezaGrupo = cabezaGrupo;
        this.rankingFIFA = rankingFIFA;
        this.jugadores = new ArrayList<>();
        this.directoresTecnicos = new ArrayList<>();
        this.cuerposTecnicos = new ArrayList<>();
        this.participaciones = new ArrayList<>();
    }
    

    public Seleccion(String nombreFederacion, String camisetaPrincipal, String camisetaSecundaria, boolean cabezaGrupo,
            int rankingFIFA, Grupo grupo) {
        this.nombreFederacion = nombreFederacion;
        this.camisetaPrincipal = camisetaPrincipal;
        this.camisetaSecundaria = camisetaSecundaria;
        this.cabezaGrupo = cabezaGrupo;
        this.rankingFIFA = rankingFIFA;
        this.grupo = grupo;
        this.jugadores = new ArrayList<>();
        this.directoresTecnicos = new ArrayList<>();
        this.cuerposTecnicos = new ArrayList<>();   
        this.participaciones = new ArrayList<>();     
    }


    public Seleccion(String nombreFederacion, String camisetaPrincipal, String camisetaSecundaria, boolean cabezaGrupo,
            int rankingFIFA, ArrayList<Participacion> participacion, Grupo grupo, Pais pais) {
        this.nombreFederacion = nombreFederacion;
        this.camisetaPrincipal = camisetaPrincipal;
        this.camisetaSecundaria = camisetaSecundaria;
        this.cabezaGrupo = cabezaGrupo;
        this.rankingFIFA = rankingFIFA;
        this.participaciones = participacion;
        this.grupo = grupo;
        this.pais = pais;
        this.jugadores = new ArrayList<>();
        this.directoresTecnicos = new ArrayList<>();
        this.cuerposTecnicos = new ArrayList<>();
    }


    public Seleccion() {

    }

    public String getNombreFederacion() {
        return nombreFederacion;
    }

    public void setNombreFederacion(String nombreFederacion) {
        this.nombreFederacion = nombreFederacion;
    }

    public String getCamisetaPrincipal() {
        return camisetaPrincipal;
    }

    public void setCamisetaPrincipal(String camisetaPrincipal) {
        this.camisetaPrincipal = camisetaPrincipal;
    }

    public String getCamisetaSecundaria() {
        return camisetaSecundaria;
    }

    public void setCamisetaSecundaria(String camisetaSecundaria) {
        this.camisetaSecundaria = camisetaSecundaria;
    }

    public boolean isCabezaGrupo() {
        return cabezaGrupo;
    }

    public void setCabezaGrupo(boolean cabezaGrupo) {
        this.cabezaGrupo = cabezaGrupo;
    }

    public int getRankingFIFA() {
        return rankingFIFA;
    }

    public void setRankingFIFA(int rankingFIFA) {
        this.rankingFIFA = rankingFIFA;
    }

    public void addParticipacion(Participacion participacion) {
        this.participaciones.add(participacion);
    }

    public ArrayList<Participacion> getParticipaciones() {
        return participaciones;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Grupo getGrupo() {
        return grupo;
    }


    public Pais getPais() {
        return pais;
    }


    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public void setJugadores(Jugador jugador) {
        this.jugadores.add(jugador);
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setDirectoresTecnicos(DirectorTecnico directorTecnico) {
        this.directoresTecnicos.add(directorTecnico);
    }

    public void setCuerposTecnicos(CuerpoTecnico cuerposTecnico) {
        this.cuerposTecnicos.add(cuerposTecnico);
    }
    
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;                    
        if (obj == null || !(obj instanceof Seleccion)) return false;
        Seleccion seleccion_verificar = (Seleccion) obj;
        if (this.getNombreFederacion().equalsIgnoreCase(seleccion_verificar.getNombreFederacion())){
            return true;
        }else {
            return false;
        }
    }

    public ArrayList<DirectorTecnico> getDirectoresTecnicos() {
        return directoresTecnicos;
    }


    public ArrayList<CuerpoTecnico> getCuerposTecnicos() {
        return cuerposTecnicos;
    }

    
}
