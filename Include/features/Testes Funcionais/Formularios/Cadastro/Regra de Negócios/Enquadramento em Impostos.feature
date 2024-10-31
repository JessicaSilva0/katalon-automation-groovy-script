Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de validar as mensagens de exceções do formulário de Cadastro
    
    Rule: O campo Grupo de IRT é condicional ao tipo de contribuinte, torna-se obrigatório caso o tipo do contribuinte for Própria ou Outrém

  Background: 
    Given realizo login no SIGT

  Scenario: Singular - Validação da obrigatoriedade de campos do Enquadramento em Impostos
   	Given estou no formulário de Cadastro
   	And seleciono o tipo de contribuinte Conta Própria ou Outrém na secção Detalhes do Registo
    And não preencho o campo obrigatório Grupo de IRT
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções do Enquadramento em Impostos

 Scenario: Coletivo - Validação da obrigatoriedade de campos de Enquadramento em Impostos
		Given estou no formulário de Cadastro
		When seleciono o tipo de contribuinte Colectivo
		Then verifico o Formulário sem preencher o campo obrigatório Regime II da secção Enquadramento em Impostos  