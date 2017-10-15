package taller2;

// Clase Cliente
public class Cliente {
    
    // Atributos
    private String Rut;
    private String Nombre;
    private String Apellido;
    private String Celular;
    private String Email;
    private ListaPrestamos prestamos;
    
    //Constructor
    public Cliente(String Rut, String Nombre, String Apellido, String Celular, String Email, ListaPrestamos prestamos) {
        this.Rut = Rut;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Celular = Celular;
        this.Email = Email;
        this.prestamos = prestamos;
    }

    // Gets y Sets
    public String getRut() {
        return Rut;
    }

    public void setRut(String Rut) {
        this.Rut = Rut;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public ListaPrestamos getPrestamos() {
        return prestamos;
    }
    
}
