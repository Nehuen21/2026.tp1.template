# Documentación de Diseño - BiblioTech

## Decisiones de Diseño

### 1. Uso de Records para entidades de datos

**Por qué se eligió:** Los records en Java son inmutables por defecto y generan automáticamente métodos como `equals()`, `hashCode()` y `toString()`. Son ideales para entidades que solo transportan datos (DTOs), como `Libro`, `Socio`, `Transaccion`, etc.

**Alternativa considerada:** Clases normales con getters/setters. Descartada porque requiere más código boilerplate y no ofrece beneficios adicionales para datos inmutables.

---

### 2. Interfaz Recurso para polimorfismo de libros

**Por qué se eligió:** Para permitir que `Libro`, `LibroFisico` y `Ebook` sean tratados de forma统一 sin importar su tipo específico. La interfaz `Recurso` define el contrato común (isbn, titulo, autor, categoria).

**Alternativa considerada:** Herencia con clases normales. Descartada porque Java no permite que los records extiendan otras clases, solo implementen interfaces.

---

### 3. Interfaz Usuario para polimorfismo de socios

**Por qué se eligió:** Similar a `Recurso`, permite que `Socio`, `Estudiante` y `Docente` sean tratados de forma統一. La interfaz `Usuario` define dni, nombre, email y tipo.

---

### 4. Repositorios con Singleton

**Por qué se eligió:** Para compartir datos entre diferentes servicios sin necesidad de inyección de dependencias compleja. Cada repositorio tiene una única instancia estática que comparten LibroService, SocioService y PrestamoService.

**Alternativa considerada:**
- Inyección de dependencias (Nivel Experto): Más limpio pero requiere más refactorización
- Crear nuevas instancias en cada service: No funciona porque cada service tendría su propia lista vacía

---

### 5. RuntimeException para excepciones de negocio

**Por qué se eligió:** Las excepciones como `LibroExistenteException`, `SocioExistenteExcepcion`, etc., heredan de RuntimeException para simplificar el manejo de errores. No requieren try-catch obligatorio.

**Alternativa considerada:** Excepciones checked. Descartada porque obligaría a declarar throws en cada método, complicando el código.

---

### 6. Enum para valores fijos

**Por qué se eligió:** Para `Categoria`, `TipoSocio` y `TipoTransaccion`, los enums son ideales porque:
- Son un conjunto fijo de valores
- Garantizan valores válidos
- pueden携带 datos (como el límite de libros en TipoSocio)

---

### 7. Arquitectura por capas (Model - Repository - Service)

**Por qué se eligió:** Separación clara de responsabilidades:
- **Model**: Solo datos (records, enums)
- **Repository**: Acceso a datos (Listas en memoria)
- **Service**: Lógica de negocio y validaciones

Esto sigue el principio de responsabilidad única (SRP) de SOLID.

---

### 8. Transacciones para historial de préstamos

**Por qué se eligió:** Un record `Transaccion` simple con tipo (PRESTAMO/DEVOLUCION) permite mantener el historial de forma sencilla. Cada transacción guarda isbn, dni del socio, tipo y fecha.

**Alternativa considerada:** Clase separada para Préstamo y Devolución. Descartada porque comparte muchos campos y la interfaz `Transaccion` es suficiente.

---

### 9. Cálculo de días de retraso

**Por qué se eligió:** Usar `java.time.temporal.ChronoUnit.DAYS.between()` para calcular la diferencia entre la fecha del préstamo y la fecha actual. Simple y preciso.

---

### 10. Validación de formato de email

**Por qué se eligió:** Validación simple con `contains("@")` y verificación de que hay un punto después del @. Suficiente para el alcance del tp.

---

## Estructura del Proyecto

```
src/com/bibliotech/
├── model/           # Records, Interfaces, Enums
│   ├── Recurso.java      (interfaz)
│   ├── Usuario.java     (interfaz)
│   ├── Libro.java       (record)
│   ├── LibroFisico.java (record)
│   ├── Ebook.java       (record)
│   ├── Socio.java       (record)
│   ├── Estudiante.java  (record)
│   ├── Docente.java     (record)
│   ├── Transaccion.java (record)
│   ├── Categoria.java   (enum)
│   ├── TipoSocio.java   (enum)
│   └── TipoTransaccion.java (enum)
│
├── repository/     # Acceso a datos
│   ├── LibroRepository.java
│   ├── SocioRepository.java
│   └── TransaccionRepository.java
│
├── service/        # Lógica de negocio
│   ├── LibroService.java
│   ├── SocioService.java
│   ├── PrestamoService.java
│   └── HistorialService.java
│
├── exception/      # Excepciones personalizadas
│   ├── LibroExistenteException.java
│   ├── SocioExistenteExcepcion.java
│   ├── EmailInvalidoException.java
│   ├── LibroNoDisponibleException.java
│   └── LimiteDePrestamosException.java
│
└── Main.java       # Punto de entrada
```

---

## Posibles mejoras (Nivel Experto)

1. **Interfaces genéricas para repositories**: Como sugiere el README en la sección 9-B
2. **Inyección de dependencias**: Pasar repositories por constructor usando interfaces
3. **Optional**: Para evitar null en retornos de búsqueda
4. **Jerarquía de excepciones**: Crear clase base `BibliotecaException` de la cual hereden las demás