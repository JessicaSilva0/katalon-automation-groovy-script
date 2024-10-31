Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de validar as mensagens de exceções do formulário de Cadastro

  Background: 
    Given realizo login no SIGT

  Scenario: Singular - Validação da obrigatoriedade de campos da Representação Fiscal
    Given estou no formulário de Cadastro
    Then visualizo as mensagens de exceções da secção Representação Fiscal