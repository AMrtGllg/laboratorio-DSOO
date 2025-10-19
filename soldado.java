public class soldado {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int velocidad;
    private String actitud;
    private int fila;
    private int columna;
    private int ejercito;

    public soldado(String nombre, int vida, int ataque, int defensa, int velocidad, String actitud, int fila, int columna, int ejercito) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.actitud = actitud;
        this.fila = fila;
        this.columna = columna;
        this.ejercito = ejercito;
    }

    public soldado(String nombre, int fila, int columna, int ejercito) {
        this(nombre, 5, 2, 2, 0, "defensiva", fila, columna, ejercito);
    }

    public soldado() {
        this("", 5, 2, 2, 0, "defensiva", 0, 0, 0);
    }

    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public int getVelocidad() { return velocidad; }
    public String getActitud() { return actitud; }
    public int getFila() { return fila; }
    public int getColumna() { return columna; }
    public int getEjercito() { return ejercito; }

    public void setVida(int vida) { this.vida = vida; }
    public void setAtaque(int ataque) { this.ataque = ataque; }
    public void setDefensa(int defensa) { this.defensa = defensa; }
    public void setVelocidad(int velocidad) { this.velocidad = velocidad; }
    public void setActitud(String actitud) { this.actitud = actitud; }
    public void setFila(int fila) { this.fila = fila; }
    public void setColumna(int columna) { this.columna = columna; }

    public void mover(int nuevaFila, int nuevaColumna) {
        this.fila = nuevaFila;
        this.columna = nuevaColumna;
    }

    @Override
    public String toString() {
        return nombre + " Vida:" + vida + " Ataque:" + ataque + " Defensa:" + defensa + " Velocidad:" + velocidad + " Actitud:" + actitud + " Posicion:(" + fila + "," + columna + ")";
    }
}

