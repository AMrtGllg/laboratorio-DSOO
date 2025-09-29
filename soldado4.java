public class soldado4 {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int velocidad;
    private String actitud;
    private int fila;
    private int columna;
    private int ejercito;

    
    public soldado4(String nombre, int vida, int fila, int columna, int ejercito) {
        this.nombre = nombre;
        this.vida = vida;
        this.fila = fila;
        this.columna = columna;
        this.ejercito = ejercito;
        this.ataque = 1;
        this.defensa = 1;
        this.velocidad = 1;
        this.actitud = "defensiva";
    }


    public soldado4(String nombre, int vida, int ataque, int defensa, int velocidad, String actitud, int fila, int columna, int ejercito) {
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

    public soldado4(String nombre, int fila, int columna, int ejercito) {
        this.nombre = nombre;
        this.fila = fila;
        this.columna = columna;
        this.ejercito = ejercito;
        this.vida = 5;
        this.ataque = 2;
        this.defensa = 2;
        this.velocidad = 1;
        this.actitud = "defensiva";
    }

    public String getNombre() { return nombre; }

    public int getVida() { return vida; }
    public void setVida(int vida) { this.vida = vida; }

    public int getAtaque() { return ataque; }
    public void setAtaque(int ataque) { this.ataque = ataque; }

    public int getDefensa() { return defensa; }
    public void setDefensa(int defensa) { this.defensa = defensa; }

    public int getVelocidad() { return velocidad; }
    public void setVelocidad(int velocidad) { this.velocidad = velocidad; }

    public String getActitud() { return actitud; }
    public void setActitud(String actitud) { this.actitud = actitud; }

    public int getFila() { return fila; }
    public void setFila(int fila) { this.fila = fila; }

    public int getColumna() { return columna; }
    public void setColumna(int columna) { this.columna = columna; }

    public int getEjercito() { return ejercito; }
    public void setEjercito(int ejercito) { this.ejercito = ejercito; }


    public void atacar() {
        this.actitud = "ofensiva";
        this.velocidad += 1;
    }

    public void defender() {
        this.actitud = "defensiva";
        this.velocidad = 0;
    }

    public void huir() {
        this.actitud = "fuga";
        this.velocidad += 2;
    }

    public void retroceder() {
        if (this.velocidad > 0) {
            this.velocidad = 0;
            this.actitud = "defensiva";
        } else {
            this.velocidad -= 1;
        }
    }

    public void recibirAtaque(int daño) {
        this.vida -= daño;
        if (this.vida < 0) {
            this.vida = 0;
        }
    }

    @Override
    public String toString() {
        return "soldado4{" +
                "nombre='" + nombre + '\'' +
                ", vida=" + vida +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                ", velocidad=" + velocidad +
                ", actitud='" + actitud + '\'' +
                ", fila=" + fila +
                ", columna=" + columna +
                ", ejercito=" + ejercito +
                '}';
    }
}
