public class caballero extends soldado {
    private boolean montado;    
    private String arma;         

    public caballero(String nombre, int vida, int ataque, int defensa, int velocidad, String actitud, int fila, int columna, int ejercito) {
        super(nombre, vida, ataque, defensa, velocidad, actitud, fila, columna, ejercito);
        this.montado = true;
        this.arma = "lanza";
    }

    public boolean isMontado() { return montado; }
    public void setMontado(boolean montado) { this.montado = montado; }

    public String getArma() { return arma; }
    public void setArma(String arma) { this.arma = arma; }

    @Override
    public String toString() {
        return "[Caballero] " + super.toString() + " Montado:" + montado + " Arma:" + arma;
    }
}
