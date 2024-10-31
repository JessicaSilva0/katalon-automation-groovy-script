Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de validar as mensagens de exceções do formulário de Cadastro
  
  
  1 - Na secção Identificação dos Sócios quando não informamos nenhum dos campos, o sistema apresenta uma validação geral "Identificação dos Sócios: Detalhes do Sócio requerido."
  2 - Na secção Identificação dos Sócios quando informamos apenas o campo Nº de Identificação, o sistema apresenta a validação "Identificação dos Sócios: Percentagem requerido."
  3 - Na secção Identificação dos Sócios quando informamos apenas o campo Percentagem, o sistema apresenta a validação "Identificação dos Sócios: Nº de Identificação requerido."

  Background: 
    Given realizo login no SIGT

  Scenario: Coletivo - Validação da obrigatoriedade de campos de "Identificação dos Sócios"
    Given estou no formulário de Cadastro
    When seleciono o tipo de contribuinte Colectivo - Empresa
    Then para os campos obrigatórios da secção Identificação dos Sócios não informados, devo visualizar mensagens de obrigatoriedade após veficar o formulário

  Scenario: Coletivo - Validação da obrigatoriedade de campos de "Identificação dos Sócios" - Percentagem
    Given estou no formulário de Cadastro
    When seleciono o tipo de contribuinte Colectivo - Empresa
    Then para o campo obrigatório Percentagem não preenchido da secção Identificação dos Sócios, devo visualizar mensagem de obrigatoriedade após veficar o formulário

  Scenario: Coletivo - Validação da obrigatoriedade de campos de "Identificação dos Sócios" - Nº de Identificação
    Given estou no formulário de Cadastro
    When seleciono o tipo de contribuinte Colectivo - Empresa
    Then para o campo obrigatório Nº de Identificação não preenchido da secção Identificação dos Sócios, devo visualizar mensagem de obrigatoriedade após veficar o formulário
