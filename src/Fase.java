import java.util.ArrayList;
import java.util.Scanner;
/**
 * Representa una fase del mundial.
 * Una fase agrupa los partidos que se disputan en una determinada
 * instancia del torneo y, cuando corresponde, los grupos que forman
 * parte de ella.
 *
 * @author Juan
 * @author Liset
 */
public class Fase {
    private NombreFase nombre;
    private ArrayList<Grupo> grupos;
    private ArrayList<Partido> partidos;

    public Fase(){
        this.grupos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    public Fase(NombreFase nombre) {
        this.nombre = nombre;
        this.grupos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }
    

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void addPartidos(Partido partido) {
        this.partidos.add(partido);
    }

    public NombreFase getNombre() {
        return nombre;
    }

    public void setNombre(NombreFase nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public void addGrupos(Grupo grupo) {
        this.grupos.add(grupo);
    }
    /**
     * Permite crear una fase del mundial seleccionando su nombre
     * y verificando que no exista previamente en el torneo.
     *
     * @param mundial mundial donde se registrará la fase
     * @param sc scanner utilizado para la entrada de datos
     */
    public static void crearFase(Mundial mundial, Scanner sc){
        int opcion;
        Fase fase_creada = new Fase();
        System.out.println("\n[+] Ingrese la fase a configurar en el mundial.\n");
        System.out.println("1. Grupos");
        System.out.println("2. Dieciseisavos");
        System.out.println("3. Octavos");
        System.out.println("4. Cuartos");
        System.out.println("5. Semifinal");
        System.out.println("6. Final");
        System.out.print("\n[+] Ingrese la opcion: ");
        opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion){
            case 1:
                fase_creada.setNombre(NombreFase.Grupos);
                break;
            case 2:
                fase_creada.setNombre(NombreFase.Dieciseisavos);
                break;
            case 3:
                fase_creada.setNombre(NombreFase.Octavos);
                break;
            case 4:
                fase_creada.setNombre(NombreFase.Cuartos);
                break;
            case 5:
                fase_creada.setNombre(NombreFase.Semifinal);
                break;
            case 6:
                fase_creada.setNombre(NombreFase.Final);
                break;
        }
        boolean yaExiste = false;
        if (mundial.getFases().isEmpty()){
            mundial.addFases(fase_creada);
        } else {
            for (Fase fase : mundial.getFases()){
                if (fase.getNombre() == fase_creada.getNombre()){
                    yaExiste = true;
                }
            }
            if (yaExiste == false){
                mundial.addFases(fase_creada);
            }else {
                System.out.println("\n[!] La fase ya se encuentra configurada en el mundial");
            }
        }
    }
    /**
     * Permite asociar uno o más grupos a una fase determinada,
     * verificando que cada grupo no se encuentre previamente
     * vinculado a otra fase.
     *
     * @param mundial mundial que contiene las fases y grupos
     * @param sc scanner utilizado para la entrada de datos
     */
    public static void vincularGrupos(Mundial mundial, Scanner sc){
        System.out.println("[+] Seleccione la fase a vincular los grupos: ");
        int id = 0;
        int opFase;
        int opGrupo;
        for (Fase fase : mundial.getFases()){
            id++;
            System.out.println(id + ". " + fase.getNombre());
        }
        System.out.print("\n\n[+] Seleccione la fase: ");
        opFase = sc.nextInt();
        sc.nextLine();

        if (opFase >= 1 && opFase <= mundial.getFases().size()){
            boolean elegir = true;
            while (elegir){
                Fase fase_vincular = mundial.getFases().get(opFase-1);
                System.out.println("[+] Indique los grupos a vincular a la fase.");
                id = 0;
                for (Grupo grupo : mundial.getGrupos()){
                    id++;
                    System.out.println(id + ". " + grupo.getIdentificacion());
                }

                System.out.print("[+] Seleccione el grupo a vincular: ");
                opGrupo = sc.nextInt();
                sc.nextLine();
                if (opGrupo >= 1 && opGrupo <= mundial.getGrupos().size()){
                    Grupo grupo_vincular = mundial.getGrupos().get(opGrupo-1);

                    if (grupo_vincular.getFase() == null){
                        fase_vincular.addGrupos(grupo_vincular);
                        grupo_vincular.setFase(fase_vincular);
                    } else {
                        System.out.println("[!] El grupo ya posee una fase asignada.");
                    }
                } else {
                    System.out.println("\n[!] Identificador invalido.");
                }
                System.out.print("[+] Desea vincular otro grupo a la fase? (si/no): ");
                String resp = sc.nextLine().toLowerCase();
                if (resp.equals("si")){
                    elegir = true;
                }else{
                    elegir = false;
                }
            }
            
        }else {
            System.out.println("[!] Identificador invalido.");
        }

    }

}
