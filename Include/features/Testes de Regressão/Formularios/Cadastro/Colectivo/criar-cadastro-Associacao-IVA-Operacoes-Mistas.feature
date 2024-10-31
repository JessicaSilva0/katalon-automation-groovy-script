Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de criar um NIF Colectivo Associação Regime de IVA Operações Mistas

  Background: 
    Given realizo login no SIGT

  Scenario: Criar NIF Colectivo Associação com Regime em IVA Operações Mistas
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Colectivo Associação com Regime em IVA Operações Mistas
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro
