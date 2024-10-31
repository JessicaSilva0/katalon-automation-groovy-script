Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de criar um NIF Colectivo Organismo Internacional Com Regime de IVA Cativo

  Background: 
    Given realizo login no SIGT

  Scenario: Criar NIF Colectivo Instituição Pública com Regime de IVA Sem Direito a Deduções
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Colectivo Organismo Internacional com Regime de IVA Cativo
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro