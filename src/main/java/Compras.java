import java.time.LocalDate;

public class Compras {
    private String codigo;
    private LocalDate fechaDeRealizacion;
    private double valorTotal;

    public Compras (String codigo, LocalDate fechaDeRealizacion, double valorTotal){
        this.codigo = codigo;
        this.fechaDeRealizacion = fechaDeRealizacion;
        this.valorTotal = valorTotal;
    }
    private MetodoDePago metodoDePago;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaDeRealizacion() {
        return fechaDeRealizacion;
    }

    public void setFechaDeRealizacion(LocalDate fechaDeRealizacion) {
        this.fechaDeRealizacion = fechaDeRealizacion;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public MetodoDePago getMetodoDePago() {
        return metodoDePago;
    }

    public void setMetodoDePago(MetodoDePago metodoDePago) {
        this.metodoDePago = metodoDePago;
    }
}
