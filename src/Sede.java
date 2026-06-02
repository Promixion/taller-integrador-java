import java.util.ArrayList;
import java.util.Scanner;

public class Sede {
    private String ciudad;
    private float alturaNivelMar;
    private String clima;
    private String zonaHoraria;
    private Pais pais;
    private ArrayList<Estadio> estadios;

    public Sede(){
        this("", 0.0f, "", "");
        this.estadios = new ArrayList<>();
    }

    public Sede(String ciudad, float alturaNivelMar, String clima, String zonaHoraria) {
        this.ciudad = ciudad;
        this.alturaNivelMar = alturaNivelMar;
        this.clima = clima;
        this.zonaHoraria = zonaHoraria;
        this.estadios = new ArrayList<>();
    }

    public Sede(String ciudad, float alturaNivelMar, String clima, String zonaHoraria, Pais pais) {
        this.ciudad = ciudad;
        this.alturaNivelMar = alturaNivelMar;
        this.clima = clima;
        this.zonaHoraria = zonaHoraria;
        this.pais = pais;
        this.estadios = new ArrayList<>();
    }

    public Sede(String ciudad, float alturaNivelMar, String clima, String zonaHoraria, Pais pais,
            ArrayList<Estadio> estadios) {
        this.ciudad = ciudad;
        this.alturaNivelMar = alturaNivelMar;
        this.clima = clima;
        this.zonaHoraria = zonaHoraria;
        this.pais = pais;
        this.estadios = estadios;

    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public float getAlturaNivelMar() {
        return alturaNivelMar;
    }

    public void setAlturaNivelMar(float alturaNivelMar) {
        this.alturaNivelMar = alturaNivelMar;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getZonaHoraria() {
        return zonaHoraria;
    }

    public void setZonaHoraria(String zonaHoraria) {
        this.zonaHoraria = zonaHoraria;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Pais getPais() {
        return pais;
    }


    public void addEstadio(Estadio estadio) {
        this.estadios.add(estadio);
    }

    public ArrayList<Estadio> getEstadios() {
        return estadios;
    }

    @Override
    public String toString() {
        return "\nciudad:" + ciudad + ", alturaNivelMar: " + alturaNivelMar + ", clima: " + clima + ", zonaHoraria: "
                + zonaHoraria + ", pais: " + pais + ", estadios: " + estadios;
    }


    @Override
    public boolean equals(Object nueva_sede) {
        if (this == nueva_sede) return true;                    
        if (nueva_sede == null || !(nueva_sede instanceof Sede)) return false; 
        return this.ciudad.toLowerCase().equals(((Sede) nueva_sede).getCiudad().toLowerCase());
    }
    
    public static Sede registSede(Mundial mundial, Scanner sc){
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
        while (true){
            System.out.print("\n[+] Indique el ID de la sede: ");
            id = sc.nextInt();
            sc.nextLine();
            if (id < 1 || id > mundial.getSedes().size()){
                System.out.println("[!] ID inválido.");
            }else{
                break;
            }
        }
        if (estadio.getSede() == null){
            sede_asignar = mundial.getSedes().get(id-1);
            sede_asignar.addEstadio(estadio);
            estadio.setSede(sede_asignar);
            Main.limpiarPantalla();
            System.out.println(String.format("\n[+] Se ha asignado el estadio %s a la sede en %s", estadio.getNombre(), sede_asignar.getCiudad()));
        }
    }

}
