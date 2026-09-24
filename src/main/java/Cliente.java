import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String documentoIdentidad;
    private String telefono;
    private String email;

    private List<Compras> listaCompras;

    public Cliente (String nombre, String documentoIdentidad, String telefono, String email){
        this.nombre = nombre;
        this.documentoIdentidad = documentoIdentidad;
        this.telefono = telefono;
        this.email = email;

        listaCompras = new ArrayList<Compras>();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", documentoIdentidad='" + documentoIdentidad + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", listaCompras=" + listaCompras +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Compras> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Compras> listaCompras) {
        this.listaCompras = listaCompras;
    }
}
