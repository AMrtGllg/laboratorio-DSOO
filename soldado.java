public class soldado {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int fila;
    private int columna;
    private String reino;

    public String getNombre(){ return nombre; }
    public void setNombre(String n){ nombre=n; }
    public int getVida(){ return vida; }
    public void setVida(int v){ vida=v; }
    public int getAtaque(){ return ataque; }
    public void setAtaque(int a){ ataque=a; }
    public int getDefensa(){ return defensa; }
    public void setDefensa(int d){ defensa=d; }
    public int getFila(){ return fila; }
    public void setFila(int f){ fila=f; }
    public int getColumna(){ return columna; }
    public void setColumna(int c){ columna=c; }
    public String getReino(){ return reino; }
    public void setReino(String r){ reino=r; }

    public void aplicarBonusReino(Terreno t){
        if(reino==null) return;
        if(reino.equals("Inglaterra") && t==Terreno.BOSQUE) setVida(getVida()+1);
        if(reino.equals("Francia") && t==Terreno.CAMPO_ABIERTO) setVida(getVida()+1);
        if(reino.equals("Castilla-Aragon") && t==Terreno.MONTAÑA) setVida(getVida()+1);
        if(reino.equals("Moros") && t==Terreno.DESIERTO) setVida(getVida()+1);
        if(reino.equals("Sacro Imperio") && (t==Terreno.BOSQUE || t==Terreno.PLAYA || t==Terreno.CAMPO_ABIERTO)) setVida(getVida()+1);
    }

    public String detalleCompleto(){
        return getClass().getSimpleName()+" nombre="+nombre+" reino="+reino+" vida="+vida+" ataque="+ataque+" defensa="+defensa+" fila="+fila+" col="+columna;
    }
}
