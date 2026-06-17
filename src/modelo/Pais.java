package modelo;
import java.util.ArrayList;

/**
 * Representa un país participante del mundial.
 * <p>
 * Un país posee un nombre, una bandera, una selección nacional,
 * una lista de sedes asociadas y una lista de árbitros pertenecientes
 * al mismo. Además, permite gestionar la relación entre estas entidades
 * y registrar nuevos países dentro de un mundial.
 * </p>
 *
 * @author Juan
 * @author Liset
 */
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
    /**
     * Compara dos países considerando únicamente su nombre,
     * ignorando diferencias entre mayúsculas y minúsculas.
     *
     * @param obj Objeto a comparar.
     * @return {@code true} si ambos países tienen el mismo nombre,
     *         {@code false} en caso contrario.
     */    

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;                    
        if (obj == null || !(obj instanceof Pais)) return false;
        Pais pais_verificar = (Pais) obj;
        if (this.getNombre().equalsIgnoreCase(pais_verificar.getNombre())){
            return true;
        }else {
            return false;
        }
    }
    
}
