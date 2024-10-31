Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de criar um NIF singular por conta Própria
    
  Background: 
    Given realizo login no SIGT
    
  Scenario: Validar o volume de negócio de IVA para o regime de simplificado de um contribuinte
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Trabalhador por conta própria com IVA Regime Geral tendo em conta a regra do Volume de Negocio
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro