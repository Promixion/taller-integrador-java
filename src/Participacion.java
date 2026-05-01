public class Participacion {
    private boolean esLocal;

    public Participacion(){

    }

    public Participacion(boolean esLocal) {
        this.esLocal = esLocal;
    }

    public boolean isEsLocal() {
        return esLocal;
    }

    public void setEsLocal(boolean esLocal) {
        this.esLocal = esLocal;
    }

    public int cantidadGoles(){
        return 1;
    }
    public int cantidadTarjAmarillas(){
        return 1;
    }
        public int cantidadTarjRojas(){
        return 1;
    }
}
