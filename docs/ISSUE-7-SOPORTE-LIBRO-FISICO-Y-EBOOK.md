# Issue #7: Soporte para Libro Físico y E-book

## Descripción
Se implementó soporte para dos subtipos de libros: LibroFisico y Ebook, ambos diferenciables dentro del sistema mediante la interfaz Recurso.

## Decisiones de Diseño

### Uso de Interfaz en lugar de Herencia
Los records en Java no pueden extender de otras clases/records, solo implementar interfaces. Por lo tanto:
- Se creó la interfaz `Recurso` con los métodos `isbn()` y `titulo()`
- `Libro`, `LibroFisico` y `Ebook` implementan esta interfaz
- Permite tratar polimórficamente a todos los tipos de recurso

## Funcionalidades implementadas

### Interfaz Recurso
- **Recurso** (interfaz): Contrato base con isbn() y titulo()
  - Implementada por todos los tipos de recurso

### Modelos
- **LibroFisico** (record): Atributos específicos
  - isbn, titulo, autor, anio, categoria, condicion, ubicacion

- **Ebook** (record): Atributos específicos
  - isbn, titulo, autor, anio, categoria, formato, tamanoArchivo

### Repository
- **LibroRepository**: Actualizado para usar `Recurso`
  - `guardar(Recurso)`: Acepta cualquier tipo de recurso
  - `buscarPorId(String isbn)`: Retorna Recurso
  - `buscarTodos()`: Retorna List<Recurso>

### Service
- **LibroService**: Actualizado para usar `Recurso`
  - `registrar(Recurso)`: Valida y guarda cualquier subtipo

### Pruebas
- **Main**: Registra ejemplos de Libro, LibroFisico y Ebook

## Estado
✅ Completado - Compilación y ejecución exitosa