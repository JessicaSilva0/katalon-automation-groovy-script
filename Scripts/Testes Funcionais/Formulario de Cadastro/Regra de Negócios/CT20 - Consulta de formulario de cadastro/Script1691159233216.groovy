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
    Como técnico, devo ser capaz de validar as mensagens de exceções da consulta do formulário de Cadastro
    

  Background: 
    Given realizo login no SIGT

  Scenario: Validar Pesquisa por Pessoa, Data Receção e Morada
    Given estou na consulta do formulário de Cadastro
    Then Pesquiso por Pessoa, Data Receção e Morada
    
  Scenario: Validar Pesquisa por Localização do Documento,  Telefone e  E-mail
	Given estou na consulta do formulário de Cadastro
	Then Pesquiso por Localização do Documento,  Telefone e  E-mail e visualizo as mensagens de exceções
 */


'Como Técnico, quero ser capaz de realizar as validações de obrigatoriedade dos campos da consulta de formulários de cadastro'
CucumberKW.runFeatureFile('Include/features/Testes Funcionais/Formularios/Cadastro/Regra de Negócios/Consulta de Formularios de Cadastro.feature')

'Sair do sistema após validação do formulário'
step.fecharNavegador()
