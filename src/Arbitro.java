import java.util.ArrayList;
import java.util.Scanner;

public class Arbitro extends Persona{
    private int aniosExperiencia;
    private Pais pais;
    private ArrayList<Arbitraje> arbitraje;
    

    public Arbitro(){

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
