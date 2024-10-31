Feature: Cadastro do Contribuinte
    Como técnico, quero garantir que o sistema permita efetuar alteração de um Cadastro de Contribuinte - Coletivo - Organismo Internacional com IVA de forma esperada.

  Background: 
    Given realizo login no SIGT

  Scenario:  alterar um cadastro de Contribuinte - Coletivo - Organismo Internacional com IVA, publicar o formulário de cadastro e imprimir os comprovativos de Cadastro
    Given estou no formulário de Cadastro
    And faço um cadastro de contribuinte Coletivo - Organismo Internacional - com IVA
    And acedo a tela de consulta de formulários de Cadastro e faço a pesquisa do contribuinte cadastrado
    And altero os dados do formulário cadastrado - Organismo Internacional - com IVA
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro