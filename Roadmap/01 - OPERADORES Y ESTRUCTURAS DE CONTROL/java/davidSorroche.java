public class Principal {
    public static void main(String[] args) {
        Operadores op = new Operadores();
        
        op.asignarTexto("");
        System.out.println(op.devolverTextoAsignado());
        
        op.concatenarCaracter('.');
        System.out.println(op.devolverTextoAsignado());
        
        op.asignarTexto("Haciendo pruebas");
        System.out.println(op.devolverTextoAsignado());
        
        op.concatenarCaracter('.');
        System.out.println(op.devolverTextoAsignado());
        
        System.out.println(op.operadorSuma(5, 10));
        System.out.println(op.operadorResta(10, 3));
        System.out.println(op.operadorMultiplicacion(2.8, 3));
        System.out.println(op.operadorDivision(28, 5));
        System.out.println(op.operadorDivisionEntera(10, 3));
        System.out.println(op.operadorModulo(10, 3));
        
        Operadores opAsignacion = new Operadores();
        
        opAsignacion.asignarTexto(" ");
        System.out.println(opAsignacion.devolverTextoAsignado());
        System.out.println(opAsignacion.concatenarCaracterAsignacion(';'));
        
        System.out.println(op.operadorSumaAsignacion(5, 10));
        System.out.println(op.operadorRestaAsignacion(10, 3));
        System.out.println(op.operadorMultiplicacionAsignacion(2.8, 3));
        System.out.println(op.operadorDivisionAsignacion(28, 5));
        System.out.println(op.operadorDivisionEnteraAsignacion(10, 3));
        System.out.println(op.operadorModuloAsignacion(10, 3));
        
        System.out.println(op.operadorUnarioPositivo(-5));
        System.out.println(op.operadorUnarioNegativo(15));
        System.out.println(op.operadorPostIncremento(9));
        System.out.println(op.operadorPreIncremento(9));
        System.out.println(op.operadorPostDecremento(10));
        System.out.println(op.operadorPreDecremento(10));
        System.out.println(op.operadorComplementoLogico(true));
        
        System.out.println(op.operadorIgualdad(5, 5));
        System.out.println(op.operadorIgualdad(5, 6));
        System.out.println(op.operadorDesigualdad(10.5, 10.5));
        System.out.println(op.operadorDesigualdad(10.5, 10.51));
        System.out.println(op.operadorMayorQue(10, 5));
        System.out.println(op.operadorMayorOIgualQue((byte)5, (byte)10));
        System.out.println(op.operadorMenorQue((short)2, (short) -2));
        System.out.println(op.operadorMenorOIgualQue(-2f, 2f));
        
        System.out.println(op.operadorNOT(10));
        System.out.println(op.operadorAND(-5, 2));
        System.out.println(op.operadorORExclusivo(-5, -10));
        System.out.println(op.operadorORInclusivo(22, 3));
        System.out.println(op.operadorDesplazamientoIzquierda(10, 3));
        System.out.println(op.operadorDesplazamientoDerecha(10, 5));
        System.out.println(op.operadorDesplazamientoDerechaSinSigno(2, 3));
        
        System.out.println(op.averiguarNumero(10));
        System.out.println(op.NumeroIntroducido(3));
        System.out.println(op.NumeroIntroducido(6));
        System.out.println(op.sumaNumeros(15));
        System.out.println(op.numeroPar());
        System.out.println(op.numPar());
        
        DificultadExtra dE = new DificultadExtra();
        dE.imprimirNumerosValidosEntre10Y55();
    }
}

public class Operadores {
    /*
        * Crea ejemplos utilizando todos los tipos de operadores de tu lenguaje:
        * Asignación, aritméticos, unarios, relaciones e igualdad y bits
    
        * Utilizando las operaciones con operadores que tú quieras, crea ejemplos
        * que representen todos los tipos de estructuras de control que existan
        * en tu lenguaje:
        * Condicionales, iterativas, excepciones...
    */
    
    private String texto;
    
    // Operador de asignación(=)
    
    public void asignarTexto(String texto) {
        // Eliminamos los espacios en blanco al final y principio del texto pasado por parámetro.
        texto = texto.trim();
        
        /*
            Asigna el texto pasado por parámetro a la variable "texto" de la clase actual(this),
            pero si el texto está vacío después de eliminarle los espacios en blancos, se asigna
            el texto : "Practicando operadores Java".
        */
        this.texto = texto.isEmpty() ? "Practicando operadores Java" : texto;
    }
    
    
    public String devolverTextoAsignado() {
        // Devuelve el texto que se le ha asignado a la variable "texto" de la clase actual(this).
        return texto;
    }
    
    // Operadores aritméticos: concatenacion(+), suma(+), resta(-), multiplicacion(*), division(/), modulo(%).
    
    public String concatenarCaracter(char caracter) {
        // Devuelve el texto de la variable "texto" concatenándole el caracter pasado por parámetro. 
        return texto + caracter;
    }
    
    public int operadorSuma(int num1, int num2) {
        // Suma dos números enteros.
        return num1 + num2;
    }

    public int operadorResta(int num1, int num2) {
        // Resta dos números enteros.
        return num1 - num2;
    }

    public double operadorMultiplicacion(double num1, double num2) {
        // Multiplica dos números decimales y lo redondea a dos decimales.
        return Math.round(num1 * num2 * 100) / 100d;
    }

    public double operadorDivision(double num1, double num2) {
        // Evitamos la division entre 0
        if(num2 == 0) {
            throw new ArithmeticException("No se puede dividir ningún número entre 0");
        }

        // Divide dos números decimales y lo redondea a dos decimales.
        return Math.round(num1 / num2 * 100) / 100.0;
    }

    public int operadorDivisionEntera(double num1, double num2) {
        // Evitamos la division entre 0
        if(num2 == 0) {
            throw new ArithmeticException("No se puede dividir ningún número entre 0");
        }

        // Divide dos números decimales redondeando al entero más próximo.
        return (int) (num1 / num2);
    }

    public int operadorModulo(int num1, int num2) {
        // Evitamos la división entre 0
        if(num2 == 0) {
            throw new ArithmeticException("No se puede dividir ningún número entre 0");
        }
        
        // Módulo de dos números enteros.
        return num1 % num2;
    }
    
    // Operadores aritméticos y asignación: concatenacion(+), suma(+), resta(-), multiplicacion(*), division(/), modulo(%).
    
    // Operadores aritméticos: concatenacion(+), suma(+), resta(-), multiplicacion(*), division(/), modulo(%).
    
    public String concatenarCaracterAsignacion(char caracter) {
        // Devuelve el texto de la variable "texto" concatenándole el caracter pasado por parámetro. 
        texto += caracter;
        return texto;
    }
    
    public int operadorSumaAsignacion(int num1, int num2) {
        // Suma dos números enteros.
        num1 += num2;
        return num1;
    }

    public int operadorRestaAsignacion(int num1, int num2) {
        // Resta dos números enteros.
        num1 -= num2;
        return num1;
    }

    public double operadorMultiplicacionAsignacion(double num1, double num2) {
        // Multiplica dos números decimales y lo redondea a dos decimales.
        num1*=num2;
        return Math.round((num1 * 100) / 100.0);
    }

    public double operadorDivisionAsignacion(double num1, double num2) {
        // Evitamos la division entre 0
        if(num2 == 0) {
            throw new ArithmeticException("No se puede dividir ningún número entre 0");
        }

        // Divide dos números decimales y lo redondea a dos decimales.
        num1 /= num2;
        return Math.round((num1 * 100) / 100.0);
    }

    public int operadorDivisionEnteraAsignacion(double num1, double num2) {
        // Evitamos la division entre 0
        if(num2 == 0) {
            throw new ArithmeticException("No se puede dividir ningún número entre 0");
        }

        // Divide dos números decimales redondeando al entero más próximo.
        num1 /= num2;
        return (int) num1;
    }

    public int operadorModuloAsignacion(int num1, int num2) {
        // Evitamos la división entre 0
        if(num2 == 0) {
            throw new ArithmeticException("No se puede dividir ningún número entre 0");
        }
        
        // Módulo de dos números enteros.
        num1 %= num2;
        return num1;
    }
    

    /* 
        Operadores unarios: operador unario positivo(+), operador unario negativo (-), 
        operador incremento(++), operador decremento(--), operador complemento lógico (!)
    */

    public int operadorUnarioPositivo(int num) {
        // Devuelve el número en positivo, es decir, el número tal cual.
        return +num;
    }

    public int operadorUnarioNegativo(int num) {
        // Devuelve el número en negativo, es decir, el número con el signo cambiado.
        return -num;
    }
    
    public double operadorPostIncremento(double num) {
        // Devuelve el número y lo incrementa en una unidad.
        return num++;
    }
    
    public double operadorPreIncremento(double num) {
        // Incrementa el número en una unidad y devuelve el número incrementado.
        return ++num;
    }

    public double operadorPostDecremento(double num) {
        // Devuelve el número y lo decrementa en una unidad.
        return num--;
    }

    public double operadorPreDecremento(double num) {
        // Decrementa el número en una unidad y devuelve el número decrementado.
        return --num;
    }

    public boolean operadorComplementoLogico(boolean booleano) {
        // Devuelve el valor booleano opuesto.
        return !booleano;
    }
    
