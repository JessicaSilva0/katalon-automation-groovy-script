Feature: Cadastro do Contribuinte

  Background: 
    Given realizo login no SIGT

  Scenario: Validar regra de Contribuinte Colectivo Residente INSTITUIÇÃO PÚBLICA - Regime Simplificado de II
    Given estou no formulário de Cadastro
    When preencho os dados do formulario para Colectivo Instituição Pública com Regime Simplificado de II
    Then valido a mensagem de exceção para a instituição pública em regime simplificado de II