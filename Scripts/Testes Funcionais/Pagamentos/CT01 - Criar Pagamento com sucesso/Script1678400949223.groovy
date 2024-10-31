import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

import steps.CommonSteps as step

/*
 Feature: Pagamentos
		Como técnico, devo ser capaz de criar pagamentos no SIGT

	Scenario: Efectuar Pagamento para um documento de cobrança válido
		Given estou na tela de pagamentos
		And preencho os dados de pagamento

 */
'Como Técnico, quero aceder o SIGT com as credenciais válidas'
CucumberKW.runFeatureFile('Include/features/Testes Funcionais/Login/login-sucesso.feature')

'Como Técnico, quero ser capaz de efectuar um novo pagamento'
CucumberKW.runFeatureFile('Include/features/Testes Funcionais/Pagamentos/efectuar-pagamentos.feature')

'Sair do sistema após criação do pagamento'
step.fecharNavegador()
