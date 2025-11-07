public class arquero extends soldado {
    private int numeroFlechas;

    public arquero(String nombre, int vida, int ataque, int defensa, int velocidad, String actitud, int fila, int columna, int ejercito, int numeroFlechas) {
        super(nombre, vida, ataque, defensa, velocidad, actitud, fila, columna, ejercito);
        this.numeroFlechas = numeroFlechas;
    }

    public int getNumeroFlechas() { return numeroFlechas; }
    public void setNumeroFlechas(int numeroFlechas) { this.numeroFlechas = numeroFlechas; }

    @Override
    public String toString() {
        return "[Arquero] " + super.toString() + " Flechas:" + numeroFlechas;
    }
}
