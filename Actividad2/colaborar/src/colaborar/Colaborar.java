package colaborar;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Pieza software 4 para Programación de Servicios y Procesos. 
 * Esta clase representa un programa que lanza procesos en paralelo utilizando
 * el archivo lenguaje.jar. Puede especificarse el nombre del archivo como primer
 * argumento. Si no se proporciona, se utilizará el nombre predeterminado "miFicheroDeLenguaje.txt".
 * 
 * 
 * @author Ángel Redondo
 */
public class Colaborar {
    
    // Variable para controlar la impresión de mensajes
    private static boolean test = false;

    /**
     * Método principal que lanza procesos en paralelo utilizando lenguaje.jar.
     * 
     * @param args los argumentos de la línea de comandos: [0] nombre del archivo (opcional)
     */
    public static void main(String[] args) {
        // Nombre predeterminado del archivo si no se proporciona el primer argumento
        String nombreArchivo = (args.length > 0) ? args[0] : "miFicheroDeLenguaje.txt";

        // Comando base para lanzar el proceso. Reciclar es vivir :-D
        String comando = "java -jar lenguaje.jar ";

        try {
            // Lanza 10 procesos en paralelo con diferentes números de líneas
            for (int i = 1; i <= 10; i++) {
                if (test) {
                    System.out.println("Lanzado el proceso: " + i);
                    System.out.println("Comando lanzado: " + comando + (i * 10) + " " + nombreArchivo);
                }

                // Lanza el proceso utilizando Runtime.getRuntime().exec()
                Process proceso = Runtime.getRuntime().exec(comando + (i * 10) + " " + nombreArchivo);

                // Espera a que el proceso termine antes de continuar con el siguiente
                proceso.waitFor();
                // No tenía esperanza en que funcionara correctamente... Pero si
            }
        } catch (SecurityException ex) {
            System.out.println("Problema de seguridad: " + ex.getMessage());
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Colaborar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}