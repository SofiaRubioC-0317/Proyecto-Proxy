package patronestructuralproxy.interfaces.impl;

import patronestructuralproxy.interfaces.ICuenta;
import patronestructuralproxy.model.Cuenta;
import patronestructuralproxy.utils.ConsoleColors;

public class CuentaBancoAImpl implements ICuenta {
    @Override
    public Cuenta retirarDinero(Cuenta cuenta, double monto) {
        double saldoActual = cuenta.getSaldoInicial() - monto;
        cuenta.setSaldoInicial(saldoActual);
        System.out.println(ConsoleColors.GREEN + "Retiro exitoso en Banco A. " + ConsoleColors.RESET + "Saldo actual: " + ConsoleColors.CYAN + cuenta.getSaldoInicial() + ConsoleColors.RESET);
        return cuenta;
    }

    @Override
    public Cuenta depositarDinero(Cuenta cuenta, double monto) {
        double saldoActual = cuenta.getSaldoInicial() + monto;
        cuenta.setSaldoInicial(saldoActual);
        System.out.println(ConsoleColors.GREEN + "Depósito exitoso en Banco A. " + ConsoleColors.RESET + "Saldo actual: " + ConsoleColors.CYAN + cuenta.getSaldoInicial() + ConsoleColors.RESET);
        return cuenta;
    }

    @Override
    public void mostrarSaldo(Cuenta cuenta) {
        System.out.println("Saldo actual: " + ConsoleColors.CYAN_BOLD + cuenta.getSaldoInicial() + ConsoleColors.RESET);
    }
}
