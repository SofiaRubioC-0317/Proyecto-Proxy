package patronestructuralproxy;


import java.util.Scanner;
import patronestructuralproxy.interfaces.ICuenta;
import patronestructuralproxy.interfaces.impl.CuentaBancoBImpl;
import patronestructuralproxy.model.Cuenta;
import patronestructuralproxy.proxy.CuentaProxy;
import patronestructuralproxy.utils.ConsoleColors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cuenta c = new Cuenta(1, "mitocode", 100);

        ICuenta cuentaProxy = new CuentaProxy(new CuentaBancoBImpl());
        
        boolean salir = false;
        while (!salir) {
            System.out.println("\n" + ConsoleColors.CYAN_BOLD + "=== MENÚ DE CUENTA BANCARIA ===" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.YELLOW + "1. Mostrar Saldo");
            System.out.println("2. Depositar Dinero");
            System.out.println("3. Retirar Dinero");
            System.out.println("4. Salir" + ConsoleColors.RESET);
            System.out.print(ConsoleColors.WHITE_BOLD + "Seleccione una opción: " + ConsoleColors.RESET);
            
            int opcion = 0;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(ConsoleColors.RED + "Por favor, ingrese un número válido." + ConsoleColors.RESET);
                continue;
            }

            switch (opcion) {
                case 1:
                    cuentaProxy.mostrarSaldo(c);
                    break;
                case 2:
                    System.out.print(ConsoleColors.WHITE_BOLD + "Ingrese el monto a depositar: " + ConsoleColors.RESET);
                    double montoDeposito = Double.parseDouble(scanner.nextLine());
                    c = cuentaProxy.depositarDinero(c, montoDeposito);
                    break;
                case 3:
                    System.out.print(ConsoleColors.WHITE_BOLD + "Ingrese el monto a retirar: " + ConsoleColors.RESET);
                    double montoRetiro = Double.parseDouble(scanner.nextLine());
                    c = cuentaProxy.retirarDinero(c, montoRetiro);
                    break;
                case 4:
                    salir = true;
                    System.out.println(ConsoleColors.GREEN_BOLD + "Gracias por usar el sistema." + ConsoleColors.RESET);
                    break;
                default:
                    System.out.println(ConsoleColors.RED + "Opción no válida." + ConsoleColors.RESET);
            }
        }
        scanner.close();
    }
}