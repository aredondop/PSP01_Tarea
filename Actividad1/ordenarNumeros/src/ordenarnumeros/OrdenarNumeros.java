package ordenarnumeros;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Pieza software 2 para Programación de Servicios y Procesos. 
 * Esta clase lee una serie de números desde la entrada estándar, los ordena
 * en orden ascendente y los imprime en la salida estándar.
 * 
 * @author Angel Redondo
 */
public class OrdenarNumeros {

    /**
     * El método principal que se ejecuta al iniciar el programa.
     * 
     * @param args los argumentos de la línea de comandos (no se utilizan en este programa)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Lee la línea de entrada y divide los números
        while (scanner.hasNextLine()) {
            String[] datos = scanner.nextLine().split(" ");
            int[] numeros = new int[datos.length];
            
            // Convierte los datos en números enteros y los almacena en un arreglo
            for (int i = 0; i < numeros.length; i++) {
                numeros[i] = Integer.parseInt(datos[i]);
            }
            
            // Ordena los números en orden ascendente
            Arrays.sort(numeros);
            
            // Imprime los números ordenados
            for (int i = 0; i < numeros.length; i++) {
                System.out.print(numeros[i] + " ");
            }
            
            // Imprime una nueva línea después de los números ordenados para dari aire
            System.out.println();
        }
        
        // Cierra el scanner para liberar recursos. A la basura!
        scanner.close();
    }
}