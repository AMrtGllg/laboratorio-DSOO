public class soldado {
    private String nombre;    
    private int vida;         
    private int fila;         
    private int columna;      
    private int ejercito;     

    public soldado(String nombre, int vida, int fila, int columna, int ejercito) {
        this.nombre = nombre;
        this.vida = vida;
        this.fila = fila;
        this.columna = columna;
        this.ejercito = ejercito;
    }

    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public int getFila() { return fila; }
    public int getColumna() { return columna; }
    public int getEjercito() { return ejercito; }
    public void setVida(int vida) { this.vida = vida; }

    public String toString() {
        return nombre + " (Vida: " + vida + ", Pos: " + fila + "," + columna + ", Ejercito: " + ejercito + ")";
    }
}
