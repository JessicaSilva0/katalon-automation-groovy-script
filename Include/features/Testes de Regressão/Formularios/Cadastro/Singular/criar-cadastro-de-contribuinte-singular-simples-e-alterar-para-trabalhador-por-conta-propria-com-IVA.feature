Feature: Cadastro do Contribuinte    
    Como Tester quero garantir que o sistema permita efetuar alteração de um Cadastro de Contribuinte Singular Simples 
    registado no sistema para Trabalhador por Conta Própria com IVA de forma esperada.
    
  Background: 
    Given realizo login no SIGT
    
  Scenario: Alteração de Cadastro de Contribuinte - Singular - Simples para um Trabalhador por Conta Própria
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Singular Simples
    When valido e publico o formulario
    And pesquiso o contribuinte que foi cadastrado para fazer alteracao
    And preencho os dados do formulario em falta devido alteração de simples para Trabalhador por conta própria com IVA
    Then valido e publico o formulario