@smoketest
Feature:  navegación en el site de motor.es
 Quiero navegar por el web site motor.es
 
 Scenario: Navegar a la página de noticias usando el menu principal 
    Given que el usuario esta en la pagina de inicio
    When el usuario hace click en la opcion Noticias del menu
    Then se muestra la pagina de Noticias    

	@movil @noticias
  Scenario: Navegar a la página de noticias usando el menu lateral 
    Given que el usuario esta en la pagina de inicio
    When el usuario despliega el menu lateral
    And el usuario hace click en la opcion Noticias del menu lateral
    Then se muestra la pagina de Noticias

  Scenario: Navegar a la página de noticias de fórmula 1 usando el menu principal
    Given que el usuario esta en la pagina de inicio
    When el usuario hace click en la opcion formula1 del menu
    Then se muestra la pagina de noticias de la formula1

	@movil
  Scenario: Navegar a la página de noticias de fórmula 1 usando el menu lateral
    Given que el usuario esta en la pagina de inicio
    When el usuario despliega el menu lateral
    And el usuario hace click en la opcion formula1 del menu lateral
    Then se muestra la pagina de noticias de la formula1

  @movil @clasificacion
  Scenario: Navegar a la página con la clasificacion del campeonato de fórmula 1 usando el menu lateral
    Given que el usuario esta en la pagina de inicio
    When el usuario despliega el menu lateral
    And el usuario despliega el submenu formula1
    And el usuario hace click en la opcion que contiene la palabra clasificacion
    Then se muestra la pagina con la clasificacion del campeonato de formula1

  @movil
  Scenario: Navegar a la página con los pilotos del campeonato de fórmula 1 usando el menu lateral
    Given que el usuario esta en la pagina de inicio
    When el usuario despliega el menu lateral
    And el usuario despliega el submenu formula1
    And el usuario hace click en la opcion pilotos
    Then se muestra la pagina con los pilotos del campeonato de formula1

  @movil @escuderias
  Scenario: Navegar a la página con las escuderias del campeonato de fórmula 1 usando el menu lateral
    Given que el usuario esta en la pagina de inicio
    When el usuario despliega el menu lateral
    And el usuario despliega el submenu formula1
    And el usuario hace click en la opcion escuderias
    Then se muestra la pagina con las escuderias del campeonato de formula1

  @movil
  Scenario: Navegar a la página con el calendario del campeonato de fórmula 1 usando el menu lateral
    Given que el usuario esta en la pagina de inicio
    When el usuario despliega el menu lateral
    And el usuario despliega el submenu formula1
    And el usuario hace click en la opcion que contiene la palabra calendario
    Then se muestra la pagina con el calendario del campeonato de formula1
    
  Scenario: Navegar a la página de coches Km 0 usando el menu principal 
    Given que el usuario esta en la pagina de inicio
    When el usuario hace click en la opcion coche Km0 del menu
    Then se muestra la pagina de busqueda de coches Km0    

	@movil
  Scenario: Navegar a la página de coches Km 0 usando el menu lateral 
    Given que el usuario esta en la pagina de inicio
    When el usuario despliega el menu lateral
    And el usuario hace click en la opcion coche Km0 del menu lateral
    Then se muestra la pagina de busqueda de coches Km0
    
  @renting
	Scenario: Navegar a la página de renting usando el menu principal 
    Given que el usuario esta en la pagina de inicio
    When el usuario hace click en la opcion renting del menu
    Then se muestra la pagina de principal de renting    

	@movil @renting
  Scenario: Navegar a la página de renting usando el menu lateral 
    Given que el usuario esta en la pagina de inicio
    When el usuario despliega el menu lateral
    And el usuario hace click en la opcion renting del menu lateral
    Then se muestra la pagina de principal de renting