package ui;

import negocio.TiendaDeRegalosService;


import java.util.Scanner;
import java.util.InputMismatchException;

public class Menu {
    private TiendaDeRegalosService tiendaService;
    String idProducto, nombre, descripcion;
    String familia;
    double precio;
    String marca, modelo, color;
    String voltaje;
    int garantia, capacidad;
    String autor, editorial, genero;
    int anioPublicacion, numeroPaginas;

    public Menu() {
        //ProductoDAO productoDAO = new ProductoDAO(100); // Capacidad del inventario
        //this.tiendaService = new TiendaDeRegalosService(productoDAO);
        this.tiendaService = new TiendaDeRegalosService(100,"datos/archivos");
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;    

        do {
            mostrarMenu();

            //colocar un bloque try-catch

            
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea
        
            /*
            Esta línea captura una excepción de tipo InputMismatchException.
             Esta excepción se lanza cuando se intenta leer un tipo de entrada 
             que no coincide con el tipo esperado, por ejemplo, 
             si se espera un número entero pero se ingresa una cadena 
             de texto.
            */
            {
                System.out.println("\t***Error: Debe ingresar un número entero.***");
                scanner.nextLine(); // Consumir la nueva línea
                continue;
            }
           
            switch (opcion) {
                case 1:
                    tiendaService.presentarse();
                    break;
                case 2:
                    mostrarFamiliaProducto(scanner);
                    break;
                case 3:{
                   agregarProducto(scanner);
                    break;
                }
                case 4:
                    eliminarProducto(scanner);
                    break;
                case 5:
                    listarProductos();
                    break;
                case 6:
                    venderProducto(scanner);
                    break;
                case 7:
                    actualizarPrecio(scanner);
                    break;
                case 8:
                    aplicarDescuento(scanner);
                    break;
                case 9:
                    calcularValorTotalProductos();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0);

        scanner.close();
    }
    private void mostrarMenu() {
        System.out.println("\n--- Menú de Tienda de Regalos ---");
        System.out.println("1. Presentarse");
        System.out.println("2. Mostrar Familia de Producto");
        System.out.println("3. Agregar Producto");
        System.out.println("4. Eliminar Producto");
        System.out.println("5. Listar Productos");
        System.out.println("6. Vender Producto");
        System.out.println("7. Actualizar Precio");
        System.out.println("8. Aplicar Descuento");
        System.out.println("9. Calcular valor total de productos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
    
    private void mostrarFamiliaProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre de la familia de producto: ");
        String familia = scanner.nextLine();
        tiendaService.mostrarFamiliaProducto(familia);
    }

    private void captura_productos(Scanner scanner){
        //Datos comunes del producto
        boolean datosValidos = false;
          
        try {
            System.out.print("Ingrese el Id del producto: ");
            idProducto = scanner.nextLine();
            System.out.print("Ingrese el nombre del producto: ");
            nombre = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Error al capturar los datos del producto: " + e.getMessage());
        }
        
        while (!datosValidos){
            try{
                System.out.print("Ingrese el precio del producto: ");
                precio = scanner.nextDouble();
                scanner.nextLine(); // Consumir la nueva línea
                System.out.print("Ingrese la descripcion del producto: ");
                descripcion = scanner.nextLine();
                datosValidos = true;
            }
            catch(InputMismatchException e){
                System.out.println("\t***Error: el precio debe ser un número.***");
                scanner.nextLine(); // Consumir la nueva línea
            
            }
        }
    }
    
    private void captura_electrodomestico(Scanner scanner){
        boolean datosValidos = false;

        try {
            System.out.print("Ingrese la marca del producto: ");
            marca = scanner.nextLine();
            System.out.print("Ingrese el modelo del producto: ");
            modelo = scanner.nextLine();
            System.out.print("Ingrese el color del producto: ");
            color = scanner.nextLine();

            while (!datosValidos) {
                try {
                    System.out.print("Ingrese la garantia del producto (en meses): ");
                    garantia = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    System.out.print("Ingrese el voltaje del producto (voltios): ");
                    voltaje = scanner.nextLine();
                    datosValidos = true;
                } catch (InputMismatchException e) {
                    System.out.println("\t***Error: la garantia debe ser un número entero.***");
                    scanner.nextLine(); // Consumir la nueva línea
                }
            }
        } catch (Exception e) {
            System.out.println("Error al capturar los datos del electrodoméstico: " + e.getMessage());
        }
    
             
    }
      
    private void captura_Electronico(Scanner scanner){
        boolean datosValidos = false;
        try {
            System.out.print("Ingrese la marca del producto: ");
            marca = scanner.nextLine();
            System.out.print("Ingrese el modelo del producto: ");
            modelo = scanner.nextLine();
            System.out.print("Ingrese el color del producto: ");
            color = scanner.nextLine();

            while (!datosValidos) {
                try {
                    System.out.print("Ingrese la garantia del producto (en meses): ");
                    garantia = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    System.out.print("Ingrese el voltaje del producto (en voltios): ");
                    voltaje = scanner.nextLine();
                    datosValidos = true;
                } catch (InputMismatchException e) {
                    System.out.println("\t***Error: la garantia debe ser un número entero.***");
                    scanner.nextLine(); // Consumir la nueva línea
                }
            }
        } catch (Exception e) {
            System.out.println("Error al capturar los datos del producto: " + e.getMessage());
        }
           
    }
    
    private void captura_literario(Scanner scanner){
        boolean datosValidos = false;

        try {
            System.out.print("Ingrese la marca del producto: ");
            marca = scanner.nextLine();
            System.out.print("Ingrese el modelo del producto: ");
            modelo = scanner.nextLine();
            System.out.print("Ingrese el color del producto: ");
            color = scanner.nextLine();

            while (!datosValidos) {
                try {
                    System.out.print("Ingrese la garantia del producto (en meses): ");
                    garantia = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    System.out.print("Ingrese el voltaje del producto (en voltios): ");
                    voltaje = scanner.nextLine();
                    datosValidos = true;
                } catch (InputMismatchException e) {
                    System.out.println("\t***Error: la garantia debe ser un número entero.***");
                    scanner.nextLine(); // Consumir la nueva línea
                }
            }
        } catch (Exception e) {
            System.out.println("Error al capturar los datos del producto: " + e.getMessage());
        }
       
         
    }
     
    private void captura_Promocionales(Scanner scanner){
       
    }

    private void agregarProducto(Scanner scanner) {
        System.out.println("Seleccione el tipo de producto:");
        System.out.println("1. Libro");
        System.out.println("2. Televisor");
        System.out.println("3. Celular");
        System.out.println("4. Calculadora");
        System.out.println("5. Licuadora");
        System.out.println("6. Tostadora");
        System.out.println("7. Promocionales");
      
        System.out.println("0. Cancelar/Terminar");
        int tipoProducto = -1;

        do{
            try{
        
                System.out.print("Ingrese el número correspondiente al tipo de producto: ");
                tipoProducto = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea
            }
            catch(InputMismatchException e){
                System.out.println("\t***Error: Debe ingresar un número entero.***");
                scanner.nextLine(); // Consumir la nueva línea
                continue;
            }
        } while (tipoProducto < 0 || tipoProducto > 7);

        //Datos comunes del producto
        captura_productos(scanner);
        boolean datosValidos = false;

        switch (tipoProducto) {
            case 1://Libro
                captura_literario(scanner); 
                //Datos específicos del libro
                System.out.print("Ingrese el ISBN: ");
                String isbn = scanner.nextLine();
                familia = tiendaService.obtenerFamiliaProductoLiterario();
                

                tiendaService.agregarLibro(idProducto, nombre, precio, descripcion, familia,autor, editorial, 
                                            anioPublicacion, genero, numeroPaginas, isbn);
                
                System.out.println("Libro agregado exitosamente."); 
                break;
            case 2://Televisor
                captura_Electronico(scanner);
                //Datos específicos del televisor
                System.out.print("Ingrese el tamaño (en pulgadas): ");
                String tamanio = scanner.nextLine();
                System.out.print("Ingrese la resolución (en pixeles): ");
                String resolucion = scanner.nextLine();
                System.out.print("Ingrese el tipo de pantalla (LCD,LED,OLED,etc): ");
                String tipoPantalla = scanner.nextLine();
                familia = tiendaService.obtenerFamiliaProductoElectronico();
            
                tiendaService.agregarTelevision(idProducto, nombre, precio, descripcion,familia
                                                , marca,  modelo, color, garantia,  voltaje
                                                ,tamanio,  resolucion, tipoPantalla);
               
                System.out.println("Television agregado exitosamente."); 
                break;
            case 3://Celular
                captura_Electronico(scanner);
                //Datos específicos del celular

                datosValidos = false;

                while(!datosValidos){
                    try{
                        System.out.print("Ingrese el número de cámaras: ");
                        int numCamaras = scanner.nextInt();
                        scanner.nextLine(); // Consumir la nueva línea
                        System.out.print("Ingrese Sistema Opertativo (Android,iOS,Windows Phone, etc.): ");
                        String sistemaOperativo = scanner.nextLine();
                        System.out.print("Ingrese capacidad de almacenamiento (en GB): ");
                        int capacidadAlmacenamiento = scanner.nextInt();
                        scanner.nextLine(); // Consumir la nueva línea
                        System.out.print("Ingrese la RAM (en GB): ");
                        int ram = scanner.nextInt();
                        scanner.nextLine(); // Consumir la nueva línea
                        System.out.print("Ingrese el tipo de pantalla (LCD,IPS,OLED y AMOLED): ");
                        String tipoPantallaCelular = scanner.nextLine();
                        familia= tiendaService.obtenerFamiliaProductoElectronico();
                        tiendaService.agregarCelular(idProducto, nombre, precio, descripcion,familia
                                                    ,marca, modelo, color, garantia, voltaje
                                                    ,numCamaras, sistemaOperativo, capacidadAlmacenamiento
                                                    ,ram, tipoPantallaCelular);
                        System.out.println("Celular agregado exitosamente.");
                        datosValidos = true;
                    }
                    catch(InputMismatchException e){
                        System.out.println("\t***Error: el número de cámaras, capacidad de almacenamiento y RAM deben ser números enteros.***");
                        scanner.nextLine(); // Consumir la nueva línea
                    }
                }
                
                break;
            case 4://Calculadora
                captura_Electronico(scanner);
                //Datos específicos de la calculadora
                System.out.print("Ingrese el tipo de calculadora (científicas estándar,programables, etc.): ");
                String tipoCalculadora = scanner.nextLine();

                familia = tiendaService.obtenerFamiliaProductoElectronico();
                tiendaService.agregarCalculadora(idProducto, nombre, precio, descripcion,familia
                                                ,marca, modelo, color, garantia
                                                ,voltaje ,tipoCalculadora);
                System.out.println("Calculadora agregada exitosamente.");
                break;
            case 5://Licuadora
                captura_electrodomestico(scanner); 
                //Datos específicos de la licuadora

                datosValidos = false;
                while(!datosValidos){
                    try{
                        System.out.print("Ingrese la potencia (vatios): ");
                        int potencia = scanner.nextInt();
                        scanner.nextLine(); // Consumir la nueva línea
                        System.out.print("Ingrese la capacidad (mililitros): ");
                        int capacidad = scanner.nextInt();
                        scanner.nextLine(); // Consumir la nueva línea
                        familia = tiendaService.obtenerFamiliaProductoElectrodomestico();
                        tiendaService.agregarLicuadora(idProducto, nombre, precio, descripcion, familia, 
                                                        marca, modelo, color, garantia, voltaje, potencia, capacidad);
                        System.out.println("Licuadora agregada exitosamente.");
                        datosValidos = true;
                    }
                    catch(InputMismatchException e){
                        System.out.println("\t***Error: la potencia y la capacidad deben ser números enteros.***");
                        scanner.nextLine(); // Consumir la nueva línea
                    }
                }

                break;
            case 6://Tostadora
                captura_electrodomestico(scanner);
                //datos específicos de la tostadora
                datosValidos = false;

                while(!datosValidos){
                    try{
                        System.out.print("Ingrese el número de ranuras: ");
                        int numRanuras = scanner.nextInt();
                        scanner.nextLine(); // Consumir la nueva línea

                        familia = tiendaService.obtenerFamiliaProductoElectrodomestico();
                        tiendaService.agregarTostadora(idProducto, nombre, precio,  descripcion,familia
                                                        ,marca, modelo, color, garantia, voltaje
                                                        ,numRanuras);
                        System.out.println("Tostadora agregada exitosamente.");
                        datosValidos = true;
                    }
                    catch(InputMismatchException e){
                        System.out.println("\t***Error: el número de ranuras debe ser un número entero.***");
                        scanner.nextLine(); // Consumir la nueva línea
                    }
                }
                
                break;
            case 7://Promocionales
                captura_Promocionales(scanner);
                //Datos específicos del producto promocional
                System.out.print("ingrese talla del producto: ");
                String talla = scanner.nextLine();
                System.out.print("ingrese color del producto: ");
                String colorPromocional = scanner.nextLine();
                familia = tiendaService.obtenerFamiliaProductoPromocional();
                tiendaService.agregarProductoPromocional(idProducto, nombre, precio, descripcion, 
                                                        familia, talla, colorPromocional);
                System.out.println("Producto promocional agregado exitosamente.");
                break;
            default:
                System.out.println("Tipo de producto no válido.");
                return;
    }

    }

    private void eliminarProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String nombre = scanner.nextLine();
        tiendaService.eliminarProducto(nombre);
    }

    private void listarProductos() {
        tiendaService.listarProductos();
    }

    private void venderProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a vender: ");
        String nombre = scanner.nextLine();
        tiendaService.venderProducto(nombre);
    }

