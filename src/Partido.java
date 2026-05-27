import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

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

    public ArrayList<Arbitraje> getArbitraje() {
        return arbitraje;
    }

    public void addArbitraje(Arbitraje arbitraje) {
        this.arbitraje.add(arbitraje);
    }

    public void generarEvento(Mundial mundial, Scanner sc){

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

    @Override
    public String toString() {
        return "Partido -> fecha: " + fecha + " horario: " + horario + " fase:" + fase.getNombre() + " participacionLocal: "
                + participacionLocal.getSeleccion().getPais().getNombre() + " participacionVisitante: " + participacionVisitante.getSeleccion().getPais().getNombre();
    }

    public static void configurarArbitraje(Mundial mundial, Scanner sc, Partido partido){

        boolean agregar;
        int op = 0;
        Arbitraje arbitraje = null;
        do {
            op = 0;
            System.out.println("\n[+] Seleccione los arbitros que conformaran el equipo de arbitraje.");
            for (Arbitro arbitro : mundial.getArbitros()){
                op++;
                System.out.println(op + ". " + arbitro.getNombre());
            }
            System.out.print("\n[+] Seleccione el arbitro: ");
            op = sc.nextInt();
            sc.nextLine();

            Arbitro arbitro = mundial.getArbitros().get(op-1);

            op = 0;
            System.out.println("\n[+] Indique la categoria del arbitro.");
            System.out.println("1. Principal");
            System.out.println("2. Primer asistente");
            System.out.println("3. Segundo asistente");
            System.out.println("4. Cuarto arbitro");
            System.out.println("5. VAR principal");
            System.out.println("6. VAR asistente");
            System.out.print("\n[+] Seleccione la categoria: ");
            op = sc.nextInt();
            sc.nextLine();
            switch (op){
                case 1:
                    arbitraje = new Arbitraje(CategoriaArbitro.Principal);
                    break;
                case 2:
                    arbitraje = new Arbitraje(CategoriaArbitro.Asistente1);
                    break;
                case 3:
                    arbitraje = new Arbitraje(CategoriaArbitro.Asistente2);
                    break;
                case 4:
                    arbitraje = new Arbitraje(CategoriaArbitro.CuartoArbitro);
                    break;
                case 5:
                    arbitraje = new Arbitraje(CategoriaArbitro.VarPrincipal);
                    break;
                case 6:
                    arbitraje = new Arbitraje(CategoriaArbitro.VarAsistente);
                    break;
            }

            arbitraje.setArbitro(arbitro);
            arbitraje.setPartido(partido);

            arbitro.addArbitraje(arbitraje);
            partido.addArbitraje(arbitraje);

            System.out.print("[+] Desea agregar alguien mas al equipo de arbitraje? (si/no): ");
            String resp = sc.nextLine().toLowerCase();
            boolean arbitraje_valido = false;
            if (resp.equals("si")){
                agregar = true;
            } else {
                agregar = false;
                for (Arbitraje arbitraje_check : partido.getArbitraje()){
                    if (arbitraje_check.getRol() == CategoriaArbitro.Principal){
                        arbitraje_valido = true;
                    }
                }
                if (!arbitraje_valido){
                    System.out.println("\n[!] Se requiere un arbitro de rol principal.");
                    agregar = true;
                }
            }

        } while (agregar);

    }

    public static void planificarPartido(Mundial mundial, Scanner sc){

        ArrayList<Estadio> estadios_disponibles = new ArrayList<>();

        System.out.print("\n[+] Ingrese la fecha del partido (AÑO-MES-DIA): ");
        LocalDate fecha = LocalDate.parse(sc.nextLine());
        System.out.print("\n[+] Ingrese el horario (HORA:MINUTO): ");
        LocalTime horario = LocalTime.parse(sc.nextLine());
        System.out.print("\n[+] Ingrese la duracion del partido: ");
        int duracion = sc.nextInt();
        sc.nextLine();
        System.out.print("\n[+] Indique el tiempo adicional que tendra el partido: ");
        int tiempoAdicional = sc.nextInt();
        sc.nextLine();

        Partido partido = new Partido(fecha, horario, duracion, tiempoAdicional);

        for (Sede sede : mundial.getSedes()){
            for (Estadio estadio : sede.getEstadios()){
                    estadios_disponibles.add(estadio);
            }
        }

        int op = 0;
        System.out.println("\n[+] Seleccione el estadio donde se jugara el partido");
        for (Estadio estadio : estadios_disponibles){
            op++;
            System.out.println(op + ". " + estadio.getNombre());
        }
        System.out.print("\n[+] Ingrese el indentificador del estadio: ");
        op = sc.nextInt();
        sc.nextLine();
        partido.setEstadio(estadios_disponibles.get(op-1));
        estadios_disponibles.get(op-1).addPartido(partido);

        op = 0;
        System.out.println("[+] Indique a que fase corresponde el partido.");
        for (Fase fase : mundial.getFases()){
            op++;
            System.out.println(op + ". " + fase.getNombre());
        }
        System.out.print("\n[+] Ingrese la fase a la que pertenece el partido: ");
        op = sc.nextInt();
        sc.nextLine();

        partido.setFase(mundial.getFases().get(op-1));
        mundial.getFases().get(op-1).addPartidos(partido);

        op = 0;
        System.out.println("[+] Indique las selecciones que jugaran el partido.");
        for (Seleccion seleccion : mundial.getSelecciones()){
            op++;
            System.out.println(op + ". " + seleccion.getPais().getNombre());
        }

        System.out.print("[+] Ingrese la seleccion LOCAL: ");
        int op1 = sc.nextInt();
        sc.nextLine();
        System.out.print("[+] Ingrese la seleccion VISITANTE: ");
        int op2 = sc.nextInt();
        sc.nextLine();
        if (op1 == op2){
            System.out.println("[!] No puede indicar la misma seleccion.");
            return;
        }
        Seleccion seleccionLocal = mundial.getSelecciones().get(op1-1);
        Seleccion seleccionVisitante = mundial.getSelecciones().get(op2-1);

        Participacion participacionLocal = new Participacion(true, partido, seleccionLocal);
        Participacion participacionVisitante = new Participacion(false, partido, seleccionVisitante);

        partido.setParticipacionLocal(participacionLocal);
        partido.setParticipacionVisitante(participacionVisitante);

        participacionLocal.setPartido(partido);
        participacionVisitante.setPartido(partido);

        seleccionLocal.addParticipacion(participacionLocal);
        seleccionVisitante.addParticipacion(participacionVisitante);

        configurarArbitraje(mundial, sc, partido);

        mundial.addPartidos(partido);

        System.out.println("\n[+] El partido se ha planificado exitosamente.");

    }

}
