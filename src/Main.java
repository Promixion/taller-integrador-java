import java.util.HashSet;
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

    public static Mundial crearMundial(Scanner sc){
        Mundial mundial;
        int anio;
        String mascota;
        int fechaComienzo;
        int fechaFinalizacion;

        System.out.println("\n[+] Cree el mundial. ");
        System.out.print("\n\tIngrese el año del mundial: ");
        anio = sc.nextInt();
        sc.nextLine();
        System.out.print("\tIngrese la mascota: ");
        mascota = sc.nextLine();
        System.out.print("\tIngrese la fecha de comienzo del mundial: ");
        fechaComienzo = sc.nextInt();
        System.out.print("\tIngrese la fecha de finalizacion del mundial: ");
        fechaFinalizacion = sc.nextInt();
        while (! (fechaFinalizacion > fechaComienzo)){
            System.out.println("\n[!] La fecha de finalizacion no puede ser antes que la fecha de comienzo.");
            System.out.print("\tIngrese la fecha de finalizacion del mundial: ");
            fechaFinalizacion = sc.nextInt();
        }
        limpiarPantalla();

        mundial = new Mundial(anio, mascota, fechaComienzo, fechaFinalizacion);

        return mundial;

    }

    public static Sede registSede(Scanner sc){
        String ciudad;
        float alturaNivelMar;
        String clima;
        String zonaHoraria;
  
        System.out.print("\n[+] Ingrese la ciudad de la sede: ");
        ciudad = sc.nextLine();
        System.out.print("\n[+] Ingrese la altura al nivel del mar: ");
        alturaNivelMar = sc.nextFloat();
        sc.nextLine();
        System.out.print("\n[+] Ingrese el clima: ");
        clima = sc.nextLine();
        System.out.print("\n[+] Ingrese la zona horaria: ");
        zonaHoraria = sc.nextLine();

        return new Sede(ciudad, alturaNivelMar, clima, zonaHoraria);

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

    public static Pais agregarPais(Mundial mundial, Scanner sc){
        String nombre;
        String bandera;
        String opcion;
        Pais pais;
        System.out.print("\n[+] Ingrese el nombre del pais: ");
        nombre = sc.nextLine();
        System.out.print("\n[+] Ingrese la bandera del pais: ");
        bandera = sc.nextLine();
        pais = new Pais(nombre, bandera);

        for (Sede sede : mundial.getSedes()){
            if (sede.getPais() == null){
                System.out.print("\n[?] La sede " + sede.getCiudad() + " pertenece al pais " + pais.getNombre() + "? (si/no): ");
                opcion = sc.nextLine().toLowerCase();
                if(opcion.equals("si")){
                    sede.setPais(pais);
                    pais.setSedes(sede);
                }
            }
        }

        return pais;
    }

    public static Seleccion agregarSeleccion(Mundial mundial, Scanner sc){
        String nombreFederacion;
        String camisetaPrincipal;
        String camisetaSecundaria;
        boolean cabezaGrupo;
        String op;
        int rankingFIFA;
        Seleccion seleccion;
        int dorsal;
        float peso;
        float altura;
        String nombre;
        int fecNacimiento;
        int opcion;
        boolean agregar = true;
        HashSet<Pais> paises = new HashSet<>();

        System.out.print("\n[+] Ingrese el nombre de la federacion de la seleccion: ");
        nombreFederacion = sc.nextLine();
        System.out.print("\n[+] Ingrese la camiseta principal de la seleccion: ");
        camisetaPrincipal = sc.nextLine();
        System.out.print("\n[+] Ingrese la camiseta secundaria de la seleccion: ");
        camisetaSecundaria = sc.nextLine();
        System.out.print("\n[+] La seleccion es cabeza de grupo? (si/no): ");
        op = sc.nextLine().toLowerCase();
        if (op.equals("si")){
            cabezaGrupo = true;
        }else {
            cabezaGrupo = false;
        }
        System.out.print("\n[+] Ingrese el ranking de FIFA de la seleccion: ");
        rankingFIFA = sc.nextInt();
        sc.nextLine();
        seleccion = new Seleccion(nombreFederacion, camisetaPrincipal, camisetaSecundaria, cabezaGrupo, rankingFIFA);

        System.out.println("\n[+] Agregue los jugadores de la seleccion: \n");
        while (agregar){
            System.out.print("\t[+] Ingrese el nombre del jugador: ");
            nombre = sc.nextLine();
            System.out.print("\t[+] Ingrese la fecha de nacimiento del jugador: ");
            fecNacimiento = sc.nextInt();
            sc.nextLine();
            System.out.print("\t[+] Ingrese el numero de dorsal: ");
            dorsal = sc.nextInt();
            sc.nextLine();
            System.out.print("\t[+] Ingrese la altura del jugador: ");
            altura = sc.nextFloat();
            sc.nextLine();
            System.out.print("\t[+] Ingrese el peso del jugador: ");
            peso = sc.nextFloat();
            sc.nextLine();
            do {
                System.out.println("\n[+] Indique la posicion del jugador: \n");
                System.out.println("1. Arquero");
                System.out.println("2. Defensor");
                System.out.println("3. Mediocampista");
                System.out.println("4. Delantero\n");
                System.out.print("[+] Ingrese la posicion: ");
                opcion = sc.nextInt();
                sc.nextLine();
                limpiarPantalla();
            }while (opcion > 4 || opcion < 1 );
            switch (opcion){
                case 1:
                    seleccion.setJugadores(new Jugador(nombre, fecNacimiento, dorsal, Posicion.Arquero, peso, altura));
                    break;
                case 2:
                    seleccion.setJugadores(new Jugador(nombre, fecNacimiento, dorsal, Posicion.Defensor, peso, altura));
                    break;
                case 3:
                    seleccion.setJugadores(new Jugador(nombre, fecNacimiento, dorsal, Posicion.Mediocampista, peso, altura));
                    break;
                case 4:
                    seleccion.setJugadores(new Jugador(nombre, fecNacimiento, dorsal, Posicion.Delantero, peso, altura));
                    break;
            }
            System.out.print("\n[+] Desea agregar otro jugador? (si/no): ");
            op = sc.nextLine().toLowerCase();
            if (op.equals("si")){
                agregar = true;
            }else{
                agregar = false;
            }
        }
        agregar = true;

        System.out.println("\n[+] Ingrese las personas del cuerpo tecnico de la seleccion: ");
        while (agregar){
            System.out.print("\n[+] Ingrese el nombre del integrante del cuerpo tecnico: ");
            nombre = sc.nextLine();
            System.out.print("\n[+] Ingrese la fecha de nacimiento del integrante: ");
            fecNacimiento = sc.nextInt();
            sc.nextLine();
        do {
            System.out.println("\n[+] Indique el rol del integrante: \n");
            System.out.println("\t1. Ayudante de campo");
            System.out.println("\t2. Preparador fisico");
            System.out.println("\t3. Medico");
            System.out.println("\t4. Kinesiologo");
            System.out.println("\t5. Entrenador de arqueros");
            System.out.println("\t6. Analista de videos");
            System.out.println("\t7. Nutricionista");
            System.out.println("\t8. Psicologo\n");

            System.out.print("[+] Ingrese el rol: ");
            opcion = sc.nextInt();
            sc.nextLine();
            
        }while (opcion > 8 || opcion < 1 );
        switch (opcion){
             case 1:
                seleccion.setCuerposTecnicos(new CuerpoTecnico(nombre, fecNacimiento, Rol.AyudanteCampo));
                break;
            case 2:
                seleccion.setCuerposTecnicos(new CuerpoTecnico(nombre, fecNacimiento, Rol.PreparadorFisico));
                break;
            case 3:
                seleccion.setCuerposTecnicos(new CuerpoTecnico(nombre, fecNacimiento, Rol.Medico));
                break;
            case 4:
                seleccion.setCuerposTecnicos(new CuerpoTecnico(nombre, fecNacimiento, Rol.Kinesiologo));
                break;
            case 5:
                seleccion.setCuerposTecnicos(new CuerpoTecnico(nombre, fecNacimiento, Rol.EntrenadorArqueros));
                break;
            case 6:
                seleccion.setCuerposTecnicos(new CuerpoTecnico(nombre, fecNacimiento, Rol.AnalistaVideos));
                break;
            case 7:
                seleccion.setCuerposTecnicos(new CuerpoTecnico(nombre, fecNacimiento, Rol.Nutricionista));
                break;
            case 8:
                seleccion.setCuerposTecnicos(new CuerpoTecnico(nombre, fecNacimiento, Rol.Psicologo));
                break;
        }
            System.out.print("\n[+] Desea agregar otro miembro del cuerpo tecnico? (si/no): ");
            op = sc.nextLine().toLowerCase();
            if (op.equals("si")){
                agregar = true;
            }else {
                agregar = false;
            }
    }
        for ( Sede sede : mundial.getSedes() ){
            if (sede.getPais() != null){
                paises.add(sede.getPais());
            }
        }

        for (Pais pais : paises){
            System.out.print("\n[+] La seleccion es del pais " + pais.getNombre() + "? (si/no): ");
            op = sc.nextLine().toLowerCase();
            if (op.equals("si")){
                pais.setSeleccion(seleccion);
                seleccion.setPais(pais);
            }
        }

        return seleccion;
    }

    public static void vincularEstadiosSede(Estadio estadio, Mundial mundial, Scanner sc){
        int id = 0;
        Sede sede_asignar;
        if (mundial.getSedes().isEmpty()){
           System.out.println("[!] No hay sedes registradas.");
            return;
        }
        for(Sede sede : mundial.getSedes()){
            System.out.println(String.format("ID %d:", id+1) + "\n\t" + sede.getCiudad());
            id++;
        }
        System.out.print("\n[+] Indique el ID de la sede: ");
        id = sc.nextInt();
        sc.nextLine();
        if (id < 1 || id > mundial.getSedes().size()){
            System.out.println("[!] ID inválido.");
            return;
        }   
        sede_asignar = mundial.getSedes().get(id-1);
        sede_asignar.addEstadio(estadio);
        estadio.setSede(sede_asignar);
        limpiarPantalla();
        System.out.println(String.format("\n[+] Se ha asignado el estadio %s a la sede en %s", estadio.getNombre(), sede_asignar.getCiudad()));

    }

    public static void gestInfraestructura(Mundial mundial, Scanner sc){
        int opcion;
        String op;
        Sede sede;
        Estadio estadio;
        do{
            limpiarPantalla();
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
                    sede = registSede(sc);
                    mundial.setSede(sede);
                    limpiarPantalla();
                    System.out.println("\n[+] Sede creada exitosamente.");
                    break;
                case 2:
                    if (mundial.getSedes().isEmpty()){
                        limpiarPantalla();
                        System.out.println("[!] Primero debe crear una sede.");
                        break;
                    }
                    estadio = agregarEstadio(sc);
                    System.out.print("\n[+] Vincule el estadio a su sede:\n\n");
                    vincularEstadiosSede(estadio, mundial, sc);
                    break;
                }
            }while (opcion != 3);
        }

        
    
    public static void adminDelegaciones(Mundial mundial, Scanner sc){
        limpiarPantalla();
        Pais pais;
        Seleccion seleccion;
        int opcion;
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
                    pais = agregarPais(mundial, sc);
                    limpiarPantalla();
                    System.out.println("\n[+] Se ha agregado con exito el pais " + pais.getNombre());
                    break;
                case 2:
                    seleccion = agregarSeleccion(mundial, sc);
                    System.out.println("\n[+] Se ha agregado con exito la seleccion.");
                    break;
                case 3:
                    limpiarPantalla();
                    break;

            }

        } while (opcion != 3);

    }

    public static void orgDeportiva(Mundial mundial){

    }
    public static void registEvento(Mundial mundial){

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Mundial mundial;
        
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

        mundial = crearMundial(sc);

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
                    orgDeportiva(mundial);
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
