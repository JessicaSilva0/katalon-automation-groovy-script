Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de validar as mensagens de exceções do formulário de Cadastro

  Background: 
    Given realizo login no SIGT

  Scenario: Validar Anexo Documento Bilhete de Identidade
    Given estou no formulário de Cadastro
    Then anexo o documento do tipo de Identificação: "Bilhete de Identidade"

  Scenario: Validar Anexo Documento Cartão de Refugiado
    Given estou no formulário de Cadastro
    Then anexo o documento do tipo de Identificação: "Cartão de Refugiado"

  Scenario: Validar Anexo Documento Cartão de Residente
    Given estou no formulário de Cadastro
    Then anexo o documento do tipo de Identificação: "Cartão de Residente"

  Scenario: Validar Anexo Documento Outro
    Given estou no formulário de Cadastro
    Then anexo o documento do tipo de Identificação: "Outro"

  Scenario: Validar Anexo Documento Passaporte
    Given estou no formulário de Cadastro
    Then anexo o documento do tipo de Identificação: "Passaporte"
