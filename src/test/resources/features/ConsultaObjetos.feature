@ConsultarObjetos
Feature: Consultar lista de Objetos
#Miguel Cordova

  @caso_objetos_uno @happypath
  Scenario: Validar la consulta de datos de un usuario
    Given que Objetos es una API publica
    When Se realiza la consulta de la lista de objetos
    Then valida la respuesta sea 200

