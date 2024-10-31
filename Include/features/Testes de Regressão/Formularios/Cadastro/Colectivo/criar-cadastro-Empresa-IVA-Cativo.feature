Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de criar um NIF Colectivo Empresa com Regime de IVA Obrigado a cativar o IVA

  Background: 
    Given realizo login no SIGT

  Scenario: Contribuinte Colectivo - Residente - Empresa com Regime de IVA - Obrigado a cativar o IVA (artigo 21º do CIVA)
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Colectivo Empresa - Regime de IVA - Obrigado a cativar o IVA 
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro
