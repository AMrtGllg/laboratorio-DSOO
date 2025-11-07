public class lancero extends soldado {
    private int longitudLanza;

    public void setLongitudLanza(int l){ this.longitudLanza=l; }
    public int getLongitudLanza(){ return this.longitudLanza; }

    public void schiltrom(){ setDefensa(getDefensa()+1); }

    @Override
    public String detalleCompleto(){
        return super.detalleCompleto()+" longitudLanza="+longitudLanza;
    }
}
