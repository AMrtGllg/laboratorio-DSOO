import java.util.*;

public class videojuego {
    public static void main(String[] args) {
        ejecutarLab08();
    }

    public static void ejecutarLab08(){
        Random rnd=new Random();
        Terreno terr = Terreno.values()[rnd.nextInt(Terreno.values().length)];
        Mapa mapa=new Mapa(8, terr);

        String reinoA = elegirReino(rnd);
        String reinoB = elegirReino(rnd);
        while(reinoB.equals(reinoA)) reinoB = elegirReino(rnd);

        EjercitoLista A=new EjercitoLista();
        EjercitoArreglo B=new EjercitoArreglo(20);

        generarEjercitoLista(A,"A",mapa,reinoA,rnd);
        generarEjercitoArreglo(B,"B",mapa,reinoB,rnd);

        aplicarBonus(A.getTropas(), mapa.getTerritorio());
        aplicarBonus(B.getTropas(), B.size(), mapa.getTerritorio());

        System.out.println("=== TABLERO ("+terr+")===");
        mapa.imprimir(A.getTropas(), B.getTropas(), B.size());

        System.out.println("\n=== DATOS A ("+reinoA+") ===");
        A.imprimirDatos();
        System.out.println("\n=== DATOS B ("+reinoB+") ===");
        B.imprimirDatos();

        System.out.println("\nMayor vida A: "+(A.mayorVida()!=null?A.mayorVida().detalleCompleto():"-"));
        System.out.println("Mayor vida B: "+(B.mayorVida()!=null?B.mayorVida().detalleCompleto():"-"));

        System.out.println("\nPromedio A: "+A.promedioVida());
        System.out.println("Promedio B: "+B.promedioVida());

        System.out.println("\n=== Orden creación A ===");
        A.imprimirOrdenCreacion();
        System.out.println("\n=== Orden creación B ===");
        B.imprimirOrdenCreacion();

        A.ordenarPorVidaDesc();
        B.ordenarPorVidaDesc();
        System.out.println("\n=== Ranking A ===");
        A.imprimirOrdenCreacion();
        System.out.println("\n=== Ranking B ===");
        B.imprimirOrdenCreacion();

        int vidaA=A.totalVida();
        int vidaB=B.totalVida();

        System.out.println("\n=== RESUMEN ===");
        System.out.println(resumenEjercito("Ejército A", reinoA, A.getTropas()));
        System.out.println(resumenEjercito("Ejército B", reinoB, B.getTropas(), B.size()));

        System.out.println("\n=== RESULTADO ===");
        System.out.println(Batalla.resumenGanador(reinoA, vidaA, reinoB, vidaB));
    }

    private static String elegirReino(Random rnd){
        int x=rnd.nextInt(5);
        if(x==0) return "Inglaterra";
        if(x==1) return "Francia";
        if(x==2) return "Castilla-Aragon";
        if(x==3) return "Moros";
        return "Sacro Imperio";
    }

    private static void aplicarBonus(ArrayList<soldado> lst, Terreno t){
        int i=0;
        while(i<lst.size()){
            lst.get(i).aplicarBonusReino(t);
            i=i+1;
        }
    }

    private static void aplicarBonus(soldado[] arr, int n, Terreno t){
        int i=0;
        while(i<n){
            arr[i].aplicarBonusReino(t);
            i=i+1;
        }
    }

