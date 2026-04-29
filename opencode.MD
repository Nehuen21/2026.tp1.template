# Resumen del Proyecto

**Proyecto**: BiblioTech - Sistema de Gestión de Biblioteca  
**Lenguaje**: Java  
**Modo de trabajo**: Nivel Inicial (iremos evolucionando al Nivel Experto una vez asentadas las bases)

### Donde estamos
Estamos en la **Parte 1: Bases** del sistema. Por ahora usamos:
- Clases simples con getters/setters 
- Usaremos records solo si hace falta
- Listas en memoria (sin Optionals)
- RuntimeException básica (sin jerarquía compleja)
- Clases concretas (sin interfaces ni inyección de dependencias)

### Instrucciones para el agente
- Lee siempre `opencode.MD` al inicio para saber en que etapa estamos
- El agente debe trabajar como COPILOTO para el usuario, la idea no es que genere codigo sino que guie al usuario.
- Cualquier instruction importante o contexto adicional debe agregarse aqui
- Primero pregunta si no entendés algo antes de asumir
- Trabajamos en base al README.MD
-  No puedes modificar ni realizar implementaciones en el codigo a menos que el usuario te lo ordene
- Recuerda con que issue estamos trabajando, en caso de que alucines preguntale al usuario
- El objetivo del uso de agentes es guiarme con un to do list para que no se me escape ninguna consigna ubicada en el 
 Readme
- Luego de cumplir con las rubricas en nivel inicial avanzaremos con las implementaciones para nivel avanzado
- Cada vez que el usuario te pide hacer un commit hazlo bajo el estandar de conventional commits, verifica que estamos
 trabajando sobre la rama adecuada (rama creada a partir del issue que estamos resolviendo, en caso de perderte pregunta.)

---

## Resumen Sesión Anterior (Issue #6)
✅ **Completado**: Registro de libros con datos básicos
- Categoria enum con id y nombre
- Libro record con isbn, titulo, autor, anio, categoria
- LibroRepository con guardar, buscarPorId, buscarTodos
- LibroExistenteException
- LibroService con lógica de registrar()
- Main de prueba - compila y ejecuta correctamente

---

## Resumen Sesión Actual (Issue #7)
✅ **Completado**: Soporte para Libro Físico y E-book
- Interfaz Recurso con isbn() y titulo()
- LibroFisico (record) con condicion, ubicacion
- Ebook (record) con formato, tamanoArchivo
- LibroRepository actualizado para usar Recurso (polimorfismo)
- LibroService.registrar() acepta Recurso
- Main prueba ambos tipos - compila y ejecuta correctamente

---

## Resumen Sesión Anterior (Issue #8)
✅ **Completado**: Búsqueda de libros por título, autor y categoría
- Recurso interface ampliada con autor() y categoria()
- LibroRepository con buscarPorTitulo, buscarPorAutor, buscarPorCategoria
- LibroService expone los métodos de búsqueda
- Búsqueda parcial e ignore case

---

## Resumen Sesión Anterior (Issue #9)
✅ **Completado**: Registro de socios con validación de datos
- TipoSocio enum con limite de libros (ESTUDIANTE 3, DOCENTE 5)
- Socio record con dni, nombre, email, tipo
- SocioRepository con guardar, buscarPorDni, buscarTodos
- SocioExistenteException y EmailInvalidoException
- SocioService con registrar() validando DNI único y email
- Main prueba registro de socios - compila y ejecuta correctamente

---

## Resumen Sesión Anterior (Issue #5)
✅ **Completado**: Categorización de socios - Estudiantes y Docentes
- Interfaz Usuario con dni(), nombre(), email()
- Socio implementa Usuario
- Estudiante (record) con TipoSocio.ESTUDIANTE
- Docente (record) con TipoSocio.DOCENTE
- SocioRepository usa Usuario (polimorfismo)
- SocioService.registrar() acepta Usuario
- Main prueba Socio, Estudiante y Docente

---

# Issue: Registro histórico de prestamos y devoluciones

## Descripcion
Guardar un historial de todas las transacciones realizadas (prestamos y devoluciones) para poder consultarlas posteriormente.

## Issues relacionados del Milestone
- Issue #2: Devolución de libros con cálculo de días de retraso
- Issue #1: Registro de préstamos con verificación de disponibilidad y límites

---

## To Do List (Nivel Inicial - Parte 1: Bases)

- [ ] 1. Crear enum `TipoTransaccion` (PRESTAMO, DEVOLUCION)
- [ ] 2. Crear record `Transaccion` con atributos: id, isbn, dniSocio, tipo, fecha
- [ ] 3. Crear `TransaccionRepository` con métodos: guardar, buscarPorSocio, buscarPorLibro, buscarTodos
- [ ] 4. Crear `HistorialService` para gestionar el historial
- [ ] 5. Actualizar Main para probar registro de transacciones
- [ ] 6. Compilar y verificar