Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de efetuar alteração de um Cadastro de Contribuinte Singular Conta Própria sem IVA - adicionando IVA

  Background: 
    Given realizo login no SIGT
    
  Scenario: validar que quando é feita a cessação do Regime em IVA, é exigido o Motivo de suspensão
    Given estou no formulário de Cadastro
    And faço um cadastro de contribuinte Singular Conta Própria - com IVA
    When acedo a tela de consulta de formulários de Cadastro e faço a pesquisa do contribuinte cadastrado
    And altero e clico em cessar o regime de IVA sem informar o Motivo da suspensão
    Then visualizo a mensagem de exceção da sessão do para informar o Motivo de suspensão
    
    