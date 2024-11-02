package Banco.SistemaBancario;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Fecha {
    // Obtener la fecha y hora actuales
    public static LocalDateTime obtenerFechaHoraActual() {
        return LocalDateTime.now();
    }
    // Obtener la fecha actual como String en un formato específico
    public static String obtenerFechaActual(String formato) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        return obtenerFechaHoraActual().format(formatter);
    }
    // Ejemplo de uso: Obtener la fecha en formato predeterminado
    public static String obtenerFechaActual() {
        return obtenerFechaActual("dd-MM-yyyy HH:mm:ss"); // Formato por defecto
    }
    public String toString() {
        return obtenerFechaActual(); // Por defecto, retorna el formato estándar
    }
}
