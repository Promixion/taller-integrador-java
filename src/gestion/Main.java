package gestion;
import java.util.Scanner;

/**
 * Clase principal del sistema.
 * Contiene el punto de entrada de la aplicación y gestiona
 * el flujo inicial del programa mediante el menú principal.
 *
 * @author Juan
 * @author Liset
 * @see <a href="https://github.com/Promixion/taller-integrador-java">Repositorio del proyecto</a>
 */
public class Main {

    /**
     * Limpia la consola utilizando secuencias de escape ANSI.
     * Si el entorno no soporta dichas secuencias, imprime
     * múltiples saltos de línea como mecanismo alternativo.
     */

    public static void limpiarPantalla() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (Exception e) {
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }

    /**
     * Punto de entrada de la aplicación.
     * Crea la instancia inicial del mundial y presenta el menú
     * principal desde el cual es posible acceder a las distintas
     * funcionalidades del sistema, incluyendo la gestión de
     * infraestructura, delegaciones, organización deportiva,
     * registro de eventos e informes.
     *
     * @param args argumentos recibidos por línea de comandos
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
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

        GestionMundial gestion = new GestionMundial(sc);
        Informes informe = new Informes();
        Menus menus = new Menus(gestion, sc, informe);
        menus.menuPrincipal(); // loop principal del menú

    }

}
