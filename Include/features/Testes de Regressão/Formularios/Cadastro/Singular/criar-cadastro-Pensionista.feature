Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de criar um NIF singular Pensionista

  Background: 
    Given realizo login no SIGT

  Scenario: Singular - Criar NIF Pensionista
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Pensionista
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro
