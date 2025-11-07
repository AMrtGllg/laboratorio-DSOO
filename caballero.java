public class caballero extends soldado {
    private boolean montado;
    private String arma;

    public boolean isMontado(){ return montado; }
    public void setMontado(boolean m){ montado=m; }
    public String getArma(){ return arma; }
    public void setArma(String a){ arma=a; }

    public void montar(){ if(!montado){ montado=true; arma="lanza"; envestir(); } }
    public void desmontar(){ if(montado){ montado=false; arma="espada"; } }

    public void envestir(){
        if(montado){ System.out.println( getNombre()+" ataca 3 veces"); }
        else { System.out.println(getNombre()+" ataca 2 veces"); }
    }

    @Override
    public String detalleCompleto(){
        return super.detalleCompleto()+ " montado=" +montado+ " arma="+arma;
    }
}
