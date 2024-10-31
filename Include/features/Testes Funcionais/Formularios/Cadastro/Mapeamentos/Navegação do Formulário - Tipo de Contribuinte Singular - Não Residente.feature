Feature: Cadastro do Contribuinte

  Background: 
    Given realizo login no SIGT

  Scenario: Mapeamento - Navegação do Formulário - Tipo de Contribuinte Singular - Não Residente
    Given estou no formulário de Cadastro
    When seleciono o Indicador de Não Residente "Não Residente"
    Then devo visualizar os 14 formulários de cadastro