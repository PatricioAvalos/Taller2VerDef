package taller2;

// Clase ListaPrestamos
public class ListaPrestamos {
    
    // Atributos
    private int cantPrestamos;
    private int max;
    private Prestamo[] prestamos;

    // Constructor
    public ListaPrestamos(int max) {
        this.max = max;
        this.cantPrestamos = 0;
        this.prestamos = new Prestamo[max];
    }
    
    // Get Cantidad de Prestamos
    public int getCantPrestamos() {
        return cantPrestamos;
    }
    
    // IngresarPrestamo: Función que ingresa un objeto prestamo del tipo "prestamo" 
    public boolean ingresarPrestamo (Prestamo prestamo){
       if(cantPrestamos < max){
           prestamos[cantPrestamos] = prestamo;
           cantPrestamos++;
           return true;
       }else{
           return false;
       }
    }
    
    // GetPrestamoI: Función que retorna un prestamo que se ubica una posición i 
    public Prestamo getPrestamoI(int i) {
        if (i >= 0 && i < cantPrestamos){
            return prestamos[i];
        }
        else{
            return null;
        }
    }
    
    // EncontrarPrestamo: Función que busca un Prestamo usando un Cod Unico
    // Retorna un objeto del tipo prestamo si lo encuentra 
    public Prestamo encontrarPrestamo(int Codigo) {
        int j;
        for(j=0; j<cantPrestamos; j++) {
            if( prestamos[j].getCodigoUnico()==Codigo){
                break; // sale del loop
            }
        }
        
        if(j == cantPrestamos) {
        return null; // No lo encontró
        }
        else{
        return prestamos[j]; // Lo encontró
        }
    }
    
}
