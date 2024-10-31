Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de validar as mensagens de exceções do formulário de Cadastro
    
     Rule: 
    1 - Validação dos campos obrigatórios sem condicionais
    2 - Na secção Detalhes de Contribuinte Singular ao selecionar os campos Pais Nacionalidade(Diferente de Angola) e Pais Naturalidade(Igual a Angola), os campos "Nif do País de Nacionalidade", "Província" e "Município" passam a ser obrigatórios

  Background: 
    Given realizo login no SIGT

  Scenario: Singular - Validação da obrigatoriedade de campos
    Given estou no formulário de Cadastro
    And não preencho os campos obrigatórios da secção Detalhes de Contribuinte Singular
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções do Detalhes de Contribuinte Singular

  Scenario: Singular - Validação da obrigatoriedade dos campos Pais Nacionalidade e Pais Naturalidade
    Given estou no formulário de Cadastro
    And preencho apenas os campos Pais Nacionalidade diferente de Angola e Pais Naturalidade igual a Angola da secção Detalhes de Contribuinte Singular
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções dos campos Nif do País de Nacionalidade, Província e Município de Detalhes de Contribuinte Singular
