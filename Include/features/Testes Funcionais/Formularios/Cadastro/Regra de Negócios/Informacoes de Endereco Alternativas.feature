Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de validar as mensagens de exceções do formulário de Cadastro

  Background: 
    Given realizo login no SIGT

  Scenario: Singular - Informações de endereço alternativas - Validação da obrigatoriedade de campos
    Given estou no formulário de Cadastro
    And preencho apenas o campo País e deixo os demais campos obrigatórios da secção Informações de endereço alternativas vazios
    When clico no botão Verificar Formulario do Cadastro
    Then devo visualizar as mensagens de exceções da secção Informações de endereço alternativas
