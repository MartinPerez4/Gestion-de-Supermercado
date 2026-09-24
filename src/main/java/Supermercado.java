import java.util.ArrayList;
import java.util.List;

public class Supermercado {
    private String nombreComercial;
    private String direccion;
    private String telefono;
    private List<Producto> listaProductos;

    public Supermercado (String nombreComercial, String direccion, String telefono){
        this.nombreComercial = nombreComercial;
        this.direccion = direccion;
        this.telefono = telefono;
        listaProductos = new ArrayList<Producto>();
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    //Metodo verificar producto
    public boolean verificarProducto(String codigo){
        boolean existe=false;
        for(Producto producto:listaProductos){
            if(producto.getCodigo()==codigo){
                existe=true;
                break;
            }
        }
        return existe;
    }
    //Metodo agregar producto
    public boolean agregarProducto(Producto producto){
        boolean agregado = false;
        boolean existe = verificarProducto(producto.getCodigo());
        if (existe==false){
            listaProductos.add(producto);
            agregado = true;
        }
        return agregado;
    }
    //Metodo para eliminar producto
    public List<Producto> eliminarProducto(String codigo) {
        //mostrar lista de productos temp
        System.out.println(listaProductos);
        for (Producto producto : listaProductos){
            if(producto.getCodigo() == codigo) {
                listaProductos.remove(producto);
            }
            else {
                System.out.println("Introdusca un codigo valido");
            }
        }
        return listaProductos;
    }
}