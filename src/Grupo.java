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

    
}
