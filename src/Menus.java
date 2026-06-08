import java.util.Scanner;
/**
 * Proporciona los distintos menús del sistema y gestiona la
 * navegación entre las funcionalidades disponibles para la
 * administración del mundial.
 *
 * Incluye las opciones relacionadas con infraestructura,
 * delegaciones, organización deportiva, registro de eventos
 * e informes.
 *
 * @author Juan
 * @author Liset
 */
public class Menus {
    /**
     * Presenta el menú de gestión de infraestructura, permitiendo
     * registrar sedes y asociar estadios a las mismas.
     *
     * @param mundial mundial sobre el cual se realizan las operaciones
     * @param sc scanner utilizado para la entrada de datos
     */
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
                        Main.limpiarPantalla();
                        System.out.println("\n[+] Sede creada exitosamente.");
                        comprobacion = false;
                    } else {
                        Main.limpiarPantalla();
                        System.out.println("[!] La sede ya se encuentra en el sistema.");
                        comprobacion = false;
                    }
                    break;
                case 2:
                    if (mundial.getSedes().isEmpty()){
                        Main.limpiarPantalla();
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
    /**
     * Presenta el menú de administración de delegaciones,
     * permitiendo registrar países, selecciones y árbitros
     * participantes del mundial.
     *
     * @param mundial mundial sobre el cual se realizan las operaciones
     * @param sc scanner utilizado para la entrada de datos
     */
    public static void adminDelegaciones(Mundial mundial, Scanner sc){
        Main.limpiarPantalla();
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
                        Main.limpiarPantalla();
                        System.out.println("\n[+] Se ha agregado con exito el pais " + pais.getNombre());
                        break;
                    } else {
                        Main.limpiarPantalla();
                        System.out.println("\n[!] Debe cargar las sedes del mundial al sistema.");
                        break;
                    }
                case 2:
                    paises_disponibles = false;
                    if (!mundial.getPaises().isEmpty()){
                        paises_disponibles = true;
                    }
                    if (paises_disponibles){
                        Seleccion.agregarSeleccion(mundial, sc);
                        System.out.println("\n[+] Se ha agregado con exito la seleccion.");
                        break;
                    }else{
                        Main.limpiarPantalla();
                        System.out.println("\n[!] Para crear una seleccion debe cargar los paises participantes.");
                        break;
                    }
                    
                case 3:
                    Arbitro.registrarArbitro(mundial, sc);
                    Main.limpiarPantalla();
                    break;
                case 4:
                    Main.limpiarPantalla();
                    break;

            }

        } while (opcion != 4);

    }
    /**
     * Presenta el menú de organización deportiva, permitiendo
     * configurar grupos, fases eliminatorias y planificar
     * partidos del torneo.
     *
     * @param mundial mundial sobre el cual se realizan las operaciones
     * @param sc scanner utilizado para la entrada de datos
     */
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
                    Main.limpiarPantalla();
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
                    Main.limpiarPantalla();;
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
                    Main.limpiarPantalla();
                    break;
            }

        } while (opcion != 4);

    }
    /**
     * Permite seleccionar un partido registrado y asociarle
     * eventos de campo ocurridos durante su desarrollo.
     *
     * @param mundial mundial que contiene los partidos registrados
     * @param sc scanner utilizado para la entrada de datos
     */
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
    /**
     * Presenta el menú de informes del sistema, permitiendo
     * acceder a estadísticas, tablas de posiciones, resultados,
     * rankings, informes disciplinarios y fichas técnicas.
     *
     * @param mundial mundial sobre el cual se generan los informes
     * @param sc scanner utilizado para la entrada de datos
     */
    public static void accederInformes(Mundial mundial, Scanner sc){
        int op;
        do{
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
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    Informes.tablaPosicionesGrupo(mundial, sc);
                    break;
                case 2:
                    Informes.tablaResultadosSeleccion(mundial, sc);
                    break;
                case 3:
                    Informes.rankingGoleadores(mundial);
                    break;
                case 4:
                    Informes.informeDisciplinario(mundial, sc);
                    break;
                case 5:
                    Informes.fichaTecnicaPartido(mundial, sc);
                    break;
                case 6:
                    Informes.estadisticasSedes(mundial, sc);
                    break;
                case 7:
                    break;
            }
        } while (op != 7);

    }
}
