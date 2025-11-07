public class Batalla {
    public static String resumenGanador(String reinoA, int vidaA, String reinoB, int vidaB){
        if(vidaA==0 && vidaB==0) return "Empate (0% vs 0%)";
        double pa = (vidaA*1.0)/(vidaA+vidaB);
        double pb = (vidaB*1.0)/(vidaA+vidaB);
        String ga = reinoA+" "+String.format("%.0f%%", pa*100);
        String gb = reinoB+" "+String.format("%.0f%%", pb*100);
        if(vidaA>vidaB) return reinoA+" gana ("+vidaA+" vs "+vidaB+") "+ga+" vs "+gb;
        if(vidaB>vidaA) return reinoB+" gana ("+vidaB+" vs "+vidaA+") "+gb+" vs "+ga;
        return "Empate ("+vidaA+" vs "+vidaB+") "+ga+" vs "+gb;
    }
}
