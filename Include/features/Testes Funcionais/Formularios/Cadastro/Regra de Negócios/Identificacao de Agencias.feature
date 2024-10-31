Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de validar as mensagens de exceções do formulário de Cadastro

  Background: 
    Given realizo login no SIGT

  Scenario: Colectivo - Validação da obrigatoriedade de campos da secção Identificação de Agências
    Given estou no formulário de Cadastro
    And seleciono o tipo de contribuinte Colectivo - Empresa
    And não preencho o campo obrigatório Porcentagem de Participação da sessão Identificação de Agências
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções da sessão Identificação de Agências
