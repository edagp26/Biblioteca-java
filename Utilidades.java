
public class Utilidades {
    
    public static String convertirNumeroATexto(int numero) {
        if (numero == 0) {
            return "cero";
        }
        
        if (numero < 0) {
            return "menos " + convertirNumeroATexto(-numero);
        }
        
        if (numero <= 30) {
            // Números del 1 al 30
            return switch (numero) {
                case 1 -> "uno";
                case 2 -> "dos";
                case 3 -> "tres";
                case 4 -> "cuatro";
                case 5 -> "cinco";
                case 6 -> "seis";
                case 7 -> "siete";
                case 8 -> "ocho";
                case 9 -> "nueve";
                case 10 -> "diez";
                case 11 -> "once";
                case 12 -> "doce";
                case 13 -> "trece";
                case 14 -> "catorce";
                case 15 -> "quince";
                case 16 -> "dieciséis";
                case 17 -> "diecisiete";
                case 18 -> "dieciocho";
                case 19 -> "diecinueve";
                case 20 -> "veinte";
                case 21 -> "veintiuno";
                case 22 -> "veintidós";
                case 23 -> "veintitrés";
                case 24 -> "veinticuatro";
                case 25 -> "veinticinco";
                case 26 -> "veintiséis";
                case 27 -> "veintisiete";
                case 28 -> "veintiocho";
                case 29 -> "veintinueve";
                case 30 -> "treinta";
                default -> "Número fuera de rango"; 
            };
        }
        
        if (numero <= 99) {
            // Números del 31 al 99
            int decena = numero / 10;
            int unidad = numero % 10;
            
            String textoDecena = "";
            
            switch (decena) {
                case 3 -> textoDecena = "treinta";
                case 4 -> textoDecena = "cuarenta";
                case 5 -> textoDecena = "cincuenta";
                case 6 -> textoDecena = "sesenta";
                case 7 -> textoDecena = "setenta";
                case 8 -> textoDecena = "ochenta";
                case 9 -> textoDecena = "noventa";
            }
            
            if (unidad == 0) {
                return textoDecena;
            } else {
                return textoDecena + " y " + convertirNumeroATexto(unidad);
            }
        }
        
        if (numero <= 999) {
            // Números del 100 al 999
            int centena = numero / 100;
            int resto = numero % 100;
            
            String textoCentena = "";
            
            switch (centena) {
                case 1 -> textoCentena = resto == 0 ? "cien" : "ciento";
                case 2 -> textoCentena = "doscientos";
                case 3 -> textoCentena = "trescientos";
                case 4 -> textoCentena = "cuatrocientos";
                case 5 -> textoCentena = "quinientos";
                case 6 -> textoCentena = "seiscientos";
                case 7 -> textoCentena = "setecientos";
                case 8 -> textoCentena = "ochocientos";
                case 9 -> textoCentena = "novecientos";
            }
            
            if (resto == 0) {
                return textoCentena;
            } else {
                return textoCentena + " " + convertirNumeroATexto(resto);
            }
        }
        
        return "número fuera de rango";
    }
    
    /**
     * Muestra el menú principal
     */
    public static void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE GESTIÓN DE BIBLIOTECA ===");
        System.out.println("1. Agregar libro/Revista");
        System.out.println("2. Ver elementos disponibles");
        System.out.println("3. Prestar elemento");
        System.out.println("4. Devolver elemento");
        System.out.println("5. Ver elementos prestados");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }
}