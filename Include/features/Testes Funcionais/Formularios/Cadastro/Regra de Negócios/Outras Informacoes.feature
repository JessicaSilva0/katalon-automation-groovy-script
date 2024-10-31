Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de validar as mensagens de exceções do formulário de Cadastro
    
    Rule: 
    1 - A secção Outras Informações é condicional ao campo Nº de Identificação Bancária (IBAN), torna-se obrigatório caso o campo estiver preenchido.
    2 - Na secção Detalhes do Registo ao selecionar o tipo de contribuinte Trabalhador por Conta Própria, habilita-se o "Volume de Negócios" na secção Outras Informações

  Background: 
    Given realizo login no SIGT

  Scenario: Singular - Validação da obrigatoriedade de campos do Outras Informações
    Given estou no formulário de Cadastro
    And não preencho os campos obrigatórios da secção Outras Informações
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções do IBAN - Outras Informações

  Scenario: Singular - Validação da obrigatoriedade de campos do Outras Informações - Trabalhador por Conta própria
    Given estou no formulário de Cadastro
    And não preencho os campos obrigatórios do Volume de Negócios na secção Outras Informações
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções do Volume de Negocios - Outras Informações
    
  Scenario: Validar o volume de negócio de IVA para o regime de simplificado de um contribuinte - Com sucesso
    Given estou no formulário de Cadastro
    Then preencho o volume de negocio no formulario de um Trabalhador por conta própria com IVA Regime Simplificado respeitando a regra do OGE
    
  Scenario: Validar o volume de negócio de IVA para o regime de simplificado de um contribuinte - Sem sucesso
    Given estou no formulário de Cadastro
    Then preencho o volume de negocio resultando abaixo de dez milhoes num formulario de um Trabalhador por conta própria com IVA Regime Simplificado nao respeitando a regra do OGE
    
  Scenario: Validar o volume de negócio de IVA para o regime de simplificado de um contribuinte - Sem sucesso
    Given estou no formulário de Cadastro
    Then preencho o volume de negocio resultando acima de trezentos e cinquenta milhoes formulario de um Trabalhador por conta própria com IVA Regime Simplificado nao respeitando a regra do OGE
    
  Scenario: Validar o volume de negócio de IVA para o regime de Geral de um contribuinte
    Given estou no formulário de Cadastro
    Then preencho o volume de negocio no formulario de um Trabalhador por conta própria com IVA Regime Geral respeitando a regra do OGE

  Scenario: Validar o volume de negócio de IVA para o regime de Exclusão - Com sucesso
    Given estou no formulário de Cadastro
    Then preencho o volume de negocio no formulario de um Trabalhador por conta própria com IVA Regime de Exclusão respeitando a regra do OGE

  Scenario: Validar o volume de negócio de IVA para o regime de Exclusão - Sem sucesso
    Given estou no formulário de Cadastro
    Then preencho o volume de negocio resultando abaixo de dez milhoes num formulario de um Trabalhador por conta própria com IVA Regime de Exclusão nao respeitando a regra do OGE
