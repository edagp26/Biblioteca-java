
/**
 * Clase Padre que define los atributos básicos para cualquier elemento de la biblioteca
 */
public class Padre {
    protected String codigo;
    protected String titulo;
    protected boolean disponible;
    protected int diasPrestado;
    
    /**
     * Constructor de la clase Padre
     * @param codigo Código único del elemento
     * @param titulo Título del elemento
     */
    public Padre(String codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponible = true;
        this.diasPrestado = 0;
    }
    
    /**
     * Método para prestar un elemento
     * @return true si el préstamo fue exitoso, false si no estaba disponible
     */
    public boolean prestar() {
        if (disponible) {
            disponible = false;
            return true;
        }
        return false;
    }
    
    /**
     * Método para definir a un elemento cuantos dias estuvo prestado
     * @param dias Días que estuvo prestado el elemento
     * @return true si la devolución fue exitosa
     */
    public boolean diasPrestado(int dias) {
        if (!disponible) {
            disponible = true;
            this.diasPrestado = dias;
            return true;
        }
        return false;
    }
    
    /**
     * Método para mostrar información del elemento
     * @return String con la información del elemento
     */
    public String mostrarInfo() {
        return "Código: " + codigo + ", Título: " + titulo + 
                ", Disponible: " + (disponible ? "Sí" : "No") + 
                (disponible ? "" : ", Días prestado: " + diasPrestado);
    }
    
    // Getters y setters
    public String getCodigo() {
        return codigo;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public boolean isDisponible() {
        return disponible;
    }
    
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    public int getDiasPrestado() {
        return diasPrestado;
    }
    
    public void setDiasPrestado(int diasPrestado) {
        this.diasPrestado = diasPrestado;
    }
    
    /**
     * Convierte el objeto a formato de texto para guardar en archivo
     * @return String con la representación del objeto
     */
    public String toFileString() {
        // Formato básico que las subclases extenderán
        return codigo + ";" + titulo + ";" + disponible + ";" + diasPrestado;
    }

    
}
