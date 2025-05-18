import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase Biblioteca que maneja la colección de libros y revistas
 */
public class Biblioteca {
    private ArrayList<Padre> coleccion;
    private final String ARCHIVO_DATOS = "biblioteca.txt";
    
    /**
     * Constructor de la clase Biblioteca
     */
    public Biblioteca() {
        coleccion = new ArrayList<>();
        cargarDatos(this.ARCHIVO_DATOS);
    }
    
    /**
     * Agrega un elemento a la colección
     * @param elemento Elemento a agregar (libro o revista)
     */
    public void agregarElemento(Padre elemento) {
        coleccion.add(elemento);
    }
    
    /**
     * Muestra todos los elementos disponibles
     */
    public void mostrarDisponibles() {
        System.out.println("\n=== ELEMENTOS DISPONIBLES ===");
        boolean hayDisponibles = false;
        
        for (Padre elemento : coleccion) {
            if (elemento.isDisponible()) {
                System.out.println(elemento.mostrarInfo());
                hayDisponibles = true;
            }
        }
        
        if (!hayDisponibles) {
            System.out.println("No hay elementos disponibles actualmente.");
        }
    }
    
    /**
     * Muestra todos los elementos prestados con los días en letras
     */
    public void mostrarPrestados() {
        System.out.println("\n=== ELEMENTOS PRESTADOS ===");
        boolean hayPrestados = false;
        
        for (Padre elemento : coleccion) {
            if (!elemento.isDisponible()) {
                System.out.println(elemento.mostrarInfo().replace(
                    "Días prestado: " + elemento.getDiasPrestado(),
                    "Días prestado: " + Utilidades.convertirNumeroATexto(elemento.getDiasPrestado())
                ));
                hayPrestados = true;
            }
        }
        
        if (!hayPrestados) {
            System.out.println("No hay elementos prestados actualmente.");
        }
    }
    
    /**
     * Realiza el préstamo de un elemento
     */
    public void prestarElemento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese el código del elemento a prestar: ");
        String codigo = scanner.nextLine();

        Padre elemento = buscarElementoPorCodigo(codigo);

        if (elemento == null) {
            System.out.println("El elemento con código " + codigo + " no existe.");
            return;
        }

        if (!elemento.isDisponible()) {
            System.out.println("El elemento ya está prestado.");
            return;
        }

        System.out.print("Ingrese la cantidad de días del préstamo: ");
        int dias;
        try {
            dias = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Debe ingresar un número entero para los días.");
            return;
        }

        // Sumar los días actuales con los nuevos
        int totalDias = elemento.getDiasPrestado() + dias;

        elemento.prestar();
        elemento.setDiasPrestado(totalDias); 
        guardarDatos(); 

        System.out.println("Préstamo realizado con éxito por " + dias + " días. Total acumulado: " + totalDias + " días.");
    }


    
    /**
     * Realiza la devolución de un elemento
     */
    public void devolverElemento() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese el código del elemento a devolver: ");
        String codigo = scanner.nextLine();

        Padre elemento = buscarElementoPorCodigo(codigo);

        if (elemento == null) {
            System.out.println("El elemento con código " + codigo + " no existe.");
            return;
        }

        if (elemento.isDisponible()) {
            System.out.println("El elemento no está prestado.");
            return;
        }

        System.out.print("¿Cuántos días estuvo prestado?: ");
        int dias = Integer.parseInt(scanner.nextLine());

        boolean devuelto = elemento.diasPrestado(dias);

        if (devuelto) {
            System.out.println("Devolución realizada con éxito.");
        } else {
            System.out.println("No se pudo realizar la devolución.");
        }
    }

    
    /**
     * Busca un elemento por su código
     * @param codigo Código del elemento a buscar
     * @return El elemento encontrado o null si no existe
     */
    private Padre buscarElementoPorCodigo(String codigo) {
        for (Padre elemento : coleccion) {
            if (elemento.getCodigo().equalsIgnoreCase(codigo)) {
                return elemento;
            }
        }
        return null;
    }
    
    /**
     * Carga los datos desde el archivo
     */
    public void cargarDatos(String ARCHIVO_DATOS) {
        File archivo = new File(ARCHIVO_DATOS);
        
        if (!archivo.exists()) {
            System.out.println("Archivo de datos no encontrado. Se creará uno nuevo al guardar.");
            // Agregar algunos elementos de ejemplo
            agregarElementosEjemplo();
            return;
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                
                if (partes.length < 5) continue; // Ignorar líneas mal formateadas
                
                String tipo = partes[0];
                String codigo = partes[1];
                String titulo = partes[2];
                boolean disponible = Boolean.parseBoolean(partes[3]);
                int diasPrestado = Integer.parseInt(partes[4]);
                
                Padre elemento = null;
                
                switch (tipo) {
                    case "LIBRO_FISICO":
                        if (partes.length >= 7) {
                            String autor = partes[5];
                            int numeroPaginas = Integer.parseInt(partes[6]);
                            elemento = new LibroFisico(codigo, titulo, autor, numeroPaginas);
                        }
                        break;
                    case "LIBRO_DIGITAL":
                        if (partes.length >= 8) {
                            String autor = partes[5];
                            String formato = partes[6];
                            double tamanioMB = Double.parseDouble(partes[7]);
                            elemento = new LibroDigital(codigo, titulo, autor, formato, tamanioMB);
                        }
                        break;
                    case "REVISTA":
                        if (partes.length >= 8) {
                            String editorial = partes[5];
                            int numero = Integer.parseInt(partes[6]);
                            int anio = Integer.parseInt(partes[7]);
                            elemento = new Revista(codigo, titulo, editorial, numero, anio);
                        }
                        break;
                }
                
                if (elemento != null) {
                    elemento.setDisponible(disponible);
                    elemento.setDiasPrestado(diasPrestado);
                    coleccion.add(elemento);
                }
            }
            System.out.println("Datos cargados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }
    
    /**
     * Guarda los datos en el archivo
     */
    public void guardarDatos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO_DATOS))) {
            for (Padre elemento : coleccion) {
                bw.write(elemento.toFileString());
                bw.newLine();
            }
            System.out.println("\nDatos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }
    
    /**
     * Agrega elementos de ejemplo a la colección
     */
    private void agregarElementosEjemplo() {
        // Agregar un libro físico de ejemplo
        agregarElemento(new LibroFisico("001", "Cien Años de Soledad", "Gabriel García Márquez", 432));
        
        // Agregar un libro digital de ejemplo
        agregarElemento(new LibroDigital("002", "Don Quijote de la Mancha", "Miguel de Cervantes", "PDF", 8.5));
        
        // Agregar una revista de ejemplo
        agregarElemento(new Revista("003", "National Geographic", "National Geographic Society", 253, 2023));
    }

    public void agregarNuevoElemento() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el tipo de elemento a agregar:");
        System.out.println("1. Libro Físico");
        System.out.println("2. Libro Digital");
        System.out.println("3. Revista");
        System.out.print("Opción: ");
        int opcion = Integer.parseInt(scanner.nextLine());

        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        switch (opcion) {
            case 1:
                System.out.print("Autor: ");
                String autorFisico = scanner.nextLine();
                System.out.print("Número de páginas: ");
                int numPaginas = Integer.parseInt(scanner.nextLine());
                agregarElemento(new LibroFisico(codigo, titulo, autorFisico, numPaginas));
                System.out.println("✅ Libro físico agregado.");
                break;
            case 2:
                System.out.print("Autor: ");
                String autorDigital = scanner.nextLine();
                System.out.print("Formato (PDF, EPUB, etc.): ");
                String formato = scanner.nextLine();
                System.out.print("Tamaño en MB: ");
                double tamanio = Double.parseDouble(scanner.nextLine());
                agregarElemento(new LibroDigital(codigo, titulo, autorDigital, formato, tamanio));
                System.out.println("✅ Libro digital agregado.");
                break;
            case 3:
                System.out.print("Nombre de la editorial: ");
                String editorial = scanner.nextLine();
                System.out.print("Numero de la revista: ");
                int numero = Integer.parseInt(scanner.nextLine());
                System.out.print("Año de publicación: ");
                int anio = Integer.parseInt(scanner.nextLine());
                agregarElemento(new Revista(codigo, titulo, editorial, numero,anio));
                System.out.println("✅ Revista agregada.");
                break;
            default:
                System.out.println("❌ Opción no válida.");
        }
    }


}