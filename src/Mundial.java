public class Mundial {
    private int anio;
    private String mascota;
    private int fechaDesde;
    private int fechaHasta;

    public Mundial(){

    }
    
    public Mundial(int anio, String mascota, int fechaDesde, int fechaHasta) {
        this.anio = anio;
        this.mascota = mascota;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
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

    

}
