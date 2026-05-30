import java.util.ArrayList;
import java.util.Scanner;

public class Estadio {
    private String nombre;
    private int capacidad;
    private Sede sede;
    private ArrayList<Partido> partido;

    public Estadio(){
        this("", 0);
        this.partido = new ArrayList<>();
    }

    public Estadio(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.partido = new ArrayList<>();
    }

    public Estadio(String nombre, int capacidad, Sede sede) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sede = sede;
        this.partido = new ArrayList<>();
    }    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Sede getSede(){
        return sede;
    }

    public void setSede(Sede sede){
        this.sede = sede;
    }

    public void addPartido(Partido partido) {
        this.partido.add(partido);
    }

    public ArrayList<Partido> getPartido() {
        return partido;
    }

    @Override
    public String toString() {
        return "\nnombre: " + nombre + ", capacidad: " + capacidad + ", sede:" + sede + ", partido: " + partido;
    } 
       
    public static Estadio agregarEstadio(Scanner sc){
        String nombre;
        int capacidad;

        System.out.print("\n[+] Ingrese el nombre del estadio: ");
        nombre = sc.nextLine();
        System.out.print("\n[+] Ingrese la capacidad del estadio: ");
        capacidad = sc.nextInt();
        sc.nextLine();

        return new Estadio(nombre, capacidad);

    }
    public static void estadisticasPorEstadio(Mundial mundial, Scanner sc) {

        ArrayList<Estadio> estadios = new ArrayList<>();
        for (Sede sede : mundial.getSedes()) {
            for (Estadio estadio : sede.getEstadios()) {
                estadios.add(estadio);
            }
        }

        if (estadios.isEmpty()) {
            System.out.println("[!] No hay estadios registrados.");
            return;
        }

        int id = 0;
        System.out.println("\n[+] Seleccione el estadio:\n");
        for (Estadio estadio : estadios) {
            System.out.println((++id) + ". " + estadio.getNombre() + " - " + estadio.getSede().getCiudad());
        }
        System.out.print("\n[+] Ingrese una opcion: ");
        int op = sc.nextInt();
        sc.nextLine();

        if (op < 1 || op > estadios.size()) {
            System.out.println("[!] Identificador invalido.");
            return;
        }

        Estadio estadio = estadios.get(op - 1);

        System.out.println("\n================================================================");
        System.out.println("          ESTADISTICAS - " + estadio.getNombre().toUpperCase());
        System.out.println("================================================================");
        System.out.println("  Ciudad   : " + estadio.getSede().getCiudad());
        System.out.println("  Capacidad: " + estadio.getCapacidad() + " espectadores");
        System.out.println("  Partidos jugados: " + estadio.getPartido().size());
        System.out.println("----------------------------------------------------------------\n");

        if (estadio.getPartido().isEmpty()) {
            System.out.println("  [i] No hay partidos jugados en este estadio.");
            return;
        }

        System.out.printf("  %-12s %-20s %-20s %8s%n", "Fase", "Local", "Visitante", "Result.");
        System.out.println("  ----------------------------------------------------------------");

        int totalGoles = 0;

        for (Partido partido : estadio.getPartido()) {
            Participacion local = partido.getParticipacionLocal();
            Participacion visitante = partido.getParticipacionVisitante();
            int gl = local.cantidadGoles();
            int gv = visitante.cantidadGoles();
            totalGoles += gl + gv;

            System.out.printf("  %-12s %-20s %-20s %4d - %-4d%n",
                    partido.getFase().getNombre(),
                    local.getSeleccion().getPais().getNombre(),
                    visitante.getSeleccion().getPais().getNombre(),
                    gl, gv);
        }

        System.out.println("  ----------------------------------------------------------------");
        System.out.println("  Total de goles en el estadio: " + totalGoles);
        System.out.println("================================================================\n");
    }
}
