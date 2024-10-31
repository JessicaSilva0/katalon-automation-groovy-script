 Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de criar um NIF Colectivo Organismo Internacional - Residente

  Background: 
    Given realizo login no SIGT

  Scenario: Criar NIF Colectivo Organismo Internacional - Residente
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Colectivo Organismo Internacional - Residente
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro