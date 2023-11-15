public class Carro {
    private String modelo;
    private String color;
    private boolean pinturaMetalizada;
    private String placa;
    private String tipoCarro;
    private int añoFabricacion;
    private String modalidadSeguro;

    public Carro(String modelo, String color, boolean pinturaMetalizada, String placa, String tipoCarro, int añoFabricacion, String modalidadSeguro) {
        this.modelo = modelo;
        this.color = color;
        this.pinturaMetalizada = pinturaMetalizada;
        this.placa = placa;
        this.tipoCarro = tipoCarro;
        this.añoFabricacion = añoFabricacion;
        this.modalidadSeguro = modalidadSeguro;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isPinturaMetalizada() {
        return pinturaMetalizada;
    }

    public void setPinturaMetalizada(boolean pinturaMetalizada) {
        this.pinturaMetalizada = pinturaMetalizada;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipoCarro() {
        return tipoCarro;
    }

    public void setTipoCarro(String tipoCarro) {
        this.tipoCarro = tipoCarro;
    }

    public int getAñoFabricacion() {
        return añoFabricacion;
    }

    public void setAñoFabricacion(int añoFabricacion) {
        this.añoFabricacion = añoFabricacion;
    }

    public String getModalidadSeguro() {
        return modalidadSeguro;
    }

    public void setModalidadSeguro(String modalidadSeguro) {
        this.modalidadSeguro = modalidadSeguro;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", pinturaMetalizada=" + pinturaMetalizada +
                ", placa='" + placa + '\'' +
                ", tipoCarro='" + tipoCarro + '\'' +
                ", añoFabricacion=" + añoFabricacion +
                ", modalidadSeguro='" + modalidadSeguro + '\'' +
                '}';
    }
}
