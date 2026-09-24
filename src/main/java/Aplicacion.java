import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
            String entradaMenu =JOptionPane.showInputDialog(null, "Menu administrador/supermercado\n" +
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
                    "0. Salir del programa\n");
            if (entradaMenu == null) {
                JOptionPane.showMessageDialog(null, "Saliendo, gracias por usar.");
                break;
            }
            try {
                opcion = Integer.parseInt(entradaMenu);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opcion invalida");
                opcion = -1;
            }
            switch (opcion) {
                case 0:
                    //Cerrando programa
                    JOptionPane.showMessageDialog(null, "Saliendo de compras, gracias por usar.");
                    break;
                case 1:
                    //Agregar producto
                    String codigo = JOptionPane.showInputDialog("Introduzca el codigo del producto: ");
                    String nombreProducto = JOptionPane.showInputDialog("Introduzca el nombre del producto");
                    //Introducir Precio unitario
                    double precioUnitario;
                    while (true) {
                        try {
                            precioUnitario = Double.parseDouble(JOptionPane.showInputDialog("Introduzca el precio del producto"));
                            break;
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Precio invalido, intentelo de nuevo.");
                        }
                    }
                    //Introducir Cantidad Disponible
                    int cantidadDisponible;
                    while (true) {
                        try {
                            cantidadDisponible = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el cantidad del producto"));
                            break;
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Cantidad invalida, intentelo de nuevo.");
                        }
                    }
                    //Introducir categoria
                    String cate = "";
                    CategoriaProducto categoria;
                    while(true) {
                        cate = JOptionPane.showInputDialog("Introduzca la Categoría:\n- Alimento\n- Bebida\n- Aseo\n- Cuidado_personal");
                        if (cate == null) {
                            JOptionPane.showMessageDialog(null, "Cerrando programa, gracias por usar.");
                        }
                        try {
                            categoria = CategoriaProducto.valueOf(cate.trim().toUpperCase());
                            break;
                        } catch (IllegalArgumentException e) {
                            JOptionPane.showMessageDialog(null, "'" + cate + "' no es una categoría válida. Intente de nuevo.");
                        }
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
                    JOptionPane.showMessageDialog(null, "Los " + Mp.getListaProductos().size() + " productos que hay son:\n" +
                            Mp.getListaProductos().toString().replace(", ", "\n").replace("[", "").replace("]", ""));
                    break;
                case 3:
                    //Actualizar productos disponibles
                    String CodigoProductoAActualizar = JOptionPane.showInputDialog(null, "Lista de productos\n" +
                            Mp.getListaProductos().toString().replace(", ", "\n").replace("[", "").replace("]", "") + "\n" +
                            "Ingrese el codigo correspondiente al producto que desea modificar: ");
                    Producto productoAActualizar = Mp.buscarProducto(CodigoProductoAActualizar);
                    if (productoAActualizar == null) {
                        JOptionPane.showMessageDialog(null, "Producto no encontrado");
                        break;
                    }
                    int atributo;
                    do {
                        String entradaAtributo = JOptionPane.showInputDialog("Menu actualizacion de producto\n" +
                                "0. Volver al menu\n" +
                                "\n" +
                                "1. Modificar codigo del producto\n" +
                                "2. Modificar nombre del producto\n" +
                                "3. Modificar precio unitario\n" +
                                "4. Modificar cantidad disponible\n" +
                                "5. Modificar categoria\n" +
                                "Ingrese a continuacion el codigo correspondiente al atributo que desea modificar: \n");
                        if (entradaAtributo == null) break;
                        try {
                            atributo = Integer.parseInt(entradaAtributo);
                        }catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Opcion de atributo invalido, intente de nuevo.");
                            atributo = -1;
                        }
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
                    String codigoProductoAEliminar = JOptionPane.showInputDialog(null, "Lista de productos:\n" +
                            String.join("\n", Mp.getListaProductosCodigo()) + "\n" +
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

                    String telefono;
                    while (true) {
                        telefono = JOptionPane.showInputDialog("Introduzca el telefono del cliente");
                        if (telefono == null) break;
                        try {
                            Integer.parseInt(telefono);
                            break;
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Ingrese un numero de telefono valido.");
                        }
                    }

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
                    JOptionPane.showMessageDialog(null, "Los " + Mp.getListaClientes().size() + " clientes que estan registrados son:\n" +
                            Mp.getListaClientes().toString().replace(", ", "\n").replace("[", "").replace("]", ""));
                    break;
                case 7:
                    //Actualizar cliente registrado
                    String documentoClienteAModificar = JOptionPane.showInputDialog(null, "Lista de clientes\n" +
                            Mp.getListaClientes().toString().replace(", ", "\n").replace("[", "").replace("]", "") + "\n" +
                            "Ingrese el documento de identidad correspondiente al cliente que desea modificar: ");
                    Cliente clienteAModificar = Mp.buscarCliente(documentoClienteAModificar);
                    if (clienteAModificar == null) {JOptionPane.showMessageDialog(null, "Cliente no encontrado"); break;}
                    int atributo2;
                    do {
                        String entradaCambio = JOptionPane.showInputDialog("Menu actualizacion de cliente\n" +
                                "0. Volver al menu\n" +
                                "\n" +
                                "1. Modificar nombre del cliente\n" +
                                "2. Modificar telefono del cliente\n" +
                                "3. Modificar email del cliente\n" +
                                "No puede cambiar el documento del cliente.\n" +
                                "Ingrese a continuacion el numero correspondiente al dato que desea modificar: \n");
                        if (entradaCambio == null) break;
                        try {
                            atributo2 = Integer.parseInt(entradaCambio);
                        }catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Opcion de dato invalido, intente de nuevo.");
                            atributo2 = -1;
                        }
                        if (atributo2 == 0) break;
                        String peticion1 = "Ingrese el nuevo valor";
                        if(atributo2 == 1){
                            peticion1 = "Ingrese el nombre del cliente: ";
                        }else if(atributo2 == 2){
                            peticion1 = "Ingrese el telefono del cliente: ";
                        }else if(atributo2 == 3){
                            peticion1 = "Ingrese el nuevo email del cliente: ";
                        }
                        String nuevoValor = JOptionPane.showInputDialog(peticion1);
                        if (nuevoValor == null) continue;
                        String msg = Mp.actualizarCliente(clienteAModificar, atributo2, nuevoValor);
                        JOptionPane.showMessageDialog(null, msg);
                    } while (atributo2!= 0);
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
                            Mp.getListaCompras().toString().replace(", ", "\n").replace("[", "").replace("]", ""));
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
                case 11:
                    //Realiza una compra
                    String documentoComprador =  JOptionPane.showInputDialog("Introduzca su documento de identidad para realizar la compra: ");
                    if (documentoComprador == null) break;
                    Cliente comprador = Mp.buscarCliente(documentoComprador);
                    if (comprador == null) { JOptionPane.showMessageDialog(null, "Cliente no encontrado"); ; break;
                    }
                    //Realizar compra
                    String codigoCompra = "" + (int) (Math.random() * 10) + (int) (Math.random() * 10);
                    double valorTotal = 0;
                    Compras compra = new Compras(codigoCompra, LocalDate.now(),valorTotal);
                    String codigoProducto = "1";
                    do {
                        codigoProducto = JOptionPane.showInputDialog("Catalogo de productos disponibles en nuestro supermercado:\n" +
                                "Continue sin ingresar nada para continuar.\n" +
                                Mp.getListaProductos() + "\n" +
                                "Introduza el codigo correspondiente al producto que quiere: \n");
                        if (codigoProducto == null || codigoProducto.equals("".trim())) {
                            break;
                        }
                        Producto productoElegido = Mp.buscarProducto(codigoProducto);
                        if(productoElegido == null) { JOptionPane.showMessageDialog(null, "Producto no encontrado"); ; break;}
                        int cantidadProducto = 0;
                        try {
                            cantidadProducto = Integer.parseInt(JOptionPane.showInputDialog("Introduzca la cantidad que quiere comprar de este producto, en este momento hay disponibles: " + productoElegido.getCantidadDisponible()));
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Cantidad invalida.");
                            break;
                        } catch (HeadlessException e) {
                            JOptionPane.showMessageDialog(null, "Cantidad invalida.");
                            break;
                        }
                        if(cantidadProducto>0&&productoElegido.getCantidadDisponible()>=cantidadProducto) {
                            productoElegido.setCantidadDisponible(productoElegido.getCantidadDisponible() - cantidadProducto);
                        }else{
                                JOptionPane.showMessageDialog(null,"La cantidad a comprar es mayor a la disponible.");
                                break;
                        }
                        compra.getListaDetalles().add(new DetalleCompra(productoElegido, cantidadProducto));
                        valorTotal += productoElegido.getPrecioUnitario() * cantidadProducto;
                    }while(true);
                    if(compra.getListaDetalles().size()==0) {
                        JOptionPane.showMessageDialog(null,"Compra vacia, ha sido cancelada.");
                        break;
                    }
                    String metodo = JOptionPane.showInputDialog("Introduzca el metodo de pago (Tarjeta, transferencia, o efectivo): ");
                    MetodoDePago metodoDePago = null;
                    try {
                        metodoDePago = MetodoDePago.valueOf(metodo.trim().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        JOptionPane.showMessageDialog(null, "Metodo de pago invalido");
                        break;
                    }
                    compra.setMetodoDePago(metodoDePago);
                    compra.setValorTotal(valorTotal);
                    Mp.agregarCompra(compra);
                    comprador.agregarCompra(compra);
                    JOptionPane.showMessageDialog(null,"Su compra ha sido generada.\n" +
                            "Codigo de compra: " + codigoCompra + "\n" +
                            "Fecha de realizacion: " + LocalDate.now() + "\n" +
                            "Metodo de pago seleccionado: " +  metodoDePago + "\n" +
                            "Productos seleccionados: " + "\n" +
                            compra.getListaDetalles() + "\n" +
                    "Valor total de la compra: " + valorTotal );
                    break;
                case 12:
                    //Mostrar historial de compras
                    String documentoCliente =  JOptionPane.showInputDialog("Introduzca su documento de identidad para mostrar el historial de compras: ");
                    if (documentoCliente == null) break;
                    Cliente cliente = Mp.buscarCliente(documentoCliente);
                    if (cliente == null) { JOptionPane.showMessageDialog(null, "Cliente no encontrado"); ; break;
                    }
                    JOptionPane.showMessageDialog(null,"Este es el historial de compras de el cliente " + cliente.getNombre() + ":\n" +
                            cliente.getListaCompras().toString().replace(", ", "\n").replace("[", "").replace("]", ""));
                    break;
                case 13:
                    //Modificar compra
                    String documentoClienteAModificarCompra =  JOptionPane.showInputDialog("Introduzca su documento de identidad para modificar una de sus compras: ");
                    if (documentoClienteAModificarCompra == null) break;
                    Cliente clienteAModificarCompra = Mp.buscarCliente(documentoClienteAModificarCompra);
                    String codigoCompraAModificar =  JOptionPane.showInputDialog("Introduzca el codigo de la compra que desea modificar: \n" +
                            clienteAModificarCompra.getListaCompras());
                    Compras compraAModificar = clienteAModificarCompra.buscarCompra(codigoCompraAModificar);
                    if (documentoClienteAModificarCompra == null) break;
                    if (clienteAModificarCompra == null || compraAModificar == null) {
                        JOptionPane.showMessageDialog(null, "Cliente o compra no encontrada");}
                    int atributo1;
                    do{
                        String entradaCambio = JOptionPane.showInputDialog("Lo unico que usted puede cambiar de su compra es el metodo de pago.\n" +
                                "Desea cambiarlo? \n" +
                                "1. Si\n" +
                                "2. No\n");
                        if (entradaCambio == null) break;

                        try {
                            atributo1 = Integer.parseInt(entradaCambio);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Opcion invalida");
                            atributo1 = -1;
                        }

                        switch (atributo1) {
                            case 1:
                                String nuevoMetodoDePago = JOptionPane.showInputDialog("Introduzca el nuevo metodo de pago: (Tarjeta, efectivo o transferencia.)");
                                MetodoDePago nuevoMetodo =  MetodoDePago.valueOf(nuevoMetodoDePago.trim().toUpperCase());
                                compraAModificar.setMetodoDePago(nuevoMetodo);
                                break;
                            case 2:
                                break;
                            default:
                                break;
                        }
                    }while (atributo1 != 1 && atributo1 != 2);
                    break;

                default:
                    break;
            }
            } while (opcion != 0) ;
        }
    }
