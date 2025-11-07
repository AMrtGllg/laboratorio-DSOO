public class espadachin extends soldado {
    private int longitudEspada;

    public void setLongitudEspada(int l){ this.longitudEspada=l; }
    public int getLongitudEspada(){ return this.longitudEspada; }

    public void muroEscudos(){ setDefensa(getDefensa()+2); }

    @Override
    public String detalleCompleto(){
        return super.detalleCompleto()+" longitudEspada="+longitudEspada;
    }
}
