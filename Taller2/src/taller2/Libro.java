package taller2;

// Clase Libro
public class Libro {
    
    // Atributos
    private String ISBN;
    private String Titulo;
    private String Autor;
    private String AñoPublicacion;
    private ListaPrestamos prestamos;
    
    // Constructor
    public Libro(String ISBN, String Titulo, String Autor, String AñoPublicacion, ListaPrestamos prestamos) {
        this.ISBN = ISBN;
        this.Titulo = Titulo;
        this.Autor = Autor;
        this.AñoPublicacion = AñoPublicacion;
        this.prestamos = prestamos;
    }
    
    // Gets y Sets
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public String getAñoPublicacion() {
        return AñoPublicacion;
    }

    public void setAñoPublicacion(String AñoPublicacion) {
        this.AñoPublicacion = AñoPublicacion;
    }

    public ListaPrestamos getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(ListaPrestamos prestamos) {
        this.prestamos = prestamos;
    }

}
