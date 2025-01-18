import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, RuntimeException {
        int opcion = 0;
        String menu = """
                ****************************
                Sea bienvenido/a al Conversor de Moneda
                1) Dólar ==> Soles Peruanos
                2) Soles Peruanos ==> Dólar
                3) Dólar ==> Real Brasileño
                4) Real Brasileño ==> Dólar
                5) Dólar ==> Peso Argentino
                6) Peso argentino ==> Dolar
                7) Salir
                
                Elija una opción válida:
                ****************************
                """;
        String text = "El valor de ";
        Scanner lectura = new Scanner(System.in);
        List<Conversor> consultas = new ArrayList<>();
        ConsultarConversor consulta = new ConsultarConversor();



        try{
            while (opcion !=7){

                System.out.println(menu);
                opcion = Integer.valueOf(lectura.nextLine());
                if(opcion!=7){
                    System.out.println("Ingrese el valor a convertir");
                    var valorAConvertir = Double.valueOf(lectura.nextLine());
                    Conversor conversor = null;
                    switch (opcion){
                        case 1:

                            conversor = consulta.buscaDivisa("USD","PEN",valorAConvertir);
                            System.out.println(text+valorAConvertir+conversor);
                            break;
                        case 2:

                            conversor = consulta.buscaDivisa("PEN","USD",valorAConvertir);
                            System.out.println(text+valorAConvertir+conversor);
                            break;

                        case 3:

                            conversor = consulta.buscaDivisa("USD","BRL",valorAConvertir);
                            System.out.println(text+valorAConvertir+conversor);
                            break;
                        case 4:

                            conversor = consulta.buscaDivisa("BRL","USD",valorAConvertir);
                            System.out.println(text+valorAConvertir+conversor);
                            break;
                        case 5:

                            conversor = consulta.buscaDivisa("USD","ARS",valorAConvertir);
                            System.out.println(text+valorAConvertir+conversor);
                            break;
                        case 6:

                            conversor = consulta.buscaDivisa("ARS","USD",valorAConvertir);
                            System.out.println(text+valorAConvertir+conversor);
                            break;
                        case 7:
                            System.out.println("Saliendo del programa, gracias por utlizar nuestros servicios");
                            break;

                        default:
                            System.out.println("Opción no valida");
                    }
                    GeneradorDeArchivo generador = new GeneradorDeArchivo();
                    generador.guardarJson(conversor);

                }
                System.out.println("Saliendo del programa, gracias por utlizar nuestros servicios");
            }

            
        }catch (NumberFormatException e){
            System.out.println("error, unknown-code(SOLO LAS OPCIONES VALIDAS Y NUMEROS PARA CALCULAR LAS DIVISAS ): "+e.getMessage());
        }
    }
}
