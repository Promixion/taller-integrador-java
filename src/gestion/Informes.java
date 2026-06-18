package gestion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import modelo.Arbitraje;
import modelo.Estadio;
import modelo.Evento;
import modelo.Grupo;
import modelo.Jugador;
import modelo.Participacion;
import modelo.Partido;
import modelo.Sede;
import modelo.Seleccion;
import modelo.enums.TipoEvento;
/**
 * Clase encargada de generar y mostrar los distintos informes
 * estadísticos y de consulta relacionados con el mundial.
 *
 * <p>
 * Proporciona funcionalidades para visualizar tablas de posiciones,
 * resultados de selecciones, rankings de goleadores, informes
 * disciplinarios, fichas técnicas de partidos y estadísticas
 * asociadas a estadios y ciudades sede.
 * </p>
 *
 * <p>
 * Los informes se construyen a partir de la información registrada
 * en el sistema mediante la clase {@code GestionMundial}, permitiendo
 * consultar el desempeño de selecciones, jugadores, árbitros,
 * partidos y sedes a lo largo del torneo.
 * </p>
 *
 * <h2>Informes disponibles</h2>
 * <ul>
 *   <li>Tabla de posiciones por grupo.</li>
 *   <li>Tabla de resultados por selección.</li>
 *   <li>Ranking de goleadores.</li>
 *   <li>Informe disciplinario por selección o jugador.</li>
 *   <li>Ficha técnica detallada de partidos.</li>
 *   <li>Estadísticas de estadios y ciudades sede.</li>
 * </ul>
 *
 * @author Juan
 * @author Liset
 */
public class Informes {
    /**
     * Crea una instancia de la clase Informes.
     * <p>
     * No requiere parámetros de inicialización ya que los datos
     * necesarios para generar los informes son proporcionados
     * mediante los objetos recibidos en cada método.
     * </p>
     */
    public Informes() {
    }

