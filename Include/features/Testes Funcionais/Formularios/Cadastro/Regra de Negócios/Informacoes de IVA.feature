Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de validar as mensagens de exceções do formulário de Cadastro
    
    Rule: 
 	1 - A secção Informações de IVA possui as condicionais Operações Mistas e Obrigado a cativar o IVA, as quais tornam-se obrigatórios os campos Tipo de Regime e Sector
 	2 - A secção Informações de IVA possui a condicional Tipo de Contabilidade que quando selecionado o tipo Organizada, os campos: Opção pela Contabilidade Organizada, 
  Localização da Contabilidade e NIF, passam a ser obrigatórios
 	3 - Na secção Informações de IVA quando o Tipo de Contabilidade selecionado for do tipo Organizada e a condicional NIF devidamente preenchida, o campo Tipo de Contacto Principal
  passa a ser obrigatório
  4 - Na secção Informações de IVA quando as condicionais NIF e Tipo de Contacto Principal(Estrangeiro) forem devidamente preenchidas, os campos: Código do País e Número, passam a ser obrigatório
	5 - Na secção Informações de IVA quando o campo Província for devidamente preenchido, os campos: Município e Comuna/Distrito Urbano passam a ser obrigatórios
	6 - Na secção Informações de IVA quando o Regime for Simplificado em II no Enquandramento em IVA só poderá ser de Exclusão

  Background: 
    Given realizo login no SIGT

  Scenario: Singular - Validação da obrigatoriedade de campos da secção Informações de IVA - Condicionais campos Operações Mistas e Obrigado a cativar o IVA
    Given estou no formulário de Cadastro
    And seleciono o tipo de contribuinte Conta Própria ou Outrém na secção Detalhes do Registo
    And não preencho os campos obrigatórios da secção Informações de IVA exceto os campos Operações Mistas e Obrigado a cativar o IVA
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções da secção Informações de IVA contendo as validações de obrigatóriedade dos campos Tipo de Regime e Sector

  Scenario: Singular - Validação da obrigatoriedade de campos da secção Informações de IVA - Condicional Tipo de Contabilidade igual à Organizada
    Given estou no formulário de Cadastro
    And seleciono o tipo de contribuinte Conta Própria ou Outrém na secção Detalhes do Registo
    And não preencho os campos obrigatórios da secção Informações de IVA exceto o campo Tipo de Contabilidade igual à Organizada
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções da secção Informações de IVA contendo as validações de obrigatóriedade dos campos Opção pela Contabilidade Organizada, Localização da Contabilidade e NIF

  Scenario: Singular - Validação da obrigatoriedade de campos da secção Informações de IVA - Condicional Tipo de Contabilidade igual à Organizada - Tipo de Contacto Principal
    Given estou no formulário de Cadastro
    And seleciono o tipo de contribuinte Conta Própria ou Outrém na secção Detalhes do Registo
    And não preencho os campos obrigatórios da secção Informações de IVA exceto os campos Tipo de Contabilidade igual à Organizada e NIF
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções da secção Informações de IVA contendo a validação de obrigatóriedade do campo Tipo de Contacto Principal

  Scenario: Singular - Validação da obrigatoriedade de campos da secção Informações de IVA - Condicionais Tipo de Contabilidade igual à Organizada e Tipo de Contacto Principal igua a estrangeiro
    Given estou no formulário de Cadastro
    And seleciono o tipo de contribuinte Conta Própria ou Outrém na secção Detalhes do Registo
    And não preencho os campos obrigatórios da secção Informações de IVA exceto os campos NIF e Tipo de Contacto Principal igual a estrangeiro
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções da secção Informações de IVA contendo a validação de obrigatóriedade dos campos Código do País e Número
    
  Scenario: Singular - Validação da obrigatoriedade de campos da secção Informações de IVA - Condicional campo Província
    Given estou no formulário de Cadastro
    And seleciono o tipo de contribuinte Conta Própria ou Outrém na secção Detalhes do Registo
    And não preencho os campos obrigatórios da secção Informações de IVA exceto o campo Província
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções da secção Informações de IVA contendo as validações de obrigatóriedade dos campos Município e Comuna Distrito Urbano
    
    
  Scenario: Validar regra do Colectivo - Regime Simplificado de II - Enquadramento em IVA - Regime - Regime Geral
    Given estou no formulário de Cadastro
    And seleciono o Contribuinte Colectivo - Regime Simplificado - Regime Geral
    When clico no botão Verificar Formulario do Cadastro
    Then valido a mensagem de exceção para o Colectivo Regime simplificado de II e Enquadramento em IVA no Regime como Regime Geral ou Simplificado
    
  Scenario: Validar regra do Colectivo - Regime Simplificado de II - Enquadramento em IVA - Regime - Regime Simplificado
    Given estou no formulário de Cadastro
    And seleciono o Contribuinte Colectivo - Regime Simplificado - Regime Simplificado
    When clico no botão Verificar Formulario do Cadastro
    Then valido a mensagem de exceção para o Colectivo Regime simplificado de II e Enquadramento em IVA no Regime como Regime Geral ou Simplificado
    