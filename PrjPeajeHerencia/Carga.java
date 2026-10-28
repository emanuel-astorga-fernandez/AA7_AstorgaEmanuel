
public class Carga extends Vehiculo {

    public static final double TARIFA = 500;

    public Carga(String placa, String marca,
                 String modelo, int annio) {
        super(placa, marca, modelo, annio);
    }

    public double calcularMontoPeaje() {
        return TARIFA;
    }

    public String getTipo() {
        return "carga";
    }
}
