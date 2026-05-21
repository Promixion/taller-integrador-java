import java.util.Scanner;

public class Main {

    public static void limpiarPantalla() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }

    public static void gestInfraestructura(Mundial mundial, Scanner sc){
        int opcion;
        Sede sede_nueva;
        Estadio estadio;
        boolean comprobacion = false;
        do{
            System.out.println("\n-------- Infraestructura --------\n");
            System.out.println("\t1. Registrar sede.");
            System.out.println("\t2. Agregar estadio.");
            System.out.println("\t3. Volver.");
            System.out.println("\n----------------------------------\n");
            System.out.print("[+] Ingrese una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    sede_nueva = Sede.registSede(sc);

                    if (! mundial.getSedes().isEmpty()){
                        for (Sede sede : mundial.getSedes()){
                            if(sede.equals(sede_nueva)){
                                comprobacion = true;
                                break;
                            }
                        }
                    }
                    if (comprobacion == false){
                        mundial.setSede(sede_nueva);
                        limpiarPantalla();
                        System.out.println("\n[+] Sede creada exitosamente.");
                        comprobacion = false;
                    } else {
                        limpiarPantalla();
                        System.out.println("[!] La sede ya se encuentra en el sistema.");
                        comprobacion = false;
                    }
                    break;
                case 2:
                    if (mundial.getSedes().isEmpty()){
                        limpiarPantalla();
                        System.out.println("[!] Primero debe crear una sede.");
                        break;
                    }
                    estadio = Estadio.agregarEstadio(sc);
                    System.out.print("\n[+] Vincule el estadio a su sede:\n\n");
                    Sede.vincularEstadiosSede(estadio, mundial, sc);
                    break;
            }
        } while (opcion != 3);
    }

    public static void adminDelegaciones(Mundial mundial, Scanner sc){
        limpiarPantalla();
        Pais pais;
        int opcion;
        boolean paises_disponibles = false;
        do {
            System.out.println("\n--------- Administrar delegaciones ---------\n");
            System.out.println("1. Agregar un pais.");
            System.out.println("2. Agregar una seleccion.");;
            System.out.println("3. Volver.");
            System.out.println("\n--------------------------------------------\n");
            System.out.print("\n[+] Ingrese una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    if (! mundial.getSedes().isEmpty()){
                        pais = Pais.agregarPais(mundial, sc);
                        limpiarPantalla();
                        System.out.println("\n[+] Se ha agregado con exito el pais " + pais.getNombre());
                        break;
                    } else {
                        limpiarPantalla();
                        System.out.println("\n[!] Debe cargar las sedes del mundial al sistema.");
                        break;
                    }
                case 2:
                    paises_disponibles = false;
                    for (Sede sede : mundial.getSedes()){
                        if (sede.getPais() != null){
                            paises_disponibles = true;
                            break;
                        }
                    }
                    if (paises_disponibles){
                        Seleccion seleccion = Seleccion.agregarSeleccion(mundial, sc);
                        System.out.println("\n[+] Se ha agregado con exito la seleccion.");
                        break;
                    }else{
                        limpiarPantalla();
                        System.out.println("\n[!] Para crear una seleccion debe cargar los paises participantes.");
                        break;
                    }
                case 3:
                    limpiarPantalla();
                    break;

            }

        } while (opcion != 3);

    }

    public static void orgDeportiva(Mundial mundial, Scanner sc){
        
        int opcion;

        do{
            System.out.println("\n------------- Organizacion deportiva ------------\n");
            System.out.println("1. Configurar grupos");
            System.out.println("2. Configurar fase de eliminacion");
            System.out.println("3. Planificar partido");
            System.out.println("4. Volver");
            System.out.println("\n-------------------------------------------------\n");
            System.out.print("[+] Ingrese una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    limpiarPantalla();
                    if (! Mundial.selecciones.isEmpty()){
                        Grupo grupo_nuevo = Grupo.agregarGrupo(sc);
                        System.out.println("\n[+] Se ha agregado el grupo.");
                        
                        for (Seleccion seleccion : Mundial.selecciones){
                            if (seleccion.getGrupo() == null){
                                Grupo.vincularSelecciones(sc, grupo_nuevo);
                                break;
                            } else {
                                System.out.println("[!] Todas las selecciones ya pertenecen a un grupo.");
                                break;
                            }
                        }
                    } else {
                        System.out.println("[!] Deben haber selecciones registradas.");
                        continue;
                    }
                    break;
                case 2:
                    limpiarPantalla();
                    if (Mundial.grupos.isEmpty()){
                        System.out.println("\n[!] Debe configurar primero los grupos");
                        break;
                    }else {
                        Fase.crearFase(sc);
                    }
                    System.out.print("\n[+] Desea vincular grupos a las fases? (si/no): ");
                    String resp = sc.nextLine().toLowerCase();
                    if (resp.equals("si")){
                        Fase.vincularGrupos(sc);
                    }

                    break;
                case 3:
                    break;
                case 4:
                    limpiarPantalla();
                    break;
            }

        } while (opcion != 4);

    }

    public static void registEvento(Mundial mundial){

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Mundial mundial;
        limpiarPantalla();
        
        System.out.print(
"  __  __                 _ _       _ \n" +
" |  \\/  |               | (_)     | |\n" +
" | \\  / |_   _ _ __   __| |_  __ _| |\n" +
" | |\\/| | | | | '_ \\ / _` | |/ _` | |\n" +
" | |  | | |_| | | | | (_| | | (_| | |\n" +
" |_|  |_|\\__,_|_| |_|\\__,_|_|\\__,_|_|\n" +
"                                     \n" +
"                                     \n"
);

        int opcion = 0;

        mundial = Mundial.crearMundial(sc);

        while(opcion != 5){
            System.out.println("\n---------------- MENU ----------------\n");
            System.out.println("1. Gestionar infraestructura");
            System.out.println("2. Administrar delegaciones");
            System.out.println("3. Organización deportiva");
            System.out.println("4. Registrar eventos de campo");
            System.out.println("5. Salir del sistema");
            System.out.println("\n---------------------------------------\n");
            System.out.print("\n[+] Ingrese una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    limpiarPantalla();
                    gestInfraestructura(mundial, sc);
                    limpiarPantalla();
                    break;
                case 2:
                    limpiarPantalla();
                    adminDelegaciones(mundial, sc);
                    break;
                case 3:
                    limpiarPantalla();
                    orgDeportiva(mundial, sc);
                    break;
                case 4:
                    limpiarPantalla();
                    registEvento(mundial);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("\n[!] Opción invalida.");
            }

        }

    }

}
