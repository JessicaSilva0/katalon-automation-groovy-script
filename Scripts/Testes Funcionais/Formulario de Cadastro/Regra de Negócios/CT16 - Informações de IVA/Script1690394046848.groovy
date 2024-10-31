import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import steps.CommonSteps as step

/*
 * Feature: Cadastro do Contribuinte
    Como técnico, devo ser capaz de validar as mensagens de exceções do formulário de Cadastro
    
    Rule: 
 	1 - A secção Informações de IVA possui as condicionais Operações Mistas e Obrigado a cativar o IVA, as quais tornam-se obrigatórios os campos Tipo de Regime e Sector
 	2 - A secção Informações de IVA possui a condicional Tipo de Contabilidade que quando selecionado o tipo Organizada, os campos: Opção pela Contabilidade Organizada, 
  Localização da Contabilidade e NIF, passam a ser obrigatórios
 	3 - Na secção Informações de IVA quando o Tipo de Contabilidade selecionado for do tipo Organizada e a condicional NIF devidamente preenchida, o campo Tipo de Contacto Principal
  passa a ser obrigatório
 	4 - Na secção Informações de IVA quando as condicionais NIF e Tipo de Contacto Principal(Estrangeiro) forem devidamente preenchidas, os campos: Código do País e Número, passam a ser obrigatório
	5 - Na secção Informações de IVA quando o campo Província for devidamente preenchido, os campos: Município e Comuna/Distrito Urbano passam a ser obrigatórios

  Background: 
    Given realizo login no SIGT

  Scenario: Singular - Validação da obrigatoriedade de campos da secção Informações de IVA - Condicionais campos Operações Mistas e Obrigado a cativar o IVA
    Given estou no formulário de Cadastro
    And seleciono o tipo de contribuinte Conta Própria ou Outrém na secção Detalhes do Registo
    And não preencho os campos obrigatórios da secção Informações de IVA exceto os campos Operações Mistas e Obrigado a cativar o IVA
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções da secção Informações de IVA contendo as validações de obrigatóriedade dos campos Tipo de Regime e Sector

  Scenario: Singular - Validação da obrigatoriedade de campos da secção Informações de IVA - Condicional Tipo de Contabilidade igual à Organizada
    Given estou no formulário de Cadastro
    And seleciono o tipo de contribuinte Conta Própria ou Outrém na secção Detalhes do Registo
    And não preencho os campos obrigatórios da secção Informações de IVA exceto o campo Tipo de Contabilidade igual à Organizada
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções da secção Informações de IVA contendo as validações de obrigatóriedade dos campos Opção pela Contabilidade Organizada, Localização da Contabilidade e NIF

  Scenario: Singular - Validação da obrigatoriedade de campos da secção Informações de IVA - Condicional Tipo de Contabilidade igual à Organizada - Tipo de Contacto Principal
    Given estou no formulário de Cadastro
    And seleciono o tipo de contribuinte Conta Própria ou Outrém na secção Detalhes do Registo
    And não preencho os campos obrigatórios da secção Informações de IVA exceto os campos Tipo de Contabilidade igual à Organizada e NIF
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções da secção Informações de IVA contendo a validação de obrigatóriedade do campo Tipo de Contacto Principal

  Scenario: Singular - Validação da obrigatoriedade de campos da secção Informações de IVA - Condicionais Tipo de Contabilidade igual à Organizada e Tipo de Contacto Principal igua a estrangeiro
    Given estou no formulário de Cadastro
    And seleciono o tipo de contribuinte Conta Própria ou Outrém na secção Detalhes do Registo
    And não preencho os campos obrigatórios da secção Informações de IVA exceto os campos NIF e Tipo de Contacto Principal igua a estrangeiro
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções da secção Informações de IVA contendo a validação de obrigatóriedade dos campos Código do País e Número
    
  Scenario: Singular - Validação da obrigatoriedade de campos da secção Informações de IVA - Condicional campo Província
    Given estou no formulário de Cadastro
    And seleciono o tipo de contribuinte Conta Própria ou Outrém na secção Detalhes do Registo
    And não preencho os campos obrigatórios da secção Informações de IVA exceto o campo Província
    When clico no botão Verificar Formulario do Cadastro
    Then visualizo as mensagens de exceções da secção Informações de IVA contendo as validações de obrigatóriedade dos campos Município e Comuna/Distrito Urbano
 * 
 */
'Como Técnico, quero ser capaz de realizar as validações de obrigatoriedade dos campos da secção Informações de IVA'
CucumberKW.runFeatureFile('Include/features/Testes Funcionais/Formularios/Cadastro/Regra de Negócios/Informacoes de IVA.feature')

'Sair do sistema após validação do formulário'
step.fecharNavegador()