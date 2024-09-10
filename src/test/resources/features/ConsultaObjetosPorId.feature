@ConsultarObjetosID
Feature: Consultar lista de Objetos por ID
#Miguel Cordova

  @caso_objetos_id_uno @happypath
  Scenario Outline: Validar la consulta de datos de un usuario
    Given que Objetos es una API publica
    When Se inserta parametros al api consultar datos de Objetos <id>
    Then valida la respuesta sea 200
    Examples:
      | id |
      | 1  |
      | 3  |
      | 5  |

