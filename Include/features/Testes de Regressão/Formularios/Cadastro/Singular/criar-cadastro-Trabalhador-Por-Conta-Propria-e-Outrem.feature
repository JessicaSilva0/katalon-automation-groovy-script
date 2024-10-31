Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de criar um NIF singular por conta Própria e de outrém

  Background: 
    Given realizo login no SIGT

  Scenario: Singular - Criar NIF Trabalhador Conta Própria e de Outrém
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Trabalhador por conta própria e outrém
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro e Comprovativo Modelo 6
