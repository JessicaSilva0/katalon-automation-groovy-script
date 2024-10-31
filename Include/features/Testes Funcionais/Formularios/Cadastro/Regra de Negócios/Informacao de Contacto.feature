Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de validar as mensagens de exceções do formulário de Cadastro
    
     Rule: 
    1 - Validação dos campos obrigatórios sem condicionais
    2 - Na secção Informação de Contacto ao selecionar o campo Tipo de Contacto Principal = "Estrangeiro" , o campo "Código do País" passa a ser obrigatório
		3 - Na secção Informação de Contacto ao selecionar o campo Tipo de Contacto Principal = "Fixo" ou "Telemóvel" , apenas o campo "Nº de Contacto" será obrigatório
		
  Background: 
    Given realizo login no SIGT


  Scenario: Singular - Informação de Contacto - Validação da obrigatoriedade de campos
    Given estou no formulário de Cadastro
    And não preencho os campos obrigatórios da secção Informação de Contacto
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções do Informação de Contacto
    
   Scenario: Singular - Informação de Contacto - Estrangeiro - Validação da obrigatoriedade de campos 
   Given estou no formulário de Cadastro
    And não preencho os campos obrigatórios da secção Informação de Contacto, exceto os campos Tipo de Contacto Principal Estrangeiro e Código do País
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções do Informação de Contacto exceto a mensagem de Tipo de Contacto Principal devido ao preenchimento com Estrangeiro
    
    Scenario: Singular - Informação de Contacto - Fixo e Móvel - Validação da obrigatoriedade de campos 
    Given estou no formulário de Cadastro
    And não preencho os campos obrigatórios da secção Informação de Contacto, exceto o campo Tipo de Contacto Principal Fixo ou Telemóvel
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções do Informação de Contacto exceto a mensagem de Tipo de Contacto Principal devido ao preenchimento com Fixo ou Telemóvel
    
    Scenario: Coletivo - Informações de Contacto - Endereço Web
    Given estou no formulário de Cadastro
    When preencho os detalhes de registo para o tipo de contribuinte Colectivo
    Then visualizo o elemento Endereco Web na secção Informacao de Contacto
    