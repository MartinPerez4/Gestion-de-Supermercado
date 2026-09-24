import java.util.ArrayList;
import java.util.List;

public class Supermercado {
    private String nombreComercial;
    private String direccion;
    private String telefono;
    private List<Producto> listaProductos;
    private List<Cliente> listaClientes;
    private List<Compras> listaCompras;

    public Supermercado (String nombreComercial, String direccion, String telefono){
        this.nombreComercial = nombreComercial;
        this.direccion = direccion;
        this.telefono = telefono;
        listaProductos = new ArrayList<Producto>();
        listaClientes = new ArrayList<Cliente>();
        listaCompras = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Supermercado{" +
                "nombreComercial='" + nombreComercial + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", listaProductos=" + listaProductos +
                ", listaClientes=" + listaClientes +
                ", listaCompras=" + listaCompras +
                '}';
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

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Compras> getListaCompras() {
        return listaCompras;
    }

    public void setListaCompras(List<Compras> listaCompras) {
        this.listaCompras = listaCompras;
    }

    //Metodo verificar producto
    public boolean verificarProducto(String codigo){
        boolean existe=false;
        for(Producto producto:listaProductos){
            if(producto.getCodigo().equals(codigo)){
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
    //Metodo eliminar
    public boolean eliminarProducto(Producto producto) {
        boolean eliminado = false;
        boolean existe = verificarProducto(producto.getCodigo());
            if(existe==true) {
                listaProductos.remove(producto);
                eliminado = true;
            }
        return eliminado;
    }
    //Metodo para buscar producto
    public Producto buscarProducto(String codigo) {
        for (Producto producto : listaProductos){
            if(producto.getCodigo().equals(codigo)) {
                return producto;
            }
        }
        return null; //No existe
    }
    //Metodo verificar cliente
    public boolean verificarCliente(String documentoIdentidad){
        boolean existe=false;
        for(Cliente cliente:listaClientes){
            if(cliente.getDocumentoIdentidad().equals(documentoIdentidad)){
                existe=true;
                break;
            }
        }
        return existe;
    }
    //Metodo agregar cliente
    public boolean agregarCliente(Cliente cliente){
        boolean agregado = false;
        boolean existe = verificarCliente(cliente.getDocumentoIdentidad());
        if (existe==false){
            listaClientes.add(cliente);
            agregado = true;
        }
        return agregado;
    }
    //Metodo eliminar
    public boolean eliminarCliente(Cliente cliente) {
        boolean eliminado = false;
        boolean existe = verificarCliente(cliente.getDocumentoIdentidad());
        if(existe==true) {
            listaClientes.remove(cliente);
            eliminado = true;
        }
        return eliminado;
    }
    //Metodo para buscar cliente
    public Cliente buscarCliente(String documentoIdentidad) {
        for (Cliente cliente : listaClientes){
            if(cliente.getDocumentoIdentidad().equals(documentoIdentidad)) {
                return cliente;
            }
        }
        return null; //No existe
    }

    //Metodo verificar compra
    public boolean verificarCompra(String codigo){
        boolean existe=false;
        for(Compras compra:listaCompras){
            if(compra.getCodigo().equals(codigo)){
                existe=true;
                break;
            }
        }
        return existe;
    }

    //Metodo eliminar compra
    public boolean eliminarCompra(Compras compra) {
        boolean eliminado = false;
        boolean existe = verificarCompra(compra.getCodigo());
        if(existe==true) {
            listaCompras.remove(compra);
            eliminado = true;
        }
        return eliminado;
    }
    //Metodo para buscar compra
        public Compras buscarCompra(String codigo) {
        for (Compras compra : listaCompras){
            if(compra.getCodigo().equals(codigo)) {
                return compra;
            }
        }
        return null; //No existe
    }
}