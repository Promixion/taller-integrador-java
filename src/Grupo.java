import java.util.ArrayList;
import java.util.Scanner;

public class Grupo {
    private String identificacion;
    private String descripcion;
    private Fase fase;
    private ArrayList<Seleccion> seleccion;

    public Grupo(){

    }

    public Grupo(String identificacion, String descripcion) {
        this.identificacion = identificacion;
        this.descripcion = descripcion;
        this.seleccion = new ArrayList<>();
    }

    public Grupo(String identificacion, String descripcion, Fase fase) {
        this.identificacion = identificacion;
        this.descripcion = descripcion;
        this.fase = fase;
        this.seleccion = new ArrayList<>();
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int obtenerPuntos(Seleccion s){
        int puntos = 0;

        for (Partido partido : this.fase.getPartidos()) {
            Participacion partLocal = partido.getParticipacionLocal();
            Participacion partVisitante = partido.getParticipacionVisitante();

            boolean esLocal = partLocal.getSeleccion().equals(s);
            boolean esVisitante = partVisitante.getSeleccion().equals(s);

            if (!esLocal && !esVisitante) continue;

            int golesLocal = partLocal.cantidadGoles();
            int golesVisitante = partVisitante.cantidadGoles();

            if (golesLocal == golesVisitante) {
                puntos += 1; 
            } else if (esLocal && golesLocal > golesVisitante) {
                puntos += 3; 
            } else if (esVisitante && golesVisitante > golesLocal) {
                puntos += 3; 
            }

        }

        return puntos;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(Fase fase) {
        this.fase = fase;
    }

    public void addSeleccion(Seleccion seleccion) {
        this.seleccion.add(seleccion);
    }

    public ArrayList<Seleccion> getSeleccion() {
        return seleccion;
    }     
    
    public static Grupo agregarGrupo(Mundial mundial, Scanner sc){
        System.out.print("\n[+] Ingrese la identificacion del grupo: ");
        String identificacion = sc.nextLine();
        System.out.print("\n[+] Ingrese la descripcion del grupo: ");
        String descripcion = sc.nextLine();
        Grupo grupo = new Grupo(identificacion, descripcion);
        mundial.addGrupos(grupo);
        return grupo;
    }

    public static void vincularSelecciones(Mundial mundial, Scanner sc, Grupo grupo){
        int id = 0;
        int op;
        boolean hayDisponibles = true;
        System.out.println("\n[+] Indique la selecciones que pertenecen al grupo: " + grupo.getIdentificacion() + "\n");
        for (Seleccion seleccion : mundial.getSelecciones()){
            id++;
            System.out.println(id + ". " + seleccion.getPais().getNombre());
        }
        while (hayDisponibles){

            System.out.print("\n[+] Ingrese la seleccion a agregar: ");
            op = sc.nextInt();
            sc.nextLine();
            if (op < 1 || op > mundial.getSelecciones().size()){
                System.out.println("\n[!] Identificador invalido.");
                continue;
            }else {
                if (mundial.getSelecciones().get(op-1).getGrupo() == null){
                    grupo.addSeleccion(mundial.getSelecciones().get(op-1));
                    mundial.getSelecciones().get(op-1).setGrupo(grupo);
                }else {
                    System.out.println("[!] La seleccion ya posee un grupo.");
                    continue;
                }
            }
            System.out.print("\n[+] Desea agregar otra seleccion al grupo? (si/no): ");
            String resp = sc.nextLine().toLowerCase();
            hayDisponibles = false;
            if (resp.equals("si")){
                for (Seleccion seleccion : mundial.getSelecciones()){
                    if (seleccion.getGrupo() == null){
                        hayDisponibles = true;
                        break;
                    }
                }
                if (!hayDisponibles){
                    System.out.println("[i] No hay selecciones disponibles para asignar grupo.");
                    break;
                }
            } else {
                break;
            }
        }

    }
public static void tablaPosicionesGrupo(Mundial mundial, Scanner sc) {

    if (mundial.getGrupos().isEmpty()) {
        System.out.println("[!] No hay grupos configurados.");
        return;
    }

    int id = 0;
    System.out.println("\n[+] Seleccione el grupo:\n");
    for (Grupo grupo : mundial.getGrupos()) {
        System.out.println((++id) + ". Grupo " + grupo.getIdentificacion());
    }
    System.out.print("\n[+] Ingrese una opcion: ");
    int op = sc.nextInt();
    sc.nextLine();

    if (op < 1 || op > mundial.getGrupos().size()) {
        System.out.println("[!] Identificador invalido.");
        return;
    }

    Grupo grupoElegido = mundial.getGrupos().get(op - 1);

    if (grupoElegido.getFase() == null) {
        System.out.println("[!] El grupo no tiene una fase asignada.");
        return;
    }

    System.out.println("\n========== TABLA DE POSICIONES - GRUPO " + grupoElegido.getIdentificacion() + " ==========\n");
    System.out.printf("%-20s %4s %4s %4s %4s %4s %4s %4s%n","Seleccion", "PJ", "G", "E", "P", "GF", "GC", "PTS");
    System.out.println("--------------------------------------------------------------");

    ArrayList<int[]> stats = new ArrayList<>();
    ArrayList<Seleccion> selecciones = grupoElegido.getSeleccion();

    for (int i = 0; i < selecciones.size(); i++) {
        Seleccion seleccion = selecciones.get(i);
        int pj = 0, g = 0, e = 0, p = 0, gf = 0, gc = 0;

        for (Partido partido : grupoElegido.getFase().getPartidos()) {
            Participacion partLocal = partido.getParticipacionLocal();
            Participacion partVisitante = partido.getParticipacionVisitante();

            boolean esLocal = partLocal.getSeleccion().equals(seleccion);
            boolean esVisitante = partVisitante.getSeleccion().equals(seleccion);

            if (!esLocal && !esVisitante) continue;

            pj++;
            int golesLocal = partLocal.cantidadGoles();
            int golesVisitante = partVisitante.cantidadGoles();
            gf += esLocal ? golesLocal : golesVisitante;
            gc += esLocal ? golesVisitante : golesLocal;

            if (golesLocal == golesVisitante) {
                e++;
            } else if (esLocal && golesLocal > golesVisitante) {
                g++;
            } else if (esVisitante && golesVisitante > golesLocal) {
                g++;
            } else {
                p++;
            }
        }

        int pts = grupoElegido.obtenerPuntos(seleccion);
        stats.add(new int[]{i, pj, g, e, p, gf, gc, pts});
    }

    for (int i = 0; i < stats.size() - 1; i++) {
        for (int j = 0; j < stats.size() - 1 - i; j++) {
            if (stats.get(j)[7] < stats.get(j + 1)[7]) {
                int[] temp = stats.get(j);
                stats.set(j, stats.get(j + 1));
                stats.set(j + 1, temp);
            }
        }
    }

    for (int[] row : stats) {
        Seleccion s = selecciones.get(row[0]);
        System.out.printf("%-20s %4d %4d %4d %4d %4d %4d %4d%n",
                s.getPais().getNombre(),
                row[1], row[2], row[3], row[4], row[5], row[6], row[7]);
    }

    System.out.println("--------------------------------------------------------------");
}
    
}
