public class Participacion {
    private boolean esLocal;
    private Seleccion seleccion;
    private Partido partido;

    public Participacion(){

    }

    public Participacion(boolean esLocal, Partido partido, Seleccion seleccion) {
        this.esLocal = esLocal;
        this.partido = partido;
        this.seleccion =  seleccion;
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

    public void setSeleccion(Seleccion seleccion){
        this.seleccion = seleccion;
    }
    public Seleccion getSeleccion(){
        return seleccion;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Partido getPartido() {
        return partido;
    }    

}
