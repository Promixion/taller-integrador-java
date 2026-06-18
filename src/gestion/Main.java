package gestion;
import java.util.Scanner;

/**
 * Clase principal de la aplicación.
 * Contiene el punto de entrada del sistema y es responsable
 * de inicializar los componentes necesarios para la ejecución
 * del programa, así como de mostrar el menú principal.
 *
 * @author Juan
 * @author Liset
 * @see <a href="https://github.com/Promixion/taller-integrador-java">Repositorio del proyecto</a>
 */
public class Main {
    /**
     * Limpia la consola utilizando secuencias de escape ANSI.
     * <p>
     * Si el entorno de ejecución no soporta dichas secuencias,
     * se imprime una cantidad considerable de saltos de línea
     * como mecanismo alternativo.
     * </p>
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
     * <p>
     * Inicializa los objetos principales del sistema, muestra
     * la cabecera del programa y delega la interacción con el
     * usuario al menú principal.
     * </p>
     *
     * @param args argumentos recibidos por línea de comandos.
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
