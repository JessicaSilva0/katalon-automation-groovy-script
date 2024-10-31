import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

import steps.CommonSteps as step

/*
 Feature: Liquidação de Impostos
	Como técnico, devo ser capaz de validar o formulário de liquidação

  Scenario: Clicar no botão 'Validar formulário' de Liquidação
	Given estou no formulário de liquidação
	When preencho os dados do formulário
	And clico no botão Verificar Formulario
	Then Devo receber uma mensagem de verificação do formulário
*/

'Como Técnico, quero aceder o SIGT com as credenciais válidas'
CucumberKW.runFeatureFile('Include/features/Testes Funcionais/Login/login-sucesso.feature')

'Como Técnico, quero ser capaz de cadastrar um novo formulário de Liquidação'
CucumberKW.runFeatureFile('Include/features/Testes Funcionais/Formularios/Liquidação/imprimir-NL.feature')

'Sair do sistema após validação do formulário'
step.fecharNavegador()
