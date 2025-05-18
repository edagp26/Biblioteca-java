/**
 * Clase LibroFisico que extiende de Padre para representar libros físicos
 */
public class LibroFisico extends Padre {
    private String autor;
    private int numeroPaginas;
    
    /**
     * Constructor de la clase LibroFisico
     * @param codigo Código único del libro
     * @param titulo Título del libro
     * @param autor Autor del libro
     * @param numeroPaginas Número de páginas del libro
     */
    public LibroFisico(String codigo, String titulo, String autor, int numeroPaginas) {
        super(codigo, titulo);
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
    }
    
    /**
     * Método para mostrar información específica del libro físico
     * @return String con la información del libro físico
     */
    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + ", Autor: " + autor + 
               ", Número de páginas: " + numeroPaginas + " (Libro Físico)";
    }
    
    // Getters y setters específicos
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public int getNumeroPaginas() {
        return numeroPaginas;
    }
    
    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
    
    /**
     * Convierte el libro físico a formato de texto para guardar en archivo
     * @return String con la representación del libro físico
     */
    @Override
    public String toFileString() {
        return "LIBRO_FISICO;" + super.toFileString() + ";" + autor + ";" + numeroPaginas;
    }
}