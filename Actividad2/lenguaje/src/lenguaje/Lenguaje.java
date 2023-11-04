/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lenguaje;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

/**
 * Pieza software 3 para Programación de Servicios y Procesos. 
 * Esta clase genera y escribe líneas de texto aleatorias en un archivo. Las líneas
 * contienen letras aleatorias y la longitud de cada línea varía entre 1 y 10 caracteres.
 * El nombre del archivo y el número de líneas se pasan como argumentos de la línea de comandos.
 * 
 * Para ejecutar el programa, se deben proporcionar dos argumentos: el número de líneas y el nombre del archivo.
 * Por ejemplo: java lenguaje.Lenguaje 5 output.txt
 * 
 * @author Ángel Redondo
 */
public class Lenguaje {

    /**
     * Método principal que genera y escribe líneas de texto aleatorias en un archivo.
     * 
     * @param args los argumentos de la línea de comandos: [0] número de líneas, [1] nombre del archivo
     * @throws IOException si ocurre un error de entrada/salida
     */
    public static void main(String[] args) throws IOException {
        // La primera en el hocico. Verifica que nos manden todo lo que necesitamos
        if (args.length != 2) {
            System.out.println("El programa debe tener dos parametros: numero de lineas y nombre del archivo.");
            return;
        }

        // Sacamos el número de líneas y el nombre del archivo de los argumentos
        int numLineas = Integer.parseInt(args[0]);
        String nombreFichero = args[1];

        // Verifica si el archivo existe, si no, lo crea
        File archivo = new File(nombreFichero);
        if (!archivo.exists()) {
            archivo.createNewFile();
        }

        // Abre el archivo en modo de escritura con bloqueo para controlar concurrencia
        try (RandomAccessFile raf = new RandomAccessFile(archivo, "rwd");
             FileLock bloqueo = raf.getChannel().lock()) {

            // Se pone al final del archivo para añadir nuevas líneas
            raf.seek(archivo.length());

            // Genera y escribe las líneas aleatorias en el archivo
            for (int i = 0; i < numLineas; i++) {
                String linea = generarLineaAleatoria();
                raf.writeChars(linea + "\n");
            }
        }
    }

    /**
     * Genera una línea aleatoria de longitud variable entre 1 y 10 caracteres.
     * 
     * @return una cadena aleatoria de letras
     */
    private static String generarLineaAleatoria() {
        String letras = "abcdefghijklmnopqrstuvwxyz";
        int longitud = generaNumeroAleatorio(1, 10);
        StringBuilder linea = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            char letra = letras.charAt(generaNumeroAleatorio(0, letras.length() - 1));
            linea.append(letra);
        }
        return linea.toString();
    }

    /**
     * Genera un número aleatorio dentro del rango especificado.
     * 
     * @param minimo el valor mínimo del rango (inclusive)
     * @param maximo el valor máximo del rango (inclusive)
     * @return un número aleatorio dentro del rango especificado
     */
    public static int generaNumeroAleatorio(int minimo, int maximo) {
        return (int) (Math.random() * (maximo - minimo + 1) + minimo);
    }
}