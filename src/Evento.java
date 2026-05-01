public class Evento {
    private TipoEvento tipo;
    private int minuto;

    public Evento(){
        
    }

    public Evento(TipoEvento tipo, int minuto) {
        this.tipo = tipo;
        this.minuto = minuto;
    }

    public TipoEvento getTipo() {
        return tipo;
    }

    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    
}
