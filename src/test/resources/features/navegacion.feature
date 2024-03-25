@smoketest
Feature:  navegación en el site de motor.es
 Quiero navegar por el web site motor.es

  Scenario: Navegar a la página de noticias de fórmula 1 usando el menu principal
    Given que el usuario esta en la pagina de inicio
    When el usuario hace click en la opcion formula1 del menu
    Then se muestra la pagina de noticias de la formula1

  Scenario: Navegar a la página de noticias de fórmula 1 usando el menu lateral
    Given que el usuario esta en la pagina de inicio
    When el usuario despliega el menu lateral
    And el usuario hace click en la opcion formula1 del menu lateral
    Then se muestra la pagina de noticias de la formula1