Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de criar um NIF Colectivo Associação Obrigado a Cativar IVA

  Background: 
    Given realizo login no SIGT

  Scenario: Criar NIF Colectivo Associação Obrigado a Cativar IVA
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Colectivo Associação Obrigado a Cativar IVA
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro
