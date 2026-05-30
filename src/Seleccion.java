import java.util.ArrayList;
import java.util.Scanner;

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
            }else {
                break;
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

    public static void tablaResultadosSeleccion(Mundial mundial, Scanner sc){
        if (mundial.getSelecciones().isEmpty()) {
            System.out.println("[!] No hay selecciones registradas.");
            return;
        }

        int id = 0;
        System.out.println("\n[+] Seleccione la seleccion:\n");
        for (Seleccion seleccion : mundial.getSelecciones()) {
            System.out.println((++id) + ". " + seleccion.getPais().getNombre());
        }
        System.out.print("\n[+] Ingrese una opcion: ");
        int op = sc.nextInt();
        sc.nextLine();

        if (op < 1 || op > mundial.getSelecciones().size()) {
            System.out.println("[!] Identificador invalido.");
            return;
        }

        Seleccion seleccion = mundial.getSelecciones().get(op - 1);

        System.out.println("\n========== RESULTADOS - " + seleccion.getPais().getNombre().toUpperCase() + " ==========\n");
        System.out.printf("%-12s %-20s %-20s %6s %6s %6s%n",
                "Fase", "Local", "Visitante", "GL", "GV", "Resultado");
        System.out.println("------------------------------------------------------------------------");

        int totalPuntos = 0;
        int partidosJugados = 0;
        String ultimaFase = "";

        for (Participacion part : seleccion.getParticipaciones()) {
            Partido partido = part.getPartido();
            Participacion partLocal = partido.getParticipacionLocal();
            Participacion partVisitante = partido.getParticipacionVisitante();

            int golesLocal = partLocal.cantidadGoles();
            int golesVisitante = partVisitante.cantidadGoles();

            boolean esLocal = partLocal.getSeleccion().equals(seleccion);

            String resultado;
            int puntos = 0;

            if (golesLocal == golesVisitante) {
                resultado = "EMPATE";
                puntos = 1;
            } else if (esLocal && golesLocal > golesVisitante) {
                resultado = "VICTORIA";
                puntos = 3;
            } else if (!esLocal && golesVisitante > golesLocal) {
                resultado = "VICTORIA";
                puntos = 3;
            } else {
                resultado = "DERROTA";
                puntos = 0;
            }

            totalPuntos += puntos;
            partidosJugados++;
            ultimaFase = partido.getFase().getNombre().toString();

            System.out.printf("%-12s %-20s %-20s %6d %6d %6s%n",
                    partido.getFase().getNombre(),
                    partLocal.getSeleccion().getPais().getNombre(),
                    partVisitante.getSeleccion().getPais().getNombre(),
                    golesLocal,
                    golesVisitante,
                    resultado);
        }

        System.out.println("------------------------------------------------------------------------");
        System.out.println("\nResumen:");
        System.out.println("  Partidos jugados : " + partidosJugados);
        System.out.println("  Puntos totales   : " + totalPuntos);
        System.out.println("  Ultima instancia : " + (ultimaFase.isEmpty() ? "Sin partidos" : ultimaFase));
        }

    public static void informeDisciplinarioSeleccion(Mundial mundial, Scanner sc) {

        int id = 0;
        System.out.println("\n[+] Seleccione la seleccion:\n");
        for (Seleccion seleccion : mundial.getSelecciones()) {
            System.out.println((++id) + ". " + seleccion.getPais().getNombre());
        }
        System.out.print("\n[+] Ingrese una opcion: ");
        int op = sc.nextInt();
        sc.nextLine();

        if (op < 1 || op > mundial.getSelecciones().size()) {
            System.out.println("[!] Identificador invalido.");
            return;
        }

        Seleccion seleccion = mundial.getSelecciones().get(op - 1);

        System.out.println("\n========== INFORME DISCIPLINARIO - " + seleccion.getPais().getNombre().toUpperCase() + " ==========\n");
        System.out.printf("%-20s %10s %10s %10s%n", "Jugador", "Amarillas", "Rojas", "D.Amarilla");
        System.out.println("------------------------------------------------------------");

        int totalAmarillas = 0;
        int totalRojas = 0;
        int totalDobles = 0;

        for (Jugador jugador : seleccion.getJugadores()) {
            int amarillas = 0;
            int rojas = 0;
            int dobles = 0;

            for (Evento evento : jugador.getEventos()) {
                switch (evento.getTipo()) {
                    case TarjetaAmarilla:
                        amarillas++;
                        break;
                    case TarjetaRoja:
                        rojas++;
                        break;
                    case DobleAmarilla:
                        dobles++;
                        break;
                    default:
                        break;
                }
            }

            if (amarillas > 0 || rojas > 0 || dobles > 0) {
                System.out.printf("%-20s %10d %10d %10d%n",
                        jugador.getNombre(), amarillas, rojas, dobles);
                totalAmarillas += amarillas;
                totalRojas += rojas;
                totalDobles += dobles;
            }
        }

        System.out.println("------------------------------------------------------------");
        System.out.printf("%-20s %10d %10d %10d%n", "TOTAL", totalAmarillas, totalRojas, totalDobles);
    }
}
