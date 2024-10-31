Feature: Cadastro do Contribuinte
    Como Tester quero garantir que o Regime Geral - IVA de CAIXA só fica disponível para Origem Oficiosa.

  Background: 
    Given realizo login no SIGT

  Scenario: Garantir que o Regime Geral - IVA de CAIXA só fica disponível para Origem Oficiosa
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Trabalhador por conta própria com IVA
    And pesquiso o contribuinte que foi cadastrado para fazer alteracao
    Then verificar se regime de caixa esta disponivel para oficiosa