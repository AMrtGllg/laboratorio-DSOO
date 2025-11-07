public class espadachin extends soldado {
    private int longitudEspada;

    public espadachin(String nombre, int vida, int ataque, int defensa, int velocidad, String actitud, int fila, int columna, int ejercito, int longitudEspada) {
        super(nombre, vida, ataque, defensa, velocidad, actitud, fila, columna, ejercito);
        this.longitudEspada = longitudEspada;
    }

    public int getLongitudEspada() { return longitudEspada; }
    public void setLongitudEspada(int longitudEspada) { this.longitudEspada = longitudEspada; }

    @Override
    public String toString() {
        return "[Espadachin] " + super.toString() + " LongEspada:" + longitudEspada;
    }
}
