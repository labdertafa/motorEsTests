@smoketest @movil @renting
Feature:  renting de coches a través del sitio motor.es
 Quiero investigar las opciones de renting a través de la página motor.es
 
 Scenario Outline: ver las distintas opciones de renting 
    Given que el usuario esta en la pagina de renting
    When el usuario hace click en la opcion <opcion>
    And el usuario indica la couto máxima <couta>, les meses de renting <meses> y los kilometros por anio <kilometros>
    Then se muestran las ofertas disponibles con los filtros indicados
  Examples: 
     | opcion               | couta   | meses | kilometros |
     | "Pequeño o compacto" | 400     | 36    | 10000      |
     | "Sedán / Berlina"    | 500     | 36    | 10000      |
     | "Familiar"           | 500     | 48    | 15000      |
     | "Monovolumen"        | 500     | 48    | 10000      |
     | "Suv y 4x4"          | 600     | 48    | 15000      |
     | "Deportivo o coupe"  | 600     | 60    | 10000      |
     | "Cabrio"             | 500     | 48    | 20000      |