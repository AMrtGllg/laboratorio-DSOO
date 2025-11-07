public class lancero extends soldado {
    private int longitudLanza;

    public lancero(String nombre, int vida, int ataque, int defensa, int velocidad, String actitud, int fila, int columna, int ejercito, int longitudLanza) {
        super(nombre, vida, ataque, defensa, velocidad, actitud, fila, columna, ejercito);
        this.longitudLanza = longitudLanza;
    }

    public int getLongitudLanza() { return longitudLanza; }
    public void setLongitudLanza(int longitudLanza) { this.longitudLanza = longitudLanza; }

    @Override
    public String toString() {
        return "[Lancero] " + super.toString() + " LongLanza:" + longitudLanza;
    }
}
