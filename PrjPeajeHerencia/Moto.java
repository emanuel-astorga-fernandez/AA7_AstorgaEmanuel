
public class Moto extends Vehiculo {

    public static final double TARIFA = 75;

    public Moto(String placa, String marca,
                String modelo, int annio) {
        super(placa, marca, modelo, annio);
    }

    public double calcularMontoPeaje() {
        return TARIFA;
    }

    public String getTipo() {
        return "moto";
    }
}
