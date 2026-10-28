
public class Particular extends Vehiculo {

    public static final double TARIFA = 100;

    public Particular(String placa, String marca,
                      String modelo, int annio) {
        super(placa, marca, modelo, annio);
    }

    public double calcularMontoPeaje() {
        return TARIFA;
    }

    public String getTipo() {
        return "particular";
    }
}
