package patronestructuralproxy.model;

/**
 * Representa una cuenta bancaria dentro del sistema.
 *
 * Esta clase contiene la información básica de una cuenta,
 * incluyendo su identificador, el usuario propietario y
 * el saldo inicial.
 *
 * Forma parte de la capa de modelo en la implementación
 * del patrón de diseño Proxy.
 *
 * @author Sofia
 */
public class Cuenta {

    /**
     * Identificador único de la cuenta.
     */
    private int idCuenta;

    /**
     * Nombre del usuario propietario de la cuenta.
     */
    private String usuario;

    /**
     * Saldo inicial de la cuenta.
     */
    private double saldoInicial;

    /**
     * Constructor que inicializa los atributos de la cuenta.
     *
     * @param idCuenta identificador único de la cuenta
     * @param usuario nombre del usuario propietario
     * @param saldoInicial saldo inicial de la cuenta
     */
    public Cuenta(int idCuenta, String usuario, double saldoInicial) {
        this.idCuenta = idCuenta;
        this.usuario = usuario;
        this.saldoInicial = saldoInicial;
    }

    /**
     * Obtiene el identificador de la cuenta.
     *
     * @return id de la cuenta
     */
    public int getIdCuenta() {
        return idCuenta;
    }

    /**
     * Establece el identificador de la cuenta.
     *
     * @param idCuenta nuevo identificador de la cuenta
     */
    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return nombre del usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param usuario nuevo nombre del usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene el saldo inicial de la cuenta.
     *
     * @return saldo inicial
     */
    public double getSaldoInicial() {
        return saldoInicial;
    }

    /**
     * Establece el saldo inicial de la cuenta.
     *
     * @param saldoInicial nuevo saldo inicial
     */
    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }
}
