# Resumen del Proyecto

**Proyecto**: BiblioTech - Sistema de Gestión de Biblioteca  
**Lenguaje**: Java  
**Modo de trabajo**: Nivel Inicial (iremos evolucionando al Nivel Experto una vez asentadas las bases)

### Donde estamos
Estamos en la **Parte 1: Bases** del sistema. Por ahora usamos:
- Clases simples con getters/setters (sin Records)
- Listas en memoria (sin Optionals)
- RuntimeException básica (sin jerarquía compleja)
- Clases concretas (sin interfaces ni inyección de dependencias)

### Instrucciones para el agente
- Lee siempre `opencode.MD` al inicio para saber en que etapa estamos
- Cualquier instruction importante o contexto adicional debe agregarse aqui
- Primero pregunta si no entendés algo antes de asumir

---

# Issue: Registro de libros con datos basicos

## Descripcion
Crear la clase Libro con los atributos ISBN, titulo, autor, año y categoria. Implementar la funcionalidad para registrar un libro en el sistema y almacenarlo en memoria.

---

## To Do List (Nivel Inicial - Parte 1: Bases)

- [ ] 1. Crear la clase `Categoria` en `com.bibliotech.model` como enum para las categorias de libros
- [ ] 2. Crear la clase `Libro` en `com.bibliotech.model` con atributos: isbn, titulo, autor, anio, categoria ( getters y setters)
- [ ] 3. Crear la clase `LibroRepository` en `com.bibliotech.repository` con metodos: guardar, buscarPorId, buscarTodos (usa List en memoria)
- [ ] 4. Crear la excepcion `LibroExistenteException` en `com.bibliotech.exception` (extiende RuntimeException)
- [ ] 5. Crear la clase `LibroService` en `com.bibliotech.service` con el metodo para registrar libro
- [ ] 6. Implementar metodo registrar() que valide ISBN unico y guarde en repositorio
- [ ] 7. Crear clase `Main` basica para probar el flujo de registro
- [ ] 8. Compilar y verificar que funcione correctamente