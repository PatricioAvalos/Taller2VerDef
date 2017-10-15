package taller2;

// Importacion de librerias
import java.io.*;
import ucn.*;
import java.util.*;
import java.text.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// Clase App
public class App implements IApp{
    
    // Inicializacion Listas
    private ListaClientes  listaClientes;
    private ListaLibros    listaLibros;
    private ListaPrestamos listaPrestamos;
    
    public App(){
        listaClientes  = new ListaClientes(1000);
        listaLibros    = new ListaLibros(1000);
        listaPrestamos = new ListaPrestamos(1000);
    }
    
    // Deuda: Funcion que calcula el factor de una deuda usando un numero de dias como int
    // retorna el valor de una deuda
    public static int Deuda(int NumDias){
        int Deuda;
        int x=0;
        if(NumDias==x){
             return x;
        }
        if(NumDias>=1 && NumDias<=7){
             return Deuda = 100;
        }
        if(NumDias>=8 && NumDias<=14){
             return Deuda = 300;
        }
        else return Deuda = 700;
    }
    
    // ComparadorRangoFechas: Funcion que revisa si esta una fecha en un rango determinado
    // Retorna True si esta dentro del rango, Caso contrario un False
    // Parametros: Fecha  -> Fecha a comparar
    //             FechaA -> Fecha del Primer Tope del rango
    //             FechaB -> Fecha del Ultimo Tope del rango
    // Nota: Si la fecha es igual a los topes ( Ej: Fecha a comparar "13/03/1994" y
    // FechaA es igual a "13/03/1994") lo contara dentro del rango, o sea >= y <=
    // a la Fecha en un intervalo.
    public static boolean ComparadorRangoFechas(Date Fecha, Date FechaA, Date FechaB){
	if(Fecha.after(FechaA) == true && Fecha.before(FechaB)==true || Fecha.equals(FechaA)==true || Fecha.equals(FechaB)){
            return true;
	}
	else{
            return false;}
    }
    
    // DiferenciaDiasDeFechas: Funcion que retorna el resultado de la resta de
    // 2 fechas en dias
    public static int DiferenciaDiasDeFechas(Date FechaInicial, Date FechaFinal) {
        long FechaInicialMs = FechaInicial.getTime();
        long FechaFinalMs   = FechaFinal.getTime();
        long Diferencia     = FechaFinalMs - FechaInicialMs;
        double Dias = Math.floor(Diferencia / (1000 * 60 * 60 * 24));
        return ((int) Dias);
    }
    
    // StringADate: Funcion que convierte un String de formato "dd-MM-yyyy"
    // a un Date
    public static Date StringADate(String Fecha)throws ParseException{
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date FechaSalida         = formato.parse(Fecha);
        return FechaSalida;
    }
    
    // DateAString: Funcion que convierte un Date a String
    // con el formato "dd-MM-yyyy"
    public String DateAString (Date date){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String DateS          = dateFormat.format(date);
        return DateS;
    }
    
