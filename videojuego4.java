import java.util.*;

public class videojuego4 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int tamañoTablero = 10;
        soldado4[][] tablero = new soldado4[tamañoTablero][tamañoTablero];
        ArrayList<soldado4> ejercito1 = new ArrayList<>();
        ArrayList<soldado4> ejercito2 = new ArrayList<>();

        int n1 = rnd.nextInt(10) + 1; 
        int n2 = rnd.nextInt(10) + 1;

        for (int i = 0; i < n1; i++) {
            int fila, columna;
            do {
                fila = rnd.nextInt(tamañoTablero);
                columna = rnd.nextInt(tamañoTablero);
            } while (tablero[fila][columna] != null);
            soldado4 s = new soldado4("E1-" + (i+1), rnd.nextInt(10)+5, rnd.nextInt(5)+1, rnd.nextInt(5)+1, rnd.nextInt(3)+1, "defensiva", fila, columna, 1);
            ejercito1.add(s);
            tablero[fila][columna] = s;
        }
        for (int i = 0; i < n2; i++) {
            int fila, columna;
            do {
                fila = rnd.nextInt(tamañoTablero);
                columna = rnd.nextInt(tamañoTablero);
            } while (tablero[fila][columna] != null);
            soldado4 s = new soldado4("E2-" + (i+1), rnd.nextInt(10)+5, rnd.nextInt(5)+1, rnd.nextInt(5)+1, rnd.nextInt(3)+1, "defensiva", fila, columna, 2);
            ejercito2.add(s);
            tablero[fila][columna] = s;
        }


        mostrarTablero(tablero);


        System.out.println("\nEjército 1:");
        for (soldado4 s : ejercito1) {
            System.out.println(s);
        }
        System.out.println("\nEjército 2:");
        for (soldado4 s : ejercito2) {
            System.out.println(s);
        }

        System.out.println("\nSoldado con más vida de Ejército 1: " + mayorVida(ejercito1));
        System.out.println("Soldado con más vida de Ejército 2: " + mayorVida(ejercito2));
        System.out.println("Promedio de vida Ejército 1: " + promedioVida(ejercito1));
        System.out.println("Promedio de vida Ejército 2: " + promedioVida(ejercito2));


        System.out.println("\nRanking de poder Ejército 1 (burbuja):");
        ArrayList<soldado4> ranking1 = new ArrayList<>(ejercito1);
        burbuja(ranking1);
        for (soldado4 s : ranking1) System.out.println(s);

        System.out.println("\nRanking de poder Ejército 2 (selección):");
        ArrayList<soldado4> ranking2 = new ArrayList<>(ejercito2);
        seleccion(ranking2);
        for (soldado4 s : ranking2) System.out.println(s);


        int vida1 = totalVida(ejercito1);
        int vida2 = totalVida(ejercito2);
        System.out.println("\nVida total Ejército 1: " + vida1);
        System.out.println("Vida total Ejército 2: " + vida2);
        if (vida1 > vida2) {
            System.out.println("\n¡Ejército 1 gana la batalla!");
        } else if (vida2 > vida1) {
            System.out.println("\n¡Ejército 2 gana la batalla!");
        } else {
            System.out.println("\n¡Empate!");
        }
    }


    public static void mostrarTablero(soldado4[][] tablero) {
        System.out.println("\nTABLERO:");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] == null) {
                    System.out.print(" . ");
                } else if (tablero[i][j].getEjercito() == 1) {
                    System.out.print(" 1 ");
                } else {
                    System.out.print(" 2 ");
                }
            }
            System.out.println();
        }
    }

    public static soldado4 mayorVida(ArrayList<soldado4> ejercito) {
        soldado4 mayor = ejercito.get(0);
        for (soldado4 s : ejercito) {
            if (s.getVida() > mayor.getVida()) {
                mayor = s;
            }
        }
        return mayor;
    }

    public static double promedioVida(ArrayList<soldado4> ejercito) {
        int suma = 0;
        for (soldado4 s : ejercito) suma += s.getVida();
        return (double) suma / ejercito.size();
    }

    public static int totalVida(ArrayList<soldado4> ejercito) {
        int suma = 0;
        for (soldado4 s : ejercito) suma += s.getVida();
        return suma;
    }


    public static void burbuja(ArrayList<soldado4> lista) {
        int n = lista.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (lista.get(j).getVida() < lista.get(j+1).getVida()) {
                    soldado4 temp = lista.get(j);
                    lista.set(j, lista.get(j+1));
                    lista.set(j+1, temp);
                }
            }
        }
    }


    public static void seleccion(ArrayList<soldado4> lista) {
        int n = lista.size();
        for (int i = 0; i < n-1; i++) {
            int maxIdx = i;
            for (int j = i+1; j < n; j++) {
                if (lista.get(j).getVida() > lista.get(maxIdx).getVida()) {
                    maxIdx = j;
                }
            }
            soldado4 temp = lista.get(i);
            lista.set(i, lista.get(maxIdx));
            lista.set(maxIdx, temp);
        }
    }
}

