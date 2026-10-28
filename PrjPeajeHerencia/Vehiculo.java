
public abstract class Vehiculo {

    private String placa;
    private String marca;
    private String modelo;
    private int annio;

    public Vehiculo(String placa, String marca,
                    String modelo, int annio) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.annio = annio;
    }

    public abstract double calcularMontoPeaje();

    public abstract String getTipo();

    public String toString() {
        return "Placa= " + placa +
               "\nTipo= " + getTipo() +
               "\nMarca= " + marca +
               "\nModelo= " + modelo +
               "\nAño= " + annio;
    }
}
