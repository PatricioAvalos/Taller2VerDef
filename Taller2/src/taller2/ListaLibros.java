package taller2;

// Clase ListaLibros
public class ListaLibros {
    
    // Atributos
    private int cantLibros;
    private int max;
    private Libro[] libros;
    
    // Constructor
    public ListaLibros(int max) {
        this.max        = max;
        this.cantLibros = 0;
        this.libros     = new Libro[max];
    }
    
    // Get Cantidad de Libros
    public int getCantLibros() {
        return cantLibros;
    }
    
    // IngresarLibro: Función que ingresa un objeto libro del tipo "Libro"
    public boolean ingresarLibro (Libro libro){
       if(cantLibros < max){
           libros[cantLibros] = libro;
           cantLibros++;
           return true;
       }else{
           return false;
       }
    }
    
    // GetLibroI: Función que retorna un libro que se ubica una posición i 
    public Libro getLibroI(int i) {
        if (i >= 0 && i < cantLibros){
            return libros[i];
        }
        else{
            return null;
        }
    }
    
    // EncontrarCliente: Función que busca un libro usando un ISBN
    // Retorna un objeto del tipo libro si lo encuentra 
    public Libro encontrarLibro(String ISBN) {
        int j;
        for(j=0; j<cantLibros; j++) { 
            if( libros[j].getISBN().equals(ISBN) ){
                break; // sale del loop
            }
        }
        
        if(j == cantLibros) {
        return null; // No lo encontró
        }
        else{
        return libros[j]; // Lo encontró
        }
    }
    
}
