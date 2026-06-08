import java.util.ArrayList;
import java.util.Scanner;

/**
 * Representa a un árbitro participante del mundial.
 * Almacena sus datos personales, país de procedencia,
 * años de experiencia y los arbitrajes en los que participó.
 *
 * @author Juan
 * @author Liset
 */

public class Arbitro extends Persona{
    private int aniosExperiencia;
    private Pais pais;
    private ArrayList<Arbitraje> arbitraje;
    

    public Arbitro(){
        this.arbitraje = new ArrayList<>();
    }

    public Arbitro(String nombre, int fecNacimiento, int aniosExperiencia) {
        super(nombre, fecNacimiento);
        this.aniosExperiencia = aniosExperiencia;
        this.arbitraje = new ArrayList<>();
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public void addArbitraje(Arbitraje arbitraje) {
        this.arbitraje.add(arbitraje);
    }
    /**
     * Registra un árbitro en el mundial solicitando sus datos
     * por consola y asociándolo a un país participante.
     *
     * El árbitro creado se almacena tanto en la colección
     * general de árbitros del mundial como en la del país
     * seleccionado.
     *
     * @param mundial mundial donde se registrará el árbitro
     * @param sc scanner utilizado para la entrada de datos
     */
    public static void registrarArbitro(Mundial mundial, Scanner sc){
        String nombre;
        int fecNacimiento;
        int aniosExperiencia;
        int id = 0;
        int op;

        System.out.print("\n[+] Ingrese el nombre del arbitro: ");
        nombre = sc.nextLine();
        System.out.print("\n[+] Ingrese la fecha de nacimiento: ");
        fecNacimiento = sc.nextInt();
        sc.nextLine();
        System.out.print("\n[+] Ingrese los años de experiencia: ");
        aniosExperiencia = sc.nextInt();
        sc.nextLine();

        for (Pais pais : mundial.getPaises()){
            id++;
            System.out.println(id + ". " + pais.getNombre());
        }
        System.out.print("\n[+] Seleccione el pais del arbitro: ");
        op = sc.nextInt();
        sc.nextLine();
        if (op > 0 && op <= mundial.getPaises().size()){
            Arbitro arbitro = new Arbitro(nombre, fecNacimiento, aniosExperiencia);
            arbitro.setPais(mundial.getPaises().get(op-1));
            mundial.getPaises().get(op-1).setArbitros(arbitro);
            mundial.setArbitros(arbitro);
            System.out.println("\n[+] Arbitro registrado exitosamente.");
        } else {
            System.out.println("[!] Identificador invalido.");
        }

    }
}
