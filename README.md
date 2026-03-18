# Patrón Estructural Proxy en Java - Sistema Bancario

Este proyecto es una **implementación del patrón estructural Proxy en Java**. Simula un sistema bancario donde se manejan cuentas, depósitos y retiros, usando un **proxy** para controlar el acceso a las operaciones y agregar funcionalidades adicionales (como logging y validaciones).

---

## Tabla de Contenidos
- [Descripción](#descripción)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Instalación](#instalación)
- [Uso](#uso)
- [Tecnologías](#tecnologías)
- [Contribuciones](#contribuciones)
- [Licencia](#licencia)

---

## Descripción
El proyecto incluye:

- **Interfaces:**  
  `ICuenta` define los métodos que todas las cuentas deben implementar (`retirarDinero`, `depositarDinero`, `mostrarSaldo`).

- **Implementaciones de cuentas:**  
  - `CuentaBancoAImpl` – Implementación de una cuenta que simplemente realiza depósitos y retiros.  
  - `CuentaBancoBImpl` – Implementación que agrega una comisión en los depósitos.

- **Modelo:**  
  `Cuenta` contiene la información básica de la cuenta: ID, usuario y saldo.

- **Proxy:**  
  `CuentaProxy` controla el acceso a las cuentas reales, mostrando mensajes de logging en consola y permitiendo cambiar la cuenta subyacente sin modificar su uso.

- **Utilidades:**  
  `ConsoleColors` permite colorear los mensajes en consola para una mejor visualización de operaciones.

- **Main:**  
  Punto de entrada donde se presenta un **menú interactivo** para probar operaciones con las cuentas bancarias.

---

## Estructura del Proyecto
```text
patron-estructural-proxy/
│
├─ src/main/java/patronestructuralproxy/
│   ├─ interfaces/
│   │   ├─ ICuenta.java
│   │   └─ impl/
│   │       ├─ CuentaBancoAImpl.java
│   │       └─ CuentaBancoBImpl.java
│   ├─ model/
│   │   └─ Cuenta.java
│   ├─ proxy/
│   │   └─ CuentaProxy.java
│   ├─ utils/
│   │   └─ ConsoleColors.java
│   └─ Main.java
├─ pom.xml
└─ .gitignore
Instalación
Requisitos

Java 17+

Maven 3+

IDE recomendado: IntelliJ IDEA, Eclipse o VS Code

Pasos

Clonar el repositorio:

git clone https://github.com/SofiaRubioC-0317/Proyecto-Proxy.git

Entrar en la carpeta del proyecto:

cd patron-estructural-proxy

Construir el proyecto con Maven:

mvn clean install

Ejecutar la aplicación:

mvn exec:java -Dexec.mainClass="patronestructuralproxy.Main"
Uso

Al ejecutar el proyecto, se desplegará un menú interactivo:

Mostrar saldo

Depositar dinero

Retirar dinero

Salir

Ejemplo de interacción:

=== MENÚ DE CUENTA BANCARIA ===
1. Mostrar Saldo
2. Depositar Dinero
3. Retirar Dinero
4. Salir

=== SELECCIÓN DE BANCO ===
1. Banco A (Estándar, sin comisiones)
2. Banco B (Con comisión de 0.20 en depósitos)   
como son 2 bancos ,el usuario puede elegir el banco CON comisión y SIN comision

Seleccione una opción: 2
Ingrese el monto a depositar: 200
Depósito exitoso en Banco B (con comisión). Saldo actual: 300.2



El proxy registra las acciones realizadas en la consola con mensajes coloreados para distinguir operaciones.

Tecnologías

Java 17

Maven 3

IDE recomendado: IntelliJ IDEA

Git para control de versiones

Contribuciones

Si deseas contribuir:

Haz un fork del proyecto.

Crea una rama para tu feature:

git checkout -b mi-feature

Realiza cambios y haz commit:

git commit -m "Agrego nueva funcionalidad"

Envía un Pull Request.

Licencia

Este proyecto está bajo la licencia MIT.
