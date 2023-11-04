package aleatorios;

/**
 * Esta clase genera números aleatorios dentro de un rango específico.
 * 
 * @author Angel Redondo
 */
public class Aleatorios {

    /**
     *  Pieza software 1 para Programación de Servicios y Procesos. 
     *  Genera y muestra números aleatorios dentro del rango especificado.
     * 
     * @param args los argumentos de la línea de comandos ( aunque no se utilizan en este programa)
     */
    public static void main(String[] args) {
        int cantidadGenerados = 40, minimo = 0, maximo = 100; //Me gusta ofuscar
        
        for (int i = 0; i < cantidadGenerados; i++) {
            int numeroAleatorio = generaNumeroAleatorio(minimo, maximo);
            System.out.print(numeroAleatorio + " ");
        }
    }
    
    /**
     * Genera un número aleatorio dentro del rango especificado.
     * 
     * @param minimo el valor mínimo del rango (inclusive)
     * @param maximo el valor máximo del rango (inclusive)
     * @return un número aleatorio dentro del rango especificado
     */
    public static int generaNumeroAleatorio(int minimo, int maximo) {
        // Se genera un número aleatorio dentro del rango y se devuelve
        return (int) (Math.random() * (maximo - minimo + 1) + minimo);
        // Se podría controlar que no se repitieran los números
    }
}
