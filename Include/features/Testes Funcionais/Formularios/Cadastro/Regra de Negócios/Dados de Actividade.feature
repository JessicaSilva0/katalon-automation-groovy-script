Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de validar as mensagens de exceções do formulário de Cadastro

  Background: 
    Given realizo login no SIGT

  Scenario: Validar Dados de Actividade
    Given estou no formulário de Cadastro
    And não preencho os campos obrigatórios na secção Dados de Actividade
