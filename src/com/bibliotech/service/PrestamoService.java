package com.bibliotech.service;

import com.bibliotech.exception.LimiteDePrestamosException;
import com.bibliotech.exception.SocioExistenteExcepcion;
import com.bibliotech.model.Recurso;
import com.bibliotech.model.TipoTransaccion;
import com.bibliotech.model.Transaccion;
import com.bibliotech.model.Usuario;
import com.bibliotech.repository.LibroRepository;
import com.bibliotech.repository.SocioRepository;
import java.time.LocalDate;
import java.util.List;

public class PrestamoService {
    private final LibroRepository libroRepo;
    private final SocioRepository socioRepo;
    private final HistorialService historialService;
    private static int contador = 1;

    public PrestamoService() {
        this.libroRepo =  LibroRepository.getInstancia();
        this.socioRepo =  SocioRepository.getInstancia();
        this.historialService = HistorialService.getInstancia();
    }

    public void registrarPrestamo(String isbn, int dniSocio) {
        // 1. Verificar libro existe
        Recurso libro = libroRepo.buscarPorId(isbn);
        if (libro == null) {
            throw new IllegalArgumentException("El libro no existe");
        }

        // 2. Verificar socio existe
        Usuario socio = socioRepo.buscarPorDNi(dniSocio);
        if (socio == null) {
            throw new SocioExistenteExcepcion("El socio no existe");
        }

        // 3. Verificar límite del socio
        List<Transaccion> prestamos = historialService.buscarPorSocio(dniSocio);
        long prestamosActivos = prestamos.stream()
            .filter(t -> t.tipo() == TipoTransaccion.PRESTAMO)
            .count();
        int limite = socio.tipo().getLimiteLibros();
        if (prestamosActivos >= limite) {
            throw new LimiteDePrestamosException("El socio superó el límite de préstamos");
        }

        // 4. Registrar transacción
        Transaccion prestamo = new Transaccion(
            generarID(),
            isbn,
            dniSocio,
            TipoTransaccion.PRESTAMO,
            LocalDate.now()
        );
        historialService.registrarTransaccion(prestamo);
    }

    private int generarID() {
        return contador++;
    }
}