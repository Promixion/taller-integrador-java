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
    /**
     * Crea una selección con sus datos principales.
     *
     * @param nombreFederacion nombre de la federación.
     * @param camisetaPrincipal camiseta principal.
     * @param camisetaSecundaria camiseta secundaria.
     * @param cabezaGrupo indica si es cabeza de grupo.
     * @param rankingFIFA posición en el ranking FIFA.
     */
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
    
    /**
     * Crea una selección asociada a un grupo.
     *
     * @param nombreFederacion nombre de la federación.
     * @param camisetaPrincipal camiseta principal.
     * @param camisetaSecundaria camiseta secundaria.
     * @param cabezaGrupo indica si es cabeza de grupo.
     * @param rankingFIFA posición en el ranking FIFA.
     * @param grupo grupo al que pertenece la selección.
     */
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

   /**
     * Crea una selección con todos sus datos principales.
     *
     * @param nombreFederacion nombre de la federación.
     * @param camisetaPrincipal camiseta principal.
     * @param camisetaSecundaria camiseta secundaria.
     * @param cabezaGrupo indica si es cabeza de grupo.
     * @param rankingFIFA posición en el ranking FIFA.
     * @param participacion participaciones registradas.
     * @param grupo grupo al que pertenece.
     * @param pais país representado.
     */
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

    /**
     * Crea una selección sin inicializar sus atributos.
     */
    public Seleccion() {
        this.jugadores = new ArrayList<>();
        this.directoresTecnicos = new ArrayList<>();
        this.cuerposTecnicos = new ArrayList<>();
    }

    /**
     * Obtiene el nombre de la federación.
     *
     * @return nombre de la federación.
     */
    public String getNombreFederacion() {
        return nombreFederacion;
    }
    /**
     * Establece el nombre de la federación.
     *
     * @param nombreFederacion nombre a asignar.
     */
    public void setNombreFederacion(String nombreFederacion) {
        this.nombreFederacion = nombreFederacion;
    }
    /**
     * Obtiene la camiseta principal.
     *
     * @return camiseta principal.
     */
    public String getCamisetaPrincipal() {
        return camisetaPrincipal;
    }

    /**
     * Establece la camiseta principal.
     *
     * @param camisetaPrincipal camiseta a asignar.
     */
    public void setCamisetaPrincipal(String camisetaPrincipal) {
        this.camisetaPrincipal = camisetaPrincipal;
    }
    /**
     * Obtiene la camiseta secundaria.
     *
     * @return camiseta secundaria.
     */
    public String getCamisetaSecundaria() {
        return camisetaSecundaria;
    }
    /**
     * Establece la camiseta secundaria.
     *
     * @param camisetaSecundaria camiseta a asignar.
     */
    public void setCamisetaSecundaria(String camisetaSecundaria) {
        this.camisetaSecundaria = camisetaSecundaria;
    }
    /**
     * Indica si la selección es cabeza de grupo.
     *
     * @return {@code true} si es cabeza de grupo;
     *         {@code false} en caso contrario.
     */
    public boolean isCabezaGrupo() {
        return cabezaGrupo;
    }
    /**
     * Establece si la selección es cabeza de grupo.
     *
     * @param cabezaGrupo valor a asignar.
     */
    public void setCabezaGrupo(boolean cabezaGrupo) {
        this.cabezaGrupo = cabezaGrupo;
    }
    /**
     * Obtiene la posición de la selección en el ranking FIFA.
     *
     * @return ranking FIFA.
     */
    public int getRankingFIFA() {
        return rankingFIFA;
    }
    /**
     * Establece la posición de la selección en el ranking FIFA.
     *
     * @param rankingFIFA ranking a asignar.
     */
    public void setRankingFIFA(int rankingFIFA) {
        this.rankingFIFA = rankingFIFA;
    }
    /**
     * Registra una participación de la selección en un partido.
     *
     * @param participacion participación a agregar.
     */
    public void addParticipacion(Participacion participacion) {
        this.participaciones.add(participacion);
    }
    /**
     * Obtiene las participaciones registradas.
     *
     * @return lista de participaciones.
     */
    public ArrayList<Participacion> getParticipaciones() {
        return participaciones;
    }
    /**
     * Establece el grupo de la selección.
     *
     * @param grupo grupo a asociar.
     */
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    /**
     * Obtiene el grupo de la selección.
     *
     * @return grupo asociado.
     */
    public Grupo getGrupo() {
        return grupo;
    }


    /**
     * Obtiene el país representado por la selección.
     *
     * @return país asociado.
     */
    public Pais getPais() {
        return pais;
    }

    /**
     * Establece el país representado por la selección.
     *
     * @param pais país a asociar.
     */
    public void setPais(Pais pais) {
        this.pais = pais;
    }
    /**
     * Agrega un jugador a la selección.
     *
     * @param jugador jugador a incorporar.
     */
    public void setJugadores(Jugador jugador) {
        this.jugadores.add(jugador);
    }
    /**
     * Obtiene los jugadores de la selección.
     *
     * @return lista de jugadores.
     */
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    /**
     * Agrega un director técnico a la selección.
     *
     * @param directorTecnico director técnico a incorporar.
     */
    public void setDirectoresTecnicos(DirectorTecnico directorTecnico) {
        this.directoresTecnicos.add(directorTecnico);
    }
    /**
     * Agrega un integrante al cuerpo técnico.
     *
     * @param cuerposTecnico integrante a incorporar.
     */
    public void setCuerposTecnicos(CuerpoTecnico cuerposTecnico) {
        this.cuerposTecnicos.add(cuerposTecnico);
    }
    /**
     * Compara dos selecciones considerando únicamente el nombre
     * de la federación, ignorando diferencias entre mayúsculas
     * y minúsculas.
     *
     * @param obj objeto a comparar.
     * @return {@code true} si ambas selecciones representan la
     *         misma federación; {@code false} en caso contrario.
     */ 
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
    /**
     * Obtiene los directores técnicos de la selección.
     *
     * @return lista de directores técnicos.
     */
    public ArrayList<DirectorTecnico> getDirectoresTecnicos() {
        return directoresTecnicos;
    }

    /**
     * Obtiene los integrantes del cuerpo técnico.
     *
     * @return lista de integrantes del cuerpo técnico.
     */
    public ArrayList<CuerpoTecnico> getCuerposTecnicos() {
        return cuerposTecnicos;
    }

    
}
