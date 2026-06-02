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
                    Menus.gestInfraestructura(mundial, sc);
                    limpiarPantalla();
                    break;
                case 2:
                    limpiarPantalla();
                    Menus.adminDelegaciones(mundial, sc);
                    break;
                case 3:
                    limpiarPantalla();
                    Menus.orgDeportiva(mundial, sc);
                    break;
                case 4:
                    limpiarPantalla();
                    Menus.registEvento(mundial, sc);
                    break;
                case 5:
                    Menus.accederInformes(mundial, sc);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("\n[!] Opción invalida.");
            }

        }

    }

}
