@smoketest
Feature:  búsqueda de coches de Km 0 en el site de motor.es
 Quiero hacer búsquedas de coches de Km 0 en el web site motor.es

	@movil
  Scenario Outline: hacer búsqueda de coches por marca y modelo
    Given que el usuario esta en la pagina de busqueda de coches Km0
    When el usuario seleciona la marca <marca> y el modelo <modelo> del coche que quiere buscar
    Then se muestra el resultado de la busqueda efectuada
  Examples: 
     | marca     | modelo   |
     | "Renault" | "Megane" |
     | "Ford"    | "Focus"  |
     | "Seat"    | "Leon"   |
  
