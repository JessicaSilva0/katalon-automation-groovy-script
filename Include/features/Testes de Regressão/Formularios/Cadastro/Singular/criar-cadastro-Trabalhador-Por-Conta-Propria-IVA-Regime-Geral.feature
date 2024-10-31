Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de criar um NIF singular por conta Própria em IVA - Regime Geral

  Background: 
    Given realizo login no SIGT

  Scenario: Criar NIF - Trabalhador por conta Própria en IVA Regime Geral - Singular Residente
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Trabalhador por conta própria com IVA Regime Geral
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro