import java.util.ArrayList;

public class Pais {
    private String nombre;
    private String bandera;
    private ArrayList<Sede> sedes = new ArrayList<>();
    private ArrayList<Arbitro> arbitros = new ArrayList<>();
    private Seleccion seleccion;

    public Pais(){

    }

    public Pais(String nombre, String bandera) {
        this.nombre = nombre;
        this.bandera = bandera;
    }

    public Pais(String nombre, String bandera, ArrayList<Sede> sedes, ArrayList<Arbitro> arbitros, Seleccion seleccion) {
        this.nombre = nombre;
        this.bandera = bandera;
        this.sedes = sedes;
        this.arbitros = arbitros;
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

    public void setSedes(ArrayList<Sede> sede) {
        this.sedes.addAll(sede);
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
    
    
    
}
