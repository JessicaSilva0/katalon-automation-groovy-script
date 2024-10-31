Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de cadastar um Contribuinte Colectivo Associação Residente  - Regime de II - Regime Geral

  Background: 
    Given realizo login no SIGT

  Scenario: Cadastro de Contribuinte Colectivo Associação Residente - Regime de II - Regime Geral
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Colectivo Associação com Regime de II - Regime Geral
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro