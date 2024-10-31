Feature: Cadastro do Contribuinte

  Background: 
    Given realizo login no SIGT

  Scenario: Singular - Trabalhador por conta própria - Identificação de Agências - Mapeamento de campos
    Given estou no formulário de Cadastro
    And seleciono o tipo de contribuinte Conta Própria ou Outrém na secção Detalhes do Registo
    And informo os campos da navegação Identificação de Agencias
  