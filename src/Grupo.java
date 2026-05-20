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
        return 1; // Ver mas adelante
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
    
    public static Grupo agregarGrupo(Scanner sc){
        System.out.print("\n[+] Ingrese la identificacion del grupo: ");
        String identificacion = sc.nextLine();
        System.out.print("\n[+] Ingrese la descripcion del grupo: ");
        String descripcion = sc.nextLine();
        Grupo grupo = new Grupo(identificacion, descripcion);
        Mundial.grupos.add(grupo);
        return grupo;
    }
    public static void vincularSelecciones(Scanner sc, Grupo grupo){
        int id = 0;
        int op;
        System.out.println("\n[+] Indique la selecciones que pertenecen al grupo: " + grupo.getIdentificacion() + "\n");
        for (Seleccion seleccion : Mundial.selecciones){
            id++;
            System.out.println(id + ". " + seleccion.getPais().getNombre());
        }
        while (true){

            System.out.print("\n[+] Ingrese la seleccion a agregar: ");
            op = sc.nextInt();
            sc.nextLine();
            if (op < 1 || op > Mundial.selecciones.size()){
                System.out.println("\n[!] Identificador invalido.");
                continue;
            }else {
                if (Mundial.selecciones.get(id-1).getGrupo() == null){
                    grupo.addSeleccion(Mundial.selecciones.get(op-1));
                    Mundial.selecciones.get(id-1).setGrupo(grupo);
                }else {
                    System.out.println("[!] La seleccion ya posee un grupo.");
                    continue;
                }
            }
            System.out.print("\n[+] Desea agregar otra seleccion al grupo? (si/no): ");
            String resp = sc.nextLine().toLowerCase();
            if (resp.equals("si")){
                for (Seleccion seleccion :  Mundial.selecciones){
                    if (seleccion.getGrupo() == null){
                        break;
                    }
                }
                System.out.println("[i] No hay selecciones disponibles para asignar grupo.");
                break;
            }else{
                break;
            }
        }

    }
    
}
