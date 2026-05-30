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
                    sede_nueva = Sede.registSede(mundial, sc);

                    if (! mundial.getSedes().isEmpty()){
                        for (Sede sede : mundial.getSedes()){
                            if(sede.equals(sede_nueva)){
                                comprobacion = true;
                                break;
                            }
                        }
                    }
                    if (comprobacion == false){
                        mundial.addSede(sede_nueva);
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
            System.out.println("2. Agregar una seleccion.");
            System.out.println("3. Registrar un arbitro.");
            System.out.println("4. Volver.");
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
                        Seleccion.agregarSeleccion(mundial, sc);
                        System.out.println("\n[+] Se ha agregado con exito la seleccion.");
                        break;
                    }else{
                        limpiarPantalla();
                        System.out.println("\n[!] Para crear una seleccion debe cargar los paises participantes.");
                        break;
                    }
                    
                case 3:
                    Arbitro.registrarArbitro(mundial, sc);
                    limpiarPantalla();
                    break;
                case 4:
                    limpiarPantalla();
                    break;

            }

        } while (opcion != 4);

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
                    if (! mundial.getSelecciones().isEmpty()){
                        Grupo grupo_nuevo = Grupo.agregarGrupo(mundial, sc);
                        System.out.println("\n[+] Se ha agregado el grupo.");
                        boolean validation = false;
                        for (Seleccion seleccion : mundial.getSelecciones()){
                            if (seleccion.getGrupo() == null){
                                validation = true;
                                Grupo.vincularSelecciones(mundial, sc, grupo_nuevo);
                                break;
                            }
                        }
                        if (!validation){
                            System.out.println("[!] Todas las selecciones ya pertenecen a un grupo.");
                        }
                    } else {
                        System.out.println("[!] Deben haber selecciones registradas.");
                        continue;
                    }
                    break;
                case 2:
                    limpiarPantalla();
                    if (mundial.getGrupos().isEmpty()){
                        System.out.println("\n[!] Debe configurar primero los grupos");
                        break;
                    }else {
                        Fase.crearFase(mundial, sc);
                    }
                    System.out.print("\n[+] Desea vincular grupos a las fases? (si/no): ");
                    String resp = sc.nextLine().toLowerCase();
                    if (resp.equals("si")){
                        Fase.vincularGrupos(mundial, sc);
                    }
                    break;
                case 3:
                    Partido.planificarPartido(mundial, sc);
                    break;
                case 4:
                    limpiarPantalla();
                    break;
            }

        } while (opcion != 4);

    }

    public static void registEvento(Mundial mundial, Scanner sc){
        
        if (mundial.getPartidos().isEmpty()){
            System.out.println("[!] No hay partidos registrados.");
            return;
        }

        int op = 0;
        System.out.println("\n[+] Seleccione el partido a registrar un evento.\n");
        for (Partido partido : mundial.getPartidos()){
            op++;
            System.out.println(op + ". " + partido);
        }

        System.out.print("\n[+] Ingrese una opcion: ");
        op = sc.nextInt();
        sc.nextLine();

        Partido partido_evento = mundial.getPartidos().get(op-1);

        partido_evento.generarEvento(mundial, sc);

        System.out.println("\n[+] Se ha registrado el evento exitosamente.");
    }

    public static void estadisticasSedes(Mundial mundial, Scanner sc) {

        if (mundial.getSedes().isEmpty()) {
            System.out.println("[!] No hay sedes registradas.");
            return;
        }

        System.out.println("\n[+] Ver estadisticas por:\n");
        System.out.println("1. Estadio");
        System.out.println("2. Ciudad (sede)");
        System.out.print("\n[+] Ingrese una opcion: ");
        int op = sc.nextInt();
        sc.nextLine();

        if (op == 1) {
            Estadio.estadisticasPorEstadio(mundial, sc);
        } else if (op == 2) {
            Sede.estadisticasPorCiudad(mundial, sc);
        } else {
            System.out.println("[!] Opcion invalida.");
        }
    }

    public static void accederInformes(Mundial mundial, Scanner sc){
        System.out.println("\n\n============= INFORMES ===============\n");
        System.out.println("1. Tabla de posiciones por grupo");
        System.out.println("2. Tabla de resultados por seleccion");
        System.out.println("3. Ranking de goleadores");
        System.out.println("4. Informe disciplinario");
        System.out.println("5. Ficha tecnica de partido");
        System.out.println("6. Estadisticas de sedes");
        System.out.println("7. Volver");
        System.out.println("========================================");

        System.out.print("\n[+] Ingrese una opcion: ");
        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1:
                Grupo.tablaPosicionesGrupo(mundial, sc);
                break;
            case 2:
                Seleccion.tablaResultadosSeleccion(mundial, sc);
                break;
            case 3:
                Jugador.rankingGoleadores(mundial);
                break;
            case 4:
                informeDisciplinario(mundial, sc);
                break;
            case 5:
                Partido.fichaTecnicaPartido(mundial, sc);
                break;
            case 6:
                estadisticasSedes(mundial, sc);
                break;
            case 7:
                break;
        }

    }
    public static void informeDisciplinario(Mundial mundial, Scanner sc) {

        if (mundial.getSelecciones().isEmpty()) {
            System.out.println("[!] No hay selecciones registradas.");
            return;
        }

        System.out.println("\n[+] Ver informe disciplinario por:\n");
        System.out.println("1. Seleccion");
        System.out.println("2. Jugador");
        System.out.print("\n[+] Ingrese una opcion: ");
        int op = sc.nextInt();
        sc.nextLine();

        if (op == 1) {
            Seleccion.informeDisciplinarioSeleccion(mundial, sc);
        } else if (op == 2) {
            Jugador.informeDisciplinarioJugador(mundial, sc);
        } else {
            System.out.println("[!] Opcion invalida.");
        }
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

        while(opcion != 6){
            System.out.println("\n---------------- MENU ----------------\n");
            System.out.println("1. Gestionar infraestructura");
            System.out.println("2. Administrar delegaciones");
            System.out.println("3. Organización deportiva");
            System.out.println("4. Registrar eventos de campo");
            System.out.println("5. Informes");
            System.out.println("6. Salir del sistema");
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
                    registEvento(mundial, sc);
                    break;
                case 5:
                    accederInformes(mundial, sc);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("\n[!] Opción invalida.");
            }

        }

    }

}
