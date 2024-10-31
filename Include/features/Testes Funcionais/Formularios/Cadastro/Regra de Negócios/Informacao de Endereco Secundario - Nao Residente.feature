Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de validar as mensagens de exceções do formulário de Cadastro
    
  Background: 
    Given realizo login no SIGT

  Scenario: Singular - Informação de endereço secundário - Validação da obrigatoriedade de campos
    Given estou no formulário de Cadastro
    And seleciono o Indicador de Não Residente "Não Residente"
    And não preencho os campos obrigatórios da secção Informação de endereço secundário
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções da secção Informação de endereço secundário