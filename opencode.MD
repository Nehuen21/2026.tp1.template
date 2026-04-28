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

# Issue: Soporte para Libro Físico y E-book

## Descripcion
Crear las clases LibroFisico y Ebook como subtipos de Libro. Ambos deben poder registrarse y distinguirse dentro del sistema.

---

## To Do List (Nivel Inicial - Parte 1: Bases)

- [ ] 1. Analizar cómo implementar herencia/subtipos (extender record o usar interfaz)
- [ ] 2. Crear clase `LibroFisico` con atributos específicos (ej: condicion, ubicacion)
- [ ] 3. Crear clase `Ebook` con atributos específicos (ej: formato, tamanoArchivo)
- [ ] 4. Actualizar `LibroRepository` para manejar ambos tipos
- [ ] 5. Actualizar `LibroService` para validar y registrar subtipos
- [ ] 6. Actualizar Main para probar registro de ambos tipos
- [ ] 7. Compilar y verificar que funcione correctamente