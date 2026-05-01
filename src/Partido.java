import java.time.LocalDate;
import java.time.LocalTime;

public class Partido {
    private LocalDate fecha;
    private LocalTime horario;
    private int duracion;
    private int tiempoAdicional;

    public Partido(){

    }

    public Partido(LocalDate fecha, LocalTime horario, int duracion, int tiempoAdicional) {
        this.fecha = fecha;
        this.horario = horario;
        this.duracion = duracion;
        this.tiempoAdicional = tiempoAdicional;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getTiempoAdicional() {
        return tiempoAdicional;
    }

    public void setTiempoAdicional(int tiempoAdicional) {
        this.tiempoAdicional = tiempoAdicional;
    }

    

    

}
