package modelo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import gestion.GestionMundial;
import modelo.enums.TipoEvento;
/**
 * Representa un partido de fútbol disputado dentro de un mundial.
 * <p>
 * Un partido registra la fecha y horario de disputa, la duración
 * reglamentaria, el tiempo adicional, el estadio donde se juega,
 * la fase del torneo a la que pertenece, las selecciones participantes,
 * el cuerpo arbitral asignado y los eventos ocurridos durante su desarrollo.
 * </p>
 *
 * @author Juan
 * @author Liset
 */
public class Partido {
    private LocalDate fecha;
    private LocalTime horario;
    private int duracion;
    private int tiempoAdicional;
    private Estadio estadio;
    private Fase fase;
    private Participacion participacionLocal;
    private Participacion participacionVisitante;
    private ArrayList<Arbitraje> arbitraje;
    private ArrayList<Evento> eventos;
    /**
     * Crea un partido sin inicializar sus atributos.
     */
    public Partido(){
        this.eventos = new ArrayList<>();
        this.arbitraje = new ArrayList<>();
    }
    /**
     * Crea un partido con los datos básicos especificados.
     *
     * @param fecha fecha de disputa.
     * @param horario horario de inicio.
     * @param duracion duración reglamentaria.
     * @param tiempoAdicional tiempo adicional.
     */
    public Partido(LocalDate fecha, LocalTime horario, int duracion, int tiempoAdicional) {
        this.fecha = fecha;
        this.horario = horario;
        this.duracion = duracion;
        this.tiempoAdicional = tiempoAdicional;
        this.eventos = new ArrayList<>();
        this.arbitraje = new ArrayList<>();
    }
    /**
     * Crea un partido asociado a un estadio.
     *
     * @param fecha fecha de disputa.
     * @param horario horario de inicio.
     * @param duracion duración reglamentaria.
     * @param tiempoAdicional tiempo adicional.
     * @param estadio estadio donde se disputa el encuentro.
     */
    public Partido(LocalDate fecha, LocalTime horario, int duracion, int tiempoAdicional, Estadio estadio) {
        this.fecha = fecha;
        this.horario = horario;
        this.duracion = duracion;
        this.tiempoAdicional = tiempoAdicional;
        this.estadio = estadio;
        this.eventos = new ArrayList<>();
        this.arbitraje = new ArrayList<>();
    }
    /**
     * Crea un partido asociado a un estadio y una fase.
     *
     * @param fecha fecha de disputa.
     * @param horario horario de inicio.
     * @param duracion duración reglamentaria.
     * @param tiempoAdicional tiempo adicional.
     * @param estadio estadio donde se disputa el encuentro.
     * @param fase fase del torneo.
     */
    public Partido(LocalDate fecha, LocalTime horario, int duracion, int tiempoAdicional, Estadio estadio, Fase fase) {
        this.fecha = fecha;
        this.horario = horario;
        this.duracion = duracion;
        this.tiempoAdicional = tiempoAdicional;
        this.estadio = estadio;
        this.fase = fase;
        this.eventos = new ArrayList<>();
        this.arbitraje = new ArrayList<>();
    }
    
    /**
     * Crea un partido con todos sus datos principales.
     *
     * @param fecha fecha de disputa.
     * @param horario horario de inicio.
     * @param duracion duración reglamentaria.
     * @param tiempoAdicional tiempo adicional.
     * @param estadio estadio donde se disputa el encuentro.
     * @param fase fase del torneo.
     * @param participacionLocal participación de la selección local.
     * @param participacionVisitante participación de la selección visitante.
     */
    public Partido(LocalDate fecha, LocalTime horario, int duracion, int tiempoAdicional, Estadio estadio, Fase fase,
            Participacion participacionLocal, Participacion participacionVisitante) {
        this.fecha = fecha;
        this.horario = horario;
        this.duracion = duracion;
        this.tiempoAdicional = tiempoAdicional;
        this.estadio = estadio;
        this.fase = fase;
        this.participacionLocal = participacionLocal;
        this.participacionVisitante = participacionVisitante;
        this.arbitraje = new ArrayList<>();
    }

