Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de efetuar alteração de um Cadastro de Contribuinte Coletivo Empresa com IVA - Regime Geral para Regime Simplificado

  Background: 
    Given realizo login no SIGT

  Scenario: Alterar um Cadastro de Contribuinte Coletivo Empresa com IVA - Regime Geral para Regime Simplificado
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Colectivo Empresa com Regime Geral de IVA
    And acedo a tela de consulta de formulários de Cadastro e faço a pesquisa do contribuinte cadastrado
    And altero o formulário cadastrado para Colectivo Empresa de IVA - Regime Geral para Simplificado
    When valido e publico o formulario
    Then devo ver o estado "Aguardando aprovação - Nível 1"
