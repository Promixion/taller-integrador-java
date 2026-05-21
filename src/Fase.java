import java.util.ArrayList;
import java.util.Scanner;

public class Fase {
    private NombreFase nombre;
    private ArrayList<Grupo> grupos;
    private ArrayList<Partido> partidos;

    public Fase(){

    }

    public Fase(NombreFase nombre) {
        this.nombre = nombre;
        this.grupos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }
    

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(Partido partido) {
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
    
    public static void crearFase(Scanner sc){
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
                fase_creada = new Fase(NombreFase.Grupos);
                break;
            case 2:
                fase_creada = new Fase(NombreFase.Dieciseisavos);
                break;
            case 3:
                fase_creada = new Fase(NombreFase.Octavos);
                break;
            case 4:
                fase_creada = new Fase(NombreFase.Cuartos);
                break;
            case 5:
                fase_creada = new Fase(NombreFase.Semifinal);
                break;
            case 6:
                fase_creada = new Fase(NombreFase.Final);
                break;
        }
        boolean yaExiste = false;
        if (Mundial.fases.isEmpty()){
            Mundial.fases.add(fase_creada);
        } else {
            for (Fase fase : Mundial.fases){
                if (fase.getNombre() == fase_creada.getNombre()){
                    yaExiste = true;
                }
            }
            if (yaExiste == false){
                Mundial.fases.add(fase_creada);
            }else {
                System.out.println("\n[!] La fase ya se encuentra configurada en el mundial");
            }
        }
    }

    public static void vincularGrupos(Scanner sc){
        System.out.println("[+] Seleccione la fase a vincular los grupos: ");
        int id = 0;
        int op;
        for (Fase fase : Mundial.fases){
            id++;
            System.out.println(id + ". " + fase.getNombre());
        }
        System.out.print("\n\n[+] Seleccione la fase: ");
        op = sc.nextInt();
        sc.nextLine();

        if (op >= 1 && op <= Mundial.fases.size()){
            boolean elegir = true;
            while (elegir){
                Fase fase_vincular = Mundial.fases.get(op-1);
                System.out.println("[+] Indique los grupos a vincular a la fase.");
                id = 0;
                for (Grupo grupo : Mundial.grupos){
                    id++;
                    System.out.println(id + ". " + grupo.getIdentificacion());
                }

                System.out.print("[+] Seleccione el grupo a vincular: ");
                op = sc.nextInt();
                sc.nextLine();

                Grupo grupo_vincular = Mundial.grupos.get(op-1);

                if (grupo_vincular.getFase() == null){
                    fase_vincular.addGrupos(grupo_vincular);
                    grupo_vincular.setFase(fase_vincular);
                } else {
                    System.out.println("[!] El grupo ya posee una fase asignada.");
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
