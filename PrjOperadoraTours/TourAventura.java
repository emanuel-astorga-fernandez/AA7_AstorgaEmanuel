
public class TourAventura extends Tour {

    public static final double RECARGO_SEGURO = 0.15;
    public static final String DIFICULTAD_PREDETERMINADA = "medio";

    private String dificultad;

    public TourAventura(String nombre, double precioBase,
                       int cupoMaximo, Guia guia, String dificultad) {

        super(nombre, precioBase, cupoMaximo, guia);
        this.dificultad = dificultad;
    }

    public TourAventura(String nombre, double precioBase,
                       int cupoMaximo, Guia guia) {

        this(nombre, precioBase, cupoMaximo,
             guia, DIFICULTAD_PREDETERMINADA);
    }

    public double calcularPrecioPorPersona() {
        return precioBase + (precioBase * RECARGO_SEGURO);
    }

    public String toString() {
        String s = super.toString();

        s += "Tipo: Aventura\n" +
             "Dificultad: " + dificultad + "\n";

        return s;
    }
}
