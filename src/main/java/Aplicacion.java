public class Aplicacion {
    static void main(){
        Supermercado Mp = new Supermercado("Marketplus","Direccion no se que", "324439123");
        int opcion = 0;
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
            switch(opcion){
                case 0:
                    //Cerrando programa
                    break;
                case 1:
                    //Agregar producto
                String codigo = "1";
                String nombreProducto = "Arroz";
                double precioUnitario = 2000;
                int cantidadDisponible = 10;
                CategoriaProducto categoria = CategoriaProducto.ALIMENTO;
                Producto prod = new Producto(codigo,nombreProducto,precioUnitario,cantidadDisponible,categoria);
                if(Mp.agregarProducto(prod)){
                    System.out.println("Producto agregado correctamente");
                }else{
                    System.out.println("Producto ya existente");
                }
                    break;
                case 2:
                    //Mostrar productos disponibles
                    System.out.println("Los " + Mp.getListaProductos().size() + " productos que hay son: ");
                    System.out.println(Mp.getListaProductos());
                    break;
                case 3:
                    //Actualizar productos disponibles
                    break;
                case 4:
                    //Eliminar un producto
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
        }while(option!=0);
    }
}
