package taller2;

// Importacion de librerias
import java.io.*;
import ucn.*;
import java.util.*;
import java.text.*;

// Taller 2
public class Taller2{
    public static void main(String[] args) throws IOException {
        App app = new App();
        app.leerClientes();
        app.leerLibros();
        app.leerPrestamos();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("=========================================");
        System.out.println("                 Taller 2     ");
        System.out.println("=========================================");
        System.out.println(" (1) - Impresion Deuda Cliente");
        System.out.println(" (2) - Libro(s) Mas Solicitado(s)" );
        System.out.println(" (3) - Prestamos Pendientes" );
        System.out.println(" (4) - Salir" );
        
    int op;
        do{  
            System.out.println("\nIngrese una opción del menú: " );
            op = Integer.parseInt(bf.readLine());
            System.out.println("");
            switch(op){
                
                case 1: 
                    app.impDeudaClientes();
                    System.out.println("");
                    System.out.println("=========================================");
                    System.out.println("                 Taller 2     ");
                    System.out.println("=========================================");
                    System.out.println(" (1) - Impresion Deuda Cliente");
                    System.out.println(" (2) - Libro(s) Mas Solicitado(s)" );
                    System.out.println(" (3) - Prestamos Pendientes" ); 
                    System.out.println(" (4) - Salir" );
                    break;
                case 2:
                    app.libroMasSolicitado();
                    System.out.println("");
                    System.out.println("=========================================");
                    System.out.println("                 Taller 2     ");
                    System.out.println("=========================================");
                    System.out.println(" (1) - Impresion Deuda Cliente");
                    System.out.println(" (2) - Libro(s) Mas Solicitado(s)" );
                    System.out.println(" (3) - Prestamos Pendientes" );
                    System.out.println(" (4) - Salir" );
                    break;
                case 3:
                    app.prestamosPendientes();
                    System.out.println("");
                    System.out.println("=========================================");
                    System.out.println("                 Taller 2     ");
                    System.out.println("=========================================");
                    System.out.println(" (1) - Impresion Deuda Cliente");
                    System.out.println(" (2) - Libro(s) Mas Solicitado(s)" );
                    System.out.println(" (3) - Prestamos Pendientes" );
                    System.out.println(" (4) - Salir" );
                    break;
                case 4:
                    System.out.println("Ha salido del programa exitosamente" );
                    break;
                default:
                    System.out.println("OPCIÓN NO VÁLIDA" );
                    break;               
            }
        }while( op != 4 );
     }
    }