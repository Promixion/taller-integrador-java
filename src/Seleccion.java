import java.util.ArrayList;
import java.util.Scanner;
/**
 * Representa una selección nacional participante del mundial.
 * <p>
 * Una selección está asociada a un país y posee información sobre
 * su federación, indumentaria, ranking FIFA, grupo asignado,
 * jugadores, directores técnicos, cuerpo técnico y participaciones
 * en partidos.
 * </p>
 *
 * @author Juan
 * @author Liset
 */
public class Seleccion {
    private String nombreFederacion;
    private String camisetaPrincipal;
    private String camisetaSecundaria;
    private boolean cabezaGrupo;
    private int rankingFIFA;
    private ArrayList<Participacion> participaciones;
    private Grupo grupo;
    private Pais pais;
    private ArrayList<Jugador> jugadores;
    private ArrayList<DirectorTecnico> directoresTecnicos;
    private ArrayList<CuerpoTecnico> cuerposTecnicos;

    public Seleccion(String nombreFederacion, String camisetaPrincipal, String camisetaSecundaria, boolean cabezaGrupo,
            int rankingFIFA) {
        this.nombreFederacion = nombreFederacion;
        this.camisetaPrincipal = camisetaPrincipal;
        this.camisetaSecundaria = camisetaSecundaria;
        this.cabezaGrupo = cabezaGrupo;
        this.rankingFIFA = rankingFIFA;
        this.jugadores = new ArrayList<>();
        this.directoresTecnicos = new ArrayList<>();
        this.cuerposTecnicos = new ArrayList<>();
        this.participaciones = new ArrayList<>();
    }
    

    public Seleccion(String nombreFederacion, String camisetaPrincipal, String camisetaSecundaria, boolean cabezaGrupo,
            int rankingFIFA, Grupo grupo) {
        this.nombreFederacion = nombreFederacion;
        this.camisetaPrincipal = camisetaPrincipal;
        this.camisetaSecundaria = camisetaSecundaria;
        this.cabezaGrupo = cabezaGrupo;
        this.rankingFIFA = rankingFIFA;
        this.grupo = grupo;
        this.jugadores = new ArrayList<>();
        this.directoresTecnicos = new ArrayList<>();
        this.cuerposTecnicos = new ArrayList<>();   
        this.participaciones = new ArrayList<>();     
    }


    public Seleccion(String nombreFederacion, String camisetaPrincipal, String camisetaSecundaria, boolean cabezaGrupo,
            int rankingFIFA, ArrayList<Participacion> participacion, Grupo grupo, Pais pais) {
        this.nombreFederacion = nombreFederacion;
        this.camisetaPrincipal = camisetaPrincipal;
        this.camisetaSecundaria = camisetaSecundaria;
        this.cabezaGrupo = cabezaGrupo;
        this.rankingFIFA = rankingFIFA;
        this.participaciones = participacion;
        this.grupo = grupo;
        this.pais = pais;
        this.jugadores = new ArrayList<>();
        this.directoresTecnicos = new ArrayList<>();
        this.cuerposTecnicos = new ArrayList<>();
    }


    public Seleccion() {

    }

    public String getNombreFederacion() {
        return nombreFederacion;
    }

    public void setNombreFederacion(String nombreFederacion) {
        this.nombreFederacion = nombreFederacion;
    }

    public String getCamisetaPrincipal() {
        return camisetaPrincipal;
    }

    public void setCamisetaPrincipal(String camisetaPrincipal) {
        this.camisetaPrincipal = camisetaPrincipal;
    }

    public String getCamisetaSecundaria() {
        return camisetaSecundaria;
    }

    public void setCamisetaSecundaria(String camisetaSecundaria) {
        this.camisetaSecundaria = camisetaSecundaria;
    }

    public boolean isCabezaGrupo() {
        return cabezaGrupo;
    }

    public void setCabezaGrupo(boolean cabezaGrupo) {
        this.cabezaGrupo = cabezaGrupo;
    }

    public int getRankingFIFA() {
        return rankingFIFA;
    }

    public void setRankingFIFA(int rankingFIFA) {
        this.rankingFIFA = rankingFIFA;
    }

    public void addParticipacion(Participacion participacion) {
        this.participaciones.add(participacion);
    }

