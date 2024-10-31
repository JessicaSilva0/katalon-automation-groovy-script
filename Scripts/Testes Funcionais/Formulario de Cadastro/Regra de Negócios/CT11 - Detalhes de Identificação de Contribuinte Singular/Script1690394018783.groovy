import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

import steps.CommonSteps as step

/**
 * Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de validar as mensagens de exceções do formulário de Cadastro

  Background: 
    Given realizo login no SIGT

  Scenario: Validar tipo de Identificação do Contribuinte Singular
    Given estou no formulário de Cadastro
    And seleciono a opção " " no campo Tipo Idenficação da secção Detalhes de Identificação do Contribuinte
    And seleciono a opção "Bilhete de Identidade" no campo Tipo Idenficação da secção Detalhes de Identificação do Contribuinte
    And seleciono a opção "Cartão de Refugiado" no campo Tipo Idenficação da secção Detalhes de Identificação do Contribuinte
    And seleciono a opção "Cartão de Residente" no campo Tipo Idenficação da secção Detalhes de Identificação do Contribuinte
    And seleciono a opção "Certidão de Nascimento" no campo Tipo Idenficação da secção Detalhes de Identificação do Contribuinte
    And seleciono a opção "Passaporte" no campo Tipo Idenficação da secção Detalhes de Identificação do Contribuinte
    And seleciono a opção "Outro" no campo Tipo Idenficação da secção Detalhes de Identificação do Contribuinte
 */

'Como Técnico, quero ser capaz de realizar as validações de campos obrigatórios contidos na aba de navegação Detalhes de Identificação Contribuinte'
CucumberKW.runFeatureFile('Include/features/Testes Funcionais/Formularios/Cadastro/Regra de Negócios/Detalhes de Identificacao do Contribuinte Singular.feature')

'Sair do sistema após validação do formulário'
step.fecharNavegador()
