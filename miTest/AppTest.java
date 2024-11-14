package miTest;

import ui.Menu;
import ui.Aplicacion;
import ui.ErrorFisicoException;
import datos.Producto;
import datos.ProductoElectroDomestico;
import datos.ProductoElectronico;
import datos.ProductoLiterario;
import datos.ProductoPromocional;
import datos.Libro;
import datos.Television;
import datos.Celular; 
import datos.Licuadora;
import datos.Tostadora;
import datos.Usuario;
import datos.Calculadora;
import datos.Camisetapromocional;


import datos.Fecha;
import datos.FechaInvalidaException;

import negocio.TiendaDeRegalosService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;



class AppTest {

    
    private TiendaDeRegalosService tienda;
    private String ruta = "miTest/archivos";
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private Menu menu;

    private Aplicacion aplicacion;

    @BeforeEach
    public void setUp() throws IOException{

        tienda = new TiendaDeRegalosService(100,ruta); 

        // Crear copias de seguridad de los archivos
        copiarArchivo("miTest/archivos/libro.txt", "miTest/archivos/libro_backup.txt");
        copiarArchivo("miTest/archivos/celular.txt", "miTest/archivos/celular_backup.txt");
        copiarArchivo("miTest/archivos/television.txt", "miTest/archivos/television_backup.txt");
        copiarArchivo("miTest/archivos/calculadora.txt", "miTest/archivos/calculadora_backup.txt");
        copiarArchivo("miTest/archivos/licuadora.txt", "miTest/archivos/licuadora_backup.txt");
        copiarArchivo("miTest/archivos/tostadora.txt", "miTest/archivos/tostadora_backup.txt");
        copiarArchivo("miTest/archivos/camisetapromocional.txt","miTest/archivos/camisetapromocional_backup.txt");

        
       
        tienda.agregarProducto(new Television("5", "Televisor 4K", 499.99, "Televisor de alta definición", "ProductoElectronico",
            "Samsung", "QLED", "Negro", 2, "220V", "65 pulg", "8K: 7680 x 4320", "LCD"));
        tienda.agregarProducto(new Celular("5", "Celular Android", 299.99, "Celular de última generación", "ProductoElectronico",
            "Samsung", "Galaxy S21", "Azul", 1, "110V", 3, "IOS", 4, 64, "tactil"));
        tienda.agregarProducto(new Calculadora("5", "Calculadora Científica", 19.99, "Calculadora con funciones avanzadas", "Producto Electronico",
            "Casio", "FX-991ES", "Gris", 1, "N/A", "Científica"));
        tienda.agregarProducto(new Licuadora("5", "Licuadora Oster", 79.99, "Licuadora de alta velocidad con 10 velocidades", "ProductoElectrodomestico",
            "Oster", "BLSTMG-W00", "Blanco", 2, "110V", 600, 1500));
        tienda.agregarProducto(new Tostadora("5", "Tostadora Philips", 49.99, "Tostadora de 4 rebanadas con control de temperatura","ProductoElectrodomestico",
             "Philips", "HD2581/00", "Negro", 2, "110V", 4));
        tienda.agregarProducto(new Camisetapromocional("5", "Camiseta Deportiva", 19.99, "Camiseta de algodón para deportes","ProductoPromocional",
             "L", "Rojo"));
        tienda.agregarProducto(new Libro("5", "Cien Años de Soledad", 19.99, "Descripción de prueba", "ProductoLiterario",
            "Gabriel Garcia Marquez", "Editorial", 1967, "Realismo mágico", 500, "978-84-376-0494-7"));
    

       menu = new Menu();
      
       System.setOut(new PrintStream(outContent));

       aplicacion = new Aplicacion();

        // Crear el archivo de propiedades para las pruebas
        Properties properties = new Properties();
        properties.setProperty("usrname", "LourdesA");
        properties.setProperty("password", "123");
        properties.setProperty("nombre", "Maria Lourdes Armenta Lindoro");
        properties.setProperty("email", "maria.al@culiacan.tecnm.mx");

        try (FileOutputStream fos = new FileOutputStream("usuario.properties")) {
            properties.store(fos, null);
        }

    }

    @AfterEach
    public void tearDown() throws IOException {
        // Restaurar los archivos originales desde las copias de seguridad
        copiarArchivo("miTest/archivos/libro_backup.txt", "miTest/archivos/libro.txt");
        copiarArchivo("miTest/archivos/celular_backup.txt", "miTest/archivos/celular.txt");
        copiarArchivo("miTest/archivos/television_backup.txt", "miTest/archivos/television.txt");
        copiarArchivo("miTest/archivos/calculadora_backup.txt", "miTest/archivos/calculadora.txt");
        copiarArchivo("miTest/archivos/licuadora_backup.txt", "miTest/archivos/licuadora.txt");
        copiarArchivo("miTest/archivos/tostadora_backup.txt", "miTest/archivos/tostadora.txt");
        copiarArchivo("miTest/archivos/camisetapromocional_backup.txt", "miTest/archivos/camisetapromocional.txt");
       

        // Eliminar las copias de seguridad
        Files.deleteIfExists(Paths.get("miTest/archivos/libro_backup.txt"));
        Files.deleteIfExists(Paths.get("miTest/archivos/celular_backup.txt"));
        Files.deleteIfExists(Paths.get("miTest/archivos/television_backup.txt"));
        Files.deleteIfExists(Paths.get("miTest/archivos/calculadora_backup.txt"));
        Files.deleteIfExists(Paths.get("miTest/archivos/licuadora_backup.txt"));
        Files.deleteIfExists(Paths.get("miTest/archivos/tostadora_backup.txt"));
        Files.deleteIfExists(Paths.get("miTest/archivos/camisetapromocional_backup.txt"));
    }

    private void copiarArchivo(String origen, String destino) throws IOException {
        Files.copy(Paths.get(origen), Paths.get(destino), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    public void testGuardarYcargarProductos  () {
        // Crear productos de prueba
        Producto libro = new Libro("6", "Cien Años de Soledad", 19.99, "Descripción de prueba", "ProductoLiterario",
            "Gabriel Garcia Marquez", "Editorial", 1967, "Realismo mágico", 500, "978-84-376-0494-7");

        Producto celular = new Celular("6", "Celular Android", 299.99, "Celular de última generación", "ProductoElectronico",
            "Samsung", "Galaxy S21", "Azul", 1, "110V", 3, "IOS", 4, 64, "tactil");
        Producto television = new Television("6", "Televisor 4K", 499.99, "Televisor de alta definición", "ProductoElectronico",
            "Samsung", "QLED", "Negro", 2, "220V", "65 pulg", "4K: 7680 x 4320", "LCD");

        // Agregar productos al DAO a través de la TiendaRegalosService
       
        tienda.agregarProducto(libro);
        tienda.agregarProducto(celular);
        tienda.agregarProducto(television);


        Producto productos_cargados[] = tienda.getProductos();

        // Verificar que los productos se cargaron correctamente
        // 7 del setup + 3 de este método + 21 de los archivos
        assertEquals(31, tienda.getRegistros());

       // Contadores para cada tipo de producto
       int contadorLibros = 0;
       int contadorCelulares = 0;
       int contadorTelevisiones = 0;
       int contadorCalculadoras = 0;
       int contadorLicuadoras = 0;
       int contadorTostadoras = 0;
       int contadorCamisetasPromocionales = 0;

       // Contar las instancias de cada tipo de producto
       for (int i=0; i<tienda.getRegistros(); i++) {
           Producto producto = productos_cargados[i];
           if (producto instanceof Libro) {
               contadorLibros++;
           } else if (producto instanceof Celular) {
               contadorCelulares++;
           } else if (producto instanceof Television) {
               contadorTelevisiones++;
           } else if (producto instanceof Calculadora) {
               contadorCalculadoras++;
           } else if (producto instanceof Licuadora) {
               contadorLicuadoras++;
           } else if (producto instanceof Tostadora) {
               contadorTostadoras++;
           } else if (producto instanceof Camisetapromocional) {
               contadorCamisetasPromocionales++;
           }
       }

       // Verificar los contadores
       assertEquals(5, contadorLibros);
       assertEquals(5, contadorCelulares);
       assertEquals(5, contadorTelevisiones);
       assertEquals(4, contadorCalculadoras); 
       assertEquals(4, contadorLicuadoras); 
       assertEquals(4, contadorTostadoras); 
       assertEquals(4, contadorCamisetasPromocionales);

        // Verificar los detalles de cada producto
        Libro libroCargado = (Libro) productos_cargados[0];
        assertEquals("2",libroCargado.getIdProducto());
        assertEquals("Cien Años de Soledad", libroCargado.getNombre());
        assertEquals(25.50, libroCargado.getPrecio());
        assertEquals("Gabriel García Márquez", libroCargado.getAutor());
        assertEquals(417, libroCargado.getNumeroPaginas());
        assertEquals("978-0-14-118499-9", libroCargado.getIsbn());

        Celular celularCargado = (Celular) productos_cargados[3];
        assertEquals("1",celularCargado.getIdProducto());
        assertEquals("iPhone 13", celularCargado.getNombre());
        assertEquals(999.99, celularCargado.getPrecio());
        assertEquals(3, celularCargado.getNumCamaras());
        assertEquals("iOS", celularCargado.getSistemaOperativo());
        assertEquals(128, celularCargado.getCapacidadAlmacenamiento());
        assertEquals(6, celularCargado.getRam());
        assertEquals("OLED", celularCargado.getTipoPantalla());

        Television televisionCargado = (Television) productos_cargados[6];
        assertEquals("1", televisionCargado.getIdProducto());
        assertEquals("Samsung QLED TV", televisionCargado.getNombre());
        assertEquals(999.99, televisionCargado.getPrecio());
        assertEquals("55 pulgadas", televisionCargado.getTamanio());
        assertEquals("4K UHD", televisionCargado.getResolucion());
        assertEquals("QLED", televisionCargado.getTipoPantalla());

        Calculadora calculadoraCargado = (Calculadora) productos_cargados[9];
        assertEquals("1", calculadoraCargado.getIdProducto());
        assertEquals("Calculadora Científica Casio", calculadoraCargado.getNombre());

        Licuadora licuadoraCargado = (Licuadora) productos_cargados[12];
        assertEquals("1", licuadoraCargado.getIdProducto());
        assertEquals("Oster Pro 1200", licuadoraCargado.getNombre());

        Tostadora tostadoraCargado = (Tostadora) productos_cargados[15];
        assertEquals("1", tostadoraCargado.getIdProducto());
        assertEquals("Tostadora Philips", tostadoraCargado.getNombre());

        Camisetapromocional camisetaPromocionalCargado = (Camisetapromocional) productos_cargados[18];
        assertEquals("1", camisetaPromocionalCargado.getIdProducto());
        assertEquals("Camiseta Nike", camisetaPromocionalCargado.getNombre());

    }
 

    @Test
    public void testAplicarDescuentoATodos() {

        tienda.aplicarDescuentoATodos(10); // Aplicar un descuento del 10% a todos los productos
        //los productos de los archivos
        // a los productos literarios se les aplica un descuento del 10% porque el máximo es de 80%
        assertEquals(25.5-25.5*.10, tienda.getProductos()[0].getPrecio(), 0.01); // Libro
        assertEquals(15.0-15.0*.10, tienda.getProductos()[1].getPrecio(), 0.01); // Libro
        assertEquals(19.99-19.99*.10, tienda.getProductos()[2].getPrecio(),0.01); // Libro

        assertEquals(999.99-999.99*.10, tienda.getProductos()[3].getPrecio(),0.01); // Celular
        assertEquals(799.99-799.99*.10, tienda.getProductos()[4].getPrecio(),0.01); // Celular
        assertEquals(599.99-599.99*.10, tienda.getProductos()[5].getPrecio(),0.01); // Celular

        assertEquals(999.99-999.99*.10, tienda.getProductos()[6].getPrecio(),0.01); // Televisor
        assertEquals(1299.99-1299.99*.10, tienda.getProductos()[7].getPrecio(),0.01); // Televisor
        assertEquals(899.99-899.99*.10, tienda.getProductos()[8].getPrecio(),0.01); // Televisor

        assertEquals(29.99-29.99*.10, tienda.getProductos()[9].getPrecio(),0.01); // Calculadora
        assertEquals(99.99-99.99*.10, tienda.getProductos()[10].getPrecio(),0.01); // Calculadora
        assertEquals(9.99-9.99*.10, tienda.getProductos()[11].getPrecio(),0.01); // Calculadora

        assertEquals(79.99-79.99*.10, tienda.getProductos()[12].getPrecio(),0.01); // Licuadora
        assertEquals(99.99-99.99*.10, tienda.getProductos()[13].getPrecio(),0.01); // Licuadora
        assertEquals(129.99-129.99*.10, tienda.getProductos()[14].getPrecio(),0.01); // Licuadora

        assertEquals(49.99-49.99*.10, tienda.getProductos()[15].getPrecio(),0.01); // Tostadora
        assertEquals(39.99-39.99*.10, tienda.getProductos()[16].getPrecio(),0.01); // Tostadora
        assertEquals(29.99-29.99*.10, tienda.getProductos()[17].getPrecio(),0.01); // Tostadora

        
        //el precio no cambia porque no se puede aplicar un descuento a un producto promocional
        assertEquals(29.99, tienda.getProductos()[18].getPrecio(),0.01); // Camiseta
        assertEquals(24.99, tienda.getProductos()[19].getPrecio(),0.01); // Camiseta
        assertEquals(19.99, tienda.getProductos()[20].getPrecio(),0.01); // Camiseta
        
        //los productos del setup
        
        assertEquals(449.99, tienda.getProductos()[21].getPrecio(), 0.01); // Televisor
        assertEquals(269.99, tienda.getProductos()[22].getPrecio(), 0.01); // Celular
        assertEquals(17.99, tienda.getProductos()[23].getPrecio(), 0.01);  // Calculadora
        assertEquals(71.99, tienda.getProductos()[24].getPrecio(), 0.01);  // Licuadora
        assertEquals(44.99, tienda.getProductos()[25].getPrecio(), 0.01);  // Tostadora
        assertEquals(19.99, tienda.getProductos()[26].getPrecio(), 0.01);  // Camiseta
        assertEquals(17.99, tienda.getProductos()[27].getPrecio(), 0.01);  // Libro

    
       
    }
    


    @Test
    public void testMostrarInventario() {
        // Redirigir la salida estándar para capturar el output de mostrarInventario
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        tienda.mostrarInventario();

        // Verificar que la salida contiene los productos esperados
        String output = outContent.toString();
        assertTrue(output.contains("Televisor 4K"));
        assertTrue(output.contains("Celular Android"));
        assertTrue(output.contains("Calculadora Científica"));
        assertTrue(output.contains("Licuadora Oster"));
        assertTrue(output.contains("Tostadora Philips"));
        assertTrue(output.contains("Camiseta Deportiva"));
        assertTrue(output.contains("Cien Años de Soledad"));

        // Restaurar la salida estándar
        System.setOut(System.out);
    }
    
    @Test
    public void testVenderProductoExistente() {
        tienda.venderProducto("Cien Años de Soledad");
        // Verificar que el producto siga existiendo ya que tengo varios ejemplares
        assertNotNull(tienda.buscarProducto("Cien Años de Soledad")); 
        assertTrue(outContent.toString().contains("Producto vendido: Cien Años de Soledad"));
        tienda.venderProducto("1984");
        // Verificar que el producto ya no exista porque solo tengo un ejemplar
        assertNull(tienda.buscarProducto("1984"));
        assertTrue(outContent.toString().contains("Producto vendido: 1984"));
    }
     
    @Test
    public void testNoVenderProductoPromocional() {
        Camisetapromocional camisetaPromocional = new Camisetapromocional("9", "Camiseta Deportiva", 
                19.99, "Camiseta de algodón para deportes","ProductoPromocional", "L", "Rojo");
        tienda.agregarProducto(camisetaPromocional);
        
        // Intentar vender el producto promocional
        tienda.venderProducto("Camiseta Deportiva");
        
        // Verificar que el producto sigue existiendo en el inventario
        assertNotNull(tienda.buscarProducto("Camiseta Deportiva"));
        
        // Verificar que no se imprimió el mensaje de producto vendido
        assertFalse(outContent.toString().contains("Producto vendido: Camiseta Deportiva"));
    }
    

    @Test 
    public void testMenuInitialization() {
        Menu menu = new Menu();
        assertNotNull(menu, "El menú debe inicializarse correctamente");
    }

    @Test
    public void testProducto() {
        // Prueba de constructor y getNombre
        Producto producto = new Libro("1", "cien años de soledad", 19.99, "Descripción de prueba", "Productoliterario", "Gabriel Garcia Marquez", "Editorial", 1967, "Realismo mágico", 500, "978-84-376-0494-7");  
       
        assertEquals("cien años de soledad", producto.getNombre(), "El nombre del producto debe ser 'cien años de soledad'");

        // Prueba de setNombre
        producto.setNombre("Producto de Prueba 2");
        assertEquals("Producto de Prueba 2", producto.getNombre(), "El nombre del producto debe ser 'Producto de Prueba 2' después de usar setNombre");

        // Prueba de getPrecio
        assertEquals(19.99, producto.getPrecio(), "El precio del producto debe ser 19.99");

        // Prueba de setPrecio
        producto.setPrecio(14.99);
        assertEquals(14.99, producto.getPrecio(), "El precio del producto debe ser 14.99 después de usar setPrecio");

        // Prueba de getDescripcion
        assertEquals("Descripción de prueba", producto.getDescripcion(), "La descripción del producto debe ser 'Descripción de prueba'");

        // Prueba de setDescripcion
        producto.setDescripcion("Nueva descripción de prueba");
        assertEquals("Nueva descripción de prueba", producto.getDescripcion(), "La descripción del producto debe ser 'Nueva descripción de prueba' después de usar setDescripcion");

        // Prueba de getFamilia
        assertEquals("ProductoLiterario", producto.getFamilia(), "La familia del producto debe ser 'ProductoLiterario'");

       
    }
    
    @Test
    public void testAplicarDescuentoHerenciaProducto() {
        // Crear una instancia de Producto usando Libro
        Producto producto = new Libro("1", "Cien Años de Soledad", 19.99, "Descripción de prueba", "Productoliterario", "Gabriel Garcia Marquez", "Editorial", 1967, "Realismo mágico", 500, "978-84-376-0494-7");  


        // Aplicar un descuento válido
        producto.aplicarDescuento(20);
        assertEquals(16.0, producto.getPrecio(), 0.01);

        // Aplicar un descuento no válido, porque es mayor a 80%
        //entonces el costo no debe cambiar
        producto.aplicarDescuento(90);
        assertEquals(16.0, producto.getPrecio(), 0.01); // El precio no debe cambiar

        // Aplicar otro descuento válido
        //se aplica un descuento del 80% al precio original
        //19.99 - 80% = 3.2
        producto.aplicarDescuento(80);
        assertEquals(3.2, producto.getPrecio(), 0.01);
    }

    @Test
    public void testAplicarDescuentoHerenciaProductoElectronico() {
        // Crear una instancia de ProductoElectronico usando Televisor
        ProductoElectronico productoElectronico = new Television("1", "Televisor 4K", 499.99, "Televisor de alta definición", "ProductoElectronico",
                                                    "Samsung", "QLED", "Negro", 2, "220V", "65 pulg", "8K: 7680 x 4320", "LCD");

        // Aplicar un descuento válido
        productoElectronico.aplicarDescuento(20);
        assertEquals(399.99, productoElectronico.getPrecio(), 0.01);

        // Aplicar un descuento no válido, porque es mayor a 20%
        // entonces el costo no debe cambiar
        productoElectronico.aplicarDescuento(90);
        assertEquals(399.99, productoElectronico.getPrecio(), 0.01); // El precio no debe cambiar

        // Aplicar otro descuento válido
        // se aplica un descuento del 10% al precio original
        // 399.99 - 10% = 39.99
        productoElectronico.aplicarDescuento(10);
        assertEquals(360.0, productoElectronico.getPrecio(), 0.01);
    }

    @Test
    public void testAplicarDescuentoHerenciaProductoElectroDomestico() {
        // Crear una instancia de ProductoElectroDomestico usando Licuadora
        ProductoElectroDomestico productoElectroDomestico = new Licuadora("7", "Licuadora Oster", 79.99, "Licuadora de alta velocidad con 10 velocidades","Electrodomesticos",
                                                                     "Oster","BLSTMG-W00","Blanco",2,"110V", 600,1500);

        // Aplicar un descuento válido
        productoElectroDomestico.aplicarDescuento(20);
        assertEquals(63.99, productoElectroDomestico.getPrecio(), 0.01);

        // Aplicar un descuento no válido, porque es mayor a 50%
        // entonces el costo no debe cambiar
        productoElectroDomestico.aplicarDescuento(55);
        assertEquals(63.99, productoElectroDomestico.getPrecio(), 0.01); // El precio no debe cambiar

        // Aplicar otro descuento válido
        // se aplica un descuento del 80% al precio original
        // 63.99 - 20% = 51.1
        productoElectroDomestico.aplicarDescuento(20);
        assertEquals(51.19, productoElectroDomestico.getPrecio(), 0.01);
    }

    @Test
    public void testAplicarDescuentoHerenciaProductoLiterario() {
        // Crear una instancia de ProductoLiterario usando Libro
        ProductoLiterario productoLiterario = new Libro("4", "Cien Años de Soledad", 19.99, "Descripción de prueba", "ProductoLiterario",
                            "Gabriel Garcia Marquez", "Editorial", 1967, "Realismo mágico", 500, "978-84-376-0494-7");

        // Aplicar un descuento válido
        productoLiterario.aplicarDescuento(20);
        assertEquals(15.99, productoLiterario.getPrecio(), 0.01);

        // Aplicar un descuento no válido, porque es mayor a 80%
        // entonces el costo no debe cambiar
        productoLiterario.aplicarDescuento(90);
        assertEquals(15.99, productoLiterario.getPrecio(), 0.01); // El precio no debe cambiar

        // Aplicar otro descuento válido
        // se aplica un descuento del 80% al precio original
        // 15.99 - 80% = 3.2
        productoLiterario.aplicarDescuento(80);
        assertEquals(3.2, productoLiterario.getPrecio(), 0.01);
    }

    @Test
    public void testPolimorfismoProducto() {
        // Crear instancias de Televisor, Celular y Calculadora
        ProductoElectronico television = new Television("1", "Televisor 4K", 499.99, "Televisor de alta definición", "ProductoElectronico",
                                                        "Samsung", "QLED", "Negro", 2, "220V",
                                                        "65 pulg","8K: 7680 x 4320","LCD");
        ProductoElectronico celular = new Celular("2", "Celular Android", 299.99, "Celular de última generación", "ProductoElectronico",
                                                 "Samsung", "Galaxy S21", "Azul", 1, "110V",
                                                 3,"IOS",4,64,"tactil");
        ProductoElectronico calculadora = new Calculadora("3", "Calculadora Científica", 19.99, "Calculadora con funciones avanzadas", "ProductoEletroico",
                                                "Casio", "FX-991ES", "Gris", 1, "N/A","Científica");

        ProductoElectroDomestico licuadora = new Licuadora("7", "Licuadora Oster", 79.99, "Licuadora de alta velocidad con 10 velocidades","Electrodomesticos",
                                                "Oster","BLSTMG-W00","Blanco",2,"110V", 600,1500);
        ProductoElectroDomestico tostadora = new Tostadora("8","Tostadora Philips",49.99, "Tostadora de 4 rebanadas con control de temperatura","Electrodomesticos",
                                                 "Philips", "HD2581/00","Negro", 2,  "110V",4);

        ProductoLiterario libro = new Libro("4","Cien Años de Soledad", 19.99, "Descripción de prueba", "Productoliterario", 
                                                "Gabriel Garcia Marquez", "Editorial", 1967, "Realismo mágico", 500, "978-84-376-0494-7"); 
       
        ProductoPromocional camisetaPromocional = new Camisetapromocional( "9","Camiseta Deportiva",19.99,"Camiseta de algodón para deportes","ProductoPromocional",
                                                 "L","Rojo"); 

        // Verificar que las instancias son también instancias de Producto
        assertTrue(television instanceof Producto, "Televisor debe ser una instancia de Producto");
        assertTrue(celular instanceof Producto, "Celular debe ser una instancia de Producto");
        assertTrue(calculadora instanceof Producto, "Calculadora debe ser una instancia de Producto");
        assertTrue(libro instanceof Producto, "Libro debe ser una instancia de Producto");
        assertTrue(licuadora instanceof Producto,"Licuadora debe ser una instancia de Producto");
        assertTrue(tostadora instanceof Producto,"Tostadora debe ser una instancia de Producto");
        assertTrue(camisetaPromocional instanceof Producto,"Camiseta Promocional debe ser una instancia de Producto");

        // Verificar que las instancias son también instancias de Familias
        assertTrue(television instanceof ProductoElectronico, "Televisor debe ser una instancia de ProductoElectronico");
        assertTrue(celular instanceof ProductoElectronico, "Celular debe ser una instancia de ProductoElectronico");
        assertTrue(calculadora instanceof ProductoElectronico, "Calculadora debe ser una instancia de ProductoElectronico");
        assertTrue(libro instanceof ProductoLiterario, "Libro debe ser una instancia de ProductoLiterario");
        assertTrue(licuadora instanceof ProductoElectroDomestico, "Licuadora  debe ser una instancia de ProductoElectroDomestico");
        assertTrue(tostadora instanceof ProductoElectroDomestico, "Tostadora debe ser una instancia de ProductoElectroDomestico");
        assertTrue(camisetaPromocional instanceof ProductoPromocional, "Camiseta Promocional debe ser una instancia de ProductoPromocional");
    }

    @Test
    public void testAplicarDescuentoHerenciaProductoPromocional() {
        // Crear una instancia de ProductoPromocional usando Camiseta
        ProductoPromocional productoPromocional = new Camisetapromocional("9","Camiseta Deportiva",19.99,"Camiseta de algodón para deportes","ProductoPromocional",
                                                                    "L","Rojo");

        // Aplicar un descuento no válido, porque es el 
        //método aplicarDescuento no existe en la clase CamisetaPromocional
        productoPromocional.aplicarDescuento(20);
        assertEquals(19.99, productoPromocional.getPrecio(), 0.01);

        // Aplicar un descuento no válido, porque es el 
        //método aplicarDescuento no existe en la clase CamisetaPromocional
        productoPromocional.aplicarDescuento(110);
        assertEquals(19.99, productoPromocional.getPrecio(), 0.01); // El precio no debe cambiar

        // Aplicar otro descuento válido
        productoPromocional.aplicarDescuento(100);
        assertEquals(19.99, productoPromocional.getPrecio(), 0.01);
    }

    @Test
    public void testManejoDeExcepcionInputMismatch() {
        menu = new Menu();
       
        // Redirigir la salida estándar para capturar el output
        System.setOut(new PrintStream(outContent));

        // Simular la entrada de un valor no entero seguido de la opción de salida
        String input = "abc\n0\n"; // Simula la entrada de un valor no entero seguido de la opción de salida
        
        // Redirigir la entrada estándar para simular la entrada de datos
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Iniciar el menú
        menu.iniciar();

        // Verificar que se imprimió el mensaje de error generado por la excepción del menu
        //cuando se ingresa un valor no entero
        String output = outContent.toString();
        assertTrue(output.contains("\t***Error: Debe ingresar un número entero.***"));

        // Restaurar la salida estándar
        System.setOut(originalOut);
    }

    @Test
    public void testCalcularValorTotalProductos() {
        System.out.println(tienda.calcularValorTotalProductos());

        // Crear productos de prueba
        Producto libro = new Libro("1", "Cien Años de Soledad", 19.99, "Descripción de prueba", "ProductoLiterario",
            "Gabriel Garcia Marquez", "Editorial", 1967, "Realismo mágico", 500, "978-84-376-0494-7");

        Producto celular = new Celular("2", "Celular Android", 299.99, "Celular de última generación", "ProductoElectronico",
            "Samsung", "Galaxy S21", "Azul", 1, "110V", 3, "IOS", 4, 64, "tactil");

        Producto television = new Television("3", "Televisor 4K", 499.99, "Televisor de alta definición", "ProductoElectronico",
            "Samsung", "QLED", "Negro", 2, "220V", "65 pulg", "4K: 7680 x 4320", "LCD");

        // Agregar productos al DAO a través de la TiendaRegalosService
        tienda.agregarProducto(libro);
        tienda.agregarProducto(celular);
        tienda.agregarProducto(television);
        tienda.calcularValorTotalProductos();

        // Calcular el valor total de los productos
        //suma los registros de los archivos + los 7 setup+3 de este método
        double totalEsperado = 6305.33+989.93+19.99 + 299.99 + 499.99;
        double totalCalculado = tienda.calcularValorTotalProductos();

        // Verificar que el valor total calculado sea el esperado
        assertEquals(totalEsperado, totalCalculado, 0.05);
    }

     @Test
    public void testLoginExitoso() throws Exception {
        // Llamar al método login
        Usuario usuario = aplicacion.login("LourdesA", "123");

        // Verificar que el usuario no sea nulo y que los datos sean correctos
        assertNotNull(usuario);
        assertEquals("123", usuario.getContrasena());
        assertEquals("Maria Lourdes Armenta Lindoro", usuario.getNombreUsuario());
        assertEquals("maria.al@culiacan.tecnm.mx", usuario.getEmail());
    }

     @Test
    public void testLoginConError() throws Exception {
        // Llamar al método login con credenciales incorrectas y esperar un resultado nulo
        Usuario usuario = aplicacion.login("wrongUser", "wrongPassword");
        assertNull(usuario, "El usuario debería ser nulo con credenciales incorrectas");
    }

    @Test
    public void testLoginConArchivoInexistente() {
        // Eliminar el archivo de propiedades para simular un error
        assertTrue(new java.io.File("usuario.properties").delete(), "El archivo de propiedades debería ser eliminado");

        // Llamar al método login y esperar una excepción
        try {
            aplicacion.login("testUser", "testPassword");
            fail("Debería lanzar ErrorFisicoException cuando el archivo de propiedades no existe");
        } catch (ErrorFisicoException e) {
            // Verificar que se lanzó la excepción correcta
            assertNotNull(e.getCause(), "La causa de la excepción no debería ser nula");
        }
    }

     @Test
    public void testFecha() {
        // Prueba de fecha válida
        Fecha fechaValida = new Fecha(15, 8, 2023);
        assertNotNull(fechaValida, "La fecha no debería ser nula");

        // Prueba de fecha no válida
        try {
            new Fecha(31, 2, 2023); // Febrero no tiene 31 días
            fail("Debería lanzar FechaInvalidaException para una fecha no válida");
        } catch (FechaInvalidaException e) {
            assertEquals("Fecha no válida", e.getMessage());
        }

        // Prueba de cadena de fecha no válida
        try {
            new Fecha("31/02/2023"); // Febrero no tiene 31 días
            fail("Debería lanzar FechaInvalidaException para una cadena de fecha no válida");
        } catch (FechaInvalidaException e) {
            assertEquals("Formato de fecha no válido. Use 'dd/mm/yyyy'.", e.getMessage());
        }

        // Prueba de cadena de fecha válida
        Fecha fechaValidaCadena = new Fecha("15/08/2023");
        assertNotNull(fechaValidaCadena, "La fecha no debería ser nula");
    }




    
 
}