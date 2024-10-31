import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW

import steps.CommonSteps as step

/*
 * Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de validar as mensagens de exceções do formulário de Cadastro
    
    Rule: Ao selecionar Outros dentre as opções do checkbox ele cria o campo Motivo outros e este mesmo torna-se obrigatório 

  Background: 
    Given realizo login no SIGT

  Scenario: Singular - Detalhes para Não Residentes - Validação da obrigatoriedade de campos
    Given estou no formulário de Cadastro
    And seleciono o Indicador de Não Residente "Não Residente"
    And seleciono o campo Outros contido em Informação Adicional Para Não Residente
    And não preencho o campo obrigatório Motivo outros
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções do Detalhes para Não Residentes
    
  Scenario: Colectivo - Detalhes para Não Residentes - Validação da obrigatoriedade de campos
    Given estou no formulário de Cadastro
    And seleciono o Tipo de Contribuinte "COLECTIVO"
    When seleciono o Indicador de Não Residente "Não Residente"
	Then deixo vazio a Informação Adicional Para Não Residente Colectivo
		
  Scenario: Coletivo - Validação da obrigatoriedade de campos do "Detalhes para Não Residentes" - selecionando outros
	Given estou no formulário de Cadastro
	And seleciono o Tipo de Contribuinte "COLECTIVO"
	When seleciono o Indicador de Não Residente "Não Residente"
	Then não preencho o campo obrigatório Motivo outros
		
 */

'Como Técnico, quero ser capaz de realizar as validações de campos obrigatórios contidos na aba de navegação Detalhes para Não Residentes'
CucumberKW.runFeatureFile('Include/features/Testes Funcionais/Formularios/Cadastro/Regra de Negócios/Detalhes para Nao Residentes.feature')

'Sair do sistema após validação do formulário'
step.fecharNavegador()