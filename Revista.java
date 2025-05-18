/**
 * Clase Revista que extiende de Padre para representar revistas
 */
public class Revista extends Padre {
    private String editorial;
    private int numero;
    private int anio;
    
    /**
     * Constructor de la clase Revista
     * @param codigo Código único de la revista
     * @param titulo Título de la revista
     * @param editorial Editorial de la revista
     * @param numero Número de la revista
     * @param anio Año de publicación
     */
    public Revista(String codigo, String titulo, String editorial, int numero, int anio) {
        super(codigo, titulo);
        this.editorial = editorial;
        this.numero = numero;
        this.anio = anio;
    }
    
    /**
     * Método para mostrar información específica de la revista
     * @return String con la información de la revista
     */
    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + ", Editorial: " + editorial + 
                ", Número: " + numero + ", Año: " + anio + " (Revista)";
    }
    
    // Getters y setters específicos
    public String getEditorial() {
        return editorial;
    }
    
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public int getAnio() {
        return anio;
    }
    
    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    /**
     * Convierte la revista a formato de texto para guardar en archivo
     * @return String con la representación de la revista
     */
    @Override
    public String toFileString() {
        return "REVISTA;" + super.toFileString() + ";" + editorial + ";" + numero + ";" + anio;
    }
}