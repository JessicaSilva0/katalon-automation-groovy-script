Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de criar um NIF singular por conta Própria, de outrém e Pensionista

  Background: 
    Given realizo login no SIGT

  Scenario: Singular Residente - Trabalhador Conta Própria, de Outrém e Pensionista
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Trabalhador por conta própria, outrém e Pensionista - Residente
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro e Comprovativo Modelo 6

  Scenario: Singular Não Residente - Trabalhador Conta Própria, de Outrém e Pensionista
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Trabalhador por conta própria, outrém e Pensionista - Não Residente
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro e Comprovativo Modelo 6
