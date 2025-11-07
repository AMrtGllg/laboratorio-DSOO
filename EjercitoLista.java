import java.util.*;

public class EjercitoLista {
    private ArrayList<soldado> tropas = new ArrayList<soldado>();

    public void agregar(soldado s){ tropas.add(s); }
    public ArrayList<soldado> getTropas(){ return tropas; }

    public soldado mayorVida(){
        if(tropas.size()==0) return null;
        soldado m=tropas.get(0);
        int i=1;
        while(i<tropas.size()){
            if(tropas.get(i).getVida ()>m.getVida()) m=tropas.get(i);
            i=i+1;
        }
        return m;
    }

    public double promedioVida(){
        if(tropas.size()==0) return 0;
        int s=0,i=0;
        while(i<tropas.size()){ s=s+tropas.get(i).getVida(); i=i+1; }
        return (s*1.0)/tropas.size();
    }

    public int totalVida(){
        int s=0,i=0;
        while(i<tropas.size()){ s=s+tropas.get(i).getVida(); i=i+1; }
        return s;
    }

    public void ordenarPorVidaDesc(){
        int n=tropas.size();
        int i=0;
        while(i<n-1){
            int j=0;
            while(j<n-1-i){
                if(tropas.get(j).getVida()<tropas.get(j+1).getVida()){
                    soldado x=tropas.get(j);
                    tropas.set(j,tropas.get(j+1));
                    tropas.set(j+1,x);
                }
                j=j+1;
            }
            i=i+1;
        }
    }

    public void imprimirOrdenCreacion(){
        int i=0;
        while(i<tropas.size()){
            soldado s=tropas.get(i);
            System.out.println((i+1)+". "+s.getNombre()+" ("+s.getClass().getSimpleName()+") vida="+s.getVida());
            i=i+1;
        }
    }

    public void imprimirDatos(){
        int i=0;
        while(i<tropas.size()){
            System.out.println(tropas.get(i).detalleCompleto());
            i=i+1;
        }
    }
}
