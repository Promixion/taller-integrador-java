package modelo;
import java.util.ArrayList;

/**
 * Representa un país participante del mundial.
 * <p>
 * Un país posee un nombre, una bandera, una selección nacional,
 * una lista de sedes asociadas y una lista de árbitros pertenecientes
 * al mismo.
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
    /**
     * Crea un país sin inicializar sus atributos.
     */
    public Pais(){
        this.sedes = new ArrayList<>();
        this.arbitros = new ArrayList<>();
    }
    /**
     * Crea un país con el nombre y la bandera especificados.
     *
     * @param nombre nombre del país.
     * @param bandera representación de la bandera del país.
     */
    public Pais(String nombre, String bandera) {
        this.nombre = nombre;
        this.bandera = bandera;
        this.sedes = new ArrayList<>();
        this.arbitros = new ArrayList<>();
    }
    /**
     * Crea un país con el nombre, la bandera y la selección especificados.
     *
     * @param nombre nombre del país.
     * @param bandera representación de la bandera del país.
     * @param seleccion selección nacional asociada.
     */
    public Pais(String nombre, String bandera, Seleccion seleccion) {
        this.nombre = nombre;
        this.bandera = bandera;
        this.sedes = new ArrayList<>();
        this.arbitros = new ArrayList<>();
        this.seleccion = seleccion;
    }
    /**
     * Obtiene el nombre del país.
     *
     * @return nombre del país.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Establece el nombre del país.
     *
     * @param nombre nombre a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Obtiene la bandera del país.
     *
     * @return bandera del país.
     */
    public String getBandera() {
        return bandera;
    }
    /**
     * Establece la bandera del país.
     *
     * @param bandera bandera a asignar.
     */
    public void setBandera(String bandera) {
        this.bandera = bandera;
    }
    /**
     * Obtiene las sedes asociadas al país.
     *
     * @return lista de sedes.
     */
    public ArrayList<Sede> getSedes() {
        return sedes;
    }
    /**
     * Agrega una sede al país.
     *
     * @param sede sede a incorporar.
     */
    public void addSedes(Sede sede) {
        this.sedes.add(sede);
    }
    /**
     * Obtiene los árbitros pertenecientes al país.
     *
     * @return lista de árbitros.
     */
    public ArrayList<Arbitro> getArbitros() {
        return arbitros;
    }
    /**
     * Agrega un árbitro al país.
     *
     * @param arbitro árbitro a incorporar.
     */
    public void setArbitros (Arbitro arbitro) {
        this.arbitros.add(arbitro);
    }
    /**
     * Obtiene la selección nacional asociada al país.
     *
     * @return selección del país.
     */
    public Seleccion getSeleccion() {
        return seleccion;
    }
    /**
     * Establece la selección nacional asociada al país.
     *
     * @param seleccion selección a asignar.
     */
    public void setSeleccion(Seleccion seleccion) {
        this.seleccion = seleccion;
    }
    /**
     * Compara dos países considerando únicamente su nombre,
     * ignorando diferencias entre mayúsculas y minúsculas.
     *
     * @param obj objeto a comparar.
     * @return {@code true} si ambos países tienen el mismo nombre;
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
