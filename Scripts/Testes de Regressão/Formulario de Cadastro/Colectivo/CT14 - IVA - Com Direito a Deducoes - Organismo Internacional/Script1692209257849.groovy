import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import steps.CommonSteps as step

/**
 * Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de criar um NIF Colectivo Colectivo Organismo Internacional Com Direito a Deduções

  Background: 
    Given realizo login no SIGT

  Scenario: Criar NIF Colectivo Organismo Internacional com Regime de IVA Com Direito a Deduções
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Colectivo Colectivo Organismo Internacional com Regime em IVA Com Direito a Deduções
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro
	
 */

'Como Técnico, quero ser capaz de Criar Instituição Pública com Regime de IVA Sem Direito a Deduções'
CucumberKW.runFeatureFile('Include/features/Testes de Regressão/Formularios/Cadastro/Colectivo/criar-cadastro-Organismo-Internacional-IVA-Com-Direito-Deducoes.feature')

'Sair do sistema após validação do formulário'
step.fecharNavegador()