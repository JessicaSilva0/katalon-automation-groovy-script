Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de criar Contribuinte Coletivo - Residente - Organismo Internacional com Regime de IVA - Operações Mistas

  Background: 
    Given realizo login no SIGT

  Scenario: Contribuinte Coletivo - Residente - Organismo Internacional com Regime de IVA - Operações Mistas
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Organismo Internacional com Regime em IVA - Operações Mistas
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro