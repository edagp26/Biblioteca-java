import java.util.Scanner;

/**
 * Clase principal que contiene el método main
 */
public class Main {
    
    /**
     * Método principal para ejecutar la aplicación
     * @param args Argumentos de línea de comandos (no utilizados)
     */

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        boolean continuar = true;
        
        System.out.println("Bienvenido al Sistema de Gestión de Biblioteca");
        
        while (continuar) {
            Utilidades.mostrarMenu();
            
            try {
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                switch (opcion) {
                    case 1 -> biblioteca.agregarNuevoElemento();
                    case 2 -> biblioteca.mostrarDisponibles();
                    case 3 -> biblioteca.prestarElemento();
                    case 4 -> biblioteca.devolverElemento();
                    case 5 -> biblioteca.mostrarPrestados();
                    case 6 -> {
                        System.out.println("\nGuardando datos antes de salir...");
                        biblioteca.guardarDatos();
                        System.out.println("¡Gracias por usar el Sistema de Gestión de Biblioteca!");
                        continuar = false;
                    }
                    default -> System.out.println("\nOpción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("\nError: Entrada no válida. Intente de nuevo.");
                scanner.nextLine(); // Limpiar el buffer de entrada
            }
        }
        
        scanner.close();
    }
}