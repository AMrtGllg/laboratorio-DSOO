public class accionesEspeciales {

    public static void muroEscudos(espadachin e) {
        e.setDefensa(e.getDefensa() + 2);
        System.out.println(e.getNombre() + " activa Muro de Escudos: defensa ahora " + e.getDefensa());
    }

    public static void dispararFlecha(arquero a) {
        if (a.getNumeroFlechas() > 0) {
            a.setNumeroFlechas(a.getNumeroFlechas() - 1);
            System.out.println(a.getNombre() + " dispara una flecha. Flechas restantes: " + a.getNumeroFlechas());
        } else {
            System.out.println(a.getNombre () + " no tiene flechas.");
        }
    }

    public static void montar(caballero c) {
        if (!c.isMontado()) {
            c.setMontado(true);
            c.setArma("lanza");
            System.out.println(c.getNombre() + " monta y toma la lanza.");
        } else {
            System.out.println(c.getNombre() + " ya está montado.");
        }
    }

    public static void desmontar(caballero c) {
        if (c.isMontado()) {
            c.setMontado(false);
            c.setArma("espada");
            System.out.println(c.getNombre() + " desmonta y toma la espada.");
        } else {
            System.out.println(c.getNombre() + " ya está desmontado.");
        }
    }

    public static int envestir(caballero c) {
        int golpes = c.isMontado() ? 3 : 2;
        System.out.println(c.getNombre() + " envestir: " + golpes + " golpes (" + (c.isMontado() ? "montado" : "desmontado") + ").");
        return golpes;
    }

    public static void schiltrom(lancero l) {
        l.setDefensa(l.getDefensa() + 1);
        System.out.println(l.getNombre() + " forma falange: defensa ahora " + l.getDefensa());
    }
}