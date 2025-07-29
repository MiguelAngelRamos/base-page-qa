# Proyecto de Automatización de Pruebas con Selenium, Cucumber y JUnit 5

---

## Estructura de recursos y archivos feature

- **resources/features/**: Carpeta donde se almacenan los archivos `*.feature`.
- **Archivos `*.feature`**: Son archivos escritos en lenguaje Gherkin que describen escenarios de prueba en formato BDD (Behavior Driven Development). Cada escenario representa un caso de prueba derivado de los casos de uso del sistema. Ejemplo:
  ```gherkin
  Feature: Login
    Scenario: Login con credenciales inválidas
      Given I am on the login page
      When I enter email "correo@invalido" and password "123"
      Then I should see email validation error
  ```
- **Relación con BDD**: Los archivos feature permiten que los casos de prueba sean legibles por personas técnicas y no técnicas, facilitando la colaboración y el entendimiento del comportamiento esperado del sistema.

## ¿Qué son los steps y los step definitions?

- **Steps**: Son las líneas escritas en los archivos feature (Given, When, Then, And) que describen acciones y validaciones.
- **Step Definitions**: Son las implementaciones en Java que conectan cada step con el código que ejecuta la acción o validación en la aplicación. Por ejemplo, el step `Given I am on the login page` se implementa en una clase de steps como un método Java que navega a la página de login.

## ¿Qué es BasePage y por qué usarla?

- **BasePage**: Es una clase base que centraliza la lógica común de interacción con Selenium WebDriver (navegación, búsqueda de elementos, acciones, validaciones, etc.).
- **Práctica reconocida**: Usar una clase base permite reutilizar código, mantener la consistencia y facilitar el mantenimiento de los tests. Todas las páginas específicas (LoginPage, GooglePage, etc.) heredan de BasePage y aprovechan sus métodos.

## Documentación del flujo del proyecto

1. **Inicio de escenario**: Cucumber ejecuta el hook `@Before`, que inicializa el WebDriver y la página bajo prueba.
2. **Ejecución de steps**: Cada step del archivo feature se traduce en una acción o validación implementada en los step definitions.
3. **Interacción con la aplicación**: Los step definitions usan las clases de página (que heredan de BasePage) para interactuar con la aplicación web.
4. **Cierre de escenario**: Al finalizar el escenario, el hook `@After` cierra el navegador y libera recursos.

## Dependencias principales

- **Java 17**
- **JUnit Jupiter 5.10.2**: Framework de pruebas unitarias.
- **Selenium 4.21.0**: Automatización de navegadores web.
- **Cucumber 7.15.0**: Framework BDD para definir y ejecutar escenarios.
- **WebDriverManager 5.8.0**: Gestión automática de drivers de navegador.

---

Este proyecto sigue buenas prácticas de automatización y BDD, facilitando la colaboración y el mantenimiento de los tests automatizados.

---

**Author:** Miguel Ramos  
**Licencia:** MIT  
[GitHub](https://github.com/MiguelAngelRamos)
