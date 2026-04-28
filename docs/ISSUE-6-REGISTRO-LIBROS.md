# Issue #6: Registro de libros con datos básicos

## Descripción
Se implementó la funcionalidad para registrar libros en el sistema con los atributos básicos: ISBN, título, autor, año y categoría.

## Funcionalidades implementadas

### Modelo
- **Categoria** (enum): Define las categorías de libros disponibles
  - CIENCIA, HISTORIA, CIENCIAS_BASICAS, ARTE
  - Cada categoría tiene id y nombre

- **Libro** (record): Entidad inmutable con los datos del libro
  - isbn, titulo, autor, anio, categoria

### Repository
- **LibroRepository**: Manejo de datos en memoria
  - `guardar(Libro)`: Agrega un libro al repositorio
  - `buscarPorId(String isbn)`: Busca un libro por su ISBN
  - `buscarTodos()`: Devuelve todos los libros registrados

### Excepciones
- **LibroExistenteException**: Se lanza cuando se intenta registrar un libro con ISBN ya existente

### Service
- **LibroService**: Lógica de negocio
  - `registrar(Libro)`: Valida ISBN único y guarda en repositorio

### Pruebas
- **Main**: Clase de prueba que registra un libro de ejemplo

## Estado
✅ Completado - Compilación y ejecución exitosa