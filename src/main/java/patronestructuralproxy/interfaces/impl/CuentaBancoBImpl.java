package patronestructuralproxy.interfaces.impl;

import patronestructuralproxy.interfaces.ICuenta;
import patronestructuralproxy.model.Cuenta;
import patronestructuralproxy.utils.ConsoleColors;

public class CuentaBancoBImpl implements ICuenta {
    @Override
    public Cuenta retirarDinero(Cuenta cuenta, double monto) {
        double saldoActual = cuenta.getSaldoInicial() - monto;
        cuenta.setSaldoInicial(saldoActual);
        System.out.println(ConsoleColors.GREEN + "Retiro exitoso en Banco B. " + ConsoleColors.RESET + "Saldo actual: " + ConsoleColors.CYAN + cuenta.getSaldoInicial() + ConsoleColors.RESET);
        return cuenta;
    }

    @Override
    public Cuenta depositarDinero(Cuenta cuenta, double monto) {
        double saldoActual = cuenta.getSaldoInicial() + monto + 0.20;
        cuenta.setSaldoInicial(saldoActual);
        System.out.println(ConsoleColors.GREEN + "Depósito exitoso en Banco B (con comisión). " + ConsoleColors.RESET + "Saldo actual: " + ConsoleColors.CYAN + cuenta.getSaldoInicial() + ConsoleColors.RESET);
        return cuenta;
    }

    @Override
    public void mostrarSaldo(Cuenta cuenta) {
        System.out.println("Saldo actual: " + ConsoleColors.CYAN_BOLD + cuenta.getSaldoInicial() + ConsoleColors.RESET);
    }
}
