Feature: Cadastro do Contribuinte
    	Como Técnico, quero ser capaz de realizar as validações de obrigatoriedade dos campos da secção Informação de endereço
    
  Background: 
    Given realizo login no SIGT

  Scenario: Singular - Informação de endereço - Validação da obrigatoriedade de campos
    Given estou no formulário de Cadastro
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções de Informação de endereço