    private void aplicarDescuento(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a aplicar descuento: ");
        String nombre = scanner.nextLine();
        do{
            try{
                System.out.print("Ingrese el porcentaje de descuento: ");
                double porcentaje = scanner.nextDouble();
                scanner.nextLine(); // Consumir la nueva línea
                tiendaService.aplicarDescuento(nombre, porcentaje);
                break;
            }
            catch(InputMismatchException e){
                System.out.println("\t***Error: el porcentaje de descuento debe ser un número.***");
                scanner.nextLine(); // Consumir la nueva línea
            }
        } while (true);
      
    }

    private void actualizarPrecio(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto a actualizar: ");
        String nombre = scanner.nextLine();
        do{
            try{
                System.out.print("Ingrese el nuevo precio del producto: ");
                double nuevoPrecio = scanner.nextDouble();
                scanner.nextLine(); // Consumir la nueva línea
                tiendaService.actualizarPrecio(nombre, nuevoPrecio);
                break;
            }
            catch(InputMismatchException e){
                System.out.println("\t***Error: el precio debe ser un número.***");
                scanner.nextLine(); // Consumir la nueva línea
            }
        } while (true);
       
    }

    private void calcularValorTotalProductos() {
        double valorTotal = tiendaService.calcularValorTotalProductos();
        System.out.println("Valor total de los productos en inventario: $" + valorTotal);
    }
}