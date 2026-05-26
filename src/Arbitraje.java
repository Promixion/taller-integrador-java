public class Arbitraje {
    private CategoriaArbitro rol;
    private Partido partido;
    private Arbitro arbitro;

    public Arbitraje(){

    }

    public Arbitraje(CategoriaArbitro rol) {
        this.rol = rol;

    }

    public CategoriaArbitro getRol() {
        return rol;
    }

    public void setRol(CategoriaArbitro rol) {
        this.rol = rol;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Arbitro getArbitro() {
        return arbitro;
    }

    public void setArbitro(Arbitro arbitro) {
        this.arbitro = arbitro;
    }

}
