import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

import steps.CommonSteps as step

/**
 * Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de validar as mensagens de exceções do formulário de Cadastro

  Background: 
    Given realizo login no SIGT
    When estou no formulário de Cadastro

  Scenario: Validar Detalhes de Identificação do Contribuinte Colectivo
    Then valido as mensagens de exceções do Detalhes de Identificação do contribuinte Colectivo
 */

'Como Técnico, quero ser capaz de realizar as validações de campos obrigatórios contidos na aba de navegação Detalhes de Identificação Contribuinte'
CucumberKW.runFeatureFile('Include/features/Testes Funcionais/Formularios/Cadastro/Regra de Negócios/Detalhes de Identificacao do Contribuinte Colectivo.feature')

'Sair do sistema após validação do formulário'
step.fecharNavegador()
