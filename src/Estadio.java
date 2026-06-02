import java.util.ArrayList;
import java.util.Scanner;

public class Estadio {
    private String nombre;
    private int capacidad;
    private Sede sede;
    private ArrayList<Partido> partido;

    public Estadio(){
        this("", 0);
        this.partido = new ArrayList<>();
    }

    public Estadio(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.partido = new ArrayList<>();
    }

    public Estadio(String nombre, int capacidad, Sede sede) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.sede = sede;
        this.partido = new ArrayList<>();
    }    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Sede getSede(){
        return sede;
    }

    public void setSede(Sede sede){
        this.sede = sede;
    }

    public void addPartido(Partido partido) {
        this.partido.add(partido);
    }

    public ArrayList<Partido> getPartido() {
        return partido;
    }

    @Override
    public String toString() {
        return "\nnombre: " + nombre + ", capacidad: " + capacidad + ", sede:" + sede + ", partido: " + partido;
    } 
       
    public static Estadio agregarEstadio(Scanner sc){
        String nombre;
        int capacidad;

        System.out.print("\n[+] Ingrese el nombre del estadio: ");
        nombre = sc.nextLine();
        System.out.print("\n[+] Ingrese la capacidad del estadio: ");
        capacidad = sc.nextInt();
        sc.nextLine();

        return new Estadio(nombre, capacidad);

    }

}
