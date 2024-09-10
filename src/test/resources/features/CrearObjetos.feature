@ConsultarObjetosID
Feature: Consultar lista de Objetos por ID
#Miguel Cordova

  @caso_crear_objetos_uno @happypath
  Scenario Outline: Validar la consulta de datos de un usuario
    Given que Objetos es una API publica
    When Se inserta parametros al api crear datos de objetos <nombre>, <periodo>, <precio>, <modelo>, <capacidad>
    Then valida la respuesta sea 200
    Examples:
      | nombre        | periodo | precio | modelo | capacidad |
      | Apple iPad 44 | 2015    | 1600   | I9     | 200 GB    |


