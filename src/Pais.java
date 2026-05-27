import java.util.ArrayList;
import java.util.Scanner;

public class Pais {
    private String nombre;
    private String bandera;
    private ArrayList<Sede> sedes;
    private ArrayList<Arbitro> arbitros;
    private Seleccion seleccion;

    public Pais(){

    }

    public Pais(String nombre, String bandera) {
        this.nombre = nombre;
        this.bandera = bandera;
        this.sedes = new ArrayList<>();
        this.arbitros = new ArrayList<>();
    }

    public Pais(String nombre, String bandera, Seleccion seleccion) {
        this.nombre = nombre;
        this.bandera = bandera;
        this.sedes = new ArrayList<>();
        this.arbitros = new ArrayList<>();
        this.seleccion = seleccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBandera() {
        return bandera;
    }

    public void setBandera(String bandera) {
        this.bandera = bandera;
    }

    public ArrayList<Sede> getSedes() {
        return sedes;
    }

    public void addSedes(Sede sede) {
        this.sedes.add(sede);
    }

    public ArrayList<Arbitro> getArbitros() {
        return arbitros;
    }

    public void setArbitros (Arbitro arbitro) {
        this.arbitros.add(arbitro);
    }

    public Seleccion getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }
    

    @Override
    public boolean equals(Object obj){
        Pais pais_verificar = (Pais) obj;
        if (this == obj) return true;                    
        if (obj == null || !(obj instanceof Pais)) return false;
        if (this.getNombre().equalsIgnoreCase(pais_verificar.getNombre())){
            return true;
        }else {
            return false;
        }
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
                    pais.addSedes(sede);
                    if (!mundial.getPaises().contains(pais))
                        mundial.addPaises(pais);
                    break;
                }
            }
        }

        return pais;
    }
    
    
}
