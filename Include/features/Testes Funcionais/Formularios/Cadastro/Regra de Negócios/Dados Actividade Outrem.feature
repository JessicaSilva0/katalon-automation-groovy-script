Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de validar as mensagens de exceções do formulário de Cadastro
    
    Rule: O campo 'Entidade empregadora' e 'Data de ínicio do Vínculo' é condicional e torna-se obrigatório ao selecionar a checkbox "Trabalhador por conta de outrém"

  Background: 
    Given realizo login no SIGT

  Scenario: Validar Dados da Actividade de Outrém
    Given estou no formulário de Cadastro
    And seleciono o tipo de contribuinte por Outrém na secção Detalhes do Registo
    And não preencho os Dados de Actividade por conta de outrém
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções da secção Dados de Actividade por conta de Outrém
