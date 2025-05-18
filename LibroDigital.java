/**
 * Clase LibroDigital que extiende de Padre para representar libros digitales
 */
public class LibroDigital extends Padre {
    private String autor;
    private String formato; // PDF, EPUB, etc.
    private double tamanioMB;
    
    /**
     * Constructor de la clase LibroDigital
     * @param codigo Código único del libro
     * @param titulo Título del libro
     * @param autor Autor del libro
     * @param formato Formato del libro digital
     * @param tamanioMB Tamaño en MB del archivo
     */
    public LibroDigital(String codigo, String titulo, String autor, String formato, double tamanioMB) {
        super(codigo, titulo);
        this.autor = autor;
        this.formato = formato;
        this.tamanioMB = tamanioMB;
    }
    
    /**
     * Método para mostrar información específica del libro digital
     * @return String con la información del libro digital
     */
    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + ", Autor: " + autor + 
               ", Formato: " + formato + ", Tamaño: " + tamanioMB + "MB (Libro Digital)";
    }
    
    // Getters y setters específicos
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public String getFormato() {
        return formato;
    }
    
    public void setFormato(String formato) {
        this.formato = formato;
    }
    
    public double getTamanioMB() {
        return tamanioMB;
    }
    
    public void setTamanioMB(double tamanioMB) {
        this.tamanioMB = tamanioMB;
    }
    
    /**
     * Convierte el libro digital a formato de texto para guardar en archivo
     * @return String con la representación del libro digital
     */
    @Override
    public String toFileString() {
        return "LIBRO_DIGITAL;" + super.toFileString() + ";" + autor + ";" + formato + ";" + tamanioMB;
    }
}