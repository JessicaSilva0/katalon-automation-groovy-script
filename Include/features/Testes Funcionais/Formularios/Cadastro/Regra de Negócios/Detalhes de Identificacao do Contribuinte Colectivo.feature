Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de validar as mensagens de exceções do formulário de Cadastro

  Background: 
    Given realizo login no SIGT
    When estou no formulário de Cadastro

  Scenario: Validar Detalhes de Identificação do Contribuinte Colectivo
    Then valido as mensagens de exceções do Detalhes de Identificação do contribuinte Colectivo
