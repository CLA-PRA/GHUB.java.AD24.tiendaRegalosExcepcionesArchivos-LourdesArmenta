
package datos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorArchivo {
    public void cargarLibro(){
        List<Libro> libros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("datos/libro.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");
                String idProducto = datos[0];
                String nombre = datos[1];
                double precio = Double.parseDouble(datos[2]);
                String descripcion = datos[3];
                String familia = datos[4];
                String autor = datos[5];
                String editorial = datos[6];
                int anioPublicacion = Integer.parseInt(datos[7]);
                String genero = datos[8];
                int numeroPaginas = Integer.parseInt(datos[9]);
                String isbn = datos[10];

                Libro libro = new Libro(idProducto, nombre, precio, descripcion, familia, autor, editorial, anioPublicacion, genero, numeroPaginas, isbn);
                libros.add(libro);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Imprimir los libros cargados
        for (Libro libro : libros) {
           
            System.out.println(libro.obtenerDetalles());
        }

    }

    public void cargarTelevisor(){
        List<Television> televisores = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("datos/television.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");
                String idProducto = datos[0];
                String nombre = datos[1];
                double precio = Double.parseDouble(datos[2]);
                String descripcion = datos[3];
                String familia = datos[4];
                String marca = datos[5];
                String modelo = datos[6];
                String color = datos[7];
                int garantia = Integer.parseInt(datos[8]);

                String voltaje = datos[9];
                String tamanio = datos[10];
                String resolucion = datos[11];
                String tipoPantalla = datos[12];
                

                Television televisor = new Television(idProducto,  nombre,  precio,  descripcion
                            ,familia, marca,  modelo,  color, garantia,  voltaje, tamanio,  resolucion, tipoPantalla);
                televisores.add(televisor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
    
        // Imprimir los televisores cargados
        for (Television televisor : televisores) {
           
            System.out.println(televisor.obtenerDetalles());
        }
    }

    public void cargarCelular(){
        List<Celular> celulares = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("datos/celular.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");
                String idProducto = datos[0];
                String nombre = datos[1];
                double precio = Double.parseDouble(datos[2]);
                String descripcion = datos[3];
                String familia = datos[4];
                String marca = datos[5];
                String modelo = datos[6];
                String color = datos[7];
                int garantia = Integer.parseInt(datos[8]);
                String voltaje = datos[9];
                int numCamaras = Integer.parseInt(datos[10]);
                String sistemaOperativo = datos[11];
                int capacidadAlmacenamiento = Integer.parseInt(datos[12]);
                int ram = Integer.parseInt(datos[13]);
                String tipoPantalla = datos[14];

                Celular celular = new Celular(idProducto, nombre, precio, descripcion, 
                        familia, marca, modelo, color, garantia, voltaje,
                        numCamaras, sistemaOperativo, capacidadAlmacenamiento, ram, tipoPantalla);
                
                        celulares.add(celular);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Imprimir los celulares cargados
        for (Celular celular : celulares) {
         
            System.out.println(celular.obtenerDetalles());
        }
    }

    public void cargarCalculadora(){
        List<Calculadora> calculadoras = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("datos/calculadora.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");
                String idProducto = datos[0];
                String nombre = datos[1];
                double precio = Double.parseDouble(datos[2]);
                String descripcion = datos[3];
                String familia = datos[4];
                String marca = datos[5];
                String modelo = datos[6];
                String color = datos[7];
                int garantia = Integer.parseInt(datos[8]);
                String voltaje = datos[9];
                String tipoCalculadora = datos[10];

                Calculadora calculadora = new Calculadora(idProducto, nombre, precio, descripcion,familia
                        ,marca, modelo, color, garantia,voltaje ,tipoCalculadora);
                
                        calculadoras.add(calculadora);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Imprimir las calculadoras cargadas
        for (Calculadora calculadora : calculadoras) {
            
            System.out.println(calculadora.obtenerDetalles());
        }
    }

    public void cargaLicuadora(){
        List<Licuadora> licuadoras = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("datos/licuadora.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");
                String idProducto = datos[0];
                String nombre = datos[1];
                double precio = Double.parseDouble(datos[2]);
                String descripcion = datos[3];
                String familia = datos[4];
                String marca = datos[5];
                String modelo = datos[6];
                String color = datos[7];
                int garantia = Integer.parseInt(datos[8]);
                String voltaje = datos[9];
                int potencia = Integer.parseInt(datos[10]);
                int capacidad = Integer.parseInt(datos[11]);

                Licuadora licuadora = new Licuadora(idProducto, nombre, precio, descripcion, 
                            familia, marca, modelo, color, garantia, voltaje, potencia, capacidad);
                licuadoras.add(licuadora);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Imprimir las licuadoras cargadas
        for (Licuadora licuadora : licuadoras) {
           
            System.out.println(licuadora.obtenerDetalles());
        }
    }

    public void cargarTostadora(){
        List<Tostadora> tostadoras = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("datos/tostadora.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");
                String idProducto = datos[0];
                String nombre = datos[1];
                double precio = Double.parseDouble(datos[2]);
                String descripcion = datos[3];
                String familia = datos[4];
                String marca = datos[5];
                String modelo = datos[6];
                String color = datos[7];
                int garantia = Integer.parseInt(datos[8]);
                String voltaje = datos[9];
                int numRanuras = Integer.parseInt(datos[10]);
                

                Tostadora tostadora = new Tostadora(idProducto, nombre, precio,  descripcion,
                        familia,marca, modelo, color, garantia, voltaje
                        ,numRanuras);

                tostadoras.add(tostadora);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Imprimir las tostadoras cargadas
        for (Tostadora tostadora : tostadoras) {
           
            System.out.println(tostadora.obtenerDetalles());
        }
    }

    public void cargarCamiseta(){
        List<Camisetapromocional> camisetas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("datos/camisetapromocional.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");
                String idProducto = datos[0];
                String nombre = datos[1];
                double precio = Double.parseDouble(datos[2]);
                String descripcion = datos[3];
                String familia = datos[4];
                String talla = datos[5];
                String color = datos[6];
               
                Camisetapromocional camiseta = new Camisetapromocional(idProducto, nombre, precio, descripcion,familia
                             ,talla,color);

                camisetas.add(camiseta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Imprimir las camisetas cargadas
        for (Camisetapromocional camiseta : camisetas) {
           
            System.out.println(camiseta.obtenerDetalles());
        }
    }
}

