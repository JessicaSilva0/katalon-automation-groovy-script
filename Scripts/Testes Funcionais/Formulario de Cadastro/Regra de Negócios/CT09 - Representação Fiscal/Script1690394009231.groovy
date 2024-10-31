import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

import steps.CommonSteps as step

/*
 * Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de validar as mensagens de exceções do formulário de Cadastro

  Background: 
    Given realizo login no SIGT

  Scenario: Singular - Validação da obrigatoriedade de campos da Representação Fiscal
    Given estou no formulário de Cadastro
    Then visualizo as mensagens de exceções da secção Representação Fiscal

 */

'Como Técnico, quero ser capaz de realizar as validações de campos obrigatórios contidos na aba de navegação Representacão Fiscal'
CucumberKW.runFeatureFile('Include/features/Testes Funcionais/Formularios/Cadastro/Regra de Negócios/Representacao Fiscal.feature')

'Sair do sistema após validação do formulário'
step.fecharNavegador()
