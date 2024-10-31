import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import steps.CommonSteps as step

/**
 * Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de criar um NIF Colectivo Organismo Internacional Com Regime de IVA Cativo

  Background: 
    Given realizo login no SIGT

  Scenario: Criar NIF Colectivo Instituição Pública com Regime de IVA Sem Direito a Deduções
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Colectivo Organismo Internacional com Regime de IVA Cativo
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro
	
 */

'Como Técnico, quero ser capaz de Criar Instituição Pública com Regime de IVA Sem Direito a Deduções'
CucumberKW.runFeatureFile('Include/features/Testes de Regressão/Formularios/Cadastro/Colectivo/criar-cadastro-Organismo-Internacional-IVA-cativo.feature')

'Sair do sistema após validação do formulário'
step.fecharNavegador()