Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de validar as mensagens de exceções do formulário de Cadastro
    
    Rule: O Nº de Identificação do Cônjuge é condicional e torna-se obrigatório ao campo Estado Civil "Casado" e "União de Facto"

  Background: 
    Given realizo login no SIGT

  Scenario: Validar campo Estado Civil sem preenchimento
    Given estou no formulário de Cadastro
    Then seleciono a opção "Vazio" no campo Estado Civil da secção Outros Detalhes Contribuinte Singular e valido o formulário de cadastro
    

  Scenario: Validar campo Estado Civil com preenchimento
    Given estou no formulário de Cadastro
    Then seleciono a opção "Casado" no campo Estado Civil da secção Outros Detalhes Contribuinte Singular e valido o formulário de cadastro
