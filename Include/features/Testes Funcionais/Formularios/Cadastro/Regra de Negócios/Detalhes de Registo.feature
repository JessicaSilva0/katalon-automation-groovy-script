Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de validar as mensagens de exceções do formulário de Cadastro

  Background: 
    Given realizo login no SIGT
    When estou no formulário de Cadastro

  Scenario: Singular - Validação da obrigatoriedade de campos do Detalhes de Registo
    And não preencho os campos obrigatórios da secção Detalhes do Registo
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções do Detalhes do Registo

  Scenario: Colectivo - Validação da obrigatoriedade de campos do Detalhes de Registo
    Then valido o formulário sem preencher o tipo do contribuinte Colectivo