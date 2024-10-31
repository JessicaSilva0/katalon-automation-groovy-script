import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

import steps.CommonSteps as step

/**
 * Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de criar um NIF Colectivo Empresa com Regime de IVA e Operações Mistas

  Background: 
    Given realizo login no SIGT

  Scenario: Criar NIF Colectivo Empresa - Regime de IVA - Operações Mistas
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Colectivo Empresa - Regime de IVA - Operações Mistas
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro

 */


'Como Técnico, quero ser capaz de Criar um NIF Colectivo Empresa'
CucumberKW.runFeatureFile('Include/features/Testes de Regressão/Formularios/Cadastro/Colectivo/criar-cadastro-Empresa-IVA-operacoes-mistas.feature')

'Sair do sistema após validação do formulário'
step.fecharNavegador()