    /**
     * Muestra la tabla de posiciones de un grupo seleccionado,
     * incluyendo partidos jugados, victorias, empates, derrotas,
     * goles a favor, goles en contra y puntos obtenidos por cada
     * selección.
     *
     * @param mundial mundial que contiene los grupos registrados
     * @param sc scanner utilizado para la entrada de datos
     */
    public void tablaPosicionesGrupo(GestionMundial gestion, Scanner sc) {

        if (gestion.getGrupos().isEmpty()) {
            System.out.println("[!] No hay grupos configurados.");
            return;
        }

        int id = 0;
        System.out.println("\n[+] Seleccione el grupo:\n");
        for (Grupo grupo : gestion.getGrupos()) {
            System.out.println((++id) + ". Grupo " + grupo.getIdentificacion());
        }
        System.out.print("\n[+] Ingrese una opcion: ");
        int op = sc.nextInt();
        sc.nextLine();

        if (op < 1 || op > gestion.getGrupos().size()) {
            System.out.println("[!] Identificador invalido.");
            return;
        }

        Grupo grupoElegido = gestion.getGrupos().get(op - 1);

        if (grupoElegido.getFase() == null) {
            System.out.println("[!] El grupo no tiene una fase asignada.");
            return;
        }

        System.out.println("\n========== TABLA DE POSICIONES - GRUPO " + grupoElegido.getIdentificacion() + " ==========\n");
        System.out.printf("%-20s %4s %4s %4s %4s %4s %4s %4s%n","Seleccion", "PJ", "G", "E", "P", "GF", "GC", "PTS");
        System.out.println("--------------------------------------------------------------");
        /*
        * Cada elemento del arreglo almacena:
        * [0] Índice de la selección en la lista del grupo
        * [1] Partidos jugados (PJ)
        * [2] Partidos ganados (G)
        * [3] Partidos empatados (E)
        * [4] Partidos perdidos (P)
        * [5] Goles a favor (GF)
        * [6] Goles en contra (GC)
        * [7] Puntos (PTS)
        */
        ArrayList<int[]> stats = new ArrayList<>();
        ArrayList<Seleccion> selecciones = grupoElegido.getSeleccion();

        // Calcula las estadísticas de cada selección del grupo.
        for (int i = 0; i < selecciones.size(); i++) {
            Seleccion seleccion = selecciones.get(i);
            int pj = 0, g = 0, e = 0, p = 0, gf = 0, gc = 0;

            // Recorre todos los partidos de la fase para determinar
            // el desempeño de la selección actual.
            for (Partido partido : grupoElegido.getFase().getPartidos()) {
                Participacion partLocal = partido.getParticipacionLocal();
                Participacion partVisitante = partido.getParticipacionVisitante();

                // Determina si la selección participó como local o visitante.
                boolean esLocal = partLocal.getSeleccion().equals(seleccion);
                boolean esVisitante = partVisitante.getSeleccion().equals(seleccion);

                // Si la selección no participó en el partido,
                // se continúa con el siguiente.
                if (!esLocal && !esVisitante) continue;

                pj++;
                int golesLocal = partLocal.cantidadGoles();
                int golesVisitante = partVisitante.cantidadGoles();

                // Calcula goles a favor y en contra según la condición
                // de local o visitante de la selección.
                gf += esLocal ? golesLocal : golesVisitante;
                gc += esLocal ? golesVisitante : golesLocal;

                // Actualiza victorias, empates o derrotas.
                if (golesLocal == golesVisitante) {
                    e++;
                } else if (esLocal && golesLocal > golesVisitante) {
                    g++;
                } else if (esVisitante && golesVisitante > golesLocal) {
                    g++;
                } else {
                    p++;
                }
            }

            int pts = grupoElegido.obtenerPuntos(seleccion);

            // Se almacena toda la información estadística de la selección.
            stats.add(new int[]{i, pj, g, e, p, gf, gc, pts});
        }
        // Ordena la tabla de posiciones de mayor a menor cantidad de puntos
        // utilizando el algoritmo burbuja.
        for (int i = 0; i < stats.size() - 1; i++) {
            for (int j = 0; j < stats.size() - 1 - i; j++) {
                if (stats.get(j)[7] < stats.get(j + 1)[7]) {
                    int[] temp = stats.get(j);
                    stats.set(j, stats.get(j + 1));
                    stats.set(j + 1, temp);
                }
            }
        }

        // Muestra la tabla ya ordenada.
        for (int[] row : stats) {
            Seleccion s = selecciones.get(row[0]);
            System.out.printf("%-20s %4d %4d %4d %4d %4d %4d %4d%n",
                    s.getPais().getNombre(),
                    row[1], row[2], row[3], row[4], row[5], row[6], row[7]);
        }

        System.out.println("--------------------------------------------------------------");
    }

