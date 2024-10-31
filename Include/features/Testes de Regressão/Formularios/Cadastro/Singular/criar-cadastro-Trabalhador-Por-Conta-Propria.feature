Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de criar um NIF singular por conta Própria

  Background: 
    Given realizo login no SIGT

  Scenario: Criar NIF - Trabalhador por conta Própria - Singular Residente
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Trabalhador por conta própria - Residente
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro
    
      Scenario: Criar NIF - Trabalhador por conta Própria - Singular Não Residente
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Trabalhador por conta própria - Não Residente
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro
