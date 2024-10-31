import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import steps.CommonSteps as step

/*
Feature: Cadastro do Contribuinte
Como técnico, devo ser capaz de validar as mensagens de exceções do formulário de Cadastro

Background:
Given realizo login no SIGT

Scenario: Singular - Validação da obrigatóriedade de campos do Detalhes de Registo
Given estou no formulário de Cadastro
And não preencho os campos obrigatórios da secção Detalhes do Registo
When clico no botão Verificar Formulario
Then visualizo as mensagens de exceções do Detalhes do Registo
*/

'Como Técnico, quero ser capaz de realizar as validações de campos obrigatórios contidos na aba de navegação Detalhes de Registo'
CucumberKW.runFeatureFile('Include/features/Testes Funcionais/Formularios/Cadastro/Regra de Negócios/Detalhes de Registo.feature')

'Sair do sistema após validação do formulário'
step.fecharNavegador()