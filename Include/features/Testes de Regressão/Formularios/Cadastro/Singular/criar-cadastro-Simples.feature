Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de criar um NIF singular Simples

  Background: 
    Given realizo login no SIGT

  Scenario: Singular - Criar NIF Simples - Residente
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Singular Simples
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro

  Scenario: Singular - Criar NIF Simples - Não Residente
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Singular Simples Não Residente
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro
