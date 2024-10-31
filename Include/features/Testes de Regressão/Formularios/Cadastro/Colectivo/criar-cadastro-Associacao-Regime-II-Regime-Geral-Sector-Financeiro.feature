Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de criar um NIF Colectivo Associação - Residente

  Background: 
    Given realizo login no SIGT

  Scenario: Criar NIF Colectivo Associação - Residente - Regime de II - Regime Geral (Sector Financeiro)
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Colectivo Associação - Residente - Regime de II - Regime Geral - Sector Financeiro
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro
