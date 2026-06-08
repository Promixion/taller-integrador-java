import java.util.ArrayList;
import java.util.Scanner;
/**
 * Representa un mundial de fútbol.
 * Almacena la información general del torneo, incluyendo
 * sus sedes, países participantes, selecciones, árbitros,
 * grupos, fases y partidos disputados.
 *
 * @author Juan
 * @author Liset
 */
public class Mundial {
    private int anio;
    private String mascota;
    private int fechaDesde;
    private int fechaHasta;
    private ArrayList<Sede> sedes;
    private ArrayList<Pais> paises;
    private ArrayList<Arbitro> arbitros;
    private ArrayList<Seleccion> selecciones;
    private ArrayList<Grupo> grupos;
    private ArrayList<Fase> fases;
    private ArrayList<Partido> partidos;

    public Mundial(){
        this(0, "", 0, 1);
        this.sedes = new ArrayList<>();
        this.paises = new ArrayList<>();
        this.arbitros = new ArrayList<>();
        this.selecciones = new ArrayList<>();
        this.grupos = new ArrayList<>();
        this.fases = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }
    
    public Mundial(int anio, String mascota, int fechaDesde, int fechaHasta) {
        this.anio = anio;
        this.mascota = mascota;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.sedes = new ArrayList<>();
        this.paises = new ArrayList<>();
        this.arbitros = new ArrayList<>();
        this.selecciones = new ArrayList<>();
        this.grupos = new ArrayList<>();
        this.fases = new ArrayList<>();
        this.partidos = new ArrayList<>();
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

    public void addSede(Sede sede) {
        this.sedes.add(sede);
    }
    
    public void setSedes(ArrayList<Sede> sedes) {
        this.sedes = sedes;
    }

    public ArrayList<Pais> getPaises() {
        return paises;
    }

    public void addPaises(Pais pais) {
        this.paises.add(pais);
    }
    
    public ArrayList<Arbitro> getArbitros() {
        return arbitros;
    }

    public void setArbitros(Arbitro arbitro) {
        this.arbitros.add(arbitro);
    }

    public ArrayList<Seleccion> getSelecciones() {
        return selecciones;
    }

    public void addSelecciones(Seleccion seleccion) {
        this.selecciones.add(seleccion);
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    public void addGrupos(Grupo grupo) {
        this.grupos.add(grupo);
    }

    public ArrayList<Fase> getFases() {
        return fases;
    }

    public void addFases(Fase fase) {
        this.fases.add(fase);
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void addPartidos(Partido partido) {
        this.partidos.add(partido);
    }
    /**
     * Solicita por consola los datos necesarios para crear
     * un mundial y valida que la fecha de finalización sea
     * posterior a la fecha de inicio.
     *
     * @param sc scanner utilizado para la entrada de datos
     * @return instancia del mundial creada con los datos ingresados
     */
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
