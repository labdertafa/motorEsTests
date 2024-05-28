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
  
	@movil @precio
  Scenario Outline: hacer búsqueda de coches por precio y año
    Given que el usuario esta en la pagina de busqueda de coches Km0
    When el usuario seleciona el precio minimo <precio_min> y el precio maximo <precio_max> del coche
    And el usuario seleciona el anio minimo <anio_min> y el anio maximo <anio_max> del coche
    Then se muestra el resultado de la busqueda efectuada
  Examples: 
     | precio_min | precio_max | anio_min | anio_max |
     | 10000      | 20000      | 2021     | 2022     |
     | 15000      | 25000      | 2021     | 2022     |
     | 15000      | 25000      | 2022     | 2023     |
     | 20000      | 30000      | 2023     | 2024     |

	@movil @kilometro
  Scenario Outline: hacer búsqueda de coches por kilómetros y tipo de combustible
    Given que el usuario esta en la pagina de busqueda de coches Km0
    When el usuario seleciona el kilometraje minimo <kilometro_min> y el kilometraje maximo <kilometro_max> del coche
    And el usuario seleciona el tipo de combustible <combustible>
    Then se muestra el resultado de la busqueda efectuada
  Examples: 
     | kilometro_min | kilometro_max | combustible |
     | 2500          | 5000          | "Diésel"    |
     | 2500          | 5000          | "Gasolina"  |
     | 5000          | 10000         | "Gasolina"  |
     | 5000          | 10000         | "Eléctrico" |
     | 10000         | 15000         | "Eléctrico" |