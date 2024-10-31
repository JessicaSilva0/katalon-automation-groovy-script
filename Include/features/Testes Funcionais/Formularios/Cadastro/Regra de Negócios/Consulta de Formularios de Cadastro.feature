Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de validar as mensagens de exceções da consulta do formulário de Cadastro

  Background: 
    Given realizo login no SIGT

  Scenario: Validar Pesquisa por Pessoa, Data Receção e Morada
    Given estou na consulta do formulário de Cadastro
    Then Pesquiso por Pessoa, Data Receção e Morada e visualizo as mensagens de exceções

  
  Scenario: Validar Pesquisa por Localização do Documento,  Telefone e  E-mail
    Given estou na consulta do formulário de Cadastro
    Then Pesquiso por Localização do Documento,  Telefone e  E-mail e visualizo as mensagens de exceções