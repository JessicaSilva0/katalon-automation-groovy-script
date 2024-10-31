Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de criar um NIF singular por conta de outrém Funcionário Público

  Background: 
    Given realizo login no SIGT

  Scenario: Singular - Criar NIF Trabalhador Conta de Outrém - Funcionário Público
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Trabalhador por conta de Outrém - Funcionário Público
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro