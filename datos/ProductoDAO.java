package datos;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class ProductoDAO {
    private Producto[] productos;
    private int numProductos;
    private String ruta;
    private int registros = 0;
    private static final String []lista_productos={"Libro",
                                            "Celular","Television","Calculadora",
                                            "Licuadora","Tostadora",
                                            "CamisetaPromocional"};


    public ProductoDAO(int capacidad,String ruta) {
        this.productos = new Producto[capacidad];
        this.numProductos = 0;
        this.ruta = ruta;
        //Cargar los productos de los archivos
        //existe un archivo por cada tipo de producto
        //cada archivo tiene una linea por cada producto
        //cada linea tiene los atributos del producto separados por coma
        //los archivos viene especificados en la lista de productos
        for (String producto : lista_productos) {
            cargarProductos(producto); 
        }
    }
    

    public String getRuta() {
        return ruta;
    }


    public int getRegistros() {
        return registros;
    }


    public void agregarProducto(Producto producto) {
        
        if (numProductos < productos.length) {
            productos[numProductos++] = producto;
            guardarProductos(producto);

        } else {
            System.out.println("Inventario lleno, no se puede agregar el producto: " + producto.getNombre());
        }
    }

    public boolean eliminarProducto(String nombreProducto) {
        boolean eliminado = false;
        for (int i = 0; i < numProductos; i++) {
            if (productos[i].getNombre().equals(nombreProducto)) {
                Producto producto = productos[i];
    
                // Mostrar las propiedades específicas del producto
                System.out.println("Detalles del producto a eliminar:");
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Precio: $" + producto.getPrecio());
    
                if (producto instanceof Libro) {
                    Libro libro = (Libro) producto;
                    System.out.println("Autor: " + libro.getAutor());
                    System.out.println("Páginas: " + libro.getNumeroPaginas());
                } else if (producto instanceof Celular) {
                    Celular celular = (Celular) producto;
                    System.out.println("Marca: " + celular.getMarca());
                    System.out.println("Modelo: " + celular.getModelo());
                } else if (producto instanceof Television) {
                    Television televisor = (Television) producto;
                    System.out.println("Marca: " + televisor.getMarca());
                    System.out.println("Tamaño: " + televisor.getTamanio() + " pulgadas");
                } else if (producto instanceof Calculadora) {
                    Calculadora calculadora = (Calculadora) producto;
                    System.out.println("Marca: " + calculadora.getMarca());
                    System.out.println("Modelo: " + calculadora.getModelo());
                } else if (producto instanceof Tostadora) {
                    Tostadora tostadora = (Tostadora) producto;
                    System.out.println("Marca: " + tostadora.getMarca());
                    System.out.println("Modelo: " + tostadora.getModelo());
                } else if (producto instanceof Licuadora) {
                    Licuadora licuadora = (Licuadora) producto;
                    System.out.println("Potencia: " + licuadora.getPotencia() + " vatios");
                    System.out.println("Capacidad: " + licuadora.getCapacidad() + " litros");
                }
    
               
                // Eliminar el producto del arreglo
                for (int j = i; j < numProductos - 1; j++) {
                    productos[j] = productos[j + 1];
                }
                productos[numProductos - 1] = null;
                numProductos--;
                
                // Eliminar el producto del archivo
                actualizarArchivo(producto);

                eliminado = true;   
                break;
            }
        }
       return eliminado;
   
    }

    private void actualizarArchivo(Producto productoEliminado) {
    String archivo = ruta+"/productos.txt"; // Archivo por defecto
    if (productoEliminado instanceof Libro) {
        archivo = ruta+"/libro.txt";
    } else if (productoEliminado instanceof Celular) {
        archivo = ruta+"/celular.txt";
    } else if (productoEliminado instanceof Television) {
        archivo = ruta+"/television.txt";
    } else if (productoEliminado instanceof Calculadora) {
        archivo = ruta+"/calculadora.txt";
    }else if (productoEliminado instanceof Licuadora) {
        archivo = ruta+"/licuadora.txt";
    }else if (productoEliminado instanceof Tostadora) {
        archivo = ruta+"/tostadora.txt";
    }else if (productoEliminado instanceof Camisetapromocional) {
        archivo = ruta+"/camisetapromocional.txt";
    }
    

    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String[] lineas = new String[100]; // Asumiendo un máximo de 100 líneas
        int count = 0;
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(",");
            String nombreProducto = partes[1].trim(); // Asumiendo que el nombre del producto está en la segunda posición
            if (!nombreProducto.equalsIgnoreCase(productoEliminado.getNombre())) {
                lineas[count++] = linea;
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (int i = 0; i < count; i++) {
                bw.write(lineas[i]);
                bw.newLine();
            }
        }
    } catch (IOException e) {
        System.out.println("Error al actualizar el archivo: " + archivo);
        e.printStackTrace();
    }
}

    public Producto buscarProducto(String nombreProducto) {
        for (int i = 0; i < numProductos; i++) {
            if (productos[i].getNombre().equals(nombreProducto)) {
                return productos[i];
            }
        }
        return null;
    }

    public Producto[] listarProductos() {
        Producto[] lista = new Producto[numProductos];
    for (int i = 0; i < numProductos; i++) {
        lista[i] = productos[i];

        // Mostrar las propiedades específicas de cada producto
        Producto producto = lista[i];
        System.out.println("Nombre: " + producto.getNombre());
        System.out.println("Precio: $" + producto.getPrecio());

        if (producto instanceof Libro) {
            Libro libro = (Libro) producto;
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Páginas: " + libro.getNumeroPaginas());
        } else if (producto instanceof Celular) {
            Celular celular = (Celular) producto;
            System.out.println("Marca: " + celular.getMarca());
            System.out.println("Modelo: " + celular.getModelo());
        } else if (producto instanceof Television) {
            Television televisor = (Television) producto;
            System.out.println("Tamaño: " + televisor.getTamanio() + " pulgadas");
        } else if (producto instanceof Licuadora) {
            Licuadora licuadora = (Licuadora) producto;
            System.out.println("Potencia: " + licuadora.getPotencia() + " vatios");
            System.out.println("Capacidad: " + licuadora.getCapacidad() + " litros");
        }
        System.out.println(); // Línea en blanco para separar productos
    }
    return lista;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void actualizarProducto(Producto producto) {
        // Actualizar el producto en el arreglo
        for (int i = 0; i < numProductos; i++) {
            if (productos[i].getNombre().equalsIgnoreCase(producto.getNombre())) {
                productos[i] = producto;
                break;
            }
        }
        // Actualizar el producto en el archivo
        String archivo = ruta+"/productos.txt"; // Archivo por defecto
        if (producto instanceof Libro) {
            archivo = ruta+"/libro.txt";
        } else if (producto instanceof Celular) {
            archivo = ruta+"/celular.txt";
        } else if (producto instanceof Television) {
            archivo = ruta+"/television.txt";
        } else if (producto instanceof Calculadora) {
            archivo = ruta+"/calculadora.txt";
        }else if (producto instanceof Licuadora) {
            archivo = ruta+"/licuadora.txt";
        }else if (producto instanceof Tostadora) {
            archivo = ruta+"/tostadora.txt";
        }else if (producto instanceof Camisetapromocional) {
            archivo = ruta+"/camisetapromocional.txt";
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        String[] lineas = new String[100]; // Asumiendo un máximo de 1000 líneas
        int count = 0;
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(",");
            String nombreProducto = partes[1].trim(); // Asumiendo que el nombre del producto está en la segunda posición
            if (nombreProducto.equalsIgnoreCase(producto.getNombre())) {
                lineas[count++] = producto.toString();
            } else {
                lineas[count++] = linea;
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (int i = 0; i < count; i++) {
                bw.write(lineas[i]);
                bw.newLine();
            }
        }
        } catch (IOException e) {
            System.out.println("Error al actualizar el archivo: " + archivo);
            e.printStackTrace();
        }

    }

    public void mostrarFamiliaProducto(String familia) {
        System.out.println("Productos de la familia: " + familia);
        for (int i = 0; i < numProductos; i++) {
            
            if (productos[i].getFamilia().toLowerCase().contains(familia.toLowerCase())) {
                System.out.println(productos[i].obtenerDetalles());
                
            }
            
        }
    }

    public void cargarProductos(String strProducto) {
       
        String archivo = ruta+"/" + strProducto.toLowerCase() + ".txt";
        
        try(BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea = br.readLine();
            
            while (linea != null) {
                Producto producto = null; 
                //split separa la linea en partes
                String[] partes = linea.split(",");
                //verifica que la cantidad de partes sea la esperada
                int atributosEsperados = getAtributosEsperados(strProducto);
                if(partes.length !=  atributosEsperados){
                    System.err.println("Línea malformada en " + archivo + ": " + linea);
                    linea = br.readLine();
                    continue;
                }
                try{
                    switch(strProducto){
                        case "Libro":
                            producto = Libro.fromString(partes);
                            break;
                        case "Celular": 
                            producto = Celular.fromString(partes);
                            break;
                        case "Television":
                            producto = Television.fromString(partes);
                            break;
                        case "Calculadora":
                            producto = Calculadora.fromString(partes);
                            break;
                        case "Licuadora":   
                            producto = Licuadora.fromString(partes);
                            break;
                        case "Tostadora": 
                            producto = Tostadora.fromString(partes);
                            break;
                        case "CamisetaPromocional":
                            producto = Camisetapromocional.fromString(partes);
                            break;
                    }
                    if (producto != null) {
                        if (numProductos < productos.length) {
                            productos[numProductos++] = producto;
                            registros++;
                        } else {
                            System.out.println("Inventario lleno, no se puede cargar el producto: " + producto.getNombre());
                        }
                    }
                }
                catch(NumberFormatException e){
                    System.err.println("Error al convertir número: " + e.getMessage());
                }
                linea = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo: " + archivo);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + archivo);
        }
    }

    public void guardarProductos(Producto producto){
            String archivo = "";
            String linea = "";
            if (producto instanceof Libro) {
                Libro libro = (Libro) producto;
                archivo = ruta+"/libro.txt";
            
                linea =  libro.toString();
            } else if (producto instanceof Celular) {
                Celular celular = (Celular) producto;
                archivo = ruta+"/celular.txt";
                
                linea = celular.toString();
            } else if (producto instanceof Television) {
                Television televisor = (Television) producto;
                archivo = ruta+"/television.txt";
               
                linea = televisor.toString();
            }else if (producto instanceof Calculadora) {
                Calculadora calculadora = (Calculadora) producto;
                archivo = ruta+"/calculadora.txt";
                
                linea =calculadora.toString(); 
            } else if (producto instanceof Licuadora) {
                Licuadora licuadora = (Licuadora) producto;
                archivo = ruta+"/licuadora.txt";
                
                linea = licuadora.toString();
            }else if(producto instanceof Tostadora){
                Tostadora tostadora = (Tostadora) producto;
                archivo = ruta+"/tostadora.txt";
               
                linea =tostadora.toString();
            }else if(producto instanceof Camisetapromocional){
                Camisetapromocional camiseta = (Camisetapromocional) producto;
                archivo = ruta+"/camisetapromocional.txt";
                
                linea =camiseta.toString();
            }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(archivo,true))) {
            
                bw.write(linea);
                bw.newLine();
                registros++;
               
            
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + archivo);
            e.printStackTrace();
        }
    }
    private int getAtributosEsperados(String strProducto) {
        switch (strProducto) {
            case "Calculadora":
                return 11;
            case "CamisetaPromocional":
                return 7;
            case "Celular":
                return 15;

            case "Libro":
                return 11;
            case "Licuadora":
                return 12;
            
            case "Television":
                return 13;
            case "Tostadora":
                return 11;
            
            default:
                throw new IllegalArgumentException("Tipo de producto desconocido: " + strProducto);
        }
    }
}