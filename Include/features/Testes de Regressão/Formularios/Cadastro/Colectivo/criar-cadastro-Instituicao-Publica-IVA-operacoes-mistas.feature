Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de criar um NIF Colectivo Instituição Pública - Residente

  Background: 
    Given realizo login no SIGT
    
  Scenario: Contribuinte Coletivo - Residente - Instituição Publica com Regime de IVA - Operações Mistas
    Given estou no formulário de Cadastro
    And seleciono o tipo de contribuinte Colectivo - Instituição Pública
    And preencho o formulário para Contribuinte - Instituição Publica - Residente com Regime de IVA - Operações Mistas
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro