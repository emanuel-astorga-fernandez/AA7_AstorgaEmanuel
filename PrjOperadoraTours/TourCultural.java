
public class TourCultural extends Tour {

    private String idioma;

    public TourCultural(String nombre, double precioBase,
                       int cupoMaximo, Guia guia, String idioma) {

        super(nombre, precioBase, cupoMaximo, guia);
        this.idioma = idioma;
    }

    public double calcularPrecioPorPersona() {
        return precioBase + sumarEntradas();
    }

    public String toString() {
        String s = super.toString();

        s += "Tipo: Cultural\n" +
             "Idioma: " + idioma + "\n";

        return s;
    }
}