    // LeerClientes: funcion que lee un archivo "clientes.txt" y extrae los datos
    // para llevarlos a una lista de clientes
    public void leerClientes(){
        try {
            // Inicializacion Archivo para Lectura
            ArchivoEntrada Clientes = new ArchivoEntrada("clientes.txt");
            
            // Ciclo while que finaliza cuando no haya mas datos
            while(!Clientes.isEndFile()){
                Registro regCliente = Clientes.getRegistro();
                
                // Se obtienen los datos
                String RUT      = regCliente.getString();
                String Nombre   = regCliente.getString();
                String Apellido = regCliente.getString();
                String Celular  = regCliente.getString();
                String Mail     = regCliente.getString();
                
                // Creacion de una lista de prestamos para el objeto cliente
                ListaPrestamos LP = new ListaPrestamos(1000);
                
                // Creacion de Cliente
                Cliente cliente = new Cliente(RUT,Nombre,Apellido,Celular,Mail,LP);
                
                // Se almacena el cliente en la lista clientes
                listaClientes.ingresarCliente(cliente);
            }
            // Cierre del archivo
            Clientes.close();
            
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    // LeerLibros: funcion que lee un archivo "libros.txt" y extrae los datos
    // para llevarlos a una lista de libros
    public void leerLibros(){
        try {
            // Inicializacion Archivo para Lectura
            ArchivoEntrada Libros = new ArchivoEntrada("libros.txt");
            
            // Ciclo while que finaliza cuando no haya mas datos
            while(!Libros.isEndFile()){
                Registro regLibro = Libros.getRegistro();
                
                // Se obtienen los datos
                String ISBN   = regLibro.getString();
                String Titulo = regLibro.getString();
                String Autor  = regLibro.getString();
                String Año    = regLibro.getString();
                
                // Creacion de una lista de prestamos para el objeto libro
                ListaPrestamos LP = new ListaPrestamos(1000);
                
                // Creacion de Libro
                Libro libro = new Libro(ISBN,Titulo,Autor,Año,LP);
                
                // Se almacena el libro en la lista libros
                listaLibros.ingresarLibro(libro);
                }
            // Cierre del archivo
            Libros.close();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    // LeerPrestamos: funcion que lee un archivo "prestamos.txt" y extrae los datos
    // para llevarlos a una lista de prestamos
    public void leerPrestamos(){
        try {
            // Inicializacion Archivo para Lectura
            ArchivoEntrada Prestamos = new ArchivoEntrada("prestamos.txt");
            
            // Ciclo while que finaliza cuando no haya mas datos
            while(!Prestamos.isEndFile()){
                Registro regPrestamo = Prestamos.getRegistro();
                
                // Se obtienen los datos
                int NumReg                      = regPrestamo.getInt();
                String Rut                      = regPrestamo.getString();
                String ISBN                     = regPrestamo.getString();
                String FechaPrestamo            = regPrestamo.getString();
                String FechaDevolucionEstimada  = regPrestamo.getString();
                String FechaDevolucionReal      = regPrestamo.getString();
                
                // Crea un objeto del tipo libro buscando un libro con el ISBN
                Libro libro = listaLibros.encontrarLibro(ISBN);
                // Crea un objeto del tipo cliente buscando un cliente con el Rut
                Cliente cliente = listaClientes.encontrarCliente(Rut);
                
                // Creacion de prestamo
                Prestamo prestamo = new Prestamo(NumReg,FechaPrestamo,FechaDevolucionEstimada,FechaDevolucionReal,cliente,libro);
                // Ingresa Prestamo
                listaPrestamos.ingresarPrestamo(prestamo);
                
                //Busca cliente con ISBN y luego a su lista de prestamos le ingresa un prestamo
                listaClientes.encontrarCliente(Rut).getPrestamos().ingresarPrestamo(prestamo);
                //Busca libro con ISBN y luego a su lista de prestamos le ingresa un prestamo
                listaLibros.encontrarLibro(ISBN).getPrestamos().ingresarPrestamo(prestamo);
                }
            // Cierre del archivo
            Prestamos.close();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    // impDeudaClientes: Procedimiento que con el ingreso del rut de un cliente
    // imprime cada prestamo del cliente con su deuda respectiva
    // y una deuda total.
    public void impDeudaClientes(){
        // Inicializacion Variables
        int i;
        int DeudaTotal=0; // Variable para almacenar el total de deudas
        
        StdOut.println("---------------------------------------------------------------------------");
        StdOut.println("                      Impresion Deuda Cliente");
        StdOut.println("---------------------------------------------------------------------------");
        StdOut.println("Ingrese Rut cliente:");
        String RutIngresado = StdIn.readString();
        if(listaClientes.encontrarCliente(RutIngresado)!=null){
        StdOut.println("");
        StdOut.println("---------------------------------------------------------------------------");
        // Creacion variable "CantidadPrestamos" para almacenar el total de prestamos del cliente
        int CantidadPrestamos = listaClientes.encontrarCliente(RutIngresado).getPrestamos().getCantPrestamos();
        StdOut.println("Cliente: "+listaClientes.encontrarCliente(RutIngresado).getNombre()+" | RUT: "+RutIngresado);
        StdOut.println("---------------------------------------------------------------------------");
        for(i=0;i<CantidadPrestamos;i++){
            try {
                // Inicializacion Objeto tipo Prestamo "P"
                Prestamo P = listaClientes.encontrarCliente(RutIngresado).getPrestamos().getPrestamoI(i);
                
                // Creacion Variable codigo Prestamo
                int CodigoPrestamo = P.getCodigoUnico();
                // Creacion Variables Tipo Date
                Date FechaPrestamo = StringADate(P.getFechaPrestamo());
                Date FechaDevoEstimada = StringADate(P.getFechaDevEst());
                
                // If para verificar si la Fecha de devolucion real es igual a 0
                // o sea, verifica si aun no ha devuelto el libro
                if(P.getFechaDevReal().equals("0")){
                    // Suma una Deuda igual a 0 ya que aun no devuelve el libro
                    int Deuda = 0;
                    DeudaTotal +=Deuda;
                    // Realiza la impresion
                    StdOut.println("CodigoPrestamo: "+CodigoPrestamo+" | FechaPrestamo: "+DateAString(FechaPrestamo)+" | F.Dev.Estimada: "
                            +DateAString(FechaDevoEstimada)+" | F.Dev.Real: No hay");
                    StdOut.println("Diferencia de dias: 0"+" Deuda: $"+Deuda);
                    StdOut.println("---------------------------------------------------------------------------");
                }
                // Caso contrario sumara una deuda con el precio respectivo
                else{
                    Date FechaDevoReal = StringADate(P.getFechaDevReal());
                    int DiferenciaDias = DiferenciaDiasDeFechas(FechaDevoEstimada,FechaDevoReal);
                    int Deuda          = Deuda(DiferenciaDias);
                    int DeudaT         = (DiferenciaDias)*(Deuda);
                    DeudaTotal +=DeudaT;
                    // Realiza la impresion
                    StdOut.println("CodigoPrestamo: "+CodigoPrestamo+" | FechaPrestamo: "+DateAString(FechaPrestamo)
                            +" | F.Dev.Estimada: "+DateAString(FechaDevoEstimada)+" | F.Dev.Real: "+DateAString(FechaDevoReal));
                    StdOut.println("Diferencia de dias: "+DiferenciaDias+" Deuda: $"+DeudaT);
                    StdOut.println("---------------------------------------------------------------------------");
                }
            } catch (ParseException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }
        // Impresion de la deuda total del cliente    
        StdOut.println("Deuda Total: $"+DeudaTotal);
        StdOut.println("---------------------------------------------------------------------------");
    }   else{
        StdOut.println("---------------------------------------------------------------------------");
        StdOut.println("                            Rut no válido");
        StdOut.println("---------------------------------------------------------------------------");}
    }

    // LibroMasSolicitado: Funcion que dado un rango de fechas que se han ingresado por consola
    // imprime el/los libro(s) que más ha(n) sido solicitado(s) durante ese rango
    public void libroMasSolicitado(){
        try {
            // Creacion variables
            int i,j;
            // Creacion Array con ISBNs de libros
            String [] ArrayAuxISBNLibro = new String[listaLibros.getCantLibros()];
            // Creacion Array con cantidades de libros
            int [] ArrayAuxCant = new int[listaLibros.getCantLibros()];
            for (i = 0; i < listaLibros.getCantLibros(); i++) {
                ArrayAuxISBNLibro[i] = listaLibros.getLibroI(i).getISBN();
                ArrayAuxCant[i] = 0;
            }
            
            StdOut.println("---------------------------------------------------------------------------");
            StdOut.println("                      Libro(s) Mas Solicitado(s)");
            StdOut.println("---------------------------------------------------------------------------");

            // Ingresos de Fecha
            StdOut.println("Ingrese Fecha Inicial: ");
            String FechaInicial = StdIn.readString();
            Date FInicial = StringADate(FechaInicial);
            StdOut.println("Ingrese Fecha Final: ");
            String FechaFinal = StdIn.readString();
            Date FFinal = StringADate(FechaFinal);
            
            // Ciclo for que verifica si un libro esta en el rango de fechas ingresadas
            // Si esta en el rango, añade +1 a la cantidad respectiva
            for (i = 0; i < listaLibros.getCantLibros(); i++) {
                for (j = 0; j < listaLibros.getLibroI(i).getPrestamos().getCantPrestamos(); j++) {
                    Date AuxFecha = StringADate(listaLibros.getLibroI(i).getPrestamos().getPrestamoI(j).getFechaPrestamo());
                    if (ComparadorRangoFechas(AuxFecha, FInicial, FFinal)==true) {
                        ArrayAuxCant[i] += 1;
                        
                    }
                }
            }
            
            // Ordenamiento de los arrays
            for(i = 0; i<=ArrayAuxCant.length-2;i++){
                for(j = i+1; j<=ArrayAuxCant.length-1;j++){
                    if(ArrayAuxCant[i]<ArrayAuxCant[j]){
                        
                        String auxISBN; int auxC;
                        
                        auxISBN              = ArrayAuxISBNLibro[i];
                        ArrayAuxISBNLibro[i] = ArrayAuxISBNLibro[j];
                        ArrayAuxISBNLibro[j] = auxISBN;
                        
                        auxC                 = ArrayAuxCant[i];
                        ArrayAuxCant[i]      = ArrayAuxCant[j];
                        ArrayAuxCant[j]      = auxC;
                        
                    }
                }
            }   StdOut.println("");
                StdOut.println("---------------------------------------------------------------------------");
            // Impresion del libro mas solicitado, ademas imprime mas de un libro
            // si mas de un libro son los mas solicitados
            for(i=0;i<ArrayAuxISBNLibro.length;i++){
                Libro L = listaLibros.encontrarLibro(ArrayAuxISBNLibro[i]);
                if(i==0){
                    StdOut.println("Libro(s) Mas Solicitado(s): ");
                    StdOut.println("ISBN: "+ArrayAuxISBNLibro[i]+" | Titulo: "+L.getTitulo()+" | Autor: "
                            +L.getAutor()+" | Año de Publicacion: "+L.getAñoPublicacion()
                            +" | N° de veces solicitado: "+ArrayAuxCant[i]);
                }
                else{
                    if(ArrayAuxCant[i]==ArrayAuxCant[i-1]){
                        StdOut.println("ISBN: "+ArrayAuxISBNLibro[i]+" | Titulo: "+L.getTitulo()+" | Autor: "
                            +L.getAutor()+" | Año de Publicacion: "+L.getAñoPublicacion()
                            +" | N° de veces solicitado: "+ArrayAuxCant[i]);
                    }
                    if(ArrayAuxCant[i]!=ArrayAuxCant[i-1]){break;}
                }
            }
            StdOut.println("---------------------------------------------------------------------------");
        } catch (ParseException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    // PrestamosPendientes: Funcion que genera el archivo Devoluciones_pendientes.txt
    // que contiene los prestamos que aun no han sido devueltos, ademas
    // esta ordenado de la fecha mas antigua a la mas reciente
    public void prestamosPendientes(){
        
        StdOut.println("---------------------------------------------------------------------------");
        StdOut.println("                      Prestamos Pendientes");
        StdOut.println("---------------------------------------------------------------------------");

        // Creacion de variables
        int i,j;
        int cantzero = 0; // Cantidad de Prestamos que aun no han sido devueltos
        int indice   = 0;
        
        // Ciclo For para obtener la cantidad de prestamos que aun no han sido devueltos
        for(i=0;i<listaPrestamos.getCantPrestamos();i++){
            if(listaPrestamos.getPrestamoI(i).getFechaDevReal().equals("0")){
                cantzero++;
            }
        }
        
        // Inicializacion de arrays
        String [] RUTs           = new String[cantzero];
        int  [] CodUnicoPrestamo = new int[cantzero];
        Date [] FechaPrestamo    = new Date[cantzero];
        Date [] FechaDevEstimada = new Date[cantzero];
        
        // Ciclo for que verifica si dentro de la lista de prestamos se encuentran prestamos
        // que aun no han sido devueltos, y añade datos a los arrays
        for(i=0;i<listaPrestamos.getCantPrestamos();i++){
            if(listaPrestamos.getPrestamoI(i).getFechaDevReal().equals("0")){
                RUTs[indice] = listaPrestamos.getPrestamoI(i).getCliente().getRut();
                CodUnicoPrestamo[indice] = listaPrestamos.getPrestamoI(i).getCodigoUnico();
                try {
                    FechaPrestamo[indice]    = StringADate(listaPrestamos.getPrestamoI(i).getFechaPrestamo());
                    FechaDevEstimada[indice] = StringADate(listaPrestamos.getPrestamoI(i).getFechaDevEst());  
                } catch (ParseException ex) {
                    Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                }
                indice++;
            }
        }
        
        // Ordenamiento de los arrays
        for(i = 0; i<=FechaDevEstimada.length-2;i++){
            for(j = i+1; j<=FechaDevEstimada.length-1;j++){
                if(FechaDevEstimada[i].after(FechaDevEstimada[j])){
                
                    Date auxDate; int auxCodU; String auxRut;Date auxDate2;
                    auxDate              = FechaDevEstimada[i];
                    FechaDevEstimada[i]  = FechaDevEstimada[j];
                    FechaDevEstimada[j]  = auxDate;
                    
                    auxDate2             = FechaPrestamo[i];
                    FechaPrestamo[i]     = FechaPrestamo[j];
                    FechaPrestamo[j]     = auxDate2;
                    
                    auxCodU = CodUnicoPrestamo[i];
                    CodUnicoPrestamo[i]  = CodUnicoPrestamo[j];
                    CodUnicoPrestamo[j]  = auxCodU;
                    
                    auxRut  = RUTs[i];
                    RUTs[i] = RUTs[j];
                    RUTs[j] = auxRut;
                }	
            }
        }
        
        try
        {//Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            Writer writer = null;
            writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream("devoluciones_pendientes.txt"), "utf-8"));
        //Escribimos en el archivo con el metodo write
            for(i=0;i<FechaDevEstimada.length;i++){
                if(i==0){
                writer.write("Devoluciones Pendientes"+"\n");
                writer.write("C.U.P. || Fecha Prestamo || "
                        + "Fecha Devolucion Est. || Apellido || Nombre || Celular || Email  || "
                        + "Titulo del Libro"+"\n");
                Cliente C = listaPrestamos.encontrarPrestamo(CodUnicoPrestamo[i]).getCliente();
                String Aux = (CodUnicoPrestamo[i]+" || "
                        +DateAString(FechaPrestamo[i])+" || "+DateAString(FechaDevEstimada[i])
                        +" || "+C.getApellido()+" || "+C.getNombre()
                        +" || "+C.getCelular()+" || "+C.getEmail()
                        +" || "+listaPrestamos.encontrarPrestamo(CodUnicoPrestamo[i]).getLibro().getTitulo()
                        +"\n");
                writer.write(Aux);
                }
                else{
                    Cliente C = listaPrestamos.encontrarPrestamo(CodUnicoPrestamo[i]).getCliente();
                    String Aux = (CodUnicoPrestamo[i]+" || "
                        +DateAString(FechaPrestamo[i])+" || "+DateAString(FechaDevEstimada[i])
                        +" || "+C.getApellido()+" || "+C.getNombre()
                        +" || "+C.getCelular()+" || "+C.getEmail()
                        +" || "+listaPrestamos.encontrarPrestamo(CodUnicoPrestamo[i]).getLibro().getTitulo()
                        +"\n");
                    writer.write(Aux);
                }
            }
            

        //Cerramos la conexion
            writer.close();
        }
        catch(Exception e)
        {
        System.out.println("Error al escribir");
        }
    }
    
}
