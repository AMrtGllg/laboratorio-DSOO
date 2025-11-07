public class EjercitoArreglo {
    private soldado[] tropas;
    private int n = 0;

    public EjercitoArreglo(int capacidad){ tropas = new soldado[capacidad]; }
    public void agregar(soldado s){ if(n<tropas.length){ tropas[n]=s; n=n+1; } }
    public soldado[] getTropas(){ return tropas; }
    public int size(){ return n; }

    public soldado mayorVida(){
        if(n==0) return null;
        soldado m=tropas[0];
        int i=1;
        while(i<n){
            if(tropas[i].getVida()>m.getVida()) m=tropas[i];
            i=i+1;
        }
        return m;
    }

    public double promedioVida(){
        if(n==0) return 0;
        int s=0,i=0;
        while(i<n){ s=s+tropas[i].getVida (); i=i+1; }
        return (s*1.0)/n;
    }

    public int totalVida(){
        int s=0,i=0;
        while(i<n){ s=s+tropas[i].getVida(); i=i+1; }
        return s;
    }

    public void ordenarPorVidaDesc(){
        int i=0;
        while(i<n-1){
            int j=0;
            while(j<n-1-i){
                if(tropas[j].getVida()<tropas[j+1].getVida()){
                    soldado x=tropas[j]; tropas[j]=tropas[j+1]; tropas[j+1]=x;
                }
                j=j+1;
            }
            i=i+1;
        }
    }

    public void imprimirOrdenCreacion(){
        int i=0;
        while(i<n){
            soldado s=tropas[i];
            System.out.println((i+1)+". "+s.getNombre()+" ("+s.getClass().getSimpleName()+") vida="+s.getVida());
            i=i+1;
        }
    }

    public void imprimirDatos(){
        int i=0;
        while(i<n){
            System.out.println(tropas[i].detalleCompleto());
            i=i+1;
        }
    }
}
