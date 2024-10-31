Feature: Cadastro do Contribuinte
    Como técnico, quero garantir que o sistema permite efetuar alteração de um Cadastro de Contribuinte - Coletivo - Associação com IVA de forma esperada.

  Background: 
    Given realizo login no SIGT

  Scenario: Alterar um Cadastro de Contribuinte Coletivo Associacao com IVA
    Given estou no formulário de Cadastro
    And faço um cadastro de contribuinte Coletivo Associacao - com IVA
   	And acedo a tela de consulta de formulários de Cadastro e faço a pesquisa do contribuinte cadastrado
    And altero os dados do formulário cadastrado - Associacao - com IVA
    When valido e publico o formulario
   	Then imprimo o Comprovativo de Cadastro
  
    