    /*
        Operadores relacionales y de igualdad: igualdad(==), desigualdad(!=), mayor que(>),
        mayor o igual que(>=), menor que(<), menor o igual que(<=)
    */
    
    public boolean operadorIgualdad(int num1, int num2) {
        /*
            Devuelve verdadero si los dos números enteros (int) pasados por parámetros son iguales
            y falso en caso contrario.
        */
        return num1 == num2;
    }
    
    public boolean operadorDesigualdad(double num1, double num2) {
        /*
            Devuelve verdadero si los dos números decimales (double) pasados por parámetros son distintos
            y falso en caso contrario.
        */
        return num1 != num2;
    }
    
    public double operadorMayorQue(double num1, double num2) {
        // Devuelve el número decimal (double) mayor de entre los dos números decimales (double) pasados por parámetros.
        return num1 > num2 ? num1 : num2;
    }
    
    public boolean operadorMayorOIgualQue(byte num1, byte num2) {
        /* 
            Devuelve verdadero si el primer número byte pasado por parámetro es mayor o igual
            que el segundo byte, y falso en caso contrario
        */
        return num1 >= num2;
    }
    
    public short operadorMenorQue(short num1, short num2) {
        // Devuelve el número short menor de entre los dos números short pasados por parámetros.
        return num1 < num2 ? num1 : num2;
    }
    
    public boolean operadorMenorOIgualQue(float num1, float num2) {
        /* 
            Devuelve verdadero si el primer número decimal (float) pasado por parámetro es menor o igual
            que el segundo número decimal (float), y falso en caso contrario
        */
        return num1 <= num2;
    }
    
    /* 
        Operadores unario bit a bit: operador NOT(~), operador AND(&), operador OR exclusivo(^), 
        operador OR inclusivo(|), operador desplazamiento izquierda(<<).
        operador desplazamiento derecha(>>), operador desplazamiento derecha sin signo(>>>)
    */
    
    public String operadorNOT(int num) {
        // Realiza la conversión usando el operador complemento bit a bit (~).
        int resultado = ~ num;

        /*
            Convierte el número hallado a binario con formato 32bits llamando al
            método conversionBinario(int num)
        */
        String resultadoBinario = conversionBinario(resultado);
        
        //Devuelve el número entero (int) hallado y su valor en binario.
        return resultado + " (" + resultadoBinario + ")";
    }
    
    public String operadorAND(int num1, int num2) {
        // Realiza la operación usando el operador AND (&).
        int resultado = num1 & num2;
        
        /*
            Convierte el número hallado a binario con formato 32bits llamando al
            método conversionBinario(int num)
        */
        String resultadoBinario = conversionBinario(resultado);
        
        //Devuelve el número entero (int) hallado y su valor en binario.
        return resultado + " (" + resultadoBinario + ")";
    }
    
    public String operadorORExclusivo(int num1, int num2) {
        // Realiza la operación usando el operador OR exclusivo (^).
        int resultado = num1 ^ num2;
        
        /*
            Convierte el número hallado a binario con formato 32bits llamando al
            método conversionBinario(int num)
        */
        String resultadoBinario = conversionBinario(resultado);
        
        //Devuelve el número entero (int) hallado y su valor en binario.
        return resultado + " (" + resultadoBinario + ")";
    }
    
    public String operadorORInclusivo(int num1, int num2) {
        // Realiza la operación usando el operador OR inclusivo (|).
        int resultado = num1 | num2;
        
        /*
            Convierte el número hallado a binario con formato 32bits llamando al
            método conversionBinario(int num)
        */
        String resultadoBinario = conversionBinario(resultado);
        
        //Devuelve el número entero (int) hallado y su valor en binario.
        return resultado + " (" + resultadoBinario + ")";
    }
    
    public String operadorDesplazamientoIzquierda(int num, int posiciones) {
        // Realiza la operación usando el operador de desplazamiento a la izquierda(<<).
        int resultado = num << posiciones;
        
        /*
            Convierte el número hallado a binario con formato 32bits llamando al
            método conversionBinario(int num)
        */
        String resultadoBinario = conversionBinario(resultado);
        
        //Devuelve el número entero (int) hallado y su valor en binario.
        return resultado + " (" + resultadoBinario + ")";
    }
    
    public String operadorDesplazamientoDerecha(int num, int posiciones) {
        // Realiza la operación usando el operador de desplazamiento a la derecha(>>).
        int resultado = num >> posiciones;
        
        /*
            Convierte el número hallado a binario con formato 32bits llamando al
            método conversionBinario(int num)
        */
        String resultadoBinario = conversionBinario(resultado);
        
        //Devuelve el número entero (int) hallado y su valor en binario.
        return resultado + " (" + resultadoBinario + ")";
    }
    
    public String operadorDesplazamientoDerechaSinSigno(int num, int posiciones) {
        // Realiza la operación usando el operador de desplazamiento a la derecha sin signo(>>>).
        int resultado = num >>> posiciones;
        
        /*
            Convierte el número hallado a binario con formato 32bits llamando al
            método conversionBinario(int num)
        */
        String resultadoBinario = conversionBinario(resultado);
        
        //Devuelve el número entero (int) hallado y su valor en binario.
        return resultado + " (" + resultadoBinario + ")";
    }
    
    private String conversionBinario(int num) {
        // Convierte el número hallado a binario.
        String binario = Integer.toBinaryString(num);
        
        if(num < 0) {
            // Si el número es negativo. Recorta el formato binario a 32 bits.  
            binario = binario.substring(binario.length() - 32);
        } else {
            /* 
                Formatea el resultado a 32 bits, así nos aseguramos que la conversión 
                se realiza de manera adecuada.
            */
            binario = String.format("%32s", binario).replace(' ', '0');
        }
        
        return binario;
    }
    
    /*
        * Utilizando las operaciones con operadores que tú quieras, crea ejemplos
        * que representen todos los tipos de estructuras de control que existan
        * en tu lenguaje:
        * Condicionales, iterativas, excepciones...
    */
    
    // Estructuras condicionales: if...else if...else, switch...case, for, while, do while.
    
    // Condicional if... else if... else
    public String averiguarNumero(int num) {
        // Si el número pasado por parámetro es menor que 1 o superior a 100, se produce una excepción.
        if(num < 1 || num > 100) {
            throw new ArithmeticException("El número no está comprendido entre 1 y 100");
        }
        
        // Calcula un número aleatorio comprendido entre 1 y 100 (ambos incluidos).
        int numeroAleatorio = (int) (Math.random() * 100) + 1;
        
        // Si se acierta el número devuelve el mensaje de "ENHORABUENA", en caso contrario el de "LO SIENTO"
        if(num == numeroAleatorio) {
            return "¡¡¡ENHORABUENA!!! Has adivinado el número.";
        } else if (num < numeroAleatorio) {
            return "LO SIENTO, el número introducido es menor que el que había pensado.";
        }  else {
            return "LO SIENTO, el número introducido es mayor que el que había pensado.";
        }     
    }
    
    // Condicional switch...case
    public String NumeroIntroducido(int num) {
        return switch (num) {
            case 1 -> "Has introducido el número uno";
            case 2 -> "Has introducido el número dos";
            case 3 -> "Has introducido el número tres";
            case 4 -> "Has introducido el número cuatro";
            case 5 -> "Has introducido el número cinco";
            default -> "Has introducido un número no comprendido entre uno y cinco";
        };
    }
    
    // Iterativa for
    public int sumaNumeros(int num) {
        // Crea e inicializa la variable entera (int) "suma" con valor cero.
        int suma = 0;
        
        /* 
            A través de un bucle for, iteramos desde cero al número obtenido por parámetro
            y vamos sumando cada el valor de cada iteración a la variable suma
       */
        for(int i = 0; i <= num; i++) {
            suma += i;
        }
        
        // Devuelve el valor de la suma.
        return suma;
    }
    
    // Iterativa while
    public boolean numeroPar() {
        // creamos una variable entera (int) num y le asignamos un número aleatorio entre 1 y 1000.
        int num = (int) (Math.random() * 1000) + 1;
        System.out.println(num);
        
        // Iteramos asignándole a la variable num nuevos números enteros (int) aleatorios hasta que sea par.
        while(num % 2 != 0) {
            num = (int) (Math.random() * 1000) + 1;
            System.out.println(num);
        }
        
        // devuelve true una vez asignado un número par.
        return true;
    }
    
    // Iterativa do...while
    public boolean numPar() {
        int num;

        // Iteramos asignándole a una variable num números enteros (int) aleatorios hasta que sea par.
        do {
            num = (int) (Math.random() * 1000) + 1;
            System.out.println(num);
        } while(num % 2 != 0);
        
        // devuelve true una vez asignado un número par.
        return true;
    }
}

public class DificultadExtra {
    /*
        * Crea un programa que imprima por consola todos los números comprendidos
        * entre 10 y 55 (incluidos), pares, y que no son ni el 16 ni múltiplos de 3.
    */
    
    public void imprimirNumerosValidosEntre10Y55() {
        for(int num = 10; num <= 55; num++) {
            if(esNumeroParYNoEs16(num) && !esMultiploDe3(num)) {
                System.out.println(num);
            }
        }
    }
    
    private boolean esNumeroParYNoEs16(int num) {
        return num % 2 == 0 && num != 16;
    }
    
    private boolean esMultiploDe3(int num) {
        return num % 3 == 0;
    }
}
