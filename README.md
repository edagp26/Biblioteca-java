
# Biblioteca Java

Sistema de gestión de una biblioteca en consola, desarrollado en Java. Permite:
- Registrar y almacenar diferentes tipos de elementos (libros físicos, libros digitales y revistas).  
- Prestar y devolver elementos, llevando control de días de préstamo.  
- Cargar y guardar el estado en un archivo de texto (`biblioteca.txt`).

---

## 📂 Estructura del proyecto

```
/mi-proyecto
├── src
│   ├── Padre.java
│   ├── LibroFisico.java
│   ├── LibroDigital.java
│   ├── Revista.java
│   ├── Biblioteca.java
│   ├── Utilidades.java
│   └── Main.java
└── biblioteca.txt       ← Archivo de datos (se crea al primer guardado)
```

- **Padre.java**: Clase base con atributos comunes (`codigo`, `titulo`, `disponible`, `diasPrestado`).  
- **LibroFisico.java**: Extiende `Padre`, añade `autor` y `numeroPaginas`.  
- **LibroDigital.java**: Extiende `Padre`, añade `autor`, `formato` y `tamanioMB`.  
- **Revista.java**: Extiende `Padre`, añade `editorial`, `numeroEdicion` y `anioPublicacion`.  
- **Biblioteca.java**: Contiene la colección (`ArrayList<Padre>`), métodos para cargar/guardar datos, buscar, prestar, devolver y agregar nuevos elementos.  
- **Utilidades.java**: Menú y utilidades de entrada/salida.  
- **Main.java**: Arranca la aplicación y gestiona el menú principal.

---

## ⚙️ Requisitos

- Java 14 o superior (para usar *switch expressions* si las tienes).  
- JDK instalado (javac + java).  
- IDE o editor de texto (Eclipse, IntelliJ IDEA, VSCode con Extension Pack for Java, etc.).

---

## 🚀 Compilar y ejecutar

1. **Navega** al directorio raíz donde están tus `.java`:

   ```bash
   cd /ruta/a/mi-proyecto/src
   ```

2. **Compila** todo el código:

   ```bash
   javac *.java
   ```

3. **Ejecuta** la aplicación:

   ```bash
   java Main
   ```

   Verás el menú con opciones para:
   1. Mostrar elementos disponibles  
   2. Prestar elemento  
   3. Devolver elemento  
   4. Mostrar todos los elementos  
   5. Agregar nuevo elemento  
   6. Salir

---

## 📋 Uso

- **Prestar**: pide código y días de préstamo; suma los días al historial.  
- **Devolver**: pide código y días prestados; actualiza estado y suma al contador.  
- **Agregar nuevo**: elige tipo (físico, digital, revista) y completa sus datos.  
- **Los cambios** (prestar, devolver, agregar) se guardan en `biblioteca.txt` al terminar la acción.

---

## ✅ Buenas prácticas

- Mantén el archivo `biblioteca.txt` en la misma carpeta que los `.class`.  
- Respeta la estructura y nombres de archivos para que el programa los cargue correctamente.  
- Usa siempre `int` para primitivas (no `Integer`) a menos que necesites valores nulos.  
- Borra los `.class` antes de recompilar para evitar inconsistencias:
  ```bash
  rm *.class
  javac *.java
  ```

---

## 📖 Posibles mejoras

- Migrar a un **build tool** (Maven/Gradle).  
- Añadir manejo de excepciones más robusto (archivos corruptos, entradas inválidas).  
- Soportar búsquedas avanzadas (por autor, año, formato).  
- Exportar e importar en otros formatos (JSON, XML).  
- Interfaz gráfica (JavaFX / Swing).

---

