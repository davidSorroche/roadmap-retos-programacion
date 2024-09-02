import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class FuncionesPilasYColas {
    private static final String LISTA_VACIA = "Lo siento, no quedan más números en el listado.";
    private final List<Integer> numeros;
    
    public FuncionesPilasYColas (List<Integer> numeros) {
        this.numeros = numeros;
    }
    
    // Se añade un elemento al final de la lista. Tanto pop (en pilas) como enqueue (en colas) funcionan igual..
    public void pushEnqueue (int numero) {
        numeros.add (numero);
    }
    
    // Recuperamos los elementos como si se tratase de una pila. Es decir, el último en entrar es el primero en salir.
    public Object popElement () {
        if (!numeros.isEmpty()) {
            int numero = numeros.getLast ();
            numeros.removeLast ();
            return numero;
        } else {
            return "";
        }
    }
    
    // Recuperamos los elementos como si se tratase de una cola, es decir, el primero en entrar es el primero en salir.
    public Object dequeueElement () {
        if(!numeros.isEmpty()) {
            int numero = numeros.getFirst();
            numeros.removeFirst();
            return numero;
        } else {
            return "";
        }
    }

    //DIFICULTAD EXTRA
    
    //Navegador web
   private final List<String> historialWeb = new ArrayList<>();
   private final Deque<String> direccionesWeb = new ArrayDeque<>();
   private boolean esDireccionAnterior = false;
   
   public void accionNavegadorWeb(String accion) {
       switch (accion) {
           case "adelante" -> {
               if(historialWeb.size() > direccionesWeb.size()) {
                   direccionesWeb.push(historialWeb.get(direccionesWeb.size()));
               }
           } case "atrás", "atras" -> {
               if (!direccionesWeb.isEmpty()) {
                    direccionesWeb.pop();
                    esDireccionAnterior = true;
               }
           } default -> {
               direccionesWeb.push(accion);
               if(!esDireccionAnterior) {
                    historialWeb.add(accion);
               } else {
                   historialWeb.clear();
                   historialWeb.addAll(direccionesWeb.reversed());
                   esDireccionAnterior = false;
               }
           }
       }
   }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for(String direccion : direccionesWeb.reversed()) {
            sb.append(direccion).append("/");
        }
        
        return sb.toString();
    }
    
    //Impresiones
    private final Deque<String> impresionDocumentos = new ArrayDeque<>();
    
    public String imprimir(String documento) {
        if(documento.equalsIgnoreCase("imprimir")) {
            if(!impresionDocumentos.isEmpty()) {
                return String.format("Imprimiendo el documento \"%s\".", impresionDocumentos.poll());
            } else {
                return "No quedan más documentos para imprimir.";
            }
        } else {
            impresionDocumentos.offer(documento);
            return String.format("Añadido el documento \"%s\" a la cola de los documentos a imprimir.", documento.trim());
        }
    }
}

/*
 * EJERCICIO:
 * Implementa los mecanismos de introducción y recuperación de elementos propios de las
 * pilas (stacks - LIFO) y las colas (queue - FIFO) utilizando una estructura de array
 * o lista (dependiendo de las posibilidades de tu lenguaje).
 *
 * DIFICULTAD EXTRA (opcional):
 * - Utilizando la implementación de pila y cadenas de texto, simula el mecanismo adelante/atrás
 *   de un navegador web. Crea un programa en el que puedas navegar a una página o indicarle
 *   que te quieres desplazar adelante o atrás, mostrando en cada caso el nombre de la web.
 *   Las palabras "adelante", "atrás" desencadenan esta acción, el resto se interpreta como
 *   el nombre de una nueva web.
 * - Utilizando la implementación de cola y cadenas de texto, simula el mecanismo de una
 *   impresora compartida que recibe documentos y los imprime cuando así se le indica.
 *   La palabra "imprimir" imprime un elemento de la cola, el resto de palabras se
 *   interpretan como nombres de documentos.
 */

public class PilasYColas {

    public static void main(String[] args) {
        final String LISTA_VACIA = "No quedan más números en la lista.";
        List<Integer> numeros = new ArrayList<>();
        FuncionesPilasYColas f = new FuncionesPilasYColas(numeros);
        
        f.pushEnqueue(5);
        f.pushEnqueue(10);
        f.pushEnqueue(15);
        
        System.out.println(Arrays.toString(numeros.toArray()));
        
        for(int i = 0; i < 4; i++) {
            Object numero = f.popElement();
            
            if(numero instanceof Integer) {
                System.out.println(numero + "\t" + Arrays.toString(numeros.toArray()));
            } else {
                System.err.println(LISTA_VACIA);
            }
        }
        
        System.out.println();
        
        f.pushEnqueue(20);
        f.pushEnqueue(25);
        f.pushEnqueue(30);
        
        System.out.println(Arrays.toString(numeros.toArray()));
        
        for(int i = 0; i < 4; i++) {
            Object numero = f.dequeueElement();
            
            if (numero instanceof Integer) {
                System.out.println(numero + "\t" + Arrays.toString(numeros.toArray()));
            } else {
                System.err.println (LISTA_VACIA);
            }
        }
        
        //DIFICULTAD EXTRA
        String accion;
        try (Scanner entrada = new Scanner (System.in)) {
            do {
                System.out.print("\nEscribe la acción de su navegador (nombre web, adelante, atrás, salir): ");
                accion = entrada.nextLine().toLowerCase().replaceAll("\\s", "");
                
                if (accion != null && !accion.isBlank()) {
                    f.accionNavegadorWeb (accion);
                    System.out.println("\nurl: https://" + f.toString());
                }
            } while (accion != null && !accion.equalsIgnoreCase("salir"));
            
            do {
                System.out.print("\nEscribe el nombre de un documento para añadirlo a la cola de los documentos a imprimir o escribe \"imprimir\" para imprimirlos: ");
                accion = entrada.nextLine();
                System.out.println(f.imprimir(accion));
            } while (accion != null && !accion.equalsIgnoreCase("salir"));
        }
    }
}
