import javax.swing.*;

public class Aplicacion {
    static void main(){
        Supermercado Mp = new Supermercado("Marketplus","Direccion no se que", "324439123");
        int opcion;
        do{
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
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"\n" +
                    "Menu administrador/supermercado\n" +
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
                    "0. Salir del programa"));
            switch(opcion){
                case 0:
                    //Cerrando programa
                    break;
                case 1:
                    //Agregar producto
                String codigo = JOptionPane.showInputDialog("Introduzca el codigo del producto");
                String nombreProducto = JOptionPane.showInputDialog("Introduzca el nombre del producto");
                double precioUnitario =  Double.parseDouble(JOptionPane.showInputDialog("Introduzca el precio del producto"));
                int cantidadDisponible =  Integer.parseInt(JOptionPane.showInputDialog("Introduzca el cantidad del producto"));
                CategoriaProducto categoria = CategoriaProducto.ALIMENTO;
                Producto prod = new Producto(codigo,nombreProducto,precioUnitario,cantidadDisponible,categoria);
                if(Mp.agregarProducto(prod)){
                    JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
                }else{
                    JOptionPane.showMessageDialog(null, "Producto ya existente");
                }
                    break;
                case 2:
                    //Mostrar productos disponibles
                    JOptionPane.showMessageDialog(null, "Los " + Mp.getListaProductos().size() + " productos que hay son:\n"+Mp.getListaProductos());
                    break;
                case 3:
                    //Actualizar productos disponibles
                    break;
                case 4:
                    //Eliminar un producto
                    String codigoProductoAEliminar = JOptionPane.showInputDialog(null,"Lista de productos\n" +
                            Mp.getListaProductos() + "\n" +
                            "Ingrese el codigo correspondiente al producto que desea eliminar: ");
                    Producto productoAEliminar = Mp.eliminarProducto(codigoProductoAEliminar);
                    break;
                case 5:
                    //Registrar cliente
                String nombreCliente = "Maria";
                String documentoIdentidad = "12";
                String telefono = "32312";
                String email = "m@gmail.com";
                Cliente cli = new Cliente(nombreCliente,documentoIdentidad,telefono,email);

                    break;
                case 6:
                    //Mostrar clientes registrados
                    break;
                case 7:
                    //Actualizar cliente registrado
                    break;
                case 8:
                    //Eliminar cliente
                    break;
                case 9:
                    //Mostrar todas las compras
                    break;
                case 10:
                    //Eliminar una compra
                    break;
                default:
                    break;
                }
        }while(opcion!=0);
    }
}