    public ArrayList<Participacion> getParticipaciones() {
        return participaciones;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Grupo getGrupo() {
        return grupo;
    }


    public Pais getPais() {
        return pais;
    }


    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public void setJugadores(Jugador jugador) {
        this.jugadores.add(jugador);
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setDirectoresTecnicos(DirectorTecnico directorTecnico) {
        this.directoresTecnicos.add(directorTecnico);
    }

    public void setCuerposTecnicos(CuerpoTecnico cuerposTecnico) {
        this.cuerposTecnicos.add(cuerposTecnico);
    }
    
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;                    
        if (obj == null || !(obj instanceof Seleccion)) return false;
        Seleccion seleccion_verificar = (Seleccion) obj;
        if (this.getNombreFederacion().equalsIgnoreCase(seleccion_verificar.getNombreFederacion())){
            return true;
        }else {
            return false;
        }
    }
    /**
     * Registra una nueva selección en el mundial.
     * <p>
     * Permite cargar toda la información relacionada con la selección,
     * incluyendo jugadores, cuerpo técnico, directores técnicos y el
     * país que representa. Finalmente, la selección queda registrada
     * dentro del mundial.
     * </p>
     *
     * @param mundial Mundial donde se registrará la selección.
     * @param sc Scanner utilizado para la entrada de datos.
     */
    public static void agregarSeleccion(Mundial mundial, Scanner sc){
        String nombreFederacion;
        String camisetaPrincipal;
        String camisetaSecundaria;
        boolean cabezaGrupo;
        String op;
        int rankingFIFA;
        Seleccion seleccion;
        int dorsal;
        float peso;
        float altura;
        String nombre;
        int fecNacimiento;
        int opcion;
        int fecNombramiento;
        boolean agregar = true;

        System.out.print("\n[+] Ingrese el nombre de la federacion de la seleccion: ");
        nombreFederacion = sc.nextLine();
        System.out.print("\n[+] Ingrese la camiseta principal de la seleccion: ");
        camisetaPrincipal = sc.nextLine();
        System.out.print("\n[+] Ingrese la camiseta secundaria de la seleccion: ");
        camisetaSecundaria = sc.nextLine();
        System.out.print("\n[+] La seleccion es cabeza de grupo? (si/no): ");
        op = sc.nextLine().toLowerCase();
        if (op.equals("si")){
            cabezaGrupo = true;
        }else {
            cabezaGrupo = false;
        }
        System.out.print("\n[+] Ingrese el ranking de FIFA de la seleccion: ");
        rankingFIFA = sc.nextInt();
        sc.nextLine();
        seleccion = new Seleccion(nombreFederacion, camisetaPrincipal, camisetaSecundaria, cabezaGrupo, rankingFIFA);

        System.out.println("\n[+] Agregue los jugadores de la seleccion: \n");
        while (agregar){
            System.out.print("\t[+] Ingrese el nombre del jugador: ");
            nombre = sc.nextLine();
            System.out.print("\t[+] Ingrese la fecha de nacimiento del jugador: ");
            fecNacimiento = sc.nextInt();
            sc.nextLine();
            System.out.print("\t[+] Ingrese el numero de dorsal: ");
            dorsal = sc.nextInt();
            sc.nextLine();
            System.out.print("\t[+] Ingrese la altura del jugador: ");
            altura = sc.nextFloat();
            sc.nextLine();
            System.out.print("\t[+] Ingrese el peso del jugador: ");
            peso = sc.nextFloat();
            sc.nextLine();
            do {
                System.out.println("\n[+] Indique la posicion del jugador: \n");
                System.out.println("1. Arquero");
                System.out.println("2. Defensor");
                System.out.println("3. Mediocampista");
                System.out.println("4. Delantero\n");
                System.out.print("[+] Ingrese la posicion: ");
                opcion = sc.nextInt();
                sc.nextLine();
                Main.limpiarPantalla();
            }while (opcion > 4 || opcion < 1 );
            switch (opcion){
                case 1:
                    seleccion.setJugadores(new Jugador(nombre, fecNacimiento, dorsal, Posicion.Arquero, peso, altura));
                    break;
                case 2:
                    seleccion.setJugadores(new Jugador(nombre, fecNacimiento, dorsal, Posicion.Defensor, peso, altura));
                    break;
                case 3:
                    seleccion.setJugadores(new Jugador(nombre, fecNacimiento, dorsal, Posicion.Mediocampista, peso, altura));
                    break;
                case 4:
                    seleccion.setJugadores(new Jugador(nombre, fecNacimiento, dorsal, Posicion.Delantero, peso, altura));
                    break;
            }
            System.out.print("\n[+] Desea agregar otro jugador? (si/no): ");
            op = sc.nextLine().toLowerCase();
            if (op.equals("si")){
                agregar = true;
            }else{
                agregar = false;
            }
        }
        agregar = true;

        System.out.println("\n[i] Ingrese las personas del cuerpo tecnico de la seleccion. ");
        while (agregar){
                System.out.print("\n[+] Ingrese el nombre del integrante del cuerpo tecnico: ");
                nombre = sc.nextLine();
                System.out.print("\n[+] Ingrese la fecha de nacimiento del integrante: ");
                fecNacimiento = sc.nextInt();
                sc.nextLine();
            do {
                System.out.println("\n[+] Indique el rol del integrante: \n");
                System.out.println("\t1. Ayudante de campo");
                System.out.println("\t2. Preparador fisico");
                System.out.println("\t3. Medico");
                System.out.println("\t4. Kinesiologo");
                System.out.println("\t5. Entrenador de arqueros");
                System.out.println("\t6. Analista de videos");
                System.out.println("\t7. Nutricionista");
                System.out.println("\t8. Psicologo\n");

                System.out.print("[+] Ingrese el rol: ");
                opcion = sc.nextInt();
                sc.nextLine();
                
            }while (opcion > 8 || opcion < 1 );
            switch (opcion){
                case 1:
                    seleccion.setCuerposTecnicos(new CuerpoTecnico(nombre, fecNacimiento, Rol.AyudanteCampo));
                    break;
                case 2:
                    seleccion.setCuerposTecnicos(new CuerpoTecnico(nombre, fecNacimiento, Rol.PreparadorFisico));
                    break;
                case 3:
                    seleccion.setCuerposTecnicos(new CuerpoTecnico(nombre, fecNacimiento, Rol.Medico));
                    break;
                case 4:
                    seleccion.setCuerposTecnicos(new CuerpoTecnico(nombre, fecNacimiento, Rol.Kinesiologo));
                    break;
                case 5:
                    seleccion.setCuerposTecnicos(new CuerpoTecnico(nombre, fecNacimiento, Rol.EntrenadorArqueros));
                    break;
                case 6:
                    seleccion.setCuerposTecnicos(new CuerpoTecnico(nombre, fecNacimiento, Rol.AnalistaVideos));
                    break;
                case 7:
                    seleccion.setCuerposTecnicos(new CuerpoTecnico(nombre, fecNacimiento, Rol.Nutricionista));
                    break;
                case 8:
                    seleccion.setCuerposTecnicos(new CuerpoTecnico(nombre, fecNacimiento, Rol.Psicologo));
                    break;
            }
                System.out.print("\n[+] Desea agregar otro miembro del cuerpo tecnico? (si/no): ");
                op = sc.nextLine().toLowerCase();
                if (op.equals("si")){
                    agregar = true;
                }else {
                    agregar = false;
                }
        }
        Main.limpiarPantalla();
        agregar = true;
        System.out.println("\n[+] Ingrese los directores tecnicos de la seleccion.\n");
        while (agregar){
            System.out.print("[+] Ingrese el nombre del director tecnico: ");
            nombre = sc.nextLine();
            System.out.print("\n[+] Ingrese la fecha de nacimiento del director tecnico: ");
            fecNacimiento = sc.nextInt();
            sc.nextLine();
            System.out.print("\n[+] Ingrese la fecha de nombramiento del director tecnico: ");
            fecNombramiento = sc.nextInt();
            sc.nextLine();
            seleccion.setDirectoresTecnicos(new DirectorTecnico(nombre, fecNacimiento, fecNombramiento));
            System.out.print("[?] Desea agregar otro director tecnico para la seleccion (si/no): ");
            op = sc.nextLine().toLowerCase();
            if (op.equals("si")){
                agregar = true;
            }else {
                agregar = false;
            }

        }

        boolean encontrado = false;
        Main.limpiarPantalla();
        for (Pais pais : mundial.getPaises()) {
            System.out.print("\n[+] La seleccion es del pais " + pais.getNombre() + "? (si/no): ");
            op = sc.nextLine().toLowerCase();
            if (op.equals("si")) {
                if (pais.getSeleccion() == null) {
                    pais.setSeleccion(seleccion);
                    seleccion.setPais(pais);
                    encontrado = true;
                    break;
                } else {
                    System.out.println("[!] El pais " + pais.getNombre() + " ya posee una seleccion asignada.");
                }
            }
        }
        if (!encontrado) {
            Pais nuevoPais = Pais.agregarPais(mundial, sc);
            nuevoPais.setSeleccion(seleccion);
            seleccion.setPais(nuevoPais);
            if (!mundial.getPaises().contains(nuevoPais)){
                mundial.addPaises(nuevoPais);
            }
        }
        mundial.addSelecciones(seleccion);
    }

    
}
