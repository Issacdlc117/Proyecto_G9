import javax.swing.*;
import java.io.RandomAccessFile;
import java.lang.invoke.LambdaConversionException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GUI_Sqlite_Connection {
    public static void main(String[] args) {
        int numCalles_C = 0;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{

            connection = DriverManager.getConnection( "jdbc:sqlite:C:\\Users\\issac\\Desktop\\EPN\\Cuarto Semestre\\Requerimientos\\Proyecto_Gmaps\\Proyecto_Gmaps\\src\\DB_Gmaps.sqlite" );
            statement = connection.createStatement();


            if ( connection != null ){

                System.out.println("Conexión exitosa!");
                List<Mapa_C> L_Mapas = new ArrayList<>();
                List<Ciudad_C> L_Ciudad = new ArrayList<>();

                resultSet = statement.executeQuery("SELECT * FROM Mapa  ");
                while (resultSet.next()){
                    Mapa_C mapa_c = new Mapa_C(resultSet.getInt("ID_Mapa"), resultSet.getInt("ID_Pais"),
                            resultSet.getString("Pais"), resultSet.getInt("ID_Estado"),
                            resultSet.getString("Estado"), resultSet.getString("Fecha_Mapa"));
                    L_Mapas.add(mapa_c);
                }

                resultSet = statement.executeQuery("SELECT * FROM ciudad  ");
                while (resultSet.next()){
                    Ciudad_C ciudad_c = new Ciudad_C(resultSet.getInt("ID_Estado"), resultSet.getInt("ID_Ciudad"),
                            resultSet.getInt("Num_Zonas_I"), resultSet.getString("Nombre_Ciudad"),
                            resultSet.getDouble("Area_Mostrada"), resultSet.getString("Cordenadas"));
                    L_Ciudad.add(ciudad_c);
                }

                resultSet = statement.executeQuery("SELECT COUNT(*) FROM Distancias_Ciudades");
                numCalles_C = resultSet.getInt(1);
                Ruta_C grafo_c = new Ruta_C(numCalles_C);

                resultSet = statement.executeQuery("SELECT * FROM Distancias_Ciudades");
                while (resultSet.next()){
                    grafo_c.agregarArista(resultSet.getInt("ID_Ciudad_Origen"),
                            resultSet.getInt("ID_Ciudad_Destino"), resultSet.getInt("Distancia"));
                }

                /*for (Mapa_C mapa_Imp : L_Mapas) {
                    System.out.println();
                    System.out.println(mapa_Imp.toString());
                }
                System.out.println();
                for (int i = 0; i < L_Ciudad.size(); i++) {
                    Ciudad_C ciudad = L_Ciudad.get(i);
                    System.out.println("ID_Estado: " + ciudad.getID_Estado()+ " ID_Ciudad: " + ciudad.getID_Ciudad() + " Num_Zonas_I: " + ciudad.getNum_Zonas_Interes());
                    System.out.println("Nombre_Ciudad: " + ciudad.getNombre_Ciudad()+ " Area Mostrada: " + ciudad.getArea_Mostrada()+" m\n");
                }

                grafo_c.imprimirGrafo(); */

                Menu(L_Mapas, L_Ciudad, grafo_c);
            }
        }
        catch ( Exception ex ) {
            System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
            System.out.println("Error en la conexión");
        }
    }

    public static void Menu(List<Mapa_C> L_Mapas, List<Ciudad_C> L_Ciudad, Ruta_C grafo_c){

        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        int posicion_Actual = 0;

        List<Mapa_C> L_Mapas_M = L_Mapas;
        List<Ciudad_C> L_Ciudad_M = L_Ciudad;

        /*Random random = new Random();
        posicionAleatoria = random.nextInt(L_Ciudad.size());
        Ciudad_C ciudad = L_Ciudad.get(posicionAleatoria);
        //Mapa_C mapa_c = L_Mapas;

        String nombreEstado = null;
        f   if (mapa.getID_estado() == ciudad.getID_Estado()) {
                nombreEstado = mapa.getEstado();
                break;
            }
        }

        System.out.println("Usted se encuentra en la ciudad de "+ciudad.getNombre_Ciudad()+
                " en el estado de "+nombreEstado);or (Mapa_C mapa : L_Mapas) {*/

        posicion_Actual = Buscar(L_Mapas, L_Ciudad, grafo_c, opcion, null);
        posicion_Actual -=1;

        System.out.println("\tMapa Ciudades\nOpciones");
        String busqueda = null;
        boolean next = true;
        while (next){
            System.out.println("1. Buscar una Ciudad o Lugar"+
                    "\n2. Ir a una Ciudad o Lugar"+
                    "\n3. Salir"+
                    "\nIngrese su opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion){
                case 1:
                    System.out.println("Ingrese la ciudad: ");
                    //busqueda = sc.nextLine();
                    busqueda = sc.nextLine();
                    Buscar(L_Mapas, L_Ciudad, grafo_c, opcion, busqueda);

                    break;
                case 2:

                    System.out.println("Ingrese el destino: ");
                    busqueda = sc.nextLine();

                    for (Ciudad_C ciudades : L_Ciudad) {
                        if ((ciudades.getNombre_Ciudad()).equals(busqueda) ) {

                            posicion_Actual+=1;
                            grafo_c.imprimir_Ruta_Ciudades(posicion_Actual, ciudades.getID_Ciudad(), L_Ciudad_M.get(posicion_Actual-1).getNombre_Ciudad(),busqueda, L_Ciudad);                            break;
                        }
                    }

                    break;

                case 3:
                    next = false;
                break;

                default: break;
            }
        }
    }

    public static int Buscar(List<Mapa_C> L_Mapas, List<Ciudad_C> L_Ciudad, Ruta_C grafo_c, int opcion, String Buscar_Ciudad){
        int Marcador_Actual = 0;
        String nombreEstado = null;
        Ciudad_C ciudad = null;
        int ID_B = 0;

        if (opcion==0){
            int posicionAleatoria = 0;
            Random random = new Random();
            posicionAleatoria = random.nextInt(L_Ciudad.size());

            ciudad = L_Ciudad.get(posicionAleatoria);

            for (Mapa_C mapa : L_Mapas) {
                if (mapa.getID_estado() == ciudad.getID_Estado()) {
                    nombreEstado = mapa.getEstado();
                    break;
                }
            }
            System.out.println("Usted se encuentra en la ciudad de "+ciudad.getNombre_Ciudad()+
                    " en el estado de "+nombreEstado);
            Marcador_Actual = ciudad.getID_Ciudad();
            System.out.println("marcador "+Marcador_Actual);

        }else {

            for (Ciudad_C ciudades : L_Ciudad) {

                if ((ciudades.getNombre_Ciudad()).equals(Buscar_Ciudad) ) {

                    ID_B = ciudades.getID_Estado();
                    for (Mapa_C mapa : L_Mapas) {
                        if (mapa.getID_estado() == ID_B) {
                            nombreEstado = mapa.getEstado();

                            break;
                        }
                    }
                    String separar = ciudades.getCordenadas();
                    String[] coordenadas = separar.split(";");
                            //String[] coordenadas = ;
                    System.out.println("La ciudad "+Buscar_Ciudad+
                            " se encuentra en el estado de "+nombreEstado+
                            ". \nSu latitud es: "+coordenadas[0]+"\nLa longitud es: "+coordenadas[1]);
                    break;
                }
            }
        }
        return Marcador_Actual;
    }
}
