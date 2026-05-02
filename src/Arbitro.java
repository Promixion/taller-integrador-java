public class Arbitro extends Persona{
    private int aniosExperiencia;
    private Pais pais;
    private Arbitraje arbitraje;
    

    public Arbitro(){

    }

    public Arbitro(String nombre, int fecNacimiento, int aniosExperiencia, Pais pais) {
        super(nombre, fecNacimiento);
        this.aniosExperiencia = aniosExperiencia;
        this.pais = pais;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public void setArbitraje(Arbitraje arbitraje) {
        this.arbitraje = arbitraje;
    }

    

    
    

}
