public class Persona {
    private String nombre;
    private int fecNacimiento;

    public Persona(){
        
    }

    public Persona(String nombre, int fecNacimiento) {
        this.nombre = nombre;
        this.fecNacimiento = fecNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(int fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

}
