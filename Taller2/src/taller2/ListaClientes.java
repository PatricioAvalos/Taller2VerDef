package taller2;

// Clase ListaClientes
public class ListaClientes {
    
    // Atributos
    private int cantClientes;
    private int max;
    private Cliente[] clientes;
    
    // Constructor
    public ListaClientes(int max) {
        this.max          = max;
        this.cantClientes = 0;
        this.clientes     = new Cliente[max];
    }
    
    // Get Cantidad de Clientes
    public int getCantClientes() {
        return cantClientes;
    }
    
    // IngresarCliente: Función que ingresa un objeto cliente del tipo "Cliente"
    public boolean ingresarCliente (Cliente cliente){
       if(cantClientes < max){
           clientes[cantClientes] = cliente;
           cantClientes++;
           return true;
       }else{
           return false;
       }
    }
    
    // GetClienteI: Función que retorna un cliente que se ubica una posición i 
    public Cliente getClienteI(int i) {
        if (i >= 0 && i < cantClientes){
            return clientes[i];
        }
        else{
            return null;
        }
    }
    
    // EncontrarCliente: Función que busca un cliente usando un Rut
    // Retorna un objeto del tipo cliente si lo encuentra
    public Cliente encontrarCliente(String Rut) {
        int j;
        for(j=0; j<cantClientes; j++) {
            if( clientes[j].getRut().equals(Rut) ){
                break; // sale del loop
            }
        }
        
        if(j == cantClientes) {
        return null; // No la encontró
        }
        else{
        return clientes[j]; // La encontró
        }
    }
    
}
