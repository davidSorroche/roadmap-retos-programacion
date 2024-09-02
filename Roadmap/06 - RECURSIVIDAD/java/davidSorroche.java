public class FuncionesRecursividad {
    // Función recursiva que imprima los números del 1 al 100.
    public void funcionRecursiva1_100(int num) throws ValorNoPermitido {
        if(num < 1) {
            throw new ValorNoPermitido("El contador no puede empezar por debajo de 1. Lo siento.");
        } else if(num <= 100) {
            System.out.println(num);
            funcionRecursiva1_100(num + 1);
        } else {
            System.out.println("\nFin del proceso.");
        }
    }
    
    // Función para calcular el factorial de un número entero.
    public int calcularFactorial(int num) throws ValorNoPermitido {
        if(num < 0) {
            throw new ValorNoPermitido("No se puede calcular el factorial de un número negativo. Lo siento.");
        } else if(num == 0) {
            return 1;
        } else {
            return num * calcularFactorial(num - 1);
        }
    }
    
    //Función para calcular el número de la sucesión de Fibonacci según la posición.
    public int calcularNumeroFibonacci(int index) throws ValorNoPermitido {
        if(index < 1) {
            throw new ValorNoPermitido("La posición dentro de la sucesión de Fibonacci no puede ser inferior a 0.");
        } else if (index == 1) {
            return 0;
        } else if(index == 2) {
            return 1;
        } else {
            return (calcularNumeroFibonacci(index - 1) + calcularNumeroFibonacci(index - 2));
        }
    }
}

public class ValorNoPermitido extends Exception {

    public ValorNoPermitido(String mensaje) {
        super(mensaje);
    }
}

public class Recursividad {

    public static void main(String[] args) throws ValorNoPermitido {
        FuncionesRecursividad f1 = new FuncionesRecursividad();
        try {
            f1.funcionRecursiva1_100(1);
        } catch(ValorNoPermitido ex) {
            System.err.println(ex.getMessage());
        }
        
        try {
            f1.funcionRecursiva1_100(0);
        } catch(ValorNoPermitido ex) {
            System.err.println(ex.getMessage());
        }
        
        // DIFICULTAD EXTRA
        try {
            System.out.println(f1.calcularFactorial(0));
            System.out.println(f1.calcularFactorial(1));
            System.out.println(f1.calcularFactorial(5));
            System.out.println(f1.calcularFactorial(10));
        } catch(ValorNoPermitido ex) {
            System.err.println(ex.getMessage());
        }
        
        try {
            System.out.println(f1.calcularFactorial(-1));
        } catch(ValorNoPermitido ex) {
            System.err.println(ex.getMessage());
        }
        
        try {
            System.out.println(f1.calcularNumeroFibonacci(1));
            System.out.println(f1.calcularNumeroFibonacci(2));
            System.out.println(f1.calcularNumeroFibonacci(3));
            System.out.println(f1.calcularNumeroFibonacci(10));
            System.out.println(f1.calcularNumeroFibonacci(15));
        } catch(ValorNoPermitido ex) {
            System.err.println(ex.getMessage());
        }
        
        try {
            System.out.println(f1.calcularNumeroFibonacci(0));
            System.out.println(f1.calcularNumeroFibonacci(-5));
        } catch(ValorNoPermitido ex) {
            System.err.println(ex.getMessage());
        }
    }
}
