public class arquero extends soldado {
    private int numeroFlechas;

    public void setNumeroFlechas(int n){ this.numeroFlechas=n; }
    public int getNumeroFlechas(){ return this.numeroFlechas; }

    public void disparar(){
        if(numeroFlechas> 0){ numeroFlechas=numeroFlechas-1; } else { System.out.println(getNombre()+" sin flechas"); }
    }

    @Override
    public String detalleCompleto(){
        return super.detalleCompleto()+" flechas="+numeroFlechas;
    }
}
