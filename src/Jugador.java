import java.util.ArrayList;
import java.util.Scanner;

public class Jugador extends Persona {
    private int dorsal;
    private Posicion posicion;
    private float peso;
    private float altura;
    private ArrayList<Evento> eventos;

    public Jugador(){

    }

    public Jugador(String nombre, int fecNacimiento, int dorsal, Posicion posicion, float peso, float altura) {
        super(nombre, fecNacimiento);
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.peso = peso;
        this.altura = altura;
        this.eventos = new ArrayList<>();
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void addEventos(Evento evento) {
        this.eventos.add(evento);
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }
    
    public static void rankingGoleadores(Mundial mundial) {

        if (mundial.getSelecciones().isEmpty()) {
            System.out.println("[!] No hay selecciones registradas.");
            return;
        }

        ArrayList<Jugador> jugadores = new ArrayList<>();
        ArrayList<Integer> goles = new ArrayList<>();
        ArrayList<String> paises = new ArrayList<>();

        for (Seleccion seleccion : mundial.getSelecciones()) {
            for (Jugador jugador : seleccion.getJugadores()) {
                int cantGoles = 0;
                for (Evento evento : jugador.getEventos()) {
                    if (evento.getTipo() == TipoEvento.Gol || 
                        evento.getTipo() == TipoEvento.PenalConvertido) {
                        cantGoles++;
                    }
                }
                if (cantGoles > 0) {
                    jugadores.add(jugador);
                    goles.add(cantGoles);
                    paises.add(seleccion.getPais().getNombre());
                }
            }
        }

        if (jugadores.isEmpty()) {
            System.out.println("[!] No hay goles registrados aun.");
            return;
        }

        for (int i = 0; i < goles.size() - 1; i++) {
            for (int j = 0; j < goles.size() - 1 - i; j++) {
                if (goles.get(j) < goles.get(j + 1)) {
                    int tempG = goles.get(j);
                    goles.set(j, goles.get(j + 1));
                    goles.set(j + 1, tempG);
                    Jugador tempJ = jugadores.get(j);
                    jugadores.set(j, jugadores.get(j + 1));
                    jugadores.set(j + 1, tempJ);
                    String tempP = paises.get(j);
                    paises.set(j, paises.get(j + 1));
                    paises.set(j + 1, tempP);
                }
            }
        }

        System.out.println("\n========== RANKING DE GOLEADORES ==========\n");
        System.out.printf("%-5s %-20s %-20s %6s%n", "POS", "Jugador", "Seleccion", "Goles");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < jugadores.size(); i++) {
            System.out.printf("%-5d %-20s %-20s %6d%n",
                    i + 1,
                    jugadores.get(i).getNombre(),
                    paises.get(i),
                    goles.get(i));
        }

        System.out.println("--------------------------------------------------");
    }
    public static void informeDisciplinarioJugador(Mundial mundial, Scanner sc) {

        int id = 0;
        System.out.println("\n[+] Seleccione la seleccion del jugador:\n");
        for (Seleccion seleccion : mundial.getSelecciones()) {
            System.out.println((++id) + ". " + seleccion.getPais().getNombre());
        }
        System.out.print("\n[+] Ingrese una opcion: ");
        int op = sc.nextInt();
        sc.nextLine();

        if (op < 1 || op > mundial.getSelecciones().size()) {
            System.out.println("[!] Identificador invalido.");
            return;
        }

        Seleccion seleccion = mundial.getSelecciones().get(op - 1);

        id = 0;
        System.out.println("\n[+] Seleccione el jugador:\n");
        for (Jugador jugador : seleccion.getJugadores()) {
            System.out.println((++id) + ". " + jugador.getNombre());
        }
        System.out.print("\n[+] Ingrese una opcion: ");
        op = sc.nextInt();
        sc.nextLine();

        if (op < 1 || op > seleccion.getJugadores().size()) {
            System.out.println("[!] Identificador invalido.");
            return;
        }

        Jugador jugador = seleccion.getJugadores().get(op - 1);

        System.out.println("\n========== INFORME DISCIPLINARIO - " + jugador.getNombre().toUpperCase() + " ==========\n");
        System.out.printf("%-15s %-25s %-10s%n", "Tipo", "Partido", "Minuto");
        System.out.println("--------------------------------------------------");

        boolean tieneTarjetas = false;

        for (Evento evento : jugador.getEventos()) {
            if (evento.getTipo() == TipoEvento.TarjetaAmarilla ||
                evento.getTipo() == TipoEvento.TarjetaRoja ||
                evento.getTipo() == TipoEvento.DobleAmarilla) {

                String nombrePartido = "Desconocido";
                for (Partido partido : mundial.getPartidos()) {
                    if (partido.getEventos().contains(evento)) {
                        nombrePartido = partido.getParticipacionLocal().getSeleccion().getPais().getNombre()
                                + " vs "
                                + partido.getParticipacionVisitante().getSeleccion().getPais().getNombre();
                        break;
                    }
                }

                System.out.printf("%-15s %-25s %-10d%n",
                        evento.getTipo(),
                        nombrePartido,
                        evento.getMinuto());
                tieneTarjetas = true;
            }
        }

        if (!tieneTarjetas) {
            System.out.println("[i] El jugador no tiene tarjetas registradas.");
        }

        System.out.println("--------------------------------------------------");
    }

}
