Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de criar um NIF para Trabalhador por conta de outrém

  Background: 
    Given realizo login no SIGT

  Scenario: Criar NIF - Trabalhador Conta de Outrém - Singular Residente
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Trabalhador por conta de Outrém - Residente
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro

  Scenario: Criar NIF - Trabalhador Conta de Outrém - Singular Não Residente
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Trabalhador por conta de Outrém - Não Residente
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro
