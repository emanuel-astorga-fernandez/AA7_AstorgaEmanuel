
public class CargaLiviana extends Vehiculo {

    public static final double TARIFA = 200;

    public CargaLiviana(String placa, String marca,
                        String modelo, int annio) {
        super(placa, marca, modelo, annio);
    }

    public double calcularMontoPeaje() {
        return TARIFA;
    }

    public String getTipo() {
        return "carga liviana";
    }
}
