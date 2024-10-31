Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de criar um NIF Colectivo Empresa com Regime de IVA e Operações Mistas

  Background: 
    Given realizo login no SIGT

  Scenario: Criar NIF Colectivo Empresa - Regime de IVA - Operações Mistas
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Colectivo Empresa - Regime de IVA - Operações Mistas
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro
