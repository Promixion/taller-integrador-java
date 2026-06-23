package gestion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Arbitraje;
import modelo.Arbitro;
import modelo.CuerpoTecnico;
import modelo.DirectorTecnico;
import modelo.Estadio;
import modelo.Fase;
import modelo.Grupo;
import modelo.Jugador;
import modelo.Mundial;
import modelo.Pais;
import modelo.Participacion;
import modelo.Partido;
import modelo.Sede;
import modelo.Seleccion;
import modelo.enums.CategoriaArbitro;
import modelo.enums.NombreFase;
import modelo.enums.Posicion;
import modelo.enums.Rol;
/**
 * Centraliza la gestión operativa del mundial, administrando
 * las colecciones de entidades del torneo y concentrando
 * la lógica de registro, vinculación y planificación
 * que no pertenece al modelo de dominio.
 *
 * <p>
 * Actúa como intermediario entre la capa de presentación
 * ({@link Menus}) y el modelo de dominio ({@code modelo}),
 * evitando que las clases del diagrama dependan de la
 * entrada/salida por consola o de colecciones globales.
 * </p>
 *
 * @author Juan
 * @author Liset
 */
public class GestionMundial {
        private Mundial mundial;
        private Scanner sc;
        private ArrayList<Pais> paises;
        private ArrayList<Arbitro> arbitros;
        private ArrayList<Seleccion> selecciones;
        private ArrayList<Grupo> grupos;
        private ArrayList<Fase> fases;
        private ArrayList<Partido> partidos;
    /**
     * Construye una instancia de {@code GestionMundial}, inicializa
     * todas las colecciones del torneo y crea el mundial solicitando
     * sus datos por consola.
     *
     * @param sc scanner utilizado para la entrada de datos durante
     *           toda la ejecución del sistema
     */
    public GestionMundial(Scanner sc) {
        this.sc = sc;
        this.mundial = crearMundial();
        this.paises = new ArrayList<>();
        this.arbitros = new ArrayList<>();
        this.selecciones = new ArrayList<>();
        this.grupos = new ArrayList<>();
        this.fases = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }
    /**
     * Retorna la instancia del mundial gestionado.
     *
     * @return el mundial del torneo
     */
    public Mundial getMundial() {
        return mundial;
    }
    /**
     * Retorna la lista de países registrados en el torneo.
     *
     * @return lista de países participantes
     */
    public ArrayList<Pais> getPaises() {
        return paises;
    }
    /**
     * Retorna la lista de árbitros registrados en el torneo.
     *
     * @return lista de árbitros
     */
    public ArrayList<Arbitro> getArbitros() {
        return arbitros;
    }
    /**
     * Retorna la lista de selecciones registradas en el torneo.
     *
     * @return lista de selecciones participantes
     */
    public ArrayList<Seleccion> getSelecciones() {
        return selecciones;
    }
    /**
     * Retorna la lista de grupos configurados en el torneo.
     *
     * @return lista de grupos
     */
    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }
    /**
     * Retorna la lista de fases configuradas en el torneo.
     *
     * @return lista de fases
     */
    public ArrayList<Fase> getFases() {
        return fases;
    }
    /**
     * Retorna la lista de partidos planificados en el torneo.
     *
     * @return lista de partidos
     */
    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    /**
     * Solicita por consola los datos necesarios para crear el mundial
     * y valida que la fecha de finalización sea posterior a la de inicio.
     *
     * @return instancia del mundial creada con los datos ingresados
     */
    public Mundial crearMundial(){

        Mundial mundial;
        int anio;
        String mascota;
        int fechaComienzo;
        int fechaFinalizacion;

        System.out.println("\n[+] Cree el mundial. ");
        System.out.print("\n\tIngrese el año del mundial: ");
        anio = sc.nextInt();
        sc.nextLine();
        System.out.print("\tIngrese la mascota: ");
        mascota = sc.nextLine();
        System.out.print("\tIngrese la fecha de comienzo del mundial: ");
        fechaComienzo = sc.nextInt();
        System.out.print("\tIngrese la fecha de finalizacion del mundial: ");
        fechaFinalizacion = sc.nextInt();
        while (! (fechaFinalizacion > fechaComienzo)){
            System.out.println("\n[!] La fecha de finalizacion no puede ser antes que la fecha de comienzo.\n");
            System.out.print("\t[+] Ingrese la fecha de finalizacion del mundial: ");
            fechaFinalizacion = sc.nextInt();
            sc.nextLine();
        }
        Main.limpiarPantalla();

        mundial = new Mundial(anio, mascota, fechaComienzo, fechaFinalizacion);

        return mundial;

    }
    /**
     * Registra un árbitro en el torneo solicitando sus datos por consola
     * y asociándolo al país seleccionado por el usuario.
     * <p>
     * El árbitro creado se almacena en la colección general de árbitros
     * y en la lista de árbitros del país correspondiente.
     * </p>
     */
    public void registrarArbitro(){
        String nombre;
        int fecNacimiento;
        int aniosExperiencia;
        int id = 0;
        int op;

        System.out.print("\n[+] Ingrese el nombre del arbitro: ");
        nombre = sc.nextLine();
        System.out.print("\n[+] Ingrese la fecha de nacimiento: ");
        fecNacimiento = sc.nextInt();
        sc.nextLine();
        System.out.print("\n[+] Ingrese los años de experiencia: ");
        aniosExperiencia = sc.nextInt();
        sc.nextLine();

        for (Pais pais : this.paises){
            id++;
            System.out.println(id + ". " + pais.getNombre());
        }
        System.out.print("\n[+] Seleccione el pais del arbitro: ");
        op = sc.nextInt();
        sc.nextLine();
        if (op > 0 && op <= this.paises.size()){
            Arbitro arbitro = new Arbitro(nombre, fecNacimiento, aniosExperiencia);
            arbitro.setPais(this.paises.get(op-1));
            this.paises.get(op-1).setArbitros(arbitro);
            this.arbitros.add(arbitro);
            System.out.println("\n[+] Arbitro registrado exitosamente.");
        } else {
            System.out.println("[!] Identificador invalido.");
        }
    }

    /**
     * Solicita por consola los datos necesarios para crear un estadio
     * y lo retorna sin asociarlo a ninguna sede todavía.
     *
     * @return estadio creado con el nombre y capacidad ingresados
     */
    public Estadio agregarEstadio(){
        String nombre;
        int capacidad;

        System.out.print("\n[+] Ingrese el nombre del estadio: ");
        nombre = sc.nextLine();
        System.out.print("\n[+] Ingrese la capacidad del estadio: ");
        capacidad = sc.nextInt();
        sc.nextLine();

        return new Estadio(nombre, capacidad);

    }
    /**
     * Crea una nueva fase del torneo y la agrega a la colección,
     * verificando que no exista previamente una fase con el mismo nombre.
     * <p>
     * Presenta al usuario un menú con las fases disponibles según el
     * formato del torneo (Grupos, Dieciseisavos, Octavos, Cuartos,
     * Semifinal y Final).
     * </p>
     */
    public void crearFase(){
        int opcion;
        Fase fase_creada = new Fase();
        System.out.println("\n[+] Ingrese la fase a configurar en el mundial.\n");
        System.out.println("1. Grupos");
        System.out.println("2. Dieciseisavos");
        System.out.println("3. Octavos");
        System.out.println("4. Cuartos");
        System.out.println("5. Semifinal");
        System.out.println("6. Final");
        System.out.print("\n[+] Ingrese la opcion: ");
        opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion){
            case 1:
                fase_creada.setNombre(NombreFase.Grupos);
                break;
            case 2:
                fase_creada.setNombre(NombreFase.Dieciseisavos);
                break;
            case 3:
                fase_creada.setNombre(NombreFase.Octavos);
                break;
            case 4:
                fase_creada.setNombre(NombreFase.Cuartos);
                break;
            case 5:
                fase_creada.setNombre(NombreFase.Semifinal);
                break;
            case 6:
                fase_creada.setNombre(NombreFase.Final);
                break;
        }
        boolean yaExiste = false;
        if (this.fases.isEmpty()){
            this.fases.add(fase_creada);
        } else {
            for (Fase fase : this.fases){
                if (fase.getNombre() == fase_creada.getNombre()){
                    yaExiste = true;
                }
            }
            if (yaExiste == false){
                this.fases.add(fase_creada);
            }else {
                System.out.println("\n[!] La fase ya se encuentra configurada en el mundial");
            }
        }
    }
    /**
     * Vincula uno o más grupos a una fase del torneo seleccionada
     * por el usuario, verificando que cada grupo no tenga ya una
     * fase asignada.
     */
    public void vincularGrupos(){
        System.out.println("[+] Seleccione la fase a vincular los grupos: ");
        int id = 0;
        int opFase;
        int opGrupo;
        for (Fase fase : this.fases){
            id++;
            System.out.println(id + ". " + fase.getNombre());
        }
        System.out.print("\n\n[+] Seleccione la fase: ");
        opFase = sc.nextInt();
        sc.nextLine();

        if (opFase >= 1 && opFase <= this.fases.size()){
            boolean elegir = true;
            while (elegir){
                Fase fase_vincular = this.fases.get(opFase-1);
                System.out.println("[+] Indique los grupos a vincular a la fase.");
                id = 0;
                for (Grupo grupo : this.grupos){
                    id++;
                    System.out.println(id + ". " + grupo.getIdentificacion());
                }

                System.out.print("[+] Seleccione el grupo a vincular: ");
                opGrupo = sc.nextInt();
                sc.nextLine();
                if (opGrupo >= 1 && opGrupo <= this.grupos.size()){
                    Grupo grupo_vincular = this.grupos.get(opGrupo-1);

                    if (grupo_vincular.getFase() == null){
                        fase_vincular.addGrupos(grupo_vincular);
                        grupo_vincular.setFase(fase_vincular);
                    } else {
                        System.out.println("[!] El grupo ya posee una fase asignada.");
                    }
                } else {
                    System.out.println("\n[!] Identificador invalido.");
                }
                System.out.print("[+] Desea vincular otro grupo a la fase? (si/no): ");
                String resp = sc.nextLine().toLowerCase();
                if (resp.equals("si")){
                    elegir = true;
                }else{
                    elegir = false;
                }
            }
            
        }else {
            System.out.println("[!] Identificador invalido.");
        }

    }  

    /**
     * Crea un nuevo grupo, lo agrega a la colección del torneo y lo
     * retorna para que el llamador pueda vincularle selecciones.
     *
     * @return el grupo creado con la identificación y descripción ingresadas
     */
    public Grupo agregarGrupo(){
        System.out.print("\n[+] Ingrese la identificacion del grupo: ");
        String identificacion = sc.nextLine();
        System.out.print("\n[+] Ingrese la descripcion del grupo: ");
        String descripcion = sc.nextLine();
        Grupo grupo = new Grupo(identificacion, descripcion);
        this.grupos.add(grupo);
        return grupo;
    }
    /**
     * Asocia selecciones sin grupo asignado al grupo indicado.
     * <p>
     * Permite agregar múltiples selecciones de forma iterativa.
     * El proceso se detiene cuando el usuario decide no agregar más
     * o cuando no quedan selecciones disponibles.
     * </p>
     *
     * @param grupo grupo al que se vincularán las selecciones
     */
    public void vincularSelecciones(Grupo grupo){
        int id = 0;
        int op;
        boolean hayDisponibles = true;
        System.out.println("\n[+] Indique la selecciones que pertenecen al grupo: " + grupo.getIdentificacion() + "\n");
        for (Seleccion seleccion : this.selecciones){
            id++;
            System.out.println(id + ". " + seleccion.getPais().getNombre());
        }
        while (hayDisponibles){

            System.out.print("\n[+] Ingrese la seleccion a agregar: ");
            op = sc.nextInt();
            sc.nextLine();
            if (op < 1 || op > this.selecciones.size()){
                System.out.println("\n[!] Identificador invalido.");
                continue;
            }else {
                if (this.selecciones.get(op-1).getGrupo() == null){
                    grupo.addSeleccion(this.selecciones.get(op-1));
                    this.selecciones.get(op-1).setGrupo(grupo);
                }else {
                    System.out.println("[!] La seleccion ya posee un grupo.");
                    continue;
                }
            }
            System.out.print("\n[+] Desea agregar otra seleccion al grupo? (si/no): ");
            String resp = sc.nextLine().toLowerCase();
            hayDisponibles = false;
            if (resp.equals("si")){
                for (Seleccion seleccion : this.selecciones){
                    if (seleccion.getGrupo() == null){
                        hayDisponibles = true;
                        break;
                    }
                }
                if (!hayDisponibles){
                    System.out.println("[i] No hay selecciones disponibles para asignar grupo.");
                    break;
                }
            } else {
                break;
            }
        }

    }
    /**
     * Solicita los datos de un nuevo país, lo registra en la colección
     * del torneo y lo asocia opcionalmente a una sede sin país asignado.
     * <p>
     * Si el país ya se encuentra registrado, informa al usuario y
     * retorna {@code null}.
     * </p>
     *
     * @return el país creado, o {@code null} si ya existía
     */
    public Pais agregarPais(){
        String nombre;
        String bandera;
        String opcion;
        Pais pais;
        System.out.print("\n[+] Ingrese el nombre del pais: ");
        nombre = sc.nextLine();
        System.out.print("\n[+] Ingrese la bandera del pais: ");
        bandera = sc.nextLine();
        pais = new Pais(nombre, bandera);
        if (!this.paises.contains(pais)){
            this.paises.add(pais);
            for (Sede sede : mundial.getSedes()){
                if (sede.getPais() == null){
                    System.out.print("\n[?] La sede " + sede.getCiudad() + " pertenece al pais " + pais.getNombre() + "? (si/no): ");
                    opcion = sc.nextLine().toLowerCase();
                    if(opcion.equals("si")){
                        sede.setPais(pais);
                        pais.addSedes(sede);
                    }
                }
            }
            return pais;
        } else {
            Main.limpiarPantalla();
            System.out.println("\n[!] El pais ya se encuentra registrado.");
            return null;
        }

    }
    /**
     * Solicita por consola los datos de una nueva sede y la retorna.
     * La sede creada aún no está asociada a ninguna sede del mundial;
     * la vinculación se realiza desde {@link Menus}.
     *
     * @return nueva sede creada con los datos ingresados
     */
    public Sede registSede(){
        String ciudad;
        float alturaNivelMar;
        String clima;
        String zonaHoraria;
  
        System.out.print("\n[+] Ingrese la ciudad de la sede: ");
        ciudad = sc.nextLine();
        System.out.print("\n[+] Ingrese la altura al nivel del mar: ");
        alturaNivelMar = sc.nextFloat();
        sc.nextLine();
        System.out.print("\n[+] Ingrese el clima: ");
        clima = sc.nextLine();
        System.out.print("\n[+] Ingrese la zona horaria: ");
        zonaHoraria = sc.nextLine();

        return new Sede(ciudad, alturaNivelMar, clima, zonaHoraria);

    }
    /**
     * Vincula un estadio a una sede registrada en el mundial.
     * <p>
     * Presenta las sedes disponibles, solicita al usuario que indique
     * el identificador de la sede destino y realiza la asociación
     * bidireccional entre el estadio y la sede seleccionada.
     * </p>
     *
     * @param estadio estadio a vincular a una sede
     */
    public void vincularEstadiosSede(Estadio estadio){
        int id = 0;
        Sede sede_asignar;
        if (mundial.getSedes().isEmpty()){
           System.out.println("[!] No hay sedes registradas.");
            return;
        }
        for(Sede sede : mundial.getSedes()){
            System.out.println(String.format("ID %d:", id+1) + "\n\t" + sede.getCiudad());
            id++;
        }
        while (true){
            System.out.print("\n[+] Indique el ID de la sede: ");
            id = sc.nextInt();
            sc.nextLine();
            if (id < 1 || id > mundial.getSedes().size()){
                System.out.println("[!] ID inválido.");
            }else{
                break;
            }
        }
        if (estadio.getSede() == null){
            sede_asignar = mundial.getSedes().get(id-1);
            sede_asignar.addEstadio(estadio);
            estadio.setSede(sede_asignar);
            Main.limpiarPantalla();
            System.out.println(String.format("\n[+] Se ha asignado el estadio %s a la sede en %s", estadio.getNombre(), sede_asignar.getCiudad()));
        }
    }
    /**
     * Registra una nueva selección en el torneo solicitando por consola
     * toda su información, incluyendo jugadores, cuerpo técnico,
     * directores técnicos y el país que representa.
     * <p>
     * Si ninguno de los países registrados corresponde a la selección,
     * permite agregar uno nuevo en el momento.
     * </p>
     */
    public void agregarSeleccion(){
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
        for (Pais pais : this.paises) {
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
            Pais nuevoPais = this.agregarPais();
            nuevoPais.setSeleccion(seleccion);
            seleccion.setPais(nuevoPais);
            if (!this.paises.contains(nuevoPais)){
                this.paises.add(nuevoPais);
            }
        }
        this.selecciones.add(seleccion);
    }

    /**
     * Configura el equipo arbitral de un partido permitiendo seleccionar
     * árbitros de la colección del torneo y asignarles una categoría.
     * <p>
     * El método valida que el equipo cuente con al menos un árbitro de
     * categoría {@link CategoriaArbitro#Principal} antes de finalizar
     * la configuración.
     * </p>
     *
     * @param partido partido al que se asignará el equipo de arbitraje
     */
    public void configurarArbitraje(Partido partido){

        boolean agregar;
        int op = 0;
        Arbitraje arbitraje = null;
        do {
            op = 0;
            System.out.println("\n[+] Seleccione los arbitros que conformaran el equipo de arbitraje.");
            for (Arbitro arbitro : this.arbitros){
                op++;
                System.out.println(op + ". " + arbitro.getNombre());
            }
            System.out.print("\n[+] Seleccione el arbitro: ");
            op = sc.nextInt();
            sc.nextLine();

            Arbitro arbitro = this.arbitros.get(op-1);

            op = 0;
            System.out.println("\n[+] Indique la categoria del arbitro.");
            System.out.println("1. Principal");
            System.out.println("2. Primer asistente");
            System.out.println("3. Segundo asistente");
            System.out.println("4. Cuarto arbitro");
            System.out.println("5. VAR principal");
            System.out.println("6. VAR asistente");
            System.out.print("\n[+] Seleccione la categoria: ");
            op = sc.nextInt();
            sc.nextLine();
            switch (op){
                case 1:
                    arbitraje = new Arbitraje(CategoriaArbitro.Principal);
                    break;
                case 2:
                    arbitraje = new Arbitraje(CategoriaArbitro.Asistente1);
                    break;
                case 3:
                    arbitraje = new Arbitraje(CategoriaArbitro.Asistente2);
                    break;
                case 4:
                    arbitraje = new Arbitraje(CategoriaArbitro.CuartoArbitro);
                    break;
                case 5:
                    arbitraje = new Arbitraje(CategoriaArbitro.VarPrincipal);
                    break;
                case 6:
                    arbitraje = new Arbitraje(CategoriaArbitro.VarAsistente);
                    break;
            }

            arbitraje.setArbitro(arbitro);
            arbitraje.setPartido(partido);

            arbitro.addArbitraje(arbitraje);
            partido.addArbitraje(arbitraje);

            System.out.print("[+] Desea agregar alguien mas al equipo de arbitraje? (si/no): ");
            String resp = sc.nextLine().toLowerCase();
            boolean arbitraje_valido = false;
            if (resp.equals("si")){
                agregar = true;
            } else {
                agregar = false;
                for (Arbitraje arbitraje_check : partido.getArbitraje()){
                    if (arbitraje_check.getRol() == CategoriaArbitro.Principal){
                        arbitraje_valido = true;
                    }
                }
                if (!arbitraje_valido){
                    System.out.println("\n[!] Se requiere un arbitro de rol principal.");
                    agregar = true;
                }
            }

        } while (agregar);

    }

    /**
     * Planifica un nuevo partido en el torneo solicitando por consola
     * fecha, horario, duración, estadio, fase, selecciones participantes
     * y equipo de arbitraje.
     * <p>
     * Valida que las selecciones local y visitante sean distintas antes
     * de registrar el partido. Al finalizar, el partido queda registrado
     * en la colección del torneo y en la fase correspondiente.
     * </p>
     */
    public void planificarPartido(){

        ArrayList<Estadio> estadios_disponibles = new ArrayList<>();

        System.out.print("\n[+] Ingrese la fecha del partido (AÑO-MES-DIA): ");
        LocalDate fecha = LocalDate.parse(sc.nextLine());
        System.out.print("\n[+] Ingrese el horario (HORA:MINUTO): ");
        LocalTime horario = LocalTime.parse(sc.nextLine());
        System.out.print("\n[+] Ingrese la duracion del partido: ");
        int duracion = sc.nextInt();
        sc.nextLine();
        System.out.print("\n[+] Indique el tiempo adicional que tendra el partido: ");
        int tiempoAdicional = sc.nextInt();
        sc.nextLine();

        Partido partido = new Partido(fecha, horario, duracion, tiempoAdicional);

        for (Sede sede : mundial.getSedes()){
            for (Estadio estadio : sede.getEstadios()){
                    estadios_disponibles.add(estadio);
            }
        }

        int op = 0;
        System.out.println("\n[+] Seleccione el estadio donde se jugara el partido");
        for (Estadio estadio : estadios_disponibles){
            op++;
            System.out.println(op + ". " + estadio.getNombre());
        }
        System.out.print("\n[+] Ingrese el indentificador del estadio: ");
        op = sc.nextInt();
        sc.nextLine();
        partido.setEstadio(estadios_disponibles.get(op-1));
        estadios_disponibles.get(op-1).addPartido(partido);

        op = 0;
        System.out.println("[+] Indique a que fase corresponde el partido.");
        for (Fase fase : this.fases){
            op++;
            System.out.println(op + ". " + fase.getNombre());
        }
        System.out.print("\n[+] Ingrese la fase a la que pertenece el partido: ");
        op = sc.nextInt();
        sc.nextLine();

        partido.setFase(this.fases.get(op-1));
        this.fases.get(op-1).addPartidos(partido);

        op = 0;
        System.out.println("[+] Indique las selecciones que jugaran el partido.");
        for (Seleccion seleccion : this.selecciones){
            op++;
            System.out.println(op + ". " + seleccion.getPais().getNombre());
        }

        System.out.print("[+] Ingrese la seleccion LOCAL: ");
        int op1 = sc.nextInt();
        sc.nextLine();
        System.out.print("[+] Ingrese la seleccion VISITANTE: ");
        int op2 = sc.nextInt();
        sc.nextLine();
        if (op1 == op2){
            System.out.println("[!] No puede indicar la misma seleccion.");
            return;
        }
        Seleccion seleccionLocal = this.selecciones.get(op1-1);
        Seleccion seleccionVisitante = this.selecciones.get(op2-1);

        Participacion participacionLocal = new Participacion(true, partido, seleccionLocal);
        Participacion participacionVisitante = new Participacion(false, partido, seleccionVisitante);

        partido.setParticipacionLocal(participacionLocal);
        partido.setParticipacionVisitante(participacionVisitante);

        participacionLocal.setPartido(partido);
        participacionVisitante.setPartido(partido);

        seleccionLocal.addParticipacion(participacionLocal);
        seleccionVisitante.addParticipacion(participacionVisitante);

        configurarArbitraje(partido);

        this.partidos.add(partido);

        System.out.println("\n[+] El partido se ha planificado exitosamente.");

    }


}
