public class Grupo {
    private String identificacion;
    private String descripcion;

    public Grupo(){

    }

    public Grupo(String identificacion, String descripcion) {
        this.identificacion = identificacion;
        this.descripcion = descripcion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int obtenerPuntos(Seleccion s){
        return 1; // Ver mas adelante
    }
    
}
