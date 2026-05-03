import java.util.ArrayList;
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
        limpiarPantalla();

        mundial = new Mundial(anio, mascota, fechaComienzo, fechaFinalizacion);

        return mundial;

    }

    public static ArrayList<Sede> registSede(Scanner sc){
        String ciudad;
        float alturaNivelMar;
        String clima;
        String zonaHoraria;
        String resp;
        ArrayList<Sede> sedes = new ArrayList<>();;
        boolean registrar = true;
        int count = 0;
        do{
            System.out.print("\n[+] Ingrese la ciudad de la sede: ");
            ciudad = sc.nextLine();
            if (count == 0){
                sc.nextLine();
                count++;
            }
            System.out.print("\n[+] Ingrese la altura al nivel del mar: ");
            alturaNivelMar = sc.nextFloat();
            sc.nextLine();
            System.out.print("\n[+] Ingrese el clima: ");
            clima = sc.nextLine();
            System.out.print("\n[+] Ingrese la zona horaria: ");
            zonaHoraria = sc.nextLine();
            sedes.add(new Sede(ciudad, alturaNivelMar, clima, zonaHoraria));
            System.out.print("\n\n[?] Desea registrar otra sede (si/no): ");
            resp = sc.nextLine();
            resp.toLowerCase();
            if( ! resp.equals("si")){
                registrar = false;
            }else {
                registrar = true;
            }
        
        } while(registrar);
        return sedes;

    }

    public static ArrayList<Estadio> agregarEstadio(Scanner sc){
        boolean crear = true;
        String deseo;
        String nombre;
        int capacidad;
        int count = 0;
        ArrayList<Estadio> estadios = new ArrayList<>();
        do {
            System.out.print("\n[+] Ingrese el nombre del estadio: ");
            nombre = sc.nextLine();
            if (count == 0){
                sc.nextLine();
                count++;
            }
            System.out.print("\n[+] Ingrese la capacidad del estadio: ");
            capacidad = sc.nextInt();
            sc.nextLine();
            estadios.add(new Estadio(nombre, capacidad));
            System.out.print("\n[+] Desea crear otro estadio (si/no): ");
            deseo = sc.nextLine();
            deseo.toLowerCase();
            if (deseo.equals("si")){
                crear = true;
            }else{
                crear = false;
            }
        }while(crear);
        return estadios;
    }

    public static Pais agregarPais(){
        Scanner sc = new Scanner(System.in);
        String nombre;
        String bandera;
        Pais pais;
        System.out.print("\n[+] Ingrese el nombre del pais: ");
        nombre = sc.nextLine();
        System.out.print("\n[+] Ingrese la bandera del pais: ");
        bandera = sc.nextLine();
        pais = new Pais(nombre, bandera);
        return pais;
    }

    public static void vincularEstadiosSede(ArrayList<Estadio> estadios_mundial, Mundial mundial){
        System.out.println("\n[+] Listando sedes: \n");
        for(Sede sede : mundial.getSedes() ){
            System.out.println(sede);
        }



    }

    public static void gestInfraestructura(Mundial mundial){
        Scanner sc = new Scanner(System.in);
        ArrayList<Sede> sedes_mundial = new ArrayList<>();
        ArrayList<Estadio> estadios_mundial = new ArrayList<>();
        int opcion;
        String op;

        do{
            System.out.println("\n-------- Infraestructura --------\n");
            System.out.println("\t1. Registrar sede.");
            System.out.println("\t2. Agregar estadio.");
            System.out.println("\t3. Volver.");
            System.out.println("\n----------------------------------\n");
            System.out.print("[+] Ingrese una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    sedes_mundial = registSede(sc);
                    mundial.setSede(sedes_mundial);
                    break;
                case 2:
                    estadios_mundial = agregarEstadio(sc);
                    System.out.print("[?] Desea vincular los estadios con su sede? (si/no): ");
                    op = sc.nextLine();
                    op.toLowerCase();
                    if (op.equals("si")){
                        vincularEstadiosSede(estadios_mundial, mundial);
                    }else{
                        System.out.println("\n\n[!] No existen sedes del mundial.");
                    }
                }
            }while (opcion != 3);
        }

        
    
    public static void adminDelegaciones(Mundial mundial){

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
            System.out.println("\n---------------- MENU ----------------\n\n");
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
                    gestInfraestructura(mundial);
                    break;
                case 2:
                    limpiarPantalla();
                    adminDelegaciones(mundial);
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
