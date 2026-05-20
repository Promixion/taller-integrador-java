import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Mundial {
    private int anio;
    private String mascota;
    private int fechaDesde;
    private int fechaHasta;
    private ArrayList<Sede> sedes;
    static HashSet<Pais> paises = new HashSet<>();

    public Mundial(){

    }
    
    public Mundial(int anio, String mascota, int fechaDesde, int fechaHasta) {
        this.anio = anio;
        this.mascota = mascota;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.sedes = new ArrayList<>();
    }

    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public String getMascota() {
        return mascota;
    }
    public void setMascota(String mascota) {
        this.mascota = mascota;
    }
    public int getFechaDesde() {
        return fechaDesde;
    }
    public void setFechaDesde(int fechaDesde) {
        this.fechaDesde = fechaDesde;
    }
    public int getFechaHasta() {
        return fechaHasta;
    }
    public void setFechaHasta(int fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public ArrayList<Sede> getSedes() {
        return sedes;
    }

    public void setSede(Sede sede) {
        this.sedes.add(sede);
    }

    public static void addPaises(Pais pais){
        paises.add(pais);
    }
    public static HashSet<Pais> getPaises(){
        return paises;
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
            System.out.println("\n[!] La fecha de finalizacion no puede ser antes que la fecha de comienzo.\n");
            System.out.print("\t[+] Ingrese la fecha de finalizacion del mundial: ");
            fechaFinalizacion = sc.nextInt();
            sc.nextLine();
        }
        Main.limpiarPantalla();

        mundial = new Mundial(anio, mascota, fechaComienzo, fechaFinalizacion);

        return mundial;

    }

}
