
public class Cliente {

    private String nombre;
    private String condicion;

    public Cliente(String nombre, String condicion) {
        this.nombre = nombre;
        this.condicion = condicion;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean esNacional() {
        return condicion.equalsIgnoreCase("nacional");
    }

    public String toString() {
        return "Cliente: " + nombre +
               ", Condición: " + condicion;
    }
}