    private static void generarEjercitoLista(EjercitoLista E,String p,Mapa mapa,String reino,Random rnd){
        int cant=1+rnd.nextInt(10);
        int creados=0;
        while(creados<cant){
            int t=rnd.nextInt(4);
            soldado s;
            if(t==0){
                espadachin e=new espadachin();
                e.setNombre("Espadachin"+p+creados);
                e.setReino(reino);
                e.setAtaque(10); e.setDefensa(8); e.setVida(8+rnd.nextInt(3));
                e.setLongitudEspada(80+rnd.nextInt(41));
                s=e;
            } else if(t==1){
                arquero a=new arquero();
                a.setNombre("Arquero"+p+creados);
                a.setReino(reino);
                a.setAtaque(7); a.setDefensa(3); a.setVida(3+rnd.nextInt(3));
                a.setNumeroFlechas(5+rnd.nextInt(11));
                s=a;
            } else if(t==2){
                caballero c=new caballero();
                c.setNombre("Caballero"+p+creados);
                c.setReino(reino);
                c.setAtaque(13); c.setDefensa(7); c.setVida(10+rnd.nextInt(3));
                c.setMontado(rnd.nextBoolean());
                c.setArma(c.isMontado()?"lanza":"espada");
                s=c;
            } else {
                lancero l=new lancero();
                l.setNombre("Lancero"+p+creados);
                l.setReino(reino);
                l.setAtaque(5); l.setDefensa(10); l.setVida(5+rnd.nextInt(4));
                l.setLongitudLanza(180+rnd.nextInt(41));
                s=l;
            }
            boolean ok=false;
            int intentos=0;
            while(!ok && intentos<200){
                int f=rnd.nextInt(mapa.size());
                int c=rnd.nextInt(mapa.size());
                ok=mapa.colocar(s,f,c);
                intentos=intentos+1;
            }
            if(ok){ E.agregar(s); creados=creados+1; } else { break; }
        }
    }

    private static void generarEjercitoArreglo(EjercitoArreglo E,String p,Mapa mapa,String reino,Random rnd){
        int cant=1+rnd.nextInt(10);
        int creados=0;
        while(creados<cant){
            int t=rnd.nextInt(4);
            soldado s;
            if(t==0){
                espadachin e=new espadachin();
                e.setNombre("Espadachin"+p+creados);
                e.setReino(reino);
                e.setAtaque(10); e.setDefensa(8); e.setVida(8+rnd.nextInt(3));
                e.setLongitudEspada(80+rnd.nextInt(41));
                s=e;
            } else if(t==1){
                arquero a=new arquero();
                a.setNombre("Arquero"+p+creados);
                a.setReino(reino);
                a.setAtaque(7); a.setDefensa(3); a.setVida(3+rnd.nextInt(3));
                a.setNumeroFlechas(5+rnd.nextInt(11));
                s=a;
            } else if(t==2){
                caballero c=new caballero();
                c.setNombre("Caballero"+p+creados);
                c.setReino(reino);
                c.setAtaque(13); c.setDefensa(7); c.setVida(10+rnd.nextInt(3));
                c.setMontado(rnd.nextBoolean());
                c.setArma(c.isMontado()?"lanza":"espada");
                s=c;
            } else {
                lancero l=new lancero();
                l.setNombre("Lancero"+p+creados);
                l.setReino(reino);
                l.setAtaque(5); l.setDefensa(10); l.setVida(5+rnd.nextInt(4));
                l.setLongitudLanza(180+rnd.nextInt(41));
                s=l;
            }
            boolean ok=false;
            int intentos=0;
            while(!ok && intentos<200){
                int f=rnd.nextInt(mapa.size());
                int c=rnd.nextInt(mapa.size());
                ok=mapa.colocar(s,f,c);
                intentos=intentos+1;
            }
            if(ok){ E.agregar(s); creados=creados+1; } else { break; }
        }
    }

    private static String resumenEjercito(String titulo, String reino, ArrayList<soldado> lst){
        int e=0,a=0,c=0,l=0,i=0, vida=0;
        while(i<lst.size()){
            soldado s=lst.get(i);
            vida=vida+s.getVida();
            if(s instanceof espadachin) e=e+1;
            else if(s instanceof arquero) a=a+1;
            else if(s instanceof caballero) c=c+1;
            else if(s instanceof lancero) l=l+1;
            i=i+1;
        }
        return titulo+" ["+reino+"] unidades="+lst.size()+" E="+e+" A="+a+" C="+c+" L="+l+" vidaTotal="+vida;
    }

    private static String resumenEjercito(String titulo, String reino, soldado[] arr, int n){
        int e=0,a=0,c=0,l=0,i=0, vida=0;
        while(i<n){
            soldado s=arr[i];
            vida=vida+s.getVida();
            if(s instanceof espadachin) e=e+1;
            else if(s instanceof arquero) a=a+1;
            else if(s instanceof caballero) c=c+1;
            else if(s instanceof lancero) l=l+1;
            i=i+1;
        }
        return titulo+" ["+reino+"] unidades="+n+" E="+e+" A="+a+" C="+c+" L="+l+" vidaTotal="+vida;
    }
}
