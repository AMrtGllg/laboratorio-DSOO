import java.util.*;

public class videojuego {
    private static Random rnd = new Random();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final int tamaño = 10;
        soldado[][] tablero = new soldado[tamaño][tamaño];
        List<soldado> ejercito1 = new ArrayList<>();
        List<soldado> ejercito2 = new ArrayList<>();

        int n1 = rnd.nextInt(10) + 1;
        int n2 = rnd.nextInt(10) + 1;

        inicializarEjercito(ejercito1, tablero, 1, n1);
        inicializarEjercito(ejercito2, tablero, 2, n2);

        mostrarTablero(tablero);

        System.out.println("Soldado con más vida en Ejército 1: " + soldadoMayorVida(ejercito1));
        System.out.println("Soldado con más vida en Ejército 2: " + soldadoMayorVida(ejercito2));
        System.out.printf("Promedio vida Ejército 1: %.2f\n", promedioVida(ejercito1));
        System.out.printf("Promedio vida Ejército 2: %.2f\n", promedioVida(ejercito2));

        mostrarRanking("Burbuja", ejercito1, ejercito2, true);
        mostrarRanking("Selección", ejercito1, ejercito2, false);

        int vidaEjercito1 = sumVida(ejercito1);
        int vidaEjercito2 = sumVida(ejercito2);
        System.out.println("Vida total Ejército 1: " + vidaEjercito1);
        System.out.println("Vida total Ejército 2: " + vidaEjercito2);
        System.out.println("El ejército que ganará será: " + (vidaEjercito1 > vidaEjercito2 ? "Ejército 1" : "Ejército 2"));

        int turno = 1;
        while (!ejercito1.isEmpty() && !ejercito2.isEmpty()) {
            System.out.println("Turno del Ejército " + turno);
            moverSoldado(tablero, turno == 1 ? ejercito1 : ejercito2, turno == 1 ? ejercito2 : ejercito1, turno);
            mostrarTablero(tablero);
            if (turno == 1) turno = 2; else turno = 1;
        }

