import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

import steps.CommonSteps as step

/**
 * Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de criar um NIF Colectivo Empresa com Regime de IVA Obrigado a cativar o IVA

  Background: 
    Given realizo login no SIGT

  Scenario: Contribuinte Colectivo - Residente - Empresa com Regime de IVA - Obrigado a cativar o IVA (artigo 21º do CIVA)
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Colectivo Empresa - Regime de IVA - Obrigado a cativar o IVA 
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro


 */


'Como técnico, devo ser capaz de criar um NIF Colectivo Empresa com Regime de IVA Obrigado a cativar o IVA'
CucumberKW.runFeatureFile('Include/features/Testes de Regressão/Formularios/Cadastro/Colectivo/criar-cadastro-Empresa-IVA-Cativo.feature')

'Sair do sistema após validação do formulário'
step.fecharNavegador()