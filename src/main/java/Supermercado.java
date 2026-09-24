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
    public List<String> getListaProductosCodigo() {
        List<String> listaProductoCodigo = new ArrayList<>();
        for (Producto p : listaProductos) {
            listaProductoCodigo.add("nombre: " + p.getNombre() + " / código: " + p.getCodigo());
        }
        return listaProductoCodigo;
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
    //Metodo para actualizar producto
    public String actualizarProducto(Producto productoAActualizar, int atributo, String nuevoValor){
            switch (atributo) {
                case 0:
                    //Volver al menu principal
                    return "Volviendo al menu principal.";
                case 1:
                    //Modificar codigo
                    if (productoAActualizar.getCodigo().equals(nuevoValor)) {
                        return "Este codigo es el mismo que ya esta";
                    } else if (verificarProducto(nuevoValor)) {
                        return "Codigo de producto ya existente";
                    } else {
                        productoAActualizar.setCodigo(nuevoValor);
                        return "Producto actualizado correctamente";
                    }
                case 2:
                    //Modificar nombre
                    if (productoAActualizar.getNombre().equals(nuevoValor)) {
                        return "Este nombre es el mismo que ya esta";
                    } else {
                        productoAActualizar.setNombre(nuevoValor);
                        return "Producto actualizado correctamente";
                    }
                case 3:
                    //Precio unitario
                    double nuevoValorDouble = 0;
                    try {
                        nuevoValorDouble = Double.parseDouble(nuevoValor);
                    } catch (NumberFormatException e) {
                        return "Precio invalido, debe ser un numero";
                    }
                    if (productoAActualizar.getPrecioUnitario() == nuevoValorDouble) {
                        return "Este precio es el mismo que ya esta";
                    } else {
                        productoAActualizar.setPrecioUnitario(nuevoValorDouble);
                        return "Producto actualizado correctamente";
                    }
                case 4:
                    //Cantidad disponible
                    int nuevoValorEntero = 0;
                    try {
                        nuevoValorEntero = Integer.parseInt(nuevoValor);
                    } catch (NumberFormatException e) {
                        return "Cantidad invalida, debe ser un numero";
                    }
                    if (productoAActualizar.getCantidadDisponible() == nuevoValorEntero) {
                        return "Esta cantidad es la misma que ya esta";
                    } else {
                        productoAActualizar.setCantidadDisponible(nuevoValorEntero);
                        return "Producto actualizado correctamente";
                    }
                case 5:
                    //Categoria producto
                    CategoriaProducto categoriaNueva;
                    try {
                        categoriaNueva = CategoriaProducto.valueOf(nuevoValor.trim().toUpperCase());
                    } catch (Exception e) {
                        categoriaNueva = CategoriaProducto.ALIMENTO;
                        productoAActualizar.setCategoriaProducto(categoriaNueva);
                        return "Categoria no encontrada, se le asignara la categoria por defecto";
                    }
                    if (productoAActualizar.getCategoriaProducto().equals(categoriaNueva)) {
                        return "Esta categoria es la misma que ya esta";
                    } else {
                        productoAActualizar.setCategoriaProducto(categoriaNueva);
                        return "Producto actualizado correctamente";
                    }
                default:
                    return "El valor del atributo incorrecto";
            }
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