    /**
     * Muestra los resultados obtenidos por una selección durante
     * el torneo.
     * <p>
     * Para cada partido se informa la fase disputada, los equipos
     * participantes, el resultado final y la condición obtenida
     * por la selección (victoria, empate o derrota). Además,
     * se presenta un resumen con los partidos jugados, puntos
     * acumulados y la última fase alcanzada.
     * </p>
     *
     * @param gestion objeto encargado de administrar los datos del mundial.
     * @param sc scanner utilizado para la entrada de datos.
     */
    public void tablaResultadosSeleccion(GestionMundial gestion, Scanner sc){
        if (gestion.getSelecciones().isEmpty()) {
            System.out.println("[!] No hay selecciones registradas.");
            return;
        }

        int id = 0;
        System.out.println("\n[+] Seleccione la seleccion:\n");
        for (Seleccion seleccion : gestion.getSelecciones()) {
            System.out.println((++id) + ". " + seleccion.getPais().getNombre());
        }
        System.out.print("\n[+] Ingrese una opcion: ");
        int op = sc.nextInt();
        sc.nextLine();

        if (op < 1 || op > gestion.getSelecciones().size()) {
            System.out.println("[!] Identificador invalido.");
            return;
        }

        Seleccion seleccion = gestion.getSelecciones().get(op - 1);

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
    
    /**
     * Muestra el informe disciplinario de una selección,
     * detallando las tarjetas recibidas por cada jugador
     * y los totales acumulados por el equipo.
     *
     * @param mundial mundial que contiene las selecciones registradas
     * @param sc scanner utilizado para la entrada de datos
     */
    public void informeDisciplinarioSeleccion(GestionMundial gestion, Scanner sc) {

        int id = 0;
        System.out.println("\n[+] Seleccione la seleccion:\n");
        for (Seleccion seleccion : gestion.getSelecciones()) {
            System.out.println((++id) + ". " + seleccion.getPais().getNombre());
        }
        System.out.print("\n[+] Ingrese una opcion: ");
        int op = sc.nextInt();
        sc.nextLine();

        if (op < 1 || op > gestion.getSelecciones().size()) {
            System.out.println("[!] Identificador invalido.");
            return;
        }

        Seleccion seleccion = gestion.getSelecciones().get(op - 1);

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

    /**
     * Permite seleccionar y generar un informe disciplinario.
     * <p>
     * El usuario puede optar por consultar las sanciones acumuladas
     * de una selección completa o de un jugador en particular.
     * </p>
     *
     * @param gestion objeto encargado de administrar los datos del mundial.
     * @param sc scanner utilizado para la entrada de datos.
     */
    public void informeDisciplinario(GestionMundial gestion, Scanner sc) {

        if (gestion.getSelecciones().isEmpty()) {
            System.out.println("[!] No hay selecciones registradas.");
            return;
        }

        System.out.println("\n[+] Ver informe disciplinario por:\n");
        System.out.println("1. Seleccion");
        System.out.println("2. Jugador");
        System.out.print("\n[+] Ingrese una opcion: ");
        int op = sc.nextInt();
        sc.nextLine();

        if (op == 1) {
            informeDisciplinarioSeleccion(gestion, sc);
        } else if (op == 2) {
            informeDisciplinarioJugador(gestion, sc);
        } else {
            System.out.println("[!] Opcion invalida.");
        }
    }

    /**
     * Genera y muestra un ranking de goleadores del mundial.
     * <p>
     * El informe contabiliza los goles convertidos por cada jugador,
     * incluyendo los penales convertidos, y los ordena de mayor
     * a menor cantidad de anotaciones.
     * </p>
     *
     * @param gestion objeto encargado de administrar los datos del mundial.
     */
    public void rankingGoleadores(GestionMundial gestion) {

        if (gestion.getSelecciones().isEmpty()) {
            System.out.println("[!] No hay selecciones registradas.");
            return;
        }

        ArrayList<Jugador> jugadores = new ArrayList<>();
        ArrayList<Integer> goles = new ArrayList<>();
        ArrayList<String> paises = new ArrayList<>();

        for (Seleccion seleccion : gestion.getSelecciones()) {
            for (Jugador jugador : seleccion.getJugadores()) {
                int cantGoles = 0;
                for (Evento evento : jugador.getEventos()) {
                    if (evento.getTipo() == TipoEvento.Gol || 
                        evento.getTipo() == TipoEvento.PenalConvertido) {
                        cantGoles++;
                    }
                }
                if (cantGoles > 0) {
                    jugadores.add(jugador);
                    goles.add(cantGoles);
                    paises.add(seleccion.getPais().getNombre());
                }
            }
        }

        if (jugadores.isEmpty()) {
            System.out.println("[!] No hay goles registrados aun.");
            return;
        }

        for (int i = 0; i < goles.size() - 1; i++) {
            for (int j = 0; j < goles.size() - 1 - i; j++) {
                if (goles.get(j) < goles.get(j + 1)) {
                    int tempG = goles.get(j);
                    goles.set(j, goles.get(j + 1));
                    goles.set(j + 1, tempG);
                    Jugador tempJ = jugadores.get(j);
                    jugadores.set(j, jugadores.get(j + 1));
                    jugadores.set(j + 1, tempJ);
                    String tempP = paises.get(j);
                    paises.set(j, paises.get(j + 1));
                    paises.set(j + 1, tempP);
                }
            }
        }

        System.out.println("\n========== RANKING DE GOLEADORES ==========\n");
        System.out.printf("%-5s %-20s %-20s %6s%n", "POS", "Jugador", "Seleccion", "Goles");
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < jugadores.size(); i++) {
            System.out.printf("%-5d %-20s %-20s %6d%n",
                    i + 1,
                    jugadores.get(i).getNombre(),
                    paises.get(i),
                    goles.get(i));
        }

        System.out.println("--------------------------------------------------");
    }
    /**
     * Genera un informe disciplinario detallado para un jugador.
     * <p>
     * Se muestran todas las tarjetas amarillas, rojas y dobles
     * amarillas recibidas por el jugador, indicando además el
     * partido y el minuto en que fueron registradas.
     * </p>
     *
     * @param gestion objeto encargado de administrar los datos del mundial.
     * @param sc scanner utilizado para la entrada de datos.
     */
    public void informeDisciplinarioJugador(GestionMundial gestion, Scanner sc) {

        int id = 0;
        System.out.println("\n[+] Seleccione la seleccion del jugador:\n");
        for (Seleccion seleccion : gestion.getSelecciones()) {
            System.out.println((++id) + ". " + seleccion.getPais().getNombre());
        }
        System.out.print("\n[+] Ingrese una opcion: ");
        int op = sc.nextInt();
        sc.nextLine();

        if (op < 1 || op > gestion.getSelecciones().size()) {
            System.out.println("[!] Identificador invalido.");
            return;
        }

        Seleccion seleccion = gestion.getSelecciones().get(op - 1);

        id = 0;
        System.out.println("\n[+] Seleccione el jugador:\n");
        for (Jugador jugador : seleccion.getJugadores()) {
            System.out.println((++id) + ". " + jugador.getNombre());
        }
        System.out.print("\n[+] Ingrese una opcion: ");
        op = sc.nextInt();
        sc.nextLine();

        if (op < 1 || op > seleccion.getJugadores().size()) {
            System.out.println("[!] Identificador invalido.");
            return;
        }

        Jugador jugador = seleccion.getJugadores().get(op - 1);

        System.out.println("\n========== INFORME DISCIPLINARIO - " + jugador.getNombre().toUpperCase() + " ==========\n");
        System.out.printf("%-15s %-25s %-10s%n", "Tipo", "Partido", "Minuto");
        System.out.println("--------------------------------------------------");

        boolean tieneTarjetas = false;

        for (Evento evento : jugador.getEventos()) {
            if (evento.getTipo() == TipoEvento.TarjetaAmarilla ||
                evento.getTipo() == TipoEvento.TarjetaRoja ||
                evento.getTipo() == TipoEvento.DobleAmarilla) {

                String nombrePartido = "Desconocido";
                for (Partido partido : gestion.getPartidos()) {
                    if (partido.getEventos().contains(evento)) {
                        nombrePartido = partido.getParticipacionLocal().getSeleccion().getPais().getNombre()
                                + " vs "
                                + partido.getParticipacionVisitante().getSeleccion().getPais().getNombre();
                        break;
                    }
                }

                System.out.printf("%-15s %-25s %-10d%n",
                        evento.getTipo(),
                        nombrePartido,
                        evento.getMinuto());
                tieneTarjetas = true;
            }
        }

        if (!tieneTarjetas) {
            System.out.println("[i] El jugador no tiene tarjetas registradas.");
        }

        System.out.println("--------------------------------------------------");
    }
    /**
     * Muestra la ficha técnica completa de un partido.
     * <p>
     * Incluye información general del encuentro, resultado,
     * alineaciones de ambos equipos, eventos registrados y
     * cuerpo arbitral asignado.
     * </p>
     *
     * @param gestion objeto encargado de administrar los datos del mundial.
     * @param sc scanner utilizado para la entrada de datos.
     */
    public void fichaTecnicaPartido(GestionMundial gestion, Scanner sc) {

        if (gestion.getPartidos().isEmpty()) {
            System.out.println("[!] No hay partidos registrados.");
            return;
        }

        int id = 0;
        System.out.println("\n[+] Seleccione el partido:\n");
        for (Partido partido : gestion.getPartidos()) {
            System.out.println((++id) + ". " + partido);
        }
        System.out.print("\n[+] Ingrese una opcion: ");
        int op = sc.nextInt();
        sc.nextLine();

        if (op < 1 || op > gestion.getPartidos().size()) {
            System.out.println("[!] Identificador invalido.");
            return;
        }

        Partido partido = gestion.getPartidos().get(op - 1);
        Participacion local = partido.getParticipacionLocal();
        Participacion visitante = partido.getParticipacionVisitante();

        System.out.println("\n================================================================");
        System.out.println("                    FICHA TECNICA DE PARTIDO");
        System.out.println("================================================================");
        System.out.println("  Fase     : " + partido.getFase().getNombre());
        System.out.println("  Fecha    : " + partido.getFecha());
        System.out.println("  Horario  : " + partido.getHorario());
        System.out.println("  Estadio  : " + partido.getEstadio().getNombre());
        System.out.println("  Duracion : " + partido.getDuracion() + " min  |  T. Adicional: " + partido.getTiempoAdicional() + " min");
        System.out.println("----------------------------------------------------------------");

        int golesLocal = local.cantidadGoles();
        int golesVisitante = visitante.cantidadGoles();
        System.out.println("\n  " + local.getSeleccion().getPais().getNombre()
                + "  " + golesLocal + " - " + golesVisitante
                + "  " + visitante.getSeleccion().getPais().getNombre());
        System.out.println("\n----------------------------------------------------------------");

        System.out.println("\n  ALINEACION LOCAL - " + local.getSeleccion().getPais().getNombre().toUpperCase());
        System.out.printf("  %-5s %-20s %-15s%n", "N°", "Jugador", "Posicion");
        System.out.println("  ----------------------------------------");
        for (Jugador jugador : local.getSeleccion().getJugadores()) {
            System.out.printf("  %-5d %-20s %-15s%n",
                    jugador.getDorsal(),
                    jugador.getNombre(),
                    jugador.getPosicion());
        }

        System.out.println("\n  ALINEACION VISITANTE - " + visitante.getSeleccion().getPais().getNombre().toUpperCase());
        System.out.printf("  %-5s %-20s %-15s%n", "N°", "Jugador", "Posicion");
        System.out.println("  ----------------------------------------");
        for (Jugador jugador : visitante.getSeleccion().getJugadores()) {
            System.out.printf("  %-5d %-20s %-15s%n",
                    jugador.getDorsal(),
                    jugador.getNombre(),
                    jugador.getPosicion());
        }

        System.out.println("\n----------------------------------------------------------------");
        System.out.println("\n  EVENTOS DEL PARTIDO\n");
        System.out.printf("  %-8s %-20s %-20s %-15s%n", "Minuto", "Jugador", "Seleccion", "Evento");
        System.out.println("  ----------------------------------------------------------------");

        if (partido.getEventos().isEmpty()) {
            System.out.println("  [i] No hay eventos registrados para este partido.");
        } else {
            ArrayList<Evento> eventosOrdenados = new ArrayList<>(partido.getEventos());
            Collections.sort(eventosOrdenados, new Comparator<Evento>() {
                @Override
                public int compare(Evento a, Evento b) {
                    return a.getMinuto() - b.getMinuto();
                }
            });

            for (Evento evento : eventosOrdenados) {
                String nombreSeleccion = "";
                for (Seleccion seleccion : gestion.getSelecciones()) {
                    if (seleccion.getJugadores().contains(evento.getJugador())) {
                        nombreSeleccion = seleccion.getPais().getNombre();
                        break;
                    }
                }
                System.out.printf("  %-8d %-20s %-20s %-15s%n",
                        evento.getMinuto(),
                        evento.getJugador().getNombre(),
                        nombreSeleccion,
                        evento.getTipo());
            }
        }

        System.out.println("\n----------------------------------------------------------------");
        System.out.println("\n  EQUIPO DE ARBITRAJE\n");
        System.out.printf("  %-20s %-20s %-15s%n", "Arbitro", "Pais", "Categoria");
        System.out.println("  --------------------------------------------------------");

        for (Arbitraje arbitraje : partido.getArbitraje()) {
            System.out.printf("  %-20s %-20s %-15s%n",
                    arbitraje.getArbitro().getNombre(),
                    arbitraje.getArbitro().getPais().getNombre(),
                    arbitraje.getRol());
        }

        System.out.println("\n================================================================\n");
    }
    /**
     * Permite seleccionar el tipo de estadísticas relacionadas
     * con las sedes del mundial.
     * <p>
     * El usuario puede consultar estadísticas agrupadas por
     * estadio o por ciudad sede.
     * </p>
     *
     * @param gestion objeto encargado de administrar los datos del mundial.
     * @param sc scanner utilizado para la entrada de datos.
     */
    public void estadisticasSedes(GestionMundial gestion, Scanner sc) {

        if (gestion.getMundial().getSedes().isEmpty()) {
            System.out.println("[!] No hay sedes registradas.");
            return;
        }

        System.out.println("\n[+] Ver estadisticas por:\n");
        System.out.println("1. Estadio");
        System.out.println("2. Ciudad (sede)");
        System.out.print("\n[+] Ingrese una opcion: ");
        int op = sc.nextInt();
        sc.nextLine();

        if (op == 1) {
            estadisticasPorEstadio(gestion, sc);
        } else if (op == 2) {
            estadisticasPorCiudad(gestion, sc);
        } else {
            System.out.println("[!] Opcion invalida.");
        }
    }
    /**
     * Genera estadísticas correspondientes a un estadio.
     * <p>
     * Muestra la cantidad de partidos disputados, los resultados
     * obtenidos en cada encuentro y el total de goles convertidos
     * dentro del estadio seleccionado.
     * </p>
     *
     * @param gestion objeto encargado de administrar los datos del mundial.
     * @param sc scanner utilizado para la entrada de datos.
     */
    public void estadisticasPorEstadio(GestionMundial gestion, Scanner sc) {

        ArrayList<Estadio> estadios = new ArrayList<>();
        for (Sede sede : gestion.getMundial().getSedes()) {
            for (Estadio estadio : sede.getEstadios()) {
                estadios.add(estadio);
            }
        }

        if (estadios.isEmpty()) {
            System.out.println("[!] No hay estadios registrados.");
            return;
        }

        int id = 0;
        System.out.println("\n[+] Seleccione el estadio:\n");
        for (Estadio estadio : estadios) {
            System.out.println((++id) + ". " + estadio.getNombre() + " - " + estadio.getSede().getCiudad());
        }
        System.out.print("\n[+] Ingrese una opcion: ");
        int op = sc.nextInt();
        sc.nextLine();

        if (op < 1 || op > estadios.size()) {
            System.out.println("[!] Identificador invalido.");
            return;
        }

        Estadio estadio = estadios.get(op - 1);

        System.out.println("\n================================================================");
        System.out.println("          ESTADISTICAS - " + estadio.getNombre().toUpperCase());
        System.out.println("================================================================");
        System.out.println("  Ciudad   : " + estadio.getSede().getCiudad());
        System.out.println("  Capacidad: " + estadio.getCapacidad() + " espectadores");
        System.out.println("  Partidos jugados: " + estadio.getPartido().size());
        System.out.println("----------------------------------------------------------------\n");

        if (estadio.getPartido().isEmpty()) {
            System.out.println("  [i] No hay partidos jugados en este estadio.");
            return;
        }

        System.out.printf("  %-12s %-20s %-20s %8s%n", "Fase", "Local", "Visitante", "Result.");
        System.out.println("  ----------------------------------------------------------------");

        int totalGoles = 0;

        for (Partido partido : estadio.getPartido()) {
            Participacion local = partido.getParticipacionLocal();
            Participacion visitante = partido.getParticipacionVisitante();
            int gl = local.cantidadGoles();
            int gv = visitante.cantidadGoles();
            totalGoles += gl + gv;

            System.out.printf("  %-12s %-20s %-20s %4d - %-4d%n",
                    partido.getFase().getNombre(),
                    local.getSeleccion().getPais().getNombre(),
                    visitante.getSeleccion().getPais().getNombre(),
                    gl, gv);
        }

        System.out.println("  ----------------------------------------------------------------");
        System.out.println("  Total de goles en el estadio: " + totalGoles);
        System.out.println("================================================================\n");
    }
    /**
     * Genera estadísticas correspondientes a una ciudad sede.
     * <p>
     * El informe incluye los estadios ubicados en la ciudad,
     * la cantidad de partidos disputados en cada uno y el
     * total de goles registrados.
     * </p>
     *
     * @param gestion objeto encargado de administrar los datos del mundial.
     * @param sc scanner utilizado para la entrada de datos.
     */
    public void estadisticasPorCiudad(GestionMundial gestion, Scanner sc) {

        int id = 0;
        System.out.println("\n[+] Seleccione la ciudad:\n");
        for (Sede sede : gestion.getMundial().getSedes()) {
            System.out.println((++id) + ". " + sede.getCiudad());
        }
        System.out.print("\n[+] Ingrese una opcion: ");
        int op = sc.nextInt();
        sc.nextLine();

        if (op < 1 || op > gestion.getMundial().getSedes().size()) {
            System.out.println("[!] Identificador invalido.");
            return;
        }

        Sede sede = gestion.getMundial().getSedes().get(op - 1);

        int totalPartidos = 0;
        int totalGoles = 0;

        System.out.println("\n================================================================");
        System.out.println("          ESTADISTICAS - " + sede.getCiudad().toUpperCase());
        System.out.println("================================================================");
        System.out.println("  Pais     : " + (sede.getPais() != null ? sede.getPais().getNombre() : "Sin asignar"));
        System.out.println("  Clima    : " + sede.getClima());
        System.out.println("  Estadios : " + sede.getEstadios().size());
        System.out.println("----------------------------------------------------------------\n");

        for (Estadio estadio : sede.getEstadios()) {
            int partidosEstadio = estadio.getPartido().size();
            totalPartidos += partidosEstadio;

            System.out.println("  Estadio: " + estadio.getNombre() + " (cap. " + estadio.getCapacidad() + ")");
            System.out.println("  Partidos jugados: " + partidosEstadio);

            for (Partido partido : estadio.getPartido()) {
                Participacion local = partido.getParticipacionLocal();
                Participacion visitante = partido.getParticipacionVisitante();
                int gl = local.cantidadGoles();
                int gv = visitante.cantidadGoles();
                totalGoles += gl + gv;

                System.out.printf("    - [%s] %-18s %d - %d %-18s%n",
                        partido.getFase().getNombre(),
                        local.getSeleccion().getPais().getNombre(),
                        gl, gv,
                        visitante.getSeleccion().getPais().getNombre());
            }
            System.out.println();
        }

        System.out.println("----------------------------------------------------------------");
        System.out.println("  Total partidos en la ciudad : " + totalPartidos);
        System.out.println("  Total goles en la ciudad    : " + totalGoles);
        System.out.println("================================================================\n");
    }
}