        if (ejercito1.isEmpty()) System.out.println("¡Gana Ejército 2!");
        else System.out.println("¡Gana Ejército 1!");
    }

    private static void inicializarEjercito(List<soldado> ejercito, soldado[][] tablero, int idEjercito, int n) {
        int tamaño = tablero.length;
        for (int i = 0; i < n; i++) {
            int fila, col;
            do {
                fila = rnd.nextInt(tamaño);
                col = rnd.nextInt(tamaño);
            } while (tablero[fila][col] != null);
            int vida = rnd.nextInt(5) + 1;
            int ataque = rnd.nextInt(5) + 1;
            int defensa = rnd.nextInt(5) + 1;
            soldado s = new soldado("Soldado" + i + "X" + idEjercito, vida, ataque, defensa, 0, "defensiva", fila, col, idEjercito);
            ejercito.add(s);
            tablero[fila][col] = s;
        }
    }

    private static void mostrarTablero(soldado[][] tablero) {
        System.out.println("\nTABLERO:");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] == null) System.out.print(" . ");
                else if (tablero[i][j].getEjercito() == 1) System.out.print(" 1 ");
                else System.out.print(" 2 ");
            }
            System.out.println();
        }
    }

    private static soldado soldadoMayorVida(List<soldado> ejercito) {
        return Collections.max(ejercito, Comparator.comparingInt(s -> s.getVida()));
    }

    private static double promedioVida(List<soldado> ejercito) {
        int suma = 0;
        for (soldado s : ejercito) suma += s.getVida();
        return ejercito.isEmpty() ? 0 : (double) suma / ejercito.size();
    }

    private static void mostrarRanking(String metodo, List<soldado> ejercito1, List<soldado> ejercito2, boolean esBurbuja) {
        System.out.println("\nRanking por vida (" + metodo + "):");

        List<soldado> ranking1 = new ArrayList<>(ejercito1);
        List<soldado> ranking2 = new ArrayList<>(ejercito2);

        if (esBurbuja) {
            ordenarBurbuja(ranking1);
            ordenarBurbuja(ranking2);
        } else {
            ordenarSeleccion(ranking1);
            ordenarSeleccion(ranking2);
        }

        System.out.println("Ejército 1:");
        for (soldado s : ranking1) System.out.println(s);
        System.out.println("Ejército 2:");
        for (soldado s : ranking2) System.out.println(s);
    }

    private static void ordenarBurbuja(List<soldado> lista) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (lista.get(j).getVida() < lista.get(j + 1).getVida()) {
                    Collections.swap(lista, j, j + 1);
                }
            }
        }
    }

    private static void ordenarSeleccion(List<soldado> lista) {
        int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (lista.get(j).getVida() > lista.get(maxIdx).getVida()) {
                    maxIdx = j;
                }
            }
            Collections.swap(lista, i, maxIdx);
        }
    }

    private static int sumVida(List<soldado> ejercito) {
        int suma = 0;
        for (soldado s : ejercito) suma += s.getVida();
        return suma;
    }

    private static void moverSoldado(soldado[][] tablero, List<soldado> propio, List<soldado> enemigo, int idEjercito) {
        int filaOrigen, colOrigen, dir;
        while(true) {
            System.out.print("Ingrese fila del soldado a mover: ");
            filaOrigen = sc.nextInt();
            System.out.print("Ingrese columna del soldado a mover: ");
            colOrigen = sc.nextInt();
            if (filaOrigen < 0 || filaOrigen >= tablero.length || colOrigen < 0 || colOrigen >= tablero.length) {
                System.out.println("Posición fuera del tablero, intente de nuevo.");
                continue;
            }
            soldado s = tablero[filaOrigen][colOrigen];
            if (s == null || s.getEjercito() != idEjercito) {
                System.out.println("No hay soldado propio en esa posición, intente de nuevo.");
                continue;
            }
            break;
        }
        int filaDestino = filaOrigen;
        int colDestino = colOrigen;
        while(true) {
            System.out.print("Ingrese dirección de movimiento (1=arriba, 2=abajo, 3=izquierda, 4=derecha): ");
            dir = sc.nextInt();
            switch(dir) {
                case 1: filaDestino--; break;
                case 2: filaDestino++; break;
                case 3: colDestino--; break;
                case 4: colDestino++; break;
                default: System.out.println("Dirección inválida, intente de nuevo."); continue;
            }
            if (filaDestino < 0 || filaDestino >= tablero.length || colDestino < 0 || colDestino >= tablero.length) {
                System.out.println("Movimiento fuera del tablero, intente de nuevo.");
                filaDestino = filaOrigen;
                colDestino = colOrigen;
                continue;
            }
            if (tablero[filaDestino][colDestino] != null && tablero[filaDestino][colDestino].getEjercito() == idEjercito) {
                System.out.println("Ya hay un soldado propio en la casilla destino, intente de nuevo.");
                filaDestino = filaOrigen;
                colDestino = colOrigen;
                continue;
            }
            break;
        }
        soldado mover = tablero[filaOrigen][colOrigen];
        if (tablero[filaDestino][colDestino] == null) {
            tablero[filaDestino][colDestino] = mover;
            tablero[filaOrigen][colOrigen] = null;
            mover.mover(filaDestino, colDestino);
            System.out.println("Movimiento realizado sin combate.");
        } else {
            soldado enemigoSoldado = tablero[filaDestino][colDestino];
            int vidaMover = mover.getVida();
            int vidaEnemigo = enemigoSoldado.getVida();
            double probMover = (double) vidaMover / (vidaMover + vidaEnemigo);
            double probEnemigo = (double) vidaEnemigo / (vidaMover + vidaEnemigo);
            double azar = rnd.nextDouble();

            System.out.printf("Batalla: %s (vida %d) VS %s (vida %d)\n", mover.getNombre(), vidaMover, enemigoSoldado.getNombre(), vidaEnemigo);
            System.out.printf("Probabilidades: %s %.2f%%, %s %.2f%%\n", mover.getNombre(), probMover*100, enemigoSoldado.getNombre(), probEnemigo*100);

            if (azar <= probMover) {
                mover.setVida(vidaMover + 1);
                tablero[filaDestino][colDestino] = mover;
                tablero[filaOrigen][colOrigen] = null;
                mover.mover(filaDestino, colDestino);
                enemigo.remove(enemigoSoldado);
                System.out.printf("Gana %s porque su probabilidad era mayor.\n", mover.getNombre());
            } else {
                propio.remove(mover);
                tablero[filaOrigen][colOrigen] = null;
                System.out.printf("Gana %s porque su probabilidad era mayor.\n", enemigoSoldado.getNombre());
            }
        }
    }
}
