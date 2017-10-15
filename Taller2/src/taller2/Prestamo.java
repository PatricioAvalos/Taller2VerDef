package taller2;

// Clase Prestamo
public class Prestamo {
    
    // Atributos
    private int codigoUnico;
    private String fechaPrestamo;
    private String fechaDevEst;
    private String fechaDevReal;
    private Cliente cliente;
    private Libro libro;

    // Constructor
    public Prestamo(int codigoUnico, String fechaPrestamo, String fechaDevEst, String fechaDevReal, Cliente cliente, Libro libro) {
        this.codigoUnico = codigoUnico;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevEst = fechaDevEst;
        this.fechaDevReal = fechaDevReal;
        this.cliente = cliente;
        this.libro = libro;
    }
    
    // Gets y Sets
    public int getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(int codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevEst() {
        return fechaDevEst;
    }

    public void setFechaDevEst(String fechaDevEst) {
        this.fechaDevEst = fechaDevEst;
    }

    public String getFechaDevReal() {
        return fechaDevReal;
    }

    public void setFechaDevReal(String fechaDevReal) {
        this.fechaDevReal = fechaDevReal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
    
    
}
