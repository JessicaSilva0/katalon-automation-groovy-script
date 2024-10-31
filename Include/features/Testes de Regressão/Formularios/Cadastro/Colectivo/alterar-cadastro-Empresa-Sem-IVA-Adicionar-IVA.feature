Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de efetuar alteração de um Cadastro de Contribuinte Coletivo Empresa sem IVA - adicionando IVA

  Background: 
    Given realizo login no SIGT

  Scenario: Alterar um Cadastro de Contribuinte Coletivo Empresa sem IVA - adicionando IVA
    Given estou no formulário de Cadastro
    And faço um cadastro de contribuinte Coletctivo Empresa - sem IVA
   	And acedo a tela de consulta de formulários de Cadastro e faço a pesquisa do contribuinte cadastrado
    And altero o formulário cadastrado para Colectivo Empresa com IVA
    When valido e publico o formulario
   	Then devo ver o estado "Aguardando aprovação - Nível 1"
  
    
