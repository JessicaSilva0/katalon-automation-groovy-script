import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import steps.CommonSteps as step

/**
 * Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de criar um NIF Colectivo Instituição Pública Com Regime de IVA Sem Direito a Deduções

  Background: 
    Given realizo login no SIGT

  Scenario: Criar NIF Colectivo Instituição Pública com Regime de IVA Sem Direito a Deduções
    Given estou no formulário de Cadastro
    And preencho os dados do formulario para Colectivo Instituição Pública com Regime de IVA Sem Direito a Deduções
    When valido e publico o formulario
    Then imprimo o Comprovativo de Cadastro
	
 */

'Como Técnico, quero ser capaz de Criar Instituição Pública com Regime de IVA Sem Direito a Deduções'
CucumberKW.runFeatureFile('Include/features/Testes de Regressão/Formularios/Cadastro/Colectivo/criar-cadastro-Instituicao-Publica-IVA-Sem-Direito-Deducoes.feature')

'Sair do sistema após validação do formulário'
step.fecharNavegador()