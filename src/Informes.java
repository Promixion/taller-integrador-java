import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Informes {
    public static void tablaPosicionesGrupo(Mundial mundial, Scanner sc) {

    if (mundial.getGrupos().isEmpty()) {
        System.out.println("[!] No hay grupos configurados.");
        return;
    }

    int id = 0;
    System.out.println("\n[+] Seleccione el grupo:\n");
    for (Grupo grupo : mundial.getGrupos()) {
        System.out.println((++id) + ". Grupo " + grupo.getIdentificacion());
    }
    System.out.print("\n[+] Ingrese una opcion: ");
    int op = sc.nextInt();
    sc.nextLine();

    if (op < 1 || op > mundial.getGrupos().size()) {
        System.out.println("[!] Identificador invalido.");
        return;
    }

    Grupo grupoElegido = mundial.getGrupos().get(op - 1);

    if (grupoElegido.getFase() == null) {
        System.out.println("[!] El grupo no tiene una fase asignada.");
        return;
    }

    System.out.println("\n========== TABLA DE POSICIONES - GRUPO " + grupoElegido.getIdentificacion() + " ==========\n");
    System.out.printf("%-20s %4s %4s %4s %4s %4s %4s %4s%n","Seleccion", "PJ", "G", "E", "P", "GF", "GC", "PTS");
    System.out.println("--------------------------------------------------------------");

    ArrayList<int[]> stats = new ArrayList<>();
    ArrayList<Seleccion> selecciones = grupoElegido.getSeleccion();

    for (int i = 0; i < selecciones.size(); i++) {
        Seleccion seleccion = selecciones.get(i);
        int pj = 0, g = 0, e = 0, p = 0, gf = 0, gc = 0;

        for (Partido partido : grupoElegido.getFase().getPartidos()) {
            Participacion partLocal = partido.getParticipacionLocal();
            Participacion partVisitante = partido.getParticipacionVisitante();

            boolean esLocal = partLocal.getSeleccion().equals(seleccion);
            boolean esVisitante = partVisitante.getSeleccion().equals(seleccion);

            if (!esLocal && !esVisitante) continue;

            pj++;
            int golesLocal = partLocal.cantidadGoles();
            int golesVisitante = partVisitante.cantidadGoles();
            gf += esLocal ? golesLocal : golesVisitante;
            gc += esLocal ? golesVisitante : golesLocal;

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
        stats.add(new int[]{i, pj, g, e, p, gf, gc, pts});
    }

    for (int i = 0; i < stats.size() - 1; i++) {
        for (int j = 0; j < stats.size() - 1 - i; j++) {
            if (stats.get(j)[7] < stats.get(j + 1)[7]) {
                int[] temp = stats.get(j);
                stats.set(j, stats.get(j + 1));
                stats.set(j + 1, temp);
            }
        }
    }

    for (int[] row : stats) {
        Seleccion s = selecciones.get(row[0]);
        System.out.printf("%-20s %4d %4d %4d %4d %4d %4d %4d%n",
                s.getPais().getNombre(),
                row[1], row[2], row[3], row[4], row[5], row[6], row[7]);
    }

        System.out.println("--------------------------------------------------------------");
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

    public static void informeDisciplinario(Mundial mundial, Scanner sc) {

        if (mundial.getSelecciones().isEmpty()) {
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
            informeDisciplinarioSeleccion(mundial, sc);
        } else if (op == 2) {
            informeDisciplinarioJugador(mundial, sc);
        } else {
            System.out.println("[!] Opcion invalida.");
        }
    }

public static void rankingGoleadores(Mundial mundial) {

        if (mundial.getSelecciones().isEmpty()) {
            System.out.println("[!] No hay selecciones registradas.");
            return;
        }

        ArrayList<Jugador> jugadores = new ArrayList<>();
        ArrayList<Integer> goles = new ArrayList<>();
        ArrayList<String> paises = new ArrayList<>();

        for (Seleccion seleccion : mundial.getSelecciones()) {
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
    public static void informeDisciplinarioJugador(Mundial mundial, Scanner sc) {

        int id = 0;
        System.out.println("\n[+] Seleccione la seleccion del jugador:\n");
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
                for (Partido partido : mundial.getPartidos()) {
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
    public static void fichaTecnicaPartido(Mundial mundial, Scanner sc) {

        if (mundial.getPartidos().isEmpty()) {
            System.out.println("[!] No hay partidos registrados.");
            return;
        }

        int id = 0;
        System.out.println("\n[+] Seleccione el partido:\n");
        for (Partido partido : mundial.getPartidos()) {
            System.out.println((++id) + ". " + partido);
        }
        System.out.print("\n[+] Ingrese una opcion: ");
        int op = sc.nextInt();
        sc.nextLine();

        if (op < 1 || op > mundial.getPartidos().size()) {
            System.out.println("[!] Identificador invalido.");
            return;
        }

        Partido partido = mundial.getPartidos().get(op - 1);
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
                for (Seleccion seleccion : mundial.getSelecciones()) {
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
    public static void estadisticasSedes(Mundial mundial, Scanner sc) {

        if (mundial.getSedes().isEmpty()) {
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
            estadisticasPorEstadio(mundial, sc);
        } else if (op == 2) {
            estadisticasPorCiudad(mundial, sc);
        } else {
            System.out.println("[!] Opcion invalida.");
        }
    }

    public static void estadisticasPorEstadio(Mundial mundial, Scanner sc) {

        ArrayList<Estadio> estadios = new ArrayList<>();
        for (Sede sede : mundial.getSedes()) {
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

    public static void estadisticasPorCiudad(Mundial mundial, Scanner sc) {

        int id = 0;
        System.out.println("\n[+] Seleccione la ciudad:\n");
        for (Sede sede : mundial.getSedes()) {
            System.out.println((++id) + ". " + sede.getCiudad());
        }
        System.out.print("\n[+] Ingrese una opcion: ");
        int op = sc.nextInt();
        sc.nextLine();

        if (op < 1 || op > mundial.getSedes().size()) {
            System.out.println("[!] Identificador invalido.");
            return;
        }

        Sede sede = mundial.getSedes().get(op - 1);

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
