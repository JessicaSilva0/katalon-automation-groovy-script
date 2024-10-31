Feature: Cadastro do Contribuinte
   Como técnico, devo ser capaz de publicar o formulário de cadastro e imprimir os comprovativos de Cadastro

  Background: 
    Given realizo login no SIGT
    
  Scenario: Contribuinte Colectivo - Residente - Instituição Publica com Regime de IVA - Obrigado a cativar o IVA (artigo 21º do CIVA)
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Colectivo Instituição Publica Obrigado a Cativar IVA
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro