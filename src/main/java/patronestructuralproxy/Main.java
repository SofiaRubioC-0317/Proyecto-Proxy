package patronestructuralproxy;

import java.util.Scanner;
import patronestructuralproxy.interfaces.ICuenta;
import patronestructuralproxy.interfaces.impl.CuentaBancoAImpl;
import patronestructuralproxy.interfaces.impl.CuentaBancoBImpl;
import patronestructuralproxy.model.Cuenta;
import patronestructuralproxy.proxy.CuentaProxy;
import patronestructuralproxy.utils.ConsoleColors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cuenta c = new Cuenta(1, "mitocode", 100);

        System.out.println(ConsoleColors.CYAN_BOLD + "=== SELECCIÓN DE BANCO ===" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.YELLOW + "1. Banco A (Estándar, sin comisiones)");
        System.out.println("2. Banco B (Con comisión de 0.20 en depósitos)" + ConsoleColors.RESET);
        System.out.print(ConsoleColors.WHITE_BOLD + "Elija su banco: " + ConsoleColors.RESET);

        int bancoElegido = 0;
        try {
            bancoElegido = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(ConsoleColors.RED + "Entrada no válida. Usando Banco A por defecto." + ConsoleColors.RESET);
            bancoElegido = 1;
        }

        ICuenta bancoReal;
        if (bancoElegido == 2) {
            bancoReal = new CuentaBancoBImpl();
            System.out.println(ConsoleColors.GREEN + "Ha seleccionado Banco B." + ConsoleColors.RESET);
        } else {
            bancoReal = new CuentaBancoAImpl();
            System.out.println(ConsoleColors.GREEN + "Ha seleccionado Banco A." + ConsoleColors.RESET);
        }

        ICuenta cuentaProxy = new CuentaProxy(bancoReal);

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