
import java.util.ArrayList;

public abstract class Tour {

    public static final String PREFIJO = "TOUR-";
    public static final double DESCUENTO_NACIONAL = 0.20;

    private static int cantidadTours = 0;

    private String codigo;
    private String nombre;
    protected double precioBase;
    private int cupoMaximo;
    private Guia guia;
    private ArrayList<Atractivo> atractivos;
    private ArrayList<Reserva> reservas;

    public Tour(String nombre, double precioBase,
                int cupoMaximo, Guia guia) {

        cantidadTours++;
        codigo = PREFIJO + cantidadTours;

        this.nombre = nombre;
        this.precioBase = precioBase;
        this.cupoMaximo = cupoMaximo;
        this.guia = guia;

        atractivos = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public static int getCantidadTours() {
        return cantidadTours;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String consultarNombreGuia() {
        return guia.getNombreCompleto();
    }

    public void cambiarGuia(Guia nuevaGuia) {
        guia = nuevaGuia;
    }

    public void agregarAtractivo(Atractivo atractivo) {
        if (!atractivos.contains(atractivo)) {
            atractivos.add(atractivo);
        }
    }

    public String consultarNombresAtractivos() {
        String nombres = "";

        for (Atractivo a : atractivos) {
            if (!nombres.isEmpty()) {
                nombres += ", ";
            }

            nombres += a.getNombre();
        }

        return nombres;
    }

    protected double sumarEntradas() {
        double total = 0;

        for (Atractivo a : atractivos) {
            total += a.getPrecioEntrada();
        }

        return total;
    }

    public abstract double calcularPrecioPorPersona();

    public void registrarReserva(Cliente cliente) {
        registrarReserva(cliente, 1);
    }

    public void registrarReserva(Cliente cliente, int cantidad) {

        if (cantidad <= 0 || cantidad > getCuposDisponibles()) {
            return;
        }

        double monto = calcularMontoReserva(cliente, cantidad);

        Reserva nueva = new Reserva(
            reservas.size() + 1,
            cliente.getNombre(),
            cantidad,
            monto
        );

        reservas.add(nueva);
    }

    private double calcularMontoReserva(Cliente cliente,
                                       int cantidad) {

        double monto = calcularPrecioPorPersona() * cantidad;

        if (cliente.esNacional()) {
            monto = monto * (1 - DESCUENTO_NACIONAL);
        }

        return monto;
    }

    public int getCuposDisponibles() {
        int ocupados = 0;

        for (Reserva r : reservas) {
            ocupados += r.getCantidad();
        }

        return cupoMaximo - ocupados;
    }

    public final double calcularIngresoTotal() {
        double total = 0;

        for (Reserva r : reservas) {
            total += r.getMonto();
        }

        return total;
    }

    public String toString() {
        String s = "Código: " + codigo +
            "\nNombre: " + nombre +
            "\nGuía: " + consultarNombreGuia() +
            "\nPrecio base: " + precioBase +
            "\nPrecio por persona: " + calcularPrecioPorPersona() +
            "\nCupo máximo: " + cupoMaximo +
            "\nCupos disponibles: " + getCuposDisponibles() +
            "\nAtractivos: " + consultarNombresAtractivos() +
            "\nReservas:\n";

        for (Reserva r : reservas) {
            s += r.toString() + "\n";
        }

        s += "Ingreso total: " + calcularIngresoTotal() + "\n";

        return s;
    }

    private static class Reserva {

        private int numero;
        private String nombreCliente;
        private int cantidad;
        private double monto;

        private Reserva(int numero, String nombreCliente,
                        int cantidad, double monto) {

            this.numero = numero;
            this.nombreCliente = nombreCliente;
            this.cantidad = cantidad;
            this.monto = monto;
        }

        private int getCantidad() {
            return cantidad;
        }

        private double getMonto() {
            return monto;
        }

        public String toString() {
            return "Reserva " + numero +
                   ": " + nombreCliente +
                   ", personas: " + cantidad +
                   ", monto: " + monto;
        }
    }
}
