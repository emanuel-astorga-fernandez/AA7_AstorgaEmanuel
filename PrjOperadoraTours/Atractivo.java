
public class Atractivo {

    private String codigo;
    private String nombre;
    private double precioEntrada;

    public Atractivo(String codigo, String nombre,
                    double precioEntrada) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.precioEntrada = precioEntrada;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public String toString() {
        return "Código: " + codigo +
               ", Nombre: " + nombre +
               ", Entrada: " + precioEntrada;
    }
}
