Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de cadastar um Contribuinte Colectivo Residente INSTITUIÇÃO PÚBLICA - Regime de II - Regime Geral (Sector Financeiro)

  Background: 
    Given realizo login no SIGT

  Scenario: Cadastro de Contribuinte Colectivo Residente INSTITUIÇÃO PÚBLICA - Regime de II - Regime Geral (Sector Financeiro)
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Colectivo Instituição Pública com Regime de II - Regime Geral Sector Financeiro
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro