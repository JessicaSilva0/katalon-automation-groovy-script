Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de criar um NIF Colectivo Empresa - Residente

  Background: 
    Given realizo login no SIGT

  Scenario: Criar NIF Colectivo Empresa - Residente
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Colectivo Empresa - Residente
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro
