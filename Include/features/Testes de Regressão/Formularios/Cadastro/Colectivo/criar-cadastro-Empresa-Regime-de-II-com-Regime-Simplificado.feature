Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de publicar o formulário de cadastro e imprimir os comprovativos de Cadastro

  Background: 
    Given realizo login no SIGT
    
  Scenario: Cadastro de Contribuinte Colectivo Residente EMPRESA - Regime de II - Regime Simplificado

    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Colectivo Empresa com Regime de II - Regime Simplificado
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro