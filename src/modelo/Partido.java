package modelo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import gestion.GestionMundial;
import modelo.enums.TipoEvento;
/**
 * Representa un partido de fútbol dentro de un mundial.
 * <p>
 * Un partido posee una fecha, horario, duración, tiempo adicional,
 * estadio, fase del torneo, equipos participantes, cuerpo arbitral
 * y eventos ocurridos durante su desarrollo.
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

    public Partido(){

    }

    public Partido(LocalDate fecha, LocalTime horario, int duracion, int tiempoAdicional) {
        this.fecha = fecha;
        this.horario = horario;
        this.duracion = duracion;
        this.tiempoAdicional = tiempoAdicional;
        this.eventos = new ArrayList<>();
        this.arbitraje = new ArrayList<>();
    }

    public Partido(LocalDate fecha, LocalTime horario, int duracion, int tiempoAdicional, Estadio estadio) {
        this.fecha = fecha;
        this.horario = horario;
        this.duracion = duracion;
        this.tiempoAdicional = tiempoAdicional;
        this.estadio = estadio;
        this.eventos = new ArrayList<>();
        this.arbitraje = new ArrayList<>();
    }

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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getTiempoAdicional() {
        return tiempoAdicional;
    }

    public void setTiempoAdicional(int tiempoAdicional) {
        this.tiempoAdicional = tiempoAdicional;
    }

    public void setEstadio(Estadio estadio) {
        this.estadio = estadio;
    }

    public Estadio getEstadio() {
        return estadio;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public Fase getFase() {
        return fase;
    }

    public Participacion getParticipacionLocal() {
        return participacionLocal;
    }

    public void setParticipacionLocal(Participacion participacionLocal) {
        this.participacionLocal = participacionLocal;
    }

    public Participacion getParticipacionVisitante() {
        return participacionVisitante;
    }

    public void setParticipacionVisitante(Participacion participacionVisitante) {
        this.participacionVisitante = participacionVisitante;
    }

    public void addEventos(Evento evento) {
        this.eventos.add(evento);
    }
    
    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public ArrayList<Arbitraje> getArbitraje() {
        return arbitraje;
    }

    public void addArbitraje(Arbitraje arbitraje) {
        this.arbitraje.add(arbitraje);
    }

    /**
     * Genera y registra un evento para un jugador participante
     * en el partido.
     *
     * @param mundial Mundial al que pertenece el partido.
     * @param sc Scanner utilizado para la entrada de datos.
     */
    public void generarEvento(GestionMundial gestion){
        Scanner sc = new Scanner(System.in);
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
            sc.close();
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
            sc.close();
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
        sc.close();
    }

    @Override
    public String toString() {
        return "Partido -> fecha: " + fecha + " horario: " + horario + " fase:" + fase.getNombre() + " Local: "
                + participacionLocal.getSeleccion().getPais().getNombre() + " Visitante: " + participacionVisitante.getSeleccion().getPais().getNombre();
    }

}
