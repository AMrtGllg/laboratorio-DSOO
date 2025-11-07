import java.util.*;

public class Mapa {
    private Terreno[][] celdas ;
    private boolean[][] ocupado ;
    private int n;
    private Terreno territorio;
    private Random rnd = new Random();

    public Mapa(int n, Terreno territorio) {
        this.n = n;
        this.territorio = territorio;
        celdas = new Terreno[n][n];
        ocupado = new boolean[n][n];
        int i=0;
        while(i<n){
            int j=0;
            while(j<n){
                celdas[i][j] = territorio;
                ocupado[i][j] = false;
                j=j+1;
            }
            i=i+1;
        }
    }

    public int size(){ return n; }
    public Terreno get(int f,int c){ return celdas[f][c]; }
    public Terreno getTerritorio(){ return territorio; }
    public boolean libre(int f,int c){
        if(f<0||c<0||f>=n||c>=n) return false;
        return !ocupado[f][c];
    }
    public boolean colocar(soldado s,int f,int c){
        if(!libre(f,c)) return false;
        s.setFila(f);
        s.setColumna(c);
        ocupado[f][c]=true;
        return true;
    }

    public void imprimir(java.util.ArrayList<soldado> A, soldado[] B, int tamB){
        String[][] g = new String[n][n];
        int i=0;
        while(i<n){
            int j=0;
            while(j<n){
                g[i][j]="__";
                j=j+1;
            }
            i=i+1;
        }
        i=0;
        while(i<A.size()){
            soldado s=A.get(i);
            String t="A";
            if(s instanceof espadachin) t="AE";
            else if(s instanceof arquero) t="AA";
            else if(s instanceof caballero) t="AC";
            else if(s instanceof lancero) t="AL";
            g[s.getFila()][s.getColumna()]=t+s.getVida ();
            i=i+1;
        }
        i=0;
        while(i<tamB){
            soldado s=B[i];
            String t="B";
            if(s instanceof espadachin) t="BE";
            else if(s instanceof arquero) t="BA";
            else if(s instanceof caballero) t="BC";
            else if(s instanceof lancero) t="BL";
            g[s.getFila()][s.getColumna()]=t+s.getVida ();
            i=i+1;
        }
        i=0;
        while(i<n){
            int j=0;
            while(j<n){
                System.out.print(String.format("%-5s", g[i][j]));
                j=j+1;
            }
            System.out.println();
            i=i+1;
        }
    }
}