    /**
     * Obtiene la fecha del partido.
     *
     * @return fecha de disputa.
     */
    public LocalDate getFecha() {
        return fecha;
    }
    /**
     * Establece la fecha del partido.
     *
     * @param fecha fecha a asignar.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    /**
     * Obtiene el horario de inicio del partido.
     *
     * @return horario del encuentro.
     */
    public LocalTime getHorario() {
        return horario;
    }
    /**
     * Establece el horario de inicio del partido.
     *
     * @param horario horario a asignar.
     */
    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }
    /**
     * Obtiene la duración reglamentaria del partido.
     *
     * @return duración en minutos.
     */
    public int getDuracion() {
        return duracion;
    }
    /**
     * Establece la duración reglamentaria del partido.
     *
     * @param duracion duración a asignar.
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    /**
     * Obtiene el tiempo adicional del partido.
     *
     * @return tiempo adicional en minutos.
     */
    public int getTiempoAdicional() {
        return tiempoAdicional;
    }

    /**
     * Establece el tiempo adicional del partido.
     *
     * @param tiempoAdicional tiempo adicional a asignar.
     */
    public void setTiempoAdicional(int tiempoAdicional) {
        this.tiempoAdicional = tiempoAdicional;
    }
    /**
     * Establece el estadio donde se disputa el partido.
     *
     * @param estadio estadio a asociar.
     */
    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }
    /**
     * Obtiene el estadio donde se disputa el partido.
     *
     * @return estadio asociado.
     */
    public Estadio getEstadio() {
        return estadio;
    }
    /**
     * Establece la fase del torneo a la que pertenece el partido.
     *
     * @param fase fase a asociar.
     */
    public void setFase(Fase fase) {
        this.fase = fase;
    }
    /**
     * Obtiene la fase del torneo a la que pertenece el partido.
     *
     * @return fase asociada.
     */
    public Fase getFase() {
        return fase;
    }
    /**
     * Obtiene la participación de la selección local.
     *
     * @return participación local.
     */
    public Participacion getParticipacionLocal() {
        return participacionLocal;
    }
    /**
     * Establece la participación de la selección local.
     *
     * @param participacionLocal participación a asignar.
     */
    public void setParticipacionLocal(Participacion participacionLocal) {
        this.participacionLocal = participacionLocal;
    }
    /**
     * Obtiene la participación de la selección visitante.
     *
     * @return participación visitante.
     */
    public Participacion getParticipacionVisitante() {
        return participacionVisitante;
    }
    /**
     * Establece la participación de la selección visitante.
     *
     * @param participacionVisitante participación a asignar.
     */
    public void setParticipacionVisitante(Participacion participacionVisitante) {
        this.participacionVisitante = participacionVisitante;
    }
    /**
     * Registra un evento ocurrido durante el partido.
     *
     * @param evento evento a agregar.
     */
    public void addEventos(Evento evento) {
        this.eventos.add(evento);
    }
    /**
     * Obtiene los eventos registrados durante el partido.
     *
     * @return lista de eventos.
     */
    public ArrayList<Evento> getEventos() {
        return eventos;
    }
    /**
     * Obtiene el equipo arbitral asignado al partido.
     *
     * @return lista de arbitrajes.
     */
    public ArrayList<Arbitraje> getArbitraje() {
        return arbitraje;
    }
    /**
     * Agrega una participación arbitral al partido.
     *
     * @param arbitraje arbitraje a registrar.
     */
    public void addArbitraje(Arbitraje arbitraje) {
        this.arbitraje.add(arbitraje);
    }

    /**
     * Genera y registra un evento para uno de los jugadores
     * participantes del partido.
     * <p>
     * El método solicita al usuario la selección del jugador,
     * el tipo de evento y el minuto en que ocurrió. Luego registra
     * el evento tanto en el jugador como en el partido.
     * </p>
     *
     * @param gestion gestor del mundial.
     * @param sc scanner utilizado para la entrada de datos.
     */
    public void generarEvento(GestionMundial gestion, Scanner sc){
        ArrayList<Jugador> jugadores = new ArrayList<>();
        for (Jugador jugador : this.participacionLocal.getSeleccion().getJugadores()){
            jugadores.add(jugador);
        }

        for (Jugador jugador : this.participacionVisitante.getSeleccion().getJugadores()){
            jugadores.add(jugador);
        }
        
        System.out.println("\n[+] Seleccione el jugador al cual desea asignarle un evento.");
        int op = 0;
        for (Jugador jugador : jugadores){
            op++;
            System.out.println(op + ". " + jugador.getNombre());
        }
        System.out.print("[+] Ingrese una opcion: ");
        op = sc.nextInt();
        sc.nextLine();
        if (op < 1 || op > jugadores.size()){
            System.out.println("\n[!] Opcion invalida.");
            return;
        }
        Jugador jugador_asignar_evento = jugadores.get(op-1);

        op = 0;
        System.out.println("\n[+] Indique el tipo de evento para el jugador: " + jugador_asignar_evento.getNombre());
        System.out.println("1. Gol");
        System.out.println("2. Tarjeta amarilla");
        System.out.println("3. Tarjeta roja");
        System.out.println("4. Penal cometido");
        System.out.println("5. Penal convertido");
        System.out.println("6. Penal errado");
        System.out.println("7. Doble amarilla");
        System.out.println("8. Sustitucion");
        System.out.println("9. Lesion");

        System.out.print("\n[+] Ingrese una opcion: ");
        op = sc.nextInt();
        sc.nextLine();
        if (op < 1 || op > 9){
            System.out.println("\n[!] Opcion invalida.");
            return;
        }
        System.out.print("[+] Ingrese el minuto del evento: ");
        int minuto = sc.nextInt();
        sc.nextLine();
        TipoEvento tipo_evento;
        switch (op){
            case 1:
                tipo_evento = TipoEvento.Gol;
                break;
            case 2:
                tipo_evento = TipoEvento.TarjetaAmarilla;
                break;
            case 3:
                tipo_evento = TipoEvento.TarjetaRoja;
                break;
            case 4:
                tipo_evento = TipoEvento.PenalCometido;
                break;
            case 5:
                tipo_evento = TipoEvento.PenalConvertido;
                break;
            case 6:
                tipo_evento = TipoEvento.PenalErrado;
                break;
            case 7:
                tipo_evento = TipoEvento.DobleAmarilla;
                break;
            case 8:
                tipo_evento = TipoEvento.Sustitucion;
                break;
            case 9:
                tipo_evento = TipoEvento.Lesion;
                break;
            default:
                tipo_evento = TipoEvento.Gol;
        }

        Evento evento = new Evento(tipo_evento, minuto);
        jugador_asignar_evento.addEventos(evento);
        evento.setJugador(jugador_asignar_evento);
        this.addEventos(evento);
    }
    /**
     * Devuelve una representación textual resumida del partido.
     *
     * @return cadena con la información principal del encuentro.
     */
    @Override
    public String toString() {
        return "Partido -> fecha: " + fecha + " horario: " + horario + " fase:" + fase.getNombre() + " Local: "
                + participacionLocal.getSeleccion().getPais().getNombre() + " Visitante: " + participacionVisitante.getSeleccion().getPais().getNombre();
    }

}
