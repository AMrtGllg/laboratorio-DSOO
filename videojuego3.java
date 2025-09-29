import java.util.*;

public class videojuego3 {
    public static void main(String[] args) {
        int tamañoTablero = 10;

        ArrayList<ArrayList<soldado>> tablero = new ArrayList<>();
        for (int i = 0; i < tamañoTablero; i++) {
            ArrayList<soldado> fila = new ArrayList<>();
            for (int j = 0; j < tamañoTablero; j++) {
                fila.add(null);
            }
            tablero.add(fila);
        }

        ArrayList<soldado> ejercito1 = crearEjercito(1, tablero);
        ArrayList<soldado> ejercito2 = crearEjercito(2, tablero);

        mostrarTablero(tablero);

        mostrarSoldados(ejercito1);
        mostrarSoldados(ejercito2);

        System.out.println("\nEjército 1:");
        System.out.println("Soldado con más vida: " + soldadoConMasVida(ejercito1));
        System.out.println("Promedio de vida: " + promedioVida(ejercito1));

        System.out.println("\nEjército 2:");
        System.out.println("Soldado con más vida: " + soldadoConMasVida(ejercito2));
        System.out.println("Promedio de vida: " + promedioVida(ejercito2));
    }

    public static ArrayList<soldado> crearEjercito(int numEjercito, ArrayList<ArrayList<soldado>> tablero) {
        Random rnd = new Random();
        ArrayList<soldado> ejercito = new ArrayList<>();
        int n = rnd.nextInt(10) + 1;

        for (int i = 1; i <= n; i++) {
            int fila, columna;

            do {
                fila = rnd.nextInt(10);
                columna = rnd.nextInt(10);
            } while (tablero.get(fila).get(columna) != null);

            soldado s = new soldado("S" + numEjercito + "-" + i, rnd.nextInt(5) + 1, fila, columna, numEjercito);

            ejercito.add(s);
            tablero.get(fila).set(columna, s);
        }

        return ejercito;
    }

    public static void mostrarTablero(ArrayList<ArrayList<soldado>> tablero) {
        System.out.println("TABLERO:");
        for (ArrayList<soldado> fila : tablero) {
            for (soldado s : fila) {
                if (s == null) {
                    System.out.print("[ ] ");
                } else {
                    System.out.print("[" + s.getEjercito() + "] ");
                }
            }
            System.out.println();
        }
    }

    public static soldado soldadoConMasVida(ArrayList<soldado> ejercito) {
        soldado mayor = ejercito.get(0);
        for (soldado s : ejercito) {
            if (s.getVida() > mayor.getVida()) {
                mayor = s;
            }
        }
        return mayor;
    }

    public static double promedioVida(ArrayList<soldado> ejercito) {
        int suma = 0;
        for (soldado s : ejercito) {
            suma += s.getVida();
        }
        return (double) suma / ejercito.size();
    }

    public static void mostrarSoldados(ArrayList<soldado> ejercito) {
        System.out.println("Soldados del ejército:");
        for (soldado s : ejercito) {
            System.out.println(s);
        }
    }
}
