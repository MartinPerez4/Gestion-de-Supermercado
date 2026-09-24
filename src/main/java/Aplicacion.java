import javax.swing.*;

public class Aplicacion {
    static void main() {
        Supermercado Mp = new Supermercado("Marketplus", "Direccion 15", "324439123");
        int opcion;
        do {
            //Menu ou shit
            //
            //Menu administrador/supermercado
            //1. Agregar producto
            //2. Mostrar productos disponibles
            //3. Actualizar productos disponibles
            //4. Eliminar productos
            //
            //5. Registrar clientes
            //6. Mostrar clientes registrados
            //7. Actualizar clientes registrados
            //8. Eliminar clientes
            //
            //9. Mostrar todas las compras
            //10. Eliminar compra
            //
            //Menu cliente
            //11. Realizar compra
            //12. Mostrar historial de compras
            //13. Modificar compra
            //
            //0. Salir del programa

            //Switch case
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Menu administrador/supermercado\n" +
                    "1. Agregar producto\n" +
                    "2. Mostrar productos disponibles\n" +
                    "3. Actualizar productos disponibles\n" +
                    "4. Eliminar productos\n" +
                    "\n" +
                    "5. Registrar clientes\n" +
                    "6. Mostrar clientes registrados\n" +
                    "7. Actualizar clientes registrados\n" +
                    "8. Eliminar clientes\n" +
                    "\n" +
                    "9. Mostrar todas las compras\n" +
                    "10. Eliminar compra\n" +
                    "\n" +
                    "Menu cliente\n" +
                    "11. Realizar compra\n" +
                    "12. Mostrar historial de compras\n" +
                    "13. Modificar compra\n" +
                    "\n" +
                    "0. Salir del programa\n"));
            switch (opcion) {
                case 0:
                    //Cerrando programa
                    JOptionPane.showMessageDialog(null, "Saliendo de compras, gracias por usar.");
                    break;
                case 1:
                    //Agregar producto
                    String codigo = JOptionPane.showInputDialog("Introduzca el codigo del producto");
                    String nombreProducto = JOptionPane.showInputDialog("Introduzca el nombre del producto");
                    double precioUnitario = Double.parseDouble(JOptionPane.showInputDialog("Introduzca el precio del producto"));
                    int cantidadDisponible = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el cantidad del producto"));
                    String cate = JOptionPane.showInputDialog(
                            "Categoría (ALIMENTO, BEBIDA, ASEO, CUIDADO_PERSONAL):"
                    );
                    CategoriaProducto categoria;
                    try {
                        categoria = CategoriaProducto.valueOf(cate.trim().toUpperCase());
                    } catch (Exception e) {
                        categoria = CategoriaProducto.ALIMENTO;
                    }
                    Producto prod = new Producto(codigo, nombreProducto, precioUnitario, cantidadDisponible, categoria);
                    if (Mp.agregarProducto(prod)) {
                        JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "Producto ya existente");
                    }
                    break;
                case 2:
                    //Mostrar productos disponibles
                    JOptionPane.showMessageDialog(null, "Los " + Mp.getListaProductos().size() + " productos que hay son:\n" + Mp.getListaProductos());
                    break;
                case 3:
                    //Actualizar productos disponibles
                    String CodigoProductoAActualizar = JOptionPane.showInputDialog(null, "Lista de productos\n" +
                            Mp.getListaProductos() + "\n" +
                            "Ingrese el codigo correspondiente al producto que desea modificar: ");
                    Producto productoAActualizar = Mp.buscarProducto(CodigoProductoAActualizar);
                    if (productoAActualizar == null) {
                        JOptionPane.showMessageDialog(null, "Producto no encontrado");
                        break;
                    }
                    int atributo;
                    do {
                        atributo = Integer.parseInt(JOptionPane.showInputDialog("Menu actualizacion de producto\n" +
                                "0. Volver al menu\n" +
                                "\n" +
                                "1. Modificar codigo del producto\n" +
                                "2. Modificar nombre del producto\n" +
                                "3. Modificar precio unitario\n" +
                                "4. Modificar cantidad disponible\n" +
                                "5. Modificar categoria\n" +
                                "Ingrese a continuacion el codigo correspondiente al atributo que desea modificar: \n"));
                        if (atributo == 0) break;
                        String peticion = "Ingrese el nuevo valor";
                        if(atributo == 1){
                            peticion = "Ingrese el nuevo codigo del producto: ";
                        }else if(atributo == 2){
                            peticion = "Ingrese el nuevo nombre del producto: ";
                        }else if(atributo == 3){
                            peticion = "Ingrese el precio del producto: ";
                        }else if(atributo == 4){
                            peticion = "Ingrese el cantidad del producto: ";
                        }else if(atributo == 5){
                            peticion = "Ingrese el categoria del producto: ";
                        }
                        String nuevoValor = JOptionPane.showInputDialog(peticion);
                        if (nuevoValor == null) continue;
                        String msg = Mp.actualizarProducto(productoAActualizar, atributo, nuevoValor);
                        JOptionPane.showMessageDialog(null, msg);
                    } while (atributo != 0);
                        break;
                case 4:
                    //Eliminar un producto
                    String codigoProductoAEliminar = JOptionPane.showInputDialog(null, "Lista de productos\n" +
                            Mp.getListaProductos() + "\n" +
                            "Ingrese el codigo correspondiente al producto que desea eliminar: ");
                    Producto productoAEliminar = Mp.buscarProducto(codigoProductoAEliminar);
                    if (productoAEliminar != null) {
                        if (Mp.eliminarProducto(productoAEliminar)) {
                            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "Producto no eliminado correctamente");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Producto no encontrado");
                    }
                    break;
                case 5:
                    //Registrar cliente
                    String nombreCliente = JOptionPane.showInputDialog("Introduzca el nombre del cliente");
                    String documentoIdentidad = JOptionPane.showInputDialog("Introduzca el documento del cliente");
                    String telefono = JOptionPane.showInputDialog("Introduzca el telefono del cliente");
                    String email = JOptionPane.showInputDialog("Introduzca el email del cliente");
                    Cliente cli = new Cliente(nombreCliente, documentoIdentidad, telefono, email);
                    if (Mp.agregarCliente(cli)) {
                        JOptionPane.showMessageDialog(null, "Cliente registrado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null, "Este cliente ya esta registrado");
                    }
                    break;
                case 6:
                    //Mostrar clientes registrados
                    JOptionPane.showMessageDialog(null, "Los " + Mp.getListaClientes().size() + " clientes que estan registeados son:\n" + Mp.getListaClientes());
                    break;
                case 7:
                    //Actualizar cliente registrado
                    break;
                case 8:
                    //Eliminar un cliente
                    String documentoClienteAEliminar = JOptionPane.showInputDialog(null, "Lista de clientes\n" +
                            Mp.getListaClientes() + "\n" +
                            "Ingrese el documento de identidad correspondiente al cliente que desea eliminar: ");
                    Cliente clienteAEliminar = Mp.buscarCliente(documentoClienteAEliminar);
                    if (clienteAEliminar != null) {
                        if (Mp.eliminarCliente(clienteAEliminar)) {
                            JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "Cliente no eliminado correctamente");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente no encontrado");
                    }
                    break;
                case 9:
                    //Mostrar todas las compras
                    JOptionPane.showMessageDialog(null, "El historial de compras registradas en el supermercado son: \n" +
                            Mp.getListaCompras());
                    break;
                case 10:
                    //Eliminar una compra
                    String compraCodigoAEliminar = JOptionPane.showInputDialog(null, "Lista de compras\n" +
                            Mp.getListaCompras() + "\n" +
                            "Ingrese el codigo correspondiente a la compra que desea eliminar: ");
                    Compras compraAEliminar = Mp.buscarCompra(compraCodigoAEliminar);
                    if (compraAEliminar != null) {
                        if (Mp.eliminarCompra(compraAEliminar)) {
                            JOptionPane.showMessageDialog(null, "Compra eliminada correctamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "Compra no eliminada correctamente");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Compra no encontrada");
                    }
                    break;
                default:
                    break;
            }
            } while (opcion != 0) ;
        }
    }
