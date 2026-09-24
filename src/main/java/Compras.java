import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Compras {
    private String codigo;
    private LocalDate fechaDeRealizacion;
    private double valorTotal;

    private List<DetalleCompra> listaDetalles;

    public Compras (String codigo, LocalDate fechaDeRealizacion, double valorTotal){
        this.codigo = codigo;
        this.fechaDeRealizacion = fechaDeRealizacion;
        this.valorTotal = valorTotal;

        listaDetalles = new ArrayList<>();
    }

    @Override
    public String toString() {
        String texto = codigo + " | " + fechaDeRealizacion
                + " | Pago: " + metodoDePago
                + " | Total: $" + valorTotal;
        for (DetalleCompra detalle : listaDetalles) {
            texto += "\n    - " + detalle;
        }
        return texto;
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

    public List<DetalleCompra> getListaDetalles() {
        return listaDetalles;
    }

    public void setListaDetalles(List<DetalleCompra> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }
}
