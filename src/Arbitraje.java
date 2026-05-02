import java.util.ArrayList;

public class Arbitraje {
    private CategoriaArbitro rol;
    private ArrayList<Partido> partido = new ArrayList<>();
    private ArrayList<Arbitro> arbitro = new ArrayList<>();

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

    public void addPartido(Partido partido) {
        this.partido.add(partido);
    }

    public ArrayList<Partido> getPartido() {
        return partido;
    } 
    
    public void addArbitro(Arbitro arbitro) {
        this.arbitro.add(arbitro);
    }

    public ArrayList<Arbitro> getArbitro() {
        return arbitro;
    }     
    